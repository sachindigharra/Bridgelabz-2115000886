import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
public class CarToJson {
    static class Car {
        String make;
        String model;
        int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(car);
        System.out.println(json);
    }
} {
    
}
