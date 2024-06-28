import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualNutritionistWindow extends JFrame {
    private String[] questions = {
            "What is your primary fitness goal?",
            "How many meals do you eat per day?",
            "What is your preferred source of protein?",
            "How often do you consume vegetables?",
            "How much water do you drink daily?",
            "Do you prefer cooking at home or eating out?",
            "Do you have any dietary restrictions?"
    };

    private String[][] options = {
            {"Lose weight", "Build muscle", "Maintain health"},
            {"1-2", "3-4", "5-6"},
            {"Chicken", "Fish", "Plant-based"},
            {"Every meal", "Once a day", "Few times a week"},
            {"Less than 1 liter", "1-2 liters", "More than 2 liters"},
            {"Cook at home", "Eat out", "Both"},
            {"No restrictions", "Vegetarian", "Vegan"}
    };

    private String[] dietPlans = {
            "Diet Plan for Losing Weight:\n- Breakfast: Oatmeal with fruits\n- Lunch: Grilled chicken salad\n- Dinner: Steamed vegetables with fish\n- Snacks: Nuts and seeds",
            "Diet Plan for Building Muscle:\n- Breakfast: Scrambled eggs with toast\n- Lunch: Chicken breast with quinoa\n- Dinner: Beef steak with sweet potatoes\n- Snacks: Protein shakes and bars",
            "Diet Plan for Maintaining Health:\n- Breakfast: Smoothie with greens and fruits\n- Lunch: Mixed vegetable and bean salad\n- Dinner: Baked salmon with brown rice\n- Snacks: Fresh fruits and yogurt"
    };

    private int currentQuestion = 0;
    private JLabel questionLabel;
    private JComboBox<String> answerComboBox;
    private JButton nextButton;
    private JButton backButton;
    private JButton helpButton;
    private String selectedGoal;
    private JFrame mainWindow;

    public VirtualNutritionistWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Virtual Nutritionist");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for nutritionist image and content
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nutritionist image panel
        JLabel nutritionistImageLabel = new JLabel();
        ImageIcon nutritionistImageIcon = new ImageIcon("nutritionist.jpg");
        Image scaledImage = nutritionistImageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        nutritionistImageIcon = new ImageIcon(scaledImage);
        nutritionistImageLabel.setIcon(nutritionistImageIcon);
        nutritionistImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(nutritionistImageLabel, gbc);

        // Panel for question and answers
        gbc.gridy = 1;
        JPanel questionPanel = new JPanel(new GridBagLayout());
        questionLabel = new JLabel(questions[currentQuestion], JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.insets = new Insets(20, 0, 10, 0);
        questionPanel.add(questionLabel, gbc);

        answerComboBox = new JComboBox<>(options[currentQuestion]);
        answerComboBox.setPreferredSize(new Dimension(300, 30)); // Adjusted size
        answerComboBox.setSelectedIndex(-1); // No selection initially
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        questionPanel.add(answerComboBox, gbc);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answerComboBox.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an answer.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (currentQuestion == 0) {
                        selectedGoal = (String) answerComboBox.getSelectedItem();
                    }
                    currentQuestion++;
                    if (currentQuestion < questions.length) {
                        questionLabel.setText(questions[currentQuestion]);
                        answerComboBox.removeAllItems();
                        for (String option : options[currentQuestion]) {
                            answerComboBox.addItem(option);
                        }
                        answerComboBox.setSelectedIndex(-1); // No selection initially
                    } else {
                        int dietPlanIndex = getDietPlanIndex(selectedGoal);
                        if (dietPlanIndex != -1) {
                            JOptionPane.showMessageDialog(null, dietPlans[dietPlanIndex], "Diet Plan", JOptionPane.INFORMATION_MESSAGE);
                        }
                        JOptionPane.showMessageDialog(null, "Thank you for completing the questionnaire!", "Completed", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        mainWindow.setVisible(true); // Return to main window
                    }
                }
            }
        });
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        questionPanel.add(nextButton, gbc);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    questionLabel.setText(questions[currentQuestion]);
                    answerComboBox.removeAllItems();
                    for (String option : options[currentQuestion]) {
                        answerComboBox.addItem(option);
                    }
                    answerComboBox.setSelectedIndex(-1); // No selection initially
                } else {
                    dispose();
                    mainWindow.setVisible(true); // Return to main window
                }
            }
        });
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 0, 0, 0);
        questionPanel.add(backButton, gbc);

        helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 0, 0);
        questionPanel.add(helpButton, gbc);

        mainPanel.add(questionPanel, gbc);

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);
    }

    private void showHelpDialog() {
        JDialog helpDialog = new JDialog(this, "Help", true);
        helpDialog.setSize(400, 300);
        helpDialog.setLocationRelativeTo(this);
        helpDialog.setLayout(new BorderLayout());

        JTextArea helpText = new JTextArea(
                "Welcome to the Virtual Nutritionist!\n\n" +
                        "This tool will ask you a series of questions to determine your dietary needs and goals.\n\n" +
                        "1. Select the answer that best describes you for each question.\n" +
                        "2. Click 'Next' to proceed to the next question.\n" +
                        "3. If you need to go back to a previous question, click 'Back'.\n" +
                        "4. Once all questions are answered, a personalized diet plan will be displayed.\n\n" +
                        "Use the 'Back' button to return to the main window at any time."
        );
        helpText.setWrapStyleWord(true);
        helpText.setLineWrap(true);
        helpText.setEditable(false);
        helpText.setOpaque(false);
        helpText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        helpDialog.add(new JScrollPane(helpText), BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> helpDialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        helpDialog.add(buttonPanel, BorderLayout.SOUTH);

        helpDialog.setVisible(true);
    }

    private int getDietPlanIndex(String selectedGoal) {
        switch (selectedGoal) {
            case "Lose weight":
                return 0;
            case "Build muscle":
                return 1;
            case "Maintain health":
                return 2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VirtualNutritionistWindow(null).setVisible(true);
            }
        });
    }
}
