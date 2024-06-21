import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightsRoomWindow extends JFrame {
    private JFrame workoutWindow;
    private ProgressTracker progressTracker;

    public WeightsRoomWindow(JFrame workoutWindow, ProgressTracker progressTracker) {
        this.workoutWindow = workoutWindow;
        this.progressTracker = progressTracker;

        setTitle("Weights Room");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Weights room image
        JLabel weightsImageLabel = new JLabel();
        ImageIcon weightsImageIcon = new ImageIcon("weight_room.jpg"); // Replace with the path to your weights room image
        Image scaledImage = weightsImageIcon.getImage().getScaledInstance(800, 300, Image.SCALE_SMOOTH);
        weightsImageIcon = new ImageIcon(scaledImage);
        weightsImageLabel.setIcon(weightsImageIcon);
        weightsImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(weightsImageLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        JButton upperBodyButton = new JButton("Upper Body");
        JButton lowerBodyButton = new JButton("Lower Body");
        JButton backButton = new JButton("Back");

        buttonPanel.add(upperBodyButton);
        buttonPanel.add(lowerBodyButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        upperBodyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressTracker.burnCalories(200); // Assuming 200 calories burned for upper body workout
                JOptionPane.showMessageDialog(null, "You burned 200 calories doing upper body workouts!\nTotal calories burned: " + progressTracker.getCaloriesBurned());
            }
        });

        lowerBodyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressTracker.burnCalories(250); // Assuming 250 calories burned for lower body workout
                JOptionPane.showMessageDialog(null, "You burned 250 calories doing lower body workouts!\nTotal calories burned: " + progressTracker.getCaloriesBurned());
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workoutWindow.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeightsRoomWindow(null, new ProgressTracker()).setVisible(true);
            }
        });
    }
}
