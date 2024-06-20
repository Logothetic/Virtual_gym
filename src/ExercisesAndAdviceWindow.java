import javax.swing.*;
import java.awt.*;

public class ExercisesAndAdviceWindow extends JFrame {
    public ExercisesAndAdviceWindow() {
        setTitle("Gym Exercises and Nutritional Advice");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Create and add content for exercises
        JTextArea exercisesArea = new JTextArea(
                "List of Gym Exercises:\n\n" +
                        "- Push-ups\n" +
                        "- Squats\n" +
                        "- Deadlifts\n" +
                        "- Bench Press\n" +
                        "- Pull-ups\n" +
                        "- Lunges\n" +
                        "- Planks\n" +
                        "- Burpees\n" +
                        "- Bicep Curls\n" +
                        "- Tricep Dips\n" +
                        "- Shoulder Press\n" +
                        "- Leg Press\n" +
                        "- Sit-ups\n" +
                        "- Jumping Jacks\n"
        );
        exercisesArea.setEditable(false);
        add(new JScrollPane(exercisesArea));

        // Create and add content for nutritional advice
        JTextArea nutritionArea = new JTextArea(
                "Nutritional Advice:\n\n" +
                        "- Eat balanced meals\n" +
                        "- Stay hydrated\n" +
                        "- Consume protein after workouts\n" +
                        "- Avoid processed foods\n" +
                        "- Maintain a calorie deficit for weight loss\n" +
                        "- Eat plenty of fruits and vegetables\n" +
                        "- Avoid sugary drinks\n" +
                        "- Get enough fiber in your diet\n" +
                        "- Eat healthy fats in moderation\n" +
                        "- Plan your meals ahead\n" +
                        "- Avoid eating late at night\n" +
                        "- Keep track of your food intake\n"
        );
        nutritionArea.setEditable(false);
        add(new JScrollPane(nutritionArea));
    }
}
