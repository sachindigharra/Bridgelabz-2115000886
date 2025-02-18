package Feb17;

import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealName();
}

class VegetarianMeal implements MealPlan {
    private String mealName;
    
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealName() {
        return mealName;
    }
    
    @Override
    public String toString() {
        return "Vegetarian: " + mealName;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealName() {
        return mealName;
    }
    
    @Override
    public String toString() {
        return "Vegan: " + mealName;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    
    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }
    
    public String getMealName() {
        return mealName;
    }
    
    @Override
    public String toString() {
        return "Keto: " + mealName;
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();
    
    public void addMeal(T meal) {
        meals.add(meal);
    }
    
    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanner {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> mealPlan) {
        System.out.println("Generated Meal Plan:");
        for (T meal : mealPlan.getMeals()) {
            System.out.println(meal);
        }
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianPlan = new Meal<>();
        vegetarianPlan.addMeal(new VegetarianMeal("Grilled Veggie Salad"));
        vegetarianPlan.addMeal(new VegetarianMeal("Pasta Primavera"));

        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal("Tofu Stir-fry"));
        veganPlan.addMeal(new VeganMeal("Vegan Burrito"));

        Meal<KetoMeal> ketoPlan = new Meal<>();
        ketoPlan.addMeal(new KetoMeal("Grilled Chicken with Avocado"));
        ketoPlan.addMeal(new KetoMeal("Keto Cheese Omelette"));

        System.out.println("Vegetarian Meal Plan:");
        MealPlanner.generateMealPlan(vegetarianPlan);

        System.out.println("\nVegan Meal Plan:");
        MealPlanner.generateMealPlan(veganPlan);

        System.out.println("\nKeto Meal Plan:");
        MealPlanner.generateMealPlan(ketoPlan);
    }
}

