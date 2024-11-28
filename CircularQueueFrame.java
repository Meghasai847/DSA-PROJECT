import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CircularQueueFrame extends JFrame {

    private JTextField queueSizeInputField;
    private JTextField queueElementInputField;
    private JTextField queueDeletedElementField;
    private JTextField queueDisplayField;

    private int[] q;
    private int size;
    private int rear = -1;
    private int front = -1;

    public CircularQueueFrame(JFrame homeFrame) {

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
        setContentPane(backgroundPanel);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backgroundPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("CIRCULAR-QUEUE DATA STRUCTURE");
        lblNewLabel.setBounds(553, 27, 385, 26);
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(lblNewLabel);

        JLabel queueSizeLabel = new JLabel("QUEUE-SIZE");
        queueSizeLabel.setBounds(309, 163, 136, 26);
        queueSizeLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueSizeLabel);

        queueSizeInputField = new JTextField();
        queueSizeInputField.setBounds(476, 158, 121, 35);
        queueSizeInputField.setHorizontalAlignment(SwingConstants.CENTER);
        queueSizeInputField.setColumns(10);
        backgroundPanel.add(queueSizeInputField);

        JButton queueCreateBtn = new JButton("CREATE");
        queueCreateBtn.addActionListener(e -> {
            try {
                int inputSize = Integer.parseInt(queueSizeInputField.getText().trim());
                this.size = inputSize;
                if (size > 0) {
                    q = new int[size];
                    rear = -1;
                    front = -1;
                    JOptionPane.showMessageDialog(this, "Queue of size " + size + " has been created successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Size of the queue cannot be zero or negative!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer for queue size!");
            }
        });
        queueCreateBtn.setBounds(860, 158, 144, 35);
        queueCreateBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueCreateBtn);

        JLabel queueElementLabel = new JLabel("ELEMENT");
        queueElementLabel.setBounds(309, 304, 134, 26);
        queueElementLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueElementLabel);

        queueElementInputField = new JTextField();
        queueElementInputField.setBounds(476, 293, 121, 35);
        queueElementInputField.setHorizontalAlignment(SwingConstants.CENTER);
        queueElementInputField.setColumns(10);
        backgroundPanel.add(queueElementInputField);

        JButton queueElementInsertBtn = new JButton("INSERT");
        queueElementInsertBtn.addActionListener(e -> {
            try {
                if (q == null) {
                    JOptionPane.showMessageDialog(this, "Please create a Circular Queue first!");
                    return;
                }
                if ((rear + 1) % size == front) {
                    JOptionPane.showMessageDialog(this, "OOPS! Queue is full!");
                } else {
                    int elem = Integer.parseInt(queueElementInputField.getText().trim());
                    if (front == -1) {
                        front = 0;
                    }
                    rear = (rear + 1) % size;
                    q[rear] = elem;
                    JOptionPane.showMessageDialog(this, "Element " + elem + " has been inserted successfully!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer element to insert!");
            }
        });
        queueElementInsertBtn.setBounds(860, 293, 144, 35);
        queueElementInsertBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueElementInsertBtn);

        JLabel queueElementDeletedLabel = new JLabel("ELEMENT-DELETED");
        queueElementDeletedLabel.setBounds(309, 443, 211, 26);
        queueElementDeletedLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueElementDeletedLabel);

        queueDeletedElementField = new JTextField();
        queueDeletedElementField.setBounds(530, 438, 121, 35);
        queueDeletedElementField.setHorizontalAlignment(SwingConstants.CENTER);
        queueDeletedElementField.setColumns(10);
        backgroundPanel.add(queueDeletedElementField);

        JButton queueElementDeleteBtn = new JButton("DELETE");
        queueElementDeleteBtn.addActionListener(e -> {
            if (q == null || front == -1) {
                JOptionPane.showMessageDialog(this, "OOPS! Queue is empty cannot delete!");
            } else {
                int deletedElem = q[front];
                queueDeletedElementField.setText(String.valueOf(deletedElem));
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else {
                    front = (front + 1) % size;
                }
                JOptionPane.showMessageDialog(this, "Element " + deletedElem + " has been deleted successfully!");
            }
        });
        queueElementDeleteBtn.setBounds(860, 434, 144, 35);
        queueElementDeleteBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueElementDeleteBtn);

        JButton queueBackBtn = new JButton("BACK");
        queueBackBtn.addActionListener(e -> {
            this.setVisible(false);
            homeFrame.setVisible(true);
        });
        queueBackBtn.setBounds(704, 666, 144, 35);
        queueBackBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueBackBtn);

        queueDisplayField = new JTextField();
        queueDisplayField.setBounds(482, 553, 348, 35);
        queueDisplayField.setHorizontalAlignment(SwingConstants.CENTER);
        queueDisplayField.setColumns(10);
        backgroundPanel.add(queueDisplayField);

        JButton queueDisplayBtn = new JButton("DISPLAY");
        queueDisplayBtn.addActionListener(e -> {
            if (q == null || front == -1) {
                JOptionPane.showMessageDialog(this, "OOPS! Queue is empty cannot display!");
            } else {
                StringBuilder s = new StringBuilder();
                int i = front;
                while (true) {
                    s.append(q[i]).append(" ");
                    if (i == rear) break;
                    i = (i + 1) % size;
                }
                queueDisplayField.setText(s.toString().trim());
            }
        });
        queueDisplayBtn.setBounds(860, 554, 144, 35);
        queueDisplayBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(queueDisplayBtn);

        JLabel CircularQueueElementsLabel = new JLabel("QUEUE-ELEMENTS");
        CircularQueueElementsLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        CircularQueueElementsLabel.setBounds(266, 564, 206, 26);
        backgroundPanel.add(CircularQueueElementsLabel);
    }
}
