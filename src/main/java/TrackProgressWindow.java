import javax.swing.*;
import java.awt.*;

public class TrackProgressWindow extends JFrame {
    private ProgressTracker progressTracker;

    public TrackProgressWindow(JFrame mainWindow, ProgressTracker progressTracker) {
        this.progressTracker = progressTracker;

        setTitle("Track Progress");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Calories burned label
        JLabel caloriesBurnedLabel = new JLabel("Calories Burned: " + progressTracker.getCaloriesBurned(), JLabel.CENTER);
        caloriesBurnedLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(caloriesBurnedLabel, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            mainWindow.setVisible(true);
            dispose();
        });
        add(backButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrackProgressWindow(null, new ProgressTracker()).setVisible(true));
    }
}
