import java.io.IOException;
import java.util.LinkedList;
import java.util.*;

//calculate the shortest paths using an adj list
public class FlightCalc {

    private AdjList adjlist;

    // constructor
    public FlightCalc(AdjList adjlist) {
        this.adjlist = adjlist;
    }

    // call by the main java file
    public void print(Scanner requestedData) throws IOException {
        int numLines = Integer.parseInt(requestedData.nextLine());
        for (int i = 0; i < numLines; i++) {
            String str = requestedData.next();
            String[] strSplit = str.split("\\|");
            String fromCity = strSplit[0];
            String toCity = strSplit[1];
            String sortBy = strSplit[2];
            System.out.print("Flight " + (i + 1) + ": " + fromCity + ", " + toCity + " ");
            if (sortBy.compareTo("T") == 0) {
                System.out.println("(Time)");
            }
            if (sortBy.compareTo("C") == 0) {
                System.out.println("(Cost)");
            }
            printPaths(shortestPaths(fromCity, toCity, sortBy));
            System.out.println();

        }
    }

    // get all possible paths
    public ArrayList<LinkedList<String>> allPossiblePaths(String s, String d) {
        LinkedList<String> src = new LinkedList<>(); // to add to the stack for the initial state
        src.add(s);
        Stack possiblePaths = new Stack(20);
        possiblePaths.push(src);
        ArrayList<LinkedList<String>> allPaths = new ArrayList<>();

        // calculate all possible paths from s to d
        while (!possiblePaths.isEmpty()) {
            LinkedList<String> curr = possiblePaths.pop();
            String top = curr.getLast();

            if (top.compareTo(d) == 0) { // add path to allPaths if reached destination
                LinkedList<String> path = new LinkedList<>();
                for (int i = 0; i < curr.size(); i++) {
                    path.add(curr.get(i));
                }
                allPaths.add(path);
            } else { // keep searching through the neighbor city
                Cities neighborCities = adjlist.getCities(top);
                for (int i = 0; i < neighborCities.ll.size(); i++) {
                    String city = neighborCities.ll.get(i).getCity();
                    if (!curr.contains(city)) {
                        LinkedList<String> path = new LinkedList<>();
                        for (int j = 0; j < curr.size(); j++) {
                            path.add(curr.get(j));
                        }
                        path.add(city);
                        possiblePaths.push(path);
                    }
                }
            }
        }
        return allPaths;
    }

    // get 3 shortest paths
    public ArrayList<LinkedList<String>> shortestPaths(String source, String destination, String sortBy) {
        ArrayList<LinkedList<String>> allPaths = allPossiblePaths(source, destination);
        ArrayList<LinkedList<String>> shortestPaths = new ArrayList<>();

        int vals[] = new int[allPaths.size()];

        // sorted by cost
        if (sortBy.compareTo("C") == 0) {
            for (int i = 0; i < allPaths.size(); i++) {
                vals[i] = getTotalCost(allPaths.get(i));
            }
            for (int j = 0; j < vals.length - 1; j++) {
                for (int k = 0; k < vals.length - j - 1; k++) {
                    if (vals[k] > vals[k + 1]) {
                        int temp = vals[k];
                        vals[k] = vals[k + 1];
                        vals[k + 1] = temp;
                    }
                }
            }
            for (int a = 0; a < 3; a++) {
                for (LinkedList<String> l : allPaths) {
                    if (getTotalCost(l) == vals[a]) {
                        shortestPaths.add(l);
                    }
                }
            }
        } 
        //sorted by time
        else if (sortBy.compareTo("T") == 0) {
            for (int i = 0; i < allPaths.size(); i++) {
                vals[i] = getTotalTime(allPaths.get(i));
            }
            for (int j = 0; j < vals.length - 1; j++) {
                for (int k = 0; k < vals.length - j - 1; k++) {
                    if (vals[k] > vals[k + 1]) {
                        int temp = vals[k];
                        vals[k] = vals[k + 1];
                        vals[k + 1] = temp;
                    }
                }
            }
            for (int a = 0; a < 3; a++) {
                for (LinkedList<String> l : allPaths) {
                    if (getTotalTime(l) == vals[a]) {
                        shortestPaths.add(l);
                    }
                }
            }
        }
        return shortestPaths;

    }

    // prints 3 shortest paths
    public void printPaths(ArrayList<LinkedList<String>> paths) {
        int k = 0;
        if (paths.size() == 0) {
            System.out.println("No routes found.");
            return;
        }

        for (LinkedList<String> l : paths) {
            System.out.print("Path " + (k + 1) + ": ");
            for (int i = 0; i < l.size() - 1; i++) {
                System.out.print(l.get(i) + " -> ");
            }
            System.out.print(l.get(l.size() - 1) + ". ");
            int time = getTotalTime(l);
            int cost = getTotalCost(l);
            System.out.print("Time: " + time + " ");
            System.out.print("Cost: " + cost + ".00\n");
            k++;
        }

    }

    // gets total cost of a path
    public int getTotalCost(LinkedList<String> p) {
        int totalCost = 0;
        String s = p.get(0);
        for (int i = 1; i < p.size(); i++) {
            String d = p.get(i);
            Cities adj = adjlist.getCities(s);
            totalCost += adj.getCityWithName(d).getCost();
            s = d;
        }
        return totalCost;
    }

    // gets total time of path
    public int getTotalTime(LinkedList<String> p) {
        int totalTime = 0;
        String s = p.get(0);
        for (int i = 1; i < p.size(); i++) {
            String d = p.get(i);
            Cities adj = adjlist.getCities(s);
            totalTime += adj.getCityWithName(d).getTime();
            s = d;
        }
        return totalTime;
    }

}
