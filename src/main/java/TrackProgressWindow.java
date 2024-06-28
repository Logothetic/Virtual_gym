import javax.swing.*;
import java.awt.*;

public class TrackProgressWindow extends JFrame {
    private ProgressTracker progressTracker;
    private JFrame mainWindow;

    public TrackProgressWindow(JFrame mainWindow, ProgressTracker progressTracker) {
        this.mainWindow = mainWindow;
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

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            mainWindow.setVisible(true);
            dispose();
        });
        buttonPanel.add(backButton);

        // Help button
        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(e -> showHelpDialog());
        buttonPanel.add(helpButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showHelpDialog() {
        JDialog helpDialog = new JDialog(this, "Help", true);
        helpDialog.setSize(400, 300);
        helpDialog.setLocationRelativeTo(this);
        helpDialog.setLayout(new BorderLayout());

        JTextArea helpText = new JTextArea(
                "Track your progress here!\n\n" +
                        "This window displays the total calories you have burned so far.\n\n" +
                        "Use the 'Back' button to return to the main window."
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrackProgressWindow(null, new ProgressTracker()).setVisible(true));
    }
}
