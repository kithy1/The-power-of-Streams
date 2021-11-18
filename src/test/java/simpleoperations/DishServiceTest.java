package simpleoperations;


import model.Dish;
import model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class DishServiceTest {

    private final DishRepository repository = new DishDAO();
    private final DishService service = new DishService(repository);


    @Test
    void getNamesOfLowCaloriesDishes() {
        final Map<Type, List<Dish>> dishesByType = service.getDishesByType();
        Assertions.assertEquals(3, dishesByType.keySet().size());
    }

    @Test
    void getDishesByType() {

    }

    @Test
    void getNameOfThreeHighCaloricDishes() {
    }

    @Test
    void getNamesOfThreeTheMostCaloricDishes() {
    }

    @Test
    void getNumberOfHighCaloricDishes() {
    }

    @Test
    void getVegetarianDishes() {
    }

    @Test
    void getLowCaloricDishes() {
    }

    @Test
    void getHighCaloricDishes() {
    }

    @Test
    void skipMeat() {
    }

    @Test
    void getTheLongestNameOfDish() {
    }

    @Test
    void getTheLengthOfTheLongestNameOfDish() {
    }

    @Test
    void getDistinctAllLettersInDishesNames() {
    }
}