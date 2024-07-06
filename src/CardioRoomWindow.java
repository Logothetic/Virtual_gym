import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardioRoomWindow extends JFrame {
    private JFrame workoutWindow;
    private ProgressTracker progressTracker;

    public CardioRoomWindow(JFrame workoutWindow, ProgressTracker progressTracker) {
        this.workoutWindow = workoutWindow;
        this.progressTracker = progressTracker;

        setTitle("Cardio Room");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cardio room image
        JLabel cardioImageLabel = new JLabel();
        ImageIcon cardioImageIcon = new ImageIcon("cardio_room.jpg");
        Image scaledImage = cardioImageIcon.getImage().getScaledInstance(800, 300, Image.SCALE_SMOOTH);
        cardioImageIcon = new ImageIcon(scaledImage);
        cardioImageLabel.setIcon(cardioImageIcon);
        cardioImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(cardioImageLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        JButton treadmillButton = new JButton("Treadmills");
        JButton bicycleButton = new JButton("Bicycle");
        JButton backButton = new JButton("Back");

        buttonPanel.add(treadmillButton);
        buttonPanel.add(bicycleButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        treadmillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressTracker.burnCalories(300); // Assuming 300 calories burned for treadmill
                JOptionPane.showMessageDialog(null, "You burned 300 calories on the treadmill!\nTotal calories burned: " + progressTracker.getCaloriesBurned());
            }
        });

        bicycleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressTracker.burnCalories(250); // Assuming 250 calories burned for bicycle
                JOptionPane.showMessageDialog(null, "You burned 250 calories on the bicycle!\nTotal calories burned: " + progressTracker.getCaloriesBurned());
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
                new CardioRoomWindow(null, new ProgressTracker()).setVisible(true);
            }
        });
    }
}
