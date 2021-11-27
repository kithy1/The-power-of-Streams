import simpleoperations.DishDAO;
import simpleoperations.DishRepository;
import simpleoperations.DishService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        DishRepository repository = new DishDAO();
        DishService service = new DishService(repository);

        service.getDishesByType().forEach((type, dishes) -> System.out.println("dish type: " + type + " dishes: " + dishes));

        System.out.println(service.getNamesOfLowCaloriesDishes());

        System.out.println(service.getNamesOfThreeTheMostCaloricDishes());

        System.out.println(service.getNameOfThreeHighCaloricDishes());

        System.out.println(service.getNumberOfHighCaloricDishes());

        System.out.println(service.getVegetarianDishes());

        System.out.println(service.getLowCaloricDishes());

        System.out.println(service.getHighCaloricDishes());

        System.out.println(service.skipMeat());

        System.out.println(service.getTheLongestNameOfDish());

        System.out.println(service.getTheLengthOfTheLongestNameOfDish());

        System.out.println(service.getDistinctAllLettersInDishesNames());

        final List<String> strings = List.of("Null", "abc", "Cba21", "35", "null");

        strings.stream().map(s -> s.substring(0,1))
                .map(s -> s.charAt(0))
                .filter(Character::isUpperCase)
                .limit(1)
                .forEach(System.out::println);

        strings.stream().map(s -> s.toLowerCase(Locale.ROOT)).forEach(System.out::println);

        strings.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .forEach(System.out::print);

        strings.stream().map(s -> s.toLowerCase(Locale.ROOT)).forEach(System.out::print);
        System.out.println(String.join(",", strings));

        System.out.println(strings.stream().map(s -> s.toLowerCase(Locale.ROOT)).distinct().collect(Collectors.toList()));


    }
}
