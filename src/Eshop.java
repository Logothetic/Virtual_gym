import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eshop extends JFrame {
    private JPanel mainPanel;
    private JButton[] purchaseButtons;
    private JLabel[] productLabels;
    private JComboBox<Integer>[] quantitySelectors;

    public Eshop() {
        setTitle("Virtual Gym Eshop");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(6, 3, 10, 10));

        // Product names
        String[] productNames = {
                "Dumbell",
                "Jump Rope",
                "Fitness Mat",
                "Push Up Board",
                "Yoga Ball",
                "Nutrition Program"
        };


        String[] imagePaths = {
                "dumbell.jpg",
                "jump_rope.jpg",
                "mat.jpg",
                "pushup_board.jpg",
                "yoga_ball.jpg",
                "nutrition_program.jpg"
        };

        // Initialize components arrays
        productLabels = new JLabel[productNames.length];
        purchaseButtons = new JButton[productNames.length];
        quantitySelectors = new JComboBox[productNames.length];

        for (int i = 0; i < productNames.length; i++) {
            ImageIcon productIcon = new ImageIcon(new ImageIcon(imagePaths[i]).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

            // Set up labels with images
            productLabels[i] = new JLabel(productIcon);
            productLabels[i].setHorizontalAlignment(JLabel.CENTER);


            quantitySelectors[i] = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});

            // Set up buttons
            purchaseButtons[i] = new JButton("Purchase " + productNames[i]);
            final int index = i;
            purchaseButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = (int) quantitySelectors[index].getSelectedItem();
                    simulatePurchase(productNames[index], quantity);
                }
            });


            productPanel.add(productLabels[i]);
            productPanel.add(quantitySelectors[i]);
            productPanel.add(purchaseButtons[i]);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        // Add the back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        buttonPanel.add(backButton);


        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });
        buttonPanel.add(helpButton);

        mainPanel.add(new JLabel("Virtual Gym Eshop", JLabel.CENTER), BorderLayout.NORTH);
        mainPanel.add(productPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void simulatePurchase(String item, int quantity) {
        JOptionPane.showMessageDialog(this, "You have purchased: " + item + " (Quantity: " + quantity + ")", "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showHelpDialog() {
        String helpMessage = "Welcome to the Virtual Gym Eshop!\n\n" +
                "Here's how you can use this application:\n" +
                "1. Browse through the products displayed.\n" +
                "2. Select the quantity you wish to purchase from the dropdown.\n" +
                "3. Click the 'Purchase' button next to the product to make a purchase.\n" +
                "4. Click 'Back' to close the shop.\n" +
                "5. If you need further assistance, click 'Help'.";
        JOptionPane.showMessageDialog(this, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Eshop().setVisible(true);
            }
        });
    }
}
