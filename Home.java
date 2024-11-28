import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class Home {

    private JFrame frame;
    private JButton doublyLinkedList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Home window = new Home();
                window.frame.setVisible(true); // Show the frame
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public Home() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1025, 798);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen

        // Load the background image from a URL
        Image backgroundImage = null;
        try {
            URL imageUrl = new URL("https://wallpapers.com/images/featured/purple-gradient-background-rmfznb3wauiky4u8.jpg");
            backgroundImage = Toolkit.getDefaultToolkit().getImage(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Custom JPanel for background
        Image finalBackgroundImage = backgroundImage;
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (finalBackgroundImage != null) {
                    g.drawImage(finalBackgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null); // Use absolute layout

        // Add components to the custom panel
        JButton stack = new JButton("STACK");
        stack.addActionListener(e -> {
            StackFrame stackFrame = new StackFrame(frame);
            stackFrame.setVisible(true);
        });
        stack.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stack.setBounds(805, 216, 272, 42);
        backgroundPanel.add(stack);

        JButton queue = new JButton("QUEUE");
        queue.addActionListener(e -> {
            QueueFrame queueFrame = new QueueFrame(frame);
            queueFrame.setVisible(true);
        });
        queue.setFont(new Font("Sitka Text", Font.BOLD, 20));
        queue.setBounds(186, 365, 272, 42);
        backgroundPanel.add(queue);

        JButton circularQueue = new JButton("CIRCULAR-QUEUE");
        circularQueue.addActionListener(e-> {
        	CircularQueueFrame circularQueueFrame = new CircularQueueFrame(frame);
        	circularQueueFrame.setVisible(true);
        	
        });
        circularQueue.setFont(new Font("Sitka Text", Font.BOLD, 20));
        circularQueue.setBounds(805, 365, 272, 42);
        backgroundPanel.add(circularQueue);

        JButton linkedList = new JButton("SINGLY-LINKED-LIST");
        linkedList.addActionListener(e-> {
        	SinglyLinkedListFrame sFrame = new SinglyLinkedListFrame(frame);
        	sFrame.setVisible(true);
        });
        linkedList.setFont(new Font("Sitka Text", Font.BOLD, 20));
        linkedList.setBounds(186, 533, 272, 42);
        backgroundPanel.add(linkedList);

        JButton doublyLinkedList = new JButton("DOUBLY-LINKED-LIST");
        doublyLinkedList.addActionListener(e->{
        	DoublyLinkedListFrame list = new DoublyLinkedListFrame(frame);
        	list.setVisible(true);
        });
        doublyLinkedList.setFont(new Font("Sitka Text", Font.BOLD, 20));
        doublyLinkedList.setBounds(805, 533, 272, 42);
        backgroundPanel.add(doublyLinkedList);

        JLabel lblNewLabel = new JLabel("DATA STRUCTURES");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(516, 53, 272, 42);
        backgroundPanel.add(lblNewLabel);

        JButton array = new JButton("ARRAY");
        array.addActionListener(e -> {
            ArrayFrame arrayFrame = new ArrayFrame(frame);
            arrayFrame.setVisible(true);
        });
        array.setFont(new Font("Sitka Text", Font.BOLD, 20));
        array.setBounds(186, 216, 272, 42);
        backgroundPanel.add(array);

        // Set the custom panel as the content pane
        frame.setContentPane(backgroundPanel);
    }

    public Color getDoublyLinkedListBackground() {
        return doublyLinkedList.getBackground();
    }

    public void setDoublyLinkedListBackground(Color background) {
        doublyLinkedList.setBackground(background);
    }
}
