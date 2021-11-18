package model;

public record Dish(String name, boolean vegetarian, int calories, Type type) {

    @Override
    public String toString() {
        return name;
    }
}
