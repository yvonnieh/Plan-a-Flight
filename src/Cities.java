//linked list of city
public class Cities {
    protected LinkedList<City> ll;
    String city;

    public Cities(String city){
        ll = new LinkedList<City>();
        this.city = city;
    }

    public String getCityName(){
        return this.city;
    }
    
    public void add(City c){
        ll.add(c);
    }

    public City getCityName(String cityName){
        for(int i = 0; i < ll.size(); i++){
            if(ll.get(i).getCity().compareTo(cityName) == 0){
                return ll.get(i);
            }
        }
        return null;
    }

    public void print() {
        System.out.print(this.city);
        for(int i = 0; i < ll.size(); i++){
            System.out.print(" -> " + ll.get(i).getCity());
        }
    }

    public City getCityWithName(String cityName){
        for(int i = 0; i < ll.size(); i++){
            if(ll.get(i).getCity().compareTo(cityName) == 0)
                return ll.get(i);
        }
        return null;
    }


}
