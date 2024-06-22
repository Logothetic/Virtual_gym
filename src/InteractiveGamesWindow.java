import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class InteractiveGamesWindow extends JFrame {
    private JFrame mainWindow;
    private BufferedImage backgroundImage;

    public InteractiveGamesWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Interactive Games and Exercises");
        setSize(800, 600); // Initial size before maximizing
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the application exits on close
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("interactive_games.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set background image
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // Initialize components
        Font labelFont = new Font("Arial", Font.BOLD, 26);
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);

        JLabel titleLabel = new JLabel("Interactive Games and Exercises");
        titleLabel.setFont(labelFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton game1Button = createStyledButton("Game 1: Reaction Time", buttonFont);
        JButton game2Button = createStyledButton("Game 2: Memory Sequence Game", buttonFont);
        JButton game3Button = createStyledButton("Game 3: Simple Reflex Game", buttonFont);
        JButton backButton = createStyledButton("Back", buttonFont);

        // Create and add components to the panel
        JPanel panel = new JPanel();
        panel.setOpaque(true); // Ensure panel is not transparent
        panel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background for better contrast
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(game1Button, gbc);

        gbc.gridy = 2;
        panel.add(game2Button, gbc);

        gbc.gridy = 3;
        panel.add(game3Button, gbc);

        gbc.gridy = 4;
        panel.add(backButton, gbc);

        // Add the panel to the background
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        background.add(panel, gbc);

        // Add action listeners to buttons
        game1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdvancedReactionTimeGame();
            }
        });

        game2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMemorySequenceGame();
            }
        });

        game3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSimpleReflexGame();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainWindow != null) {
                    mainWindow.setVisible(true);
                }
                dispose();
            }
        });
    }

    private JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        button.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
        button.setPreferredSize(new Dimension(300, 50)); // Ensure consistent button size
        return button;
    }

    private void showMemorySequenceGame() {
        JFrame memoryFrame = new JFrame("Memory Sequence Game");
        memoryFrame.setSize(600, 400);
        memoryFrame.setLocationRelativeTo(this);

        JPanel memoryPanel = new JPanel();
        memoryPanel.setLayout(new GridBagLayout());
        memoryPanel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background

        JLabel instructions = new JLabel("Remember the sequence of colors:");
        instructions.setFont(new Font("Arial", Font.BOLD, 20));
        instructions.setForeground(Color.WHITE);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);

        JButton[] sequenceButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            sequenceButtons[i] = new JButton();
            sequenceButtons[i].setPreferredSize(new Dimension(100, 100));
            sequenceButtons[i].setBackground(Color.GRAY);
            sequenceButtons[i].setEnabled(false);
        }

        JButton startButton = createStyledButton("Start", new Font("Arial", Font.BOLD, 24));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        memoryPanel.add(instructions, gbc);

        for (int i = 0; i < 4; i++) {
            gbc.gridy = 1;
            gbc.gridx = i;
            gbc.gridwidth = 1;
            memoryPanel.add(sequenceButtons[i], gbc);
        }

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        memoryPanel.add(startButton, gbc);

        memoryFrame.add(memoryPanel);
        memoryFrame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sequence = new int[4];
                Random random = new Random();
                for (int i = 0; i < 4; i++) {
                    sequence[i] = random.nextInt(4);
                }

                new Thread(() -> {
                    try {
                        for (int i = 0; i < 4; i++) {
                            int buttonIndex = sequence[i];
                            SwingUtilities.invokeLater(() -> {
                                sequenceButtons[buttonIndex].setBackground(Color.YELLOW);
                            });
                            Thread.sleep(1000);
                            SwingUtilities.invokeLater(() -> {
                                sequenceButtons[buttonIndex].setBackground(Color.GRAY);
                            });
                            Thread.sleep(500);
                        }

                        SwingUtilities.invokeLater(() -> {
                            instructions.setText("Repeat the sequence by clicking the buttons:");
                            for (JButton button : sequenceButtons) {
                                button.setEnabled(true);
                                button.setBackground(Color.BLUE);
                            }
                        });

                        int[] userSequence = new int[4];
                        int[] clickCount = {0};

                        ActionListener buttonListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                for (int i = 0; i < 4; i++) {
                                    if (e.getSource() == sequenceButtons[i]) {
                                        userSequence[clickCount[0]] = i;
                                        clickCount[0]++;
                                        if (clickCount[0] == 4) {
                                            boolean correct = true;
                                            for (int j = 0; j < 4; j++) {
                                                if (userSequence[j] != sequence[j]) {
                                                    correct = false;
                                                    break;
                                                }
                                            }
                                            if (correct) {
                                                JOptionPane.showMessageDialog(memoryFrame, "Correct! You remembered the sequence.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(memoryFrame, "Incorrect sequence. Try again!", "Failure", JOptionPane.ERROR_MESSAGE);
                                            }
                                            memoryFrame.dispose();
                                        }
                                        break;
                                    }
                                }
                            }
                        };

                        for (JButton button : sequenceButtons) {
                            button.addActionListener(buttonListener);
                        }

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }).start();
            }
        });
    }

    private void showAdvancedReactionTimeGame() {
        JFrame reactionFrame = new JFrame("Advanced Reaction Time Game");
        reactionFrame.setSize(400, 300);
        reactionFrame.setLocationRelativeTo(this);

        JPanel reactionPanel = new JPanel();
        reactionPanel.setLayout(new GridBagLayout());
        reactionPanel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background

        JLabel instructions = new JLabel("Click the button that lights up as fast as you can!");
        instructions.setFont(new Font("Arial", Font.BOLD, 16));
        instructions.setForeground(Color.WHITE);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setPreferredSize(new Dimension(350, 30)); // Ensure instructions fit within the frame

        JButton[] buttons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton("Wait...");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(false);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Center align instructions
        reactionPanel.add(instructions, gbc);

        for (int i = 0; i < 4; i++) {
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
            reactionPanel.add(buttons[i], gbc);
        }

        reactionFrame.add(reactionPanel);
        reactionFrame.setVisible(true);

        new Thread(() -> {
            try {
                Random random = new Random();
                int waitTime = random.nextInt(5000) + 2000; // Wait between 2 and 7 seconds
                Thread.sleep(waitTime);

                SwingUtilities.invokeLater(() -> {
                    int buttonIndex = random.nextInt(4);
                    buttons[buttonIndex].setText("Click!");
                    buttons[buttonIndex].setBackground(Color.GREEN);
                    buttons[buttonIndex].setEnabled(true);

                    long startTime = System.currentTimeMillis();

                    buttons[buttonIndex].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            long reactionTime = System.currentTimeMillis() - startTime;
                            JOptionPane.showMessageDialog(reactionFrame,
                                    "Your reaction time is " + reactionTime + " milliseconds.",
                                    "Reaction Time", JOptionPane.INFORMATION_MESSAGE);
                            reactionFrame.dispose();
                        }
                    });
                });
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void showSimpleReflexGame() {
        JFrame reflexFrame = new JFrame("Simple Reflex Game");
        reflexFrame.setSize(400, 300);
        reflexFrame.setLocationRelativeTo(this);

        JPanel reflexPanel = new JPanel();
        reflexPanel.setLayout(new GridBagLayout());
        reflexPanel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background

        JLabel instructions = new JLabel("Click the button when it changes color!");
        instructions.setFont(new Font("Arial", Font.BOLD, 20));
        instructions.setForeground(Color.WHITE);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);

        JButton reflexButton = new JButton("Wait...");
        reflexButton.setFont(new Font("Arial", Font.BOLD, 24));
        reflexButton.setBackground(Color.RED);
        reflexButton.setEnabled(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        reflexPanel.add(instructions, gbc);

        gbc.gridy = 1;
        reflexPanel.add(reflexButton, gbc);

        reflexFrame.add(reflexPanel);
        reflexFrame.setVisible(true);

        new Thread(() -> {
            try {
                Random random = new Random();
                int waitTime = random.nextInt(5000) + 2000; // Wait between 2 and 7 seconds
                Thread.sleep(waitTime);

                SwingUtilities.invokeLater(() -> {
                    reflexButton.setText("Click!");
                    reflexButton.setBackground(Color.GREEN);
                    reflexButton.setEnabled(true);

                    long startTime = System.currentTimeMillis();

                    reflexButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            long reactionTime = System.currentTimeMillis() - startTime;
                            JOptionPane.showMessageDialog(reflexFrame,
                                    "Your reaction time is " + reactionTime + " milliseconds.",
                                    "Reaction Time", JOptionPane.INFORMATION_MESSAGE);
                            reflexFrame.dispose();
                        }
                    });
                });
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
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
