import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualGym extends JFrame {
    public VirtualGym() {
        // Set up the main frame
        setTitle("Virtual Gym");
        setSize(800, 600); // Initial size before maximizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        setLayout(new BorderLayout());

        // Load the gym icon
        ImageIcon gymIcon = new ImageIcon("welcome.png"); // Replace with the path to your gym icon
        JLabel iconLabel = new JLabel(gymIcon);
        add(iconLabel, BorderLayout.CENTER);

        // Create "READ ME" button
        JButton readMeButton = new JButton("READ ME");
        readMeButton.setFont(new Font("Arial", Font.BOLD, 24));
        add(readMeButton, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10)); // Use GridLayout for more buttons

        JButton exercisesAndAdviceButton = new JButton("Exercises & Advice");
        JButton trackProgressButton = new JButton("Track Progress");
        JButton interactNutritionistButton = new JButton("Virtual Nutritionist");
        JButton interactTrainerButton = new JButton("Virtual Trainer");
        JButton simulatePurchaseButton = new JButton("Simulate Purchase");
        JButton createTrainingProgramsButton = new JButton("Create Training Programs");
        JButton assessPhysicalConditionButton = new JButton("Assess Physical Condition");
        JButton interactiveGamesButton = new JButton("Interactive Games");

        buttonPanel.add(exercisesAndAdviceButton);
        buttonPanel.add(trackProgressButton);
        buttonPanel.add(interactNutritionistButton);
        buttonPanel.add(interactTrainerButton);
        buttonPanel.add(simulatePurchaseButton);
        buttonPanel.add(createTrainingProgramsButton);
        buttonPanel.add(assessPhysicalConditionButton);
        buttonPanel.add(interactiveGamesButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        exercisesAndAdviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExercisesAndAdviceWindow().setVisible(true);
            }
        });

        trackProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tracking user progress...");
                // Add code to track user progress
            }
        });

        interactNutritionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Interacting with virtual nutritionist...");
                // Add code for virtual nutritionist interaction
            }
        });

        interactTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Interacting with virtual trainer...");
                // Add code for virtual trainer interaction
            }
        });

        simulatePurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Eshop().setVisible(true);
            }
        });

        createTrainingProgramsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Program().setVisible(true);
            }
        });

        assessPhysicalConditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide main window
                new AssessPhysicalConditionWindow(VirtualGym.this).setVisible(true);
            }
        });

        interactiveGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide main window
                new InteractiveGamesWindow(VirtualGym.this).setVisible(true);
            }
        });

        // Add action listener to "READ ME" button
        readMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Welcome to the gym! Here you can be fit and healthy. Enjoy your workout and have fun!", "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VirtualGym().setVisible(true);
            }
        });
    }
}
