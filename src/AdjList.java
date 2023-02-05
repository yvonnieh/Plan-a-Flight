//create an adjacency list from the flight data

import java.util.*;

public class AdjList {

    private LinkedList<Cities> list;
    private int size = 0;

    // constructor
    public AdjList() {
        list = new LinkedList<>();
    }

    // add a new linked list cities to the linked list list
    public void add(Cities c) {
        list.add(c);
    }

    // add a new edge to the linked list cities
    public void addEdge(String c1, String c2, int cost, int time) {
        City city1 = new City(c1, cost, time);
        City city2 = new City(c2, cost, time);

        // find the linked list with the city name and append a new City
        getCities(c1).add(city2);
        getCities(c2).add(city1);
    }

    // return Linked List Cities found in the Linked List list
    public Cities getCities(String city) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCityName().compareTo(city) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    // creates adjacency list with flight data
    public void createAdjList(Scanner flightData) {
        int numLines = Integer.parseInt(flightData.nextLine());
        for (int i = 0; i < numLines; i++) {
            String str = flightData.next();
            String[] strSplit = str.split("\\|");
            Cities citiesA = createCities(strSplit[0]);
            Cities citiesB = createCities(strSplit[1]);
            String nameCityA = citiesA.getCityName();
            String nameCityB = citiesB.getCityName();
            // add edge
            addEdge(nameCityA, nameCityB, Integer.parseInt(strSplit[2]), Integer.parseInt(strSplit[3]));
        }
    }

    // if city is found, create a new Linked List Cities with city
    // else return the Linked List Cities
    public Cities createCities(String city) {
        if (!contains(city)) {
            Cities c1 = new Cities(city);
            this.add(c1);
            size++;
            return c1;
        }
        return getCities(city);
    }

    // if list contain the Linked List Cities with city c, return true
    // else return false
    public boolean contains(String c) {
        if (list.contains(getCities(c)) == true)
            return true;
        return false;
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
            System.out.println();
        }
    }

    public int size() {
        return this.size;
    }

    // return index in the list
    public int getIndex(String city) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCityName().compareTo(city) == 0) {
                return i;
            }
        }
        return -1;
    }
}
