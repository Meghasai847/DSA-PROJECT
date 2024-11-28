import java.awt.EventQueue;
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
import java.awt.Color;

public class DoublyLinkedListFrame extends JFrame {

    private JTextField doublyINsertFrontField;
    private JTextField DoublyInsertRearField;
    private JTextField DoublyInsertInterField;
    private JTextField DeletedElementFrontField;
    private JTextField DeletedElementRearField;
    private JTextField DeletedElementInterField;
    private JTextField DisplayFrwdField;
    private JTextField DisplayBackField;
    private double elem;
    class Node
    {
    	Node preLink;
    	double data;
    	Node nextLink;
    	
    }
    Node first;

    /**
     * Create the application.
     * @param frame 
     */
    public DoublyLinkedListFrame(JFrame frame) {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Load background image
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
        setContentPane(backgroundPanel); // Set the custom panel as the content pane

        // Frame configuration
        setTitle("Doubly Linked List Operations");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backgroundPanel.setLayout(null);

        // Add UI components to the panel
        JLabel lblDoublylinkedlist = new JLabel("DOUBLY-LINKED-LIST");
        lblDoublylinkedlist.setBounds(606, 26, 267, 26);
        lblDoublylinkedlist.setForeground(Color.YELLOW);
        lblDoublylinkedlist.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(lblDoublylinkedlist);

        JButton btnInsertfront = new JButton("INSERT-FRONT");
        btnInsertfront.addActionListener(e->{
        	try
        	{
        		Node n = new Node();
                n.data = Double.parseDouble(doublyINsertFrontField.getText().trim());
                n.preLink = null;
                n.nextLink = first;

                if (first != null) {
                    first.preLink = n;
                }
                first = n;
                JOptionPane.showMessageDialog(this, "Element " + n.data+" has been inserted sucessfully!");
        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "Please enter an element to insert!");
        	}
        	
        	
        });
        btnInsertfront.setBounds(897, 116, 195, 35);
        btnInsertfront.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(btnInsertfront);

        JLabel DoublyInsertFrontElementLabel = new JLabel("ELEMENT");
        DoublyInsertFrontElementLabel.setBounds(334, 125, 134, 26);
        DoublyInsertFrontElementLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(DoublyInsertFrontElementLabel);

        doublyINsertFrontField = new JTextField();
        doublyINsertFrontField.setBounds(463, 116, 121, 35);
        doublyINsertFrontField.setHorizontalAlignment(SwingConstants.CENTER);
        doublyINsertFrontField.setColumns(10);
        backgroundPanel.add(doublyINsertFrontField);
        
        
        JButton btnInsertrear = new JButton("INSERT-REAR");
        btnInsertrear.addActionListener(e-> {
        	try
        	{
        		 Node n = new Node();
                 n.data = Double.parseDouble(DoublyInsertRearField.getText().trim());
                 n.nextLink = null;

                 if (first == null) {
                     n.preLink = null;
                     first = n;
                 } else {
                     Node temp = first;
                     while (temp.nextLink != null) {
                         temp = temp.nextLink;
                     }
                     temp.nextLink = n;
                     n.preLink = temp;
                 }
                 JOptionPane.showMessageDialog(this, "Element " + n.data+" has been inserted sucessfully!");

        	}
        	catch(NumberFormatException ex)
        	{
                JOptionPane.showMessageDialog(this, "Please enter an element to insert!");

        	}
        	
        });
        btnInsertrear.setBounds(897, 199, 195, 35);
		btnInsertrear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(btnInsertrear);	
		
		JLabel DoublyInseetRearLabel = new JLabel("ELEMENT");
		DoublyInseetRearLabel.setBounds(334, 203, 134, 26);
		DoublyInseetRearLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(DoublyInseetRearLabel);
		
		
		DoublyInsertRearField = new JTextField();
		DoublyInsertRearField.setBounds(463, 198, 121, 35);
		DoublyInsertRearField.setHorizontalAlignment(SwingConstants.CENTER);
		DoublyInsertRearField.setColumns(10);
		backgroundPanel.add(DoublyInsertRearField);
		

		DoublyInsertInterField = new JTextField();
		DoublyInsertInterField.setBounds(463, 276, 121, 35);
		DoublyInsertInterField.setHorizontalAlignment(SwingConstants.CENTER);
		DoublyInsertInterField.setColumns(10);
		backgroundPanel.add(DoublyInsertInterField);
		
		JLabel DoublyInsertInterLabel = new JLabel("ELEMENT");
		DoublyInsertInterLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		DoublyInsertInterLabel.setBounds(334, 281, 134, 26);
		backgroundPanel.add(DoublyInsertInterField);
		
		JButton btnInsertInter = new JButton("INSERT-INTERMEDIATE");
		btnInsertInter.addActionListener(e->{
			try
			{
				 Node n = new Node();
		            n.data = Double.parseDouble(DoublyInsertInterField.getText().trim());
		            int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position to insert (1-based):"));

		            if (position == 1) { // Insert at front
		                n.nextLink = first;
		                if (first != null) {
		                    first.preLink = n;
		                }
		                first = n;
		                 JOptionPane.showMessageDialog(this, "Element " + n.data+" has been inserted sucessfully!");

		            } else {
		                Node temp = first;
		                int count = 1;
		                while (temp != null && count < position - 1) {
		                    temp = temp.nextLink;
		                    count++;
		                }

		                if (temp != null) {
		                    n.nextLink = temp.nextLink;
		                    if (temp.nextLink != null) {
		                        temp.nextLink.preLink = n;
		                    }
		                    temp.nextLink = n;
		                    n.preLink = temp;
		                    JOptionPane.showMessageDialog(this, "Element " + n.data+" has been inserted sucessfully!");

		                } else {
		                    JOptionPane.showMessageDialog(null, "Invalid Position!");
		                }
		                
		            }
			}
			catch(NumberFormatException ex)
			{
                JOptionPane.showMessageDialog(this, "Please enter an element to insert!");

			}
			
		});
		btnInsertInter.setBounds(897, 277, 285, 35);
		btnInsertInter.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(btnInsertInter);
		
		JButton btnDeletefront = new JButton("DELETE-FRONT");
		btnDeletefront.addActionListener(e->{
			 if (first != null) {
	                DeletedElementFrontField.setText(String.valueOf(first.data));
	                JOptionPane.showMessageDialog(this, "element "+first.data+" Deleted successfully!");
	                first = first.nextLink;
	                if (first != null) {
	                    first.preLink = null;
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "List is empty!");
	            }
		});
		btnDeletefront.setBounds(897, 357, 195, 35);
		btnDeletefront.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(btnDeletefront);
		
		JButton btnDeleterear = new JButton("DELETE-REAR");
		btnDeleterear.addActionListener(e->{
			 if (first != null) {
	                Node temp = first;
	                while (temp.nextLink != null) {
	                    temp = temp.nextLink;
	                }
	                DeletedElementRearField.setText(String.valueOf(temp.data));
	                JOptionPane.showMessageDialog(this, "element "+first.data+" Deleted successfully!");

	                if (temp.preLink != null) {
	                    temp.preLink.nextLink = null;
	                } else {
	                    first = null; // Single element case
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "List is empty!");
	            }
		});
		btnDeleterear.setBounds(897, 431, 195, 35);
		btnDeleterear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(btnDeleterear);	
		
		JButton btnDeleteintermediate = new JButton("DELETE-INTERMEDIATE");
		btnDeleteintermediate.addActionListener(e->{
			int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position to delete (1-based):"));
            if (first == null) {
                JOptionPane.showMessageDialog(null, "List is empty!");
                return;
            }

            if (position == 1) {
                DeletedElementInterField.setText(String.valueOf(first.data));
                first = first.nextLink;
                if (first != null) {
                    first.preLink = null;
                }
            } else {
                Node temp = first;
                int count = 1;
                while (temp != null && count < position) {
                    temp = temp.nextLink;
                    count++;
                }

                if (temp != null) {
                    DeletedElementInterField.setText(String.valueOf(temp.data));
	                JOptionPane.showMessageDialog(this, "element "+first.data+" Deleted successfully!");

                    if (temp.preLink != null) {
                        temp.preLink.nextLink = temp.nextLink;
                    }
                    if (temp.nextLink != null) {
                        temp.nextLink.preLink = temp.preLink;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Position!");
                }
            }
		});
		btnDeleteintermediate.setBounds(897, 513, 286, 35);
		btnDeleteintermediate.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(btnDeleteintermediate);
		
		JLabel lblDeletedelementFront = new JLabel("DELETED-ELEMENT");
		lblDeletedelementFront.setBounds(225, 361, 212, 26);
		lblDeletedelementFront.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(lblDeletedelementFront);
		
		DeletedElementFrontField = new JTextField();
		DeletedElementFrontField.setBounds(463, 356, 121, 35);
		DeletedElementFrontField.setHorizontalAlignment(SwingConstants.CENTER);
		DeletedElementFrontField.setColumns(10);
		backgroundPanel.add(DeletedElementFrontField);
		
		DeletedElementRearField = new JTextField();
		DeletedElementRearField.setBounds(463, 430, 121, 35);
		DeletedElementRearField.setHorizontalAlignment(SwingConstants.CENTER);
		DeletedElementRearField.setColumns(10);
		backgroundPanel.add(DeletedElementRearField);
		
		DeletedElementInterField = new JTextField();
		DeletedElementInterField.setBounds(463, 512, 121, 35);
		DeletedElementInterField.setHorizontalAlignment(SwingConstants.CENTER);
		DeletedElementInterField.setColumns(10);
		backgroundPanel.add(DeletedElementInterField);
		
		JLabel lblDeletedelementRear = new JLabel("DELETED-ELEMENT");
		lblDeletedelementRear.setBounds(225, 435, 212, 26);
		lblDeletedelementRear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(lblDeletedelementRear);
		
		JLabel lblDeletedelementInterLabel = new JLabel("DELETED-ELEMENT");
		lblDeletedelementInterLabel.setBounds(225, 517, 212, 26);
		lblDeletedelementInterLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(lblDeletedelementInterLabel);
		
		JButton DisplayFrwdBtn = new JButton("DISPLAY-FORWARD");
		DisplayFrwdBtn.addActionListener(e-> {
			Node temp = first;
            StringBuilder s = new StringBuilder();
            while (temp != null) {
                s.append(temp.data).append(" ");
                temp = temp.nextLink;
            }
            DisplayFrwdField.setText(s.toString());
			
		});
		DisplayFrwdBtn.setBounds(897, 594, 249, 35);
		DisplayFrwdBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(DisplayFrwdBtn);
		
		JButton DisplaBackBtn = new JButton("DISPLAY-BACKWARD");
		DisplaBackBtn.addActionListener(e->{
			 Node temp = first;
	            while (temp != null && temp.nextLink != null) {
	                temp = temp.nextLink; // Go to last node
	            }
	            StringBuilder s = new StringBuilder();
	            while (temp != null) {
	                s.append(temp.data).append(" ");
	                temp = temp.preLink;
	            }
	            DisplayBackField.setText(s.toString());
		});
		DisplaBackBtn.setBounds(897, 672, 249, 35);
		DisplaBackBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(DisplaBackBtn);
		
		DisplayFrwdField = new JTextField();
		DisplayFrwdField.setBounds(400, 594, 372, 35);
		DisplayFrwdField.setHorizontalAlignment(SwingConstants.CENTER);
		DisplayFrwdField.setColumns(10);
		backgroundPanel.add(DisplayFrwdField);
		
		JLabel DisplayFrwdLabel = new JLabel("ELEMENTS");
		DisplayFrwdLabel.setBounds(225, 604, 134, 26);
		DisplayFrwdLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(DisplayFrwdLabel);
		
		JLabel DisplayBackLabel = new JLabel("ELEMENTS");
		DisplayBackLabel.setBounds(225, 672, 134, 26);
		DisplayBackLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		backgroundPanel.add(DisplayBackLabel);
		
		DisplayBackField = new JTextField();
		DisplayBackField.setBounds(400, 672, 372, 35);
		DisplayBackField.setHorizontalAlignment(SwingConstants.CENTER);
		DisplayBackField.setColumns(10);
		backgroundPanel.add(DisplayBackField);
		
        // Add the remaining components (similar to the original code) to `backgroundPanel`

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(678, 741, 195, 35);
        btnBack.addActionListener(e -> {
            this.dispose(); // Close the current frame
        });
        btnBack.setFont(new Font("Sitka Text", Font.BOLD, 20));
        backgroundPanel.add(btnBack);
        
        JLabel DoublyInseetInterLabel_1 = new JLabel("ELEMENT");
        DoublyInseetInterLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
        DoublyInseetInterLabel_1.setBounds(334, 287, 134, 26);
        backgroundPanel.add(DoublyInseetInterLabel_1);
    }

    /**
     * Launch the application.
     */
   
}
