import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualGym extends JFrame {
    private ProgressTracker progressTracker;

    public VirtualGym() {
        progressTracker = new ProgressTracker();

        // Set up the main frame
        setTitle("Virtual Gym");
        setSize(800, 600); // Initial size before maximizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        setLayout(new BorderLayout());

        // Load the gym icon
        ImageIcon gymIcon = new ImageIcon("welcome.png"); // Replace with the path to your gym icon
        JLabel iconLabel = new JLabel(gymIcon);
        add(iconLabel, BorderLayout.CENTER);

        // Create "READ ME" button
        JButton readMeButton = new JButton("READ ME");
        readMeButton.setFont(new Font("Arial", Font.BOLD, 24));
        add(readMeButton, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10)); // Use GridLayout for more buttons

        JButton exercisesAndAdviceButton = new JButton("Exercises & Advice");
        JButton trackProgressButton = new JButton("Track Progress");
        JButton interactNutritionistButton = new JButton("Virtual Nutritionist/Trainer");
        JButton simulatePurchaseButton = new JButton("Simulate Purchase");
        JButton createTrainingProgramsButton = new JButton("Create Training Programs");
        JButton assessPhysicalConditionButton = new JButton("Assess Physical Condition");
        JButton interactiveGamesButton = new JButton("Interactive Games");
        JButton startWorkoutButton = new JButton("Start Working Out"); // New button

        buttonPanel.add(exercisesAndAdviceButton);
        buttonPanel.add(trackProgressButton);
        buttonPanel.add(interactNutritionistButton);
        buttonPanel.add(simulatePurchaseButton);
        buttonPanel.add(createTrainingProgramsButton);
        buttonPanel.add(assessPhysicalConditionButton);
        buttonPanel.add(interactiveGamesButton);
        buttonPanel.add(startWorkoutButton); // Add new button to the panel

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        exercisesAndAdviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExercisesAndAdviceWindow().setVisible(true);
            }
        });

        trackProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tracking user progress...");
                // Add code to track user progress
            }
        });

        interactNutritionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Interacting with virtual nutritionist...");
                // Add code for virtual nutritionist interaction
            }
        });

        simulatePurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Eshop().setVisible(true);
            }
        });

        createTrainingProgramsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Program().setVisible(true);
            }
        });

        assessPhysicalConditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide main window
                new AssessPhysicalConditionWindow(VirtualGym.this).setVisible(true);
            }
        });

        interactiveGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide main window
                new InteractiveGamesWindow(VirtualGym.this).setVisible(true);
            }
        });

        // Add action listener to "READ ME" button
        readMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Οδηγίες Χρήσης Εφαρμογής:\n\n" +
                                "1. Exercises & Advice:\n" +
                                "   - Πατήστε το κουμπί 'Exercises & Advice'. Θα ανοίξει ένα νέο παράθυρο που περιέχει μια λίστα από ασκήσεις και συμβουλές διατροφής. Μπορείτε να διαβάσετε και να ακολουθήσετε αυτές τις συμβουλές για καλύτερα αποτελέσματα.\n\n" +
                                "2. Track Progress:\n" +
                                "   - Πατήστε το κουμπί 'Track Progress'. Θα ανοίξει ένα παράθυρο παρακολούθησης προόδου. Εκεί μπορείτε να εισάγετε τα δεδομένα της προπόνησής σας και να παρακολουθείτε την πρόοδό σας με την πάροδο του χρόνου.\n\n" +
                                "3. Virtual Nutritionist/Trainer:\n" +
                                "   - Πατήστε το κουμπί 'Virtual Nutritionist/Trainer'. Θα ανοίξει ένα ερωτηματολόγιο. Απαντήστε στις ερωτήσεις σχετικά με τις διατροφικές σας συνήθειες και στόχους. Μετά την ολοκλήρωση, θα λάβετε εξατομικευμένες προτάσεις διατροφής και προπόνησης.\n\n" +
                                "4. Simulate Purchase:\n" +
                                "   - Πατήστε το κουμπί 'Simulate Purchase'. Θα ανοίξει ένα παράθυρο καταστήματος. Μπορείτε να περιηγηθείτε στα διαθέσιμα προϊόντα, να επιλέξετε την ποσότητα και να προσομοιώσετε μια αγορά.\n\n" +
                                "5. Create Training Programs:\n" +
                                "   - Πατήστε το κουμπί 'Create Training Programs'. Θα ανοίξει ένα παράθυρο όπου μπορείτε να δημιουργήσετε το δικό σας πρόγραμμα προπόνησης. Εισάγετε τα προσωπικά σας στοιχεία και στόχους, και πατήστε το κουμπί 'Generate Program' για να δείτε το πρόγραμμα που δημιουργήθηκε για εσάς.\n\n" +
                                "6. Assess Physical Condition:\n" +
                                "   - Πατήστε το κουμπί 'Assess Physical Condition'. Θα ανοίξει ένα παράθυρο αξιολόγησης της φυσικής σας κατάστασης. Εισάγετε τα δεδομένα όπως το ύψος, το βάρος, την ηλικία και άλλες παραμέτρους και πατήστε το κουμπί 'Calculate' για να δείτε την ανάλυση της φυσικής σας κατάστασης.\n\n" +
                                "7. Interactive Games:\n" +
                                "   - Πατήστε το κουμπί 'Interactive Games'. Θα ανοίξει ένα παράθυρο με διαδραστικά παιχνίδια. Επιλέξτε ένα από τα παιχνίδια για να δοκιμάσετε τις ικανότητές σας στην αντίδραση, τη μνήμη και άλλες δεξιότητες.\n\n" +
                                "8. Start Working Out:\n" +
                                "   - Πατήστε το κουμπί 'Start Working Out'. Θα ανοίξει ένα παράθυρο με επιλογές προπόνησης. Επιλέξτε τον τύπο προπόνησης (καρδιολογική ή με βάρη) και ακολουθήστε τις οδηγίες για να ξεκινήσετε την προπόνησή σας.\n\n" +
                                "Χρησιμοποιήστε το μενού για να πλοηγηθείτε σε όλες τις διαθέσιμες λειτουργίες και να βελτιώσετε τη φυσική σας κατάσταση.",
                        "Οδηγίες Χρήσης", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        interactNutritionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VirtualNutritionistWindow(VirtualGym.this).setVisible(true);
                setVisible(false);
            }
        });

        startWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkoutWindow(VirtualGym.this, progressTracker).setVisible(true);
                setVisible(false);
            }
        });

        trackProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrackProgressWindow(VirtualGym.this, progressTracker).setVisible(true);
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VirtualGym().setVisible(true);
            }
        });
    }
}
