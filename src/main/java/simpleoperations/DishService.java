package simpleoperations;

import model.Dish;
import model.Type;

import java.util.*;
import java.util.stream.Collectors;

public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public List<String> getNamesOfLowCaloriesDishes() {
        return repository.getAllDishes().parallelStream()
                .filter(dish -> dish.calories() < 400)
                .sorted(Comparator.comparing(Dish::calories))
                .map(Dish::name)
                .collect(Collectors.toList());
    }

    public Map<Type, List<Dish>> getDishesByType() {
        return repository.getAllDishes().stream()
                .collect(Collectors.groupingBy(Dish::type));
    }

    // Operacje filter i map zostaną scalone do postaci tego samego przejścia - jest to "loop fusion" - fuzja pętli
    public List<String> getNameOfThreeHighCaloricDishes() {
        return repository.getAllDishes().stream()
                .filter(dish -> dish.calories() > 300)
                .map(Dish::name)
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfThreeTheMostCaloricDishes() {
        return repository.getAllDishes().stream()
                .sorted((d1, d2) -> d2.calories() - d1.calories())
                .map(Dish::name)
                .limit(3)
                .collect(Collectors.toList());
    }

    public long getNumberOfHighCaloricDishes() {
        return repository.getAllDishes().stream()
                .filter(dish -> dish.calories() > 300)
                .count();
    }

    public List<Dish> getVegetarianDishes() {
        return repository.getAllDishes().stream()
                .filter(Dish::vegetarian)
                .collect(Collectors.toList());
    }

    // jeśli kolekcja wejściowa jest posortowana w wiadomy nam sposób możemy zastosować operację takeWhile - metoda ta zatrzymuje się po znalezieniu elementu, który nie pasuje do podanego predykatu
    public List<Dish> getLowCaloricDishes() {
        var dishList = new ArrayList<>(repository.getAllDishes());
        dishList.sort(Comparator.comparing(Dish::calories));
        return dishList.stream()
                .takeWhile(dish -> dish.calories() < 320)
                .collect(Collectors.toList());
    }

    public List<Dish> getHighCaloricDishes() {
        var dishList = new ArrayList<>(repository.getAllDishes());
        dishList.sort(Comparator.comparing(Dish::calories));
        return dishList.stream()
                .dropWhile(dish -> dish.calories() < 320)
                .collect(Collectors.toList());
    }

    public List<Dish> skipMeat() {
        var dishList = new ArrayList<>(repository.getAllDishes());
        dishList.sort(Comparator.comparing(Dish::type));
        return dishList.stream()
                .skip(3)
                .collect(Collectors.toList());
    }

    public String getTheLongestNameOfDish() {
        return repository.getAllDishes().stream()
                .map(Dish::name)
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(1)
                .collect(Collectors.joining());
    }

    public int getTheLengthOfTheLongestNameOfDish() {
        return repository.getAllDishes().stream()
                .mapToInt(dish -> dish.name().length())
                .max()
                .orElse(0);
    }

    public List<String> getDistinctAllLettersInDishesNames() {
        return repository.getAllDishes().stream()
                .map(Dish::name)
                .flatMap(name -> Arrays.stream(name.split("")))
                .filter(s -> !s.isBlank())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

}
