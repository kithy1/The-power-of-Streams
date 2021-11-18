package simpleoperations;

import model.Dish;

import java.util.List;

public sealed interface DishRepository permits DishDAO{

    List<Dish> getAllDishes();
}
