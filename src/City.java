//city
public class City {
    String city = "";
    int cost = 0;
    int time = 0;

    public City(String city, int cost, int time) {
        this.city = city;
        this.cost = cost;
        this.time = time;
    }

    public String getCity() {
        return this.city;
    }

    public int getCost() {
        return this.cost;
    }

    public int getTime() {
        return this.time;
    }
}
