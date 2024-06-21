import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutWindow extends JFrame {
    private JFrame mainWindow;
    private ProgressTracker progressTracker;

    public WorkoutWindow(JFrame mainWindow, ProgressTracker progressTracker) {
        this.mainWindow = mainWindow;
        this.progressTracker = progressTracker;

        setTitle("Start Working Out");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Gym image
        JLabel gymImageLabel = new JLabel();
        ImageIcon gymImageIcon = new ImageIcon("gym.jpg"); // Replace with the path to your gym image
        Image scaledImage = gymImageIcon.getImage().getScaledInstance(800, 300, Image.SCALE_SMOOTH);
        gymImageIcon = new ImageIcon(scaledImage);
        gymImageLabel.setIcon(gymImageIcon);
        gymImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(gymImageLabel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        JButton cardioButton = new JButton("Cardio");
        JButton weightsButton = new JButton("Weights");
        JButton backButton = new JButton("Back");

        buttonPanel.add(cardioButton);
        buttonPanel.add(weightsButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        cardioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CardioRoomWindow(WorkoutWindow.this, progressTracker).setVisible(true);
                setVisible(false);
            }
        });

        weightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WeightsRoomWindow(WorkoutWindow.this, progressTracker).setVisible(true);
                setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorkoutWindow(null, new ProgressTracker()).setVisible(true);
            }
        });
    }
}
