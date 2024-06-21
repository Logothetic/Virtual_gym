public class ProgressTracker {
    private int caloriesBurned;

    public ProgressTracker() {
        this.caloriesBurned = 0;
    }

    public void burnCalories(int calories) {
        this.caloriesBurned += calories;
    }

    public int getCaloriesBurned() {
        return this.caloriesBurned;
    }
}
