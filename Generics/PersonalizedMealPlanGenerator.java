interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}
class HighProteinMeal implements MealPlan {}
class Meal<T extends MealPlan> {
    private T plan;
    public Meal(T plan) { this.plan = plan; }
    public T getPlan() { return plan; }
}
class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        return new Meal<>(plan);
    }
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = generateMealPlan(new VeganMeal());
        System.out.println(vegMeal.getPlan().getClass().getSimpleName());
        System.out.println(veganMeal.getPlan().getClass().getSimpleName());
    }
} 