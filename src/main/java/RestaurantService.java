import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName (String restaurantName) throws restaurantNotFoundException{

        for (Restaurant object: restaurants) {
            if (object.getName().equals(restaurantName)){
                return object;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public int calculate_sum_of_items(List<String> item_name_list, Restaurant restaurant_object){
        int price=0, total =0;
        for (String item_name : item_name_list) {
            for (Item item : restaurant_object.getMenu()) {
                if (item.getName().equals(item_name)) {
                    price = item.getPrice();
                    total += price;
                }
            }
        }
        return total;
    }
}
