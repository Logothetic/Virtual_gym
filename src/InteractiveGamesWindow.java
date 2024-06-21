import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
        JLabel background = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\Odysseas\\IdeaProjects\\Virtual\\interactive_games.jpg").getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH)));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // Create and add components to the panel
        JPanel panel = new JPanel();
        panel.setOpaque(true); // Ensure panel is not transparent
        panel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background for better contrast
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridBagLayout());

        Font labelFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);

        JLabel titleLabel = new JLabel("Interactive Games and Exercises");
        titleLabel.setFont(labelFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton game4Button = createStyledButton("Game 1: Reaction Time", buttonFont);
        JButton game5Button = createStyledButton("Game 2: Memory Sequence Game", buttonFont);
        JButton game6Button = createStyledButton("Game 3: Simple Reflex Game", buttonFont);
        JButton game7Button = createStyledButton("Game 4: Jumping Jacks Challenge", buttonFont);
        JButton backButton = createStyledButton("Back", buttonFont);

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
        panel.add(game4Button, gbc);

        gbc.gridy = 2;
        panel.add(game5Button, gbc);

        gbc.gridy = 3;
        panel.add(game6Button, gbc);

        gbc.gridy = 4;
        panel.add(game7Button, gbc);

        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backButton, gbc);

        // Center the panel in the background
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        background.add(panel, gbc);

        // Add action listeners to buttons
        game4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdvancedReactionTimeGame();
            }
        });

        game5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMemorySequenceGame();
            }
        });

        game6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSimpleReflexGame();
            }
        });

        game7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJumpingJacksChallenge();
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

    private JButton createStyledButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
        instructions.setFont(new Font("Arial", Font.BOLD, 18));
        instructions.setForeground(Color.WHITE);

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
        instructions.setFont(new Font("Arial", Font.BOLD, 18));
        instructions.setForeground(Color.WHITE);

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
        reactionPanel.add(instructions, gbc);

        for (int i = 0; i < 4; i++) {
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
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
        instructions.setFont(new Font("Arial", Font.BOLD, 18));
        instructions.setForeground(Color.WHITE);
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

    private void showJumpingJacksChallenge() {
        JFrame jumpingJacksFrame = new JFrame("Jumping Jacks Challenge");
        jumpingJacksFrame.setSize(400, 300);
        jumpingJacksFrame.setLocationRelativeTo(this);

        JPanel jumpingJacksPanel = new JPanel();
        jumpingJacksPanel.setLayout(new GridBagLayout());
        jumpingJacksPanel.setBackground(new Color(0, 0, 0, 180)); // Set semi-transparent black background

        JLabel instructions = new JLabel("Perform as many jumping jacks as you can in 30 seconds!");
        instructions.setFont(new Font("Arial", Font.BOLD, 18));
        instructions.setForeground(Color.WHITE);
        instructions.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        JLabel countLabel = new JLabel("Count: 0");
        countLabel.setFont(new Font("Arial", Font.BOLD, 24));
        countLabel.setForeground(Color.WHITE);
        countLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        JButton incrementButton = new JButton("Jump!");
        incrementButton.setPreferredSize(new Dimension(200, 50)); // Set preferred size
        incrementButton.setFont(new Font("Arial", Font.BOLD, 24));
        incrementButton.setBackground(new Color(70, 130, 180));
        incrementButton.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jumpingJacksPanel.add(instructions, gbc);

        gbc.gridy = 1;
        jumpingJacksPanel.add(countLabel, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span both columns
        gbc.fill = GridBagConstraints.NONE; // Adjust fill
        jumpingJacksPanel.add(incrementButton, gbc);

        jumpingJacksFrame.add(jumpingJacksPanel);
        jumpingJacksFrame.setVisible(true);

        incrementButton.addActionListener(new ActionListener() {
            int count = 0;
            Timer timer = new Timer(30000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    incrementButton.setEnabled(false);
                    JOptionPane.showMessageDialog(jumpingJacksFrame,
                            "Time's up! You did " + count + " jumping jacks.",
                            "Challenge Over", JOptionPane.INFORMATION_MESSAGE);
                    jumpingJacksFrame.dispose();
                }
            });

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    timer.start();
                }
                count++;
                countLabel.setText("Count: " + count);
            }
        });
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
