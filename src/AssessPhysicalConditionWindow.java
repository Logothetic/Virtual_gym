import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssessPhysicalConditionWindow extends JFrame {
    private JTextField heightField;
    private JTextField weightField;
    private JTextField ageField;
    private JComboBox<String> genderBox;
    private JComboBox<String> activityLevelBox;
    private JTextField currentWaterIntakeField;
    private JTextField currentCaloriesField;
    private JTextField exerciseFrequencyField;
    private JTextField exerciseDurationField;
    private JLabel bmiResultLabel;
    private JLabel bmrResultLabel;
    private JLabel bodyFatResultLabel;
    private JLabel waterIntakeLabel;
    private JLabel macronutrientLabel;
    private JLabel fitnessLevelLabel;
    private JLabel exerciseAdviceLabel;
    private JLabel adviceLabel;
    private JFrame mainWindow;

    public AssessPhysicalConditionWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Assess Physical Condition");
        setSize(800, 800); // Initial size before maximizing
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Set background image
        JLabel background = new JLabel(new ImageIcon("fitness_assessment.jpg"));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // Initialize components
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        ageField = new JTextField(10);
        String[] genders = {"Male", "Female"};
        genderBox = new JComboBox<>(genders);
        String[] activityLevels = {"Sedentary", "Lightly active", "Moderately active", "Very active", "Extra active"};
        activityLevelBox = new JComboBox<>(activityLevels);
        currentWaterIntakeField = new JTextField(10);
        currentCaloriesField = new JTextField(10);
        exerciseFrequencyField = new JTextField(10);
        exerciseDurationField = new JTextField(10);
        bmiResultLabel = new JLabel("");
        bmrResultLabel = new JLabel("");
        bodyFatResultLabel = new JLabel("");
        waterIntakeLabel = new JLabel("");
        macronutrientLabel = new JLabel("");
        fitnessLevelLabel = new JLabel("");
        exerciseAdviceLabel = new JLabel("");
        adviceLabel = new JLabel("<html><body style='width: 250px'></body></html>");

        // Set font styles
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font resultFont = new Font("Arial", Font.PLAIN, 14);
        bmiResultLabel.setFont(resultFont);
        bmrResultLabel.setFont(resultFont);
        bodyFatResultLabel.setFont(resultFont);
        waterIntakeLabel.setFont(resultFont);
        macronutrientLabel.setFont(resultFont);
        fitnessLevelLabel.setFont(resultFont);
        exerciseAdviceLabel.setFont(resultFont);
        adviceLabel.setFont(resultFont);

        // Create and add components to the panel
        JPanel panel = new JPanel();
        panel.setOpaque(true); // Ensure panel is not transparent
        panel.setBackground(new Color(255, 255, 255, 180)); // Set semi-transparent white background
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Height (cm):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Weight (kg):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Age:", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Gender:", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(genderBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Activity Level:", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(activityLevelBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Current Daily Water Intake (liters):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(currentWaterIntakeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Current Daily Calorie Intake (kcal):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(currentCaloriesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Exercise Frequency (days/week):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(exerciseFrequencyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(createLabel("Exercise Duration (minutes/day):", labelFont), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(exerciseDurationField, gbc);

        JButton calculateButton = new JButton("Calculate All Metrics");
        calculateButton.setFont(labelFont);
        calculateButton.setBackground(new Color(70, 130, 180));
        calculateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(calculateButton, gbc);

        JButton backButton = new JButton("Back");
        backButton.setFont(labelFont);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backButton, gbc);

        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(bmiResultLabel, gbc);

        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(bmrResultLabel, gbc);

        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(bodyFatResultLabel, gbc);

        gbc.gridy = 14;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(waterIntakeLabel, gbc);

        gbc.gridy = 15;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(macronutrientLabel, gbc);

        gbc.gridy = 16;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(fitnessLevelLabel, gbc);

        gbc.gridy = 17;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(exerciseAdviceLabel, gbc);

        gbc.gridy = 18;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(adviceLabel, gbc);

        // Add the panel to the background
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        background.add(panel, gbc);

        // Add action listener to calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMetrics();
            }
        });

        // Add action listener to back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(true);
                dispose();
            }
        });
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void calculateMetrics() {
        try {
            double height = Double.parseDouble(heightField.getText()) / 100; // convert to meters
            double weight = Double.parseDouble(weightField.getText());
            int age = Integer.parseInt(ageField.getText());
            String gender = (String) genderBox.getSelectedItem();
            String activityLevel = (String) activityLevelBox.getSelectedItem();
            double currentWaterIntake = Double.parseDouble(currentWaterIntakeField.getText());
            double currentCalories = Double.parseDouble(currentCaloriesField.getText());
            int exerciseFrequency = Integer.parseInt(exerciseFrequencyField.getText());
            int exerciseDuration = Integer.parseInt(exerciseDurationField.getText());

            // Calculate BMI
            double bmi = weight / (height * height);
            String bmiCategory = getBMICategory(bmi);
            bmiResultLabel.setText(String.format("Your BMI is: %.2f - %s", bmi, bmiCategory));

            // Calculate BMR
            double bmr = calculateBMR(height, weight, age, gender);
            bmrResultLabel.setText(String.format("Your BMR is: %.2f calories/day", bmr));

            // Calculate Body Fat Percentage
            double bodyFat = calculateBodyFatPercentage(bmi, age, gender);
            bodyFatResultLabel.setText(String.format("Your Body Fat Percentage is: %.2f%%", bodyFat));

            // Calculate Water Intake
            double recommendedWaterIntake = calculateWaterIntake(weight);
            waterIntakeLabel.setText(String.format("Recommended Daily Water Intake: %.2f liters", recommendedWaterIntake));

            // Calculate Macronutrient Distribution
            String macronutrientDistribution = calculateMacronutrientDistribution(bmr, activityLevel);
            macronutrientLabel.setText("<html><body style='width: 250px'>" + macronutrientDistribution + "</body></html>");

            // Assess Fitness Level
            String fitnessLevel = assessFitnessLevel(bmiCategory, bodyFat);
            fitnessLevelLabel.setText("Fitness Level: " + fitnessLevel);

            // Provide Exercise Advice
            String exerciseAdvice = provideExerciseAdvice(exerciseFrequency, exerciseDuration);
            exerciseAdviceLabel.setText("<html><body style='width: 250px'>" + exerciseAdvice + "</body></html>");

            // Provide Health Advice
            String advice = provideHealthAdvice(bmiCategory, currentWaterIntake, recommendedWaterIntake, currentCalories, bmr);
            adviceLabel.setText(String.format("<html><body style='width: 250px'>%s</body></html>", advice));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for height, weight, age, water intake, calorie intake, exercise frequency, and exercise duration.");
        }
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    private double calculateBMR(double height, double weight, int age, String gender) {
        // BMR calculation using Mifflin-St Jeor Equation
        if (gender.equals("Male")) {
            return 10 * weight + 6.25 * height * 100 + 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height * 100 + 5 * age - 161;
        }
    }

    private double calculateBodyFatPercentage(double bmi, int age, String gender) {
        // Body fat percentage estimation using BMI
        if (gender.equals("Male")) {
            return (1.20 * bmi) + (0.23 * age) - 16.2;
        } else {
            return (1.20 * bmi) + (0.23 * age) - 5.4;
        }
    }

    private double calculateWaterIntake(double weight) {
        // Recommended water intake in liters
        return weight * 0.033;
    }

    private String calculateMacronutrientDistribution(double bmr, String activityLevel) {
        double activityMultiplier;

        switch (activityLevel) {
            case "Sedentary":
                activityMultiplier = 1.2;
                break;
            case "Lightly active":
                activityMultiplier = 1.375;
                break;
            case "Moderately active":
                activityMultiplier = 1.55;
                break;
            case "Very active":
                activityMultiplier = 1.725;
                break;
            case "Extra active":
                activityMultiplier = 1.9;
                break;
            default:
                activityMultiplier = 1.2;
        }

        double dailyCalories = bmr * activityMultiplier;
        double carbs = dailyCalories * 0.5 / 4; // 50% of calories from carbs, 4 kcal/g
        double proteins = dailyCalories * 0.3 / 4; // 30% of calories from proteins, 4 kcal/g
        double fats = dailyCalories * 0.2 / 9; // 20% of calories from fats, 9 kcal/g

        return String.format("Recommended Daily Macronutrient Intake:\nCarbohydrates: %.2f grams\nProteins: %.2f grams\nFats: %.2f grams",
                carbs, proteins, fats);
    }

    private String assessFitnessLevel(String bmiCategory, double bodyFat) {
        if (bmiCategory.equals("Normal weight") && bodyFat < 25) {
            return "Good";
        } else if (bmiCategory.equals("Overweight") && bodyFat < 30) {
            return "Average";
        } else if (bmiCategory.equals("Obesity")) {
            return "Poor";
        } else {
            return "Needs Improvement";
        }
    }

    private String provideExerciseAdvice(int frequency, int duration) {
        if (frequency >= 5 && duration >= 30) {
            return "Your exercise routine is good! Keep it up for maintaining your health.";
        } else if (frequency >= 3 && duration >= 20) {
            return "Your exercise routine is fair. Try to increase your exercise frequency and duration.";
        } else {
            return "You need to exercise more frequently and for longer durations to improve your health.";
        }
    }

    private String provideHealthAdvice(String bmiCategory, double currentWaterIntake, double recommendedWaterIntake, double currentCalories, double bmr) {
        StringBuilder advice = new StringBuilder();
        advice.append("Health Advice:\n");

        switch (bmiCategory) {
            case "Underweight":
                advice.append("You are underweight. Consider consulting a nutritionist to help you reach a healthier weight. Ensure you eat a balanced diet with enough calories.\n");
                break;
            case "Normal weight":
                advice.append("You have a normal weight. Keep up the good work! Maintain a balanced diet and regular physical activity to stay healthy.\n");
                break;
            case "Overweight":
                advice.append("You are overweight. Consider adopting a healthier diet and increasing your physical activity. Consulting a healthcare provider can also help you develop a plan.\n");
                break;
            case "Obesity":
                advice.append("You are in the obesity range. It's important to consult a healthcare provider to create a plan for weight loss and to check for any related health issues.\n");
                break;
            default:
                advice.append("Error in providing advice.\n");
        }

        if (currentWaterIntake < recommendedWaterIntake) {
            advice.append(String.format("You should increase your water intake to at least %.2f liters per day.\n", recommendedWaterIntake));
        } else {
            advice.append("Your water intake is sufficient.\n");
        }

        if (currentCalories < bmr) {
            advice.append("You should increase your calorie intake to meet your Basal Metabolic Rate (BMR).\n");
        } else if (currentCalories > bmr * 1.2) {
            advice.append("You should decrease your calorie intake to avoid consuming excessive calories.\n");
        } else {
            advice.append("Your calorie intake is within a healthy range.\n");
        }

        return advice.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AssessPhysicalConditionWindow(null).setVisible(true);
            }
        });
    }
}
