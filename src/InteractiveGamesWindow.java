import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractiveGamesWindow extends JFrame {
    private JFrame mainWindow;

    public InteractiveGamesWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Interactive Games and Exercises");
        setSize(800, 600); // Initial size before maximizing
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Set background image
        JLabel background = new JLabel(new ImageIcon("interactive_games.jpg"));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // Create and add components to the panel
        JPanel panel = new JPanel();
        panel.setOpaque(true); // Ensure panel is not transparent
        panel.setBackground(new Color(255, 255, 255, 180)); // Set semi-transparent white background
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridBagLayout());

        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        JLabel titleLabel = new JLabel("Interactive Games and Exercises");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton game1Button = new JButton("Game 1: Proper Squat Technique");
        game1Button.setFont(buttonFont);
        JButton game2Button = new JButton("Game 2: Push-Up Challenge");
        game2Button.setFont(buttonFont);
        JButton game3Button = new JButton("Game 3: Plank Contest");
        game3Button.setFont(buttonFont);

        JButton backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(game1Button, gbc);

        gbc.gridy = 2;
        panel.add(game2Button, gbc);

        gbc.gridy = 3;
        panel.add(game3Button, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backButton, gbc);

        // Add the panel to the background
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        background.add(panel, gbc);

        // Add action listeners to buttons
        game1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGame1Instructions();
            }
        });

        game2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGame2Instructions();
            }
        });

        game3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showGame3Instructions();
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

    private void showGame1Instructions() {
        JOptionPane.showMessageDialog(this, "Game 1: Proper Squat Technique\n\n" +
                        "1. Stand with feet shoulder-width apart.\n" +
                        "2. Lower your body by bending your knees and hips.\n" +
                        "3. Keep your back straight and knees behind your toes.\n" +
                        "4. Rise back up to the starting position.\n\n" +
                        "Try to perform as many squats as you can with proper technique!",
                "Squat Technique Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGame2Instructions() {
        JOptionPane.showMessageDialog(this, "Game 2: Push-Up Challenge\n\n" +
                        "1. Get into a high plank position with your hands under your shoulders.\n" +
                        "2. Lower your body until your chest nearly touches the floor.\n" +
                        "3. Push yourself back up to the starting position.\n\n" +
                        "See how many push-ups you can do in one minute!",
                "Push-Up Challenge Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGame3Instructions() {
        JOptionPane.showMessageDialog(this, "Game 3: Plank Contest\n\n" +
                        "1. Get into a forearm plank position.\n" +
                        "2. Keep your body in a straight line from head to heels.\n" +
                        "3. Hold the position as long as you can.\n\n" +
                        "Challenge yourself to hold the plank for as long as possible!",
                "Plank Contest Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InteractiveGamesWindow(null).setVisible(true);
            }
        });
    }
}
