import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> goalComboBox;
    private JTextArea outputArea;
    private JButton generateButton;
    private JButton exitButton;
    private JButton helpButton; // Define the help button
    private JLabel errorLabel;

    public Program() {
        setTitle("Create Customized Training Program");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Input fields
        nameField = new JTextField(20);
        ageField = new JTextField(20);
        String[] goals = {"Lose Weight", "Build Muscle", "Improve Endurance", "Increase Flexibility"};
        goalComboBox = new JComboBox<>(goals);
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);

        // Tooltips
        nameField.setToolTipText("Enter your full name");
        ageField.setToolTipText("Enter your age");
        goalComboBox.setToolTipText("Select your fitness goal");

        // Set up labels
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel goalLabel = new JLabel("Fitness Goal:");
        JLabel outputLabel = new JLabel("Generated Program:");

        // Generate button
        generateButton = new JButton("Generate Program");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateProgram();
            }
        });

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        // Help button
        helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });

        // Add components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(goalLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(goalComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(generateButton, gbc);

        gbc.gridx = 1;
        mainPanel.add(exitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(helpButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(errorLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        mainPanel.add(outputLabel, gbc);

        gbc.gridy = 7;
        mainPanel.add(new JScrollPane(outputArea), gbc);

        add(mainPanel);
    }

    private void generateProgram() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String goal = (String) goalComboBox.getSelectedItem();

        // Input validation
        if (name.isEmpty()) {
            errorLabel.setText("Please enter your name.");
            return;
        }

        if (ageText.isEmpty()) {
            errorLabel.setText("Please enter your age.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            errorLabel.setText("Please enter a valid age.");
            return;
        }

        if (age <= 0) {
            errorLabel.setText("Age must be a positive number.");
            return;
        }

        errorLabel.setText("");

        String program = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Goal: " + goal + "\n\n" +
                "Customized Training Program:\n" +
                "-------------------------------\n";

        switch (goal) {
            case "Lose Weight":
                program += "1. Cardio exercises (30 mins/day)\n" +
                        "2. High-Intensity Interval Training (HIIT)\n" +
                        "3. Healthy diet with calorie deficit\n";
                break;
            case "Build Muscle":
                program += "1. Strength training (4 times/week)\n" +
                        "2. Protein-rich diet\n" +
                        "3. Progressive overload exercises\n";
                break;
            case "Improve Endurance":
                program += "1. Long-distance running (3 times/week)\n" +
                        "2. Interval training\n" +
                        "3. Balanced diet with complex carbs\n";
                break;
            case "Increase Flexibility":
                program += "1. Yoga sessions (3 times/week)\n" +
                        "2. Stretching exercises\n" +
                        "3. Pilates classes\n";
                break;
        }

        outputArea.setText(program);
    }

    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this,
                "To use this application:\n" +
                        "1. Enter your full name in the 'Name' field.\n" +
                        "2. Enter your age in the 'Age' field.\n" +
                        "3. Select your fitness goal from the dropdown menu.\n" +
                        "4. Click 'Generate Program' to see your customized training program.\n" +
                        "5. If you need to exit the application, click the 'Exit' button.",
                "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Program().setVisible(true);
            }
        });
    }
}
