import javax.swing.*;
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
        mainPanel.setLayout(new GridLayout(6, 3, 10, 10));

        // Product names
        String[] productNames = {
                "Dumbell",
                "Jump Rope",
                "Fitness Mat",
                "Push Up Board",
                "Yoga Ball",
                "Nutrition Program"
        };

        // Product images (assuming you have images named as product1.png, product2.png, etc.)
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

        // Populate the main panel with products
        for (int i = 0; i < productNames.length; i++) {
            // Load images
            ImageIcon productIcon = new ImageIcon(imagePaths[i]);

            // Set up labels with images
            productLabels[i] = new JLabel(productIcon);

            // Set up quantity selector
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

            // Add components to the main panel
            mainPanel.add(productLabels[i]);
            mainPanel.add(quantitySelectors[i]);
            mainPanel.add(purchaseButtons[i]);
        }

        add(mainPanel);
    }

    private void simulatePurchase(String item, int quantity) {
        JOptionPane.showMessageDialog(this, "You have purchased: " + item + " (Quantity: " + quantity + ")", "Purchase Confirmation", JOptionPane.INFORMATION_MESSAGE);
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
