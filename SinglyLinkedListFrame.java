import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SinglyLinkedListFrame extends JFrame{

	private JFrame frame;
	private JTextField singlyInsertFrontField;
	private JTextField SinglyInsertRearField;
	private JTextField SinglyInsertInterField;
	private JTextField SinglyDeleteFrontField;
	private JTextField SinglyDeletedElementRearField;
	private JTextField SinglyDeletedElementInterField;
	private JTextField SinglyDisplayFrwdField;
	private JTextField SinglyDisplayBackField;
	class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }
	Node head;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public SinglyLinkedListFrame(JFrame homeFrame) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
	        setTitle("Singly Linked List Operations");
	        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        backgroundPanel.setLayout(null);
		frame = new JFrame();
		frame.setBounds(100, 100, 1392, 849);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSinglylinkedlist = new JLabel("SINGLY-LINKED-LIST");
		lblSinglylinkedlist.setForeground(Color.YELLOW);
		lblSinglylinkedlist.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblSinglylinkedlist.setBounds(679, 22, 267, 26);
		backgroundPanel.add(lblSinglylinkedlist);
		
		singlyInsertFrontField = new JTextField();
		singlyInsertFrontField.setHorizontalAlignment(SwingConstants.CENTER);
		singlyInsertFrontField.setColumns(10);
		singlyInsertFrontField.setBounds(492, 104, 121, 35);
		backgroundPanel.add(singlyInsertFrontField);
		
		JLabel singlyInsertFrontElementLabel = new JLabel("ELEMENT");
		singlyInsertFrontElementLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		singlyInsertFrontElementLabel.setBounds(372, 113, 134, 26);
		backgroundPanel.add(singlyInsertFrontElementLabel);
		
		JButton btnInsertfront = new JButton("INSERT-FRONT");
		btnInsertfront.addActionListener(e->{
			 try {
		            double data = Double.parseDouble(singlyInsertFrontField.getText().trim());
		            Node newNode = new Node(data);
		            newNode.next = head;
		            head = newNode;
		            JOptionPane.showMessageDialog(this, "Inserted at front: " + data);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(this, "Invalid input!");
		        }
		});
		btnInsertfront.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnInsertfront.setBounds(990, 104, 195, 35);
		backgroundPanel.add(btnInsertfront);
		
		JButton btnInsertrear = new JButton("INSERT-REAR");
		btnInsertrear.addActionListener(e->{
			try { double data = Double.parseDouble(SinglyInsertRearField.getText().trim()); 
			Node newNode = new Node(data); 
			if (head == null) 
			{ 
				head = newNode; 
			} 
			else 
			{ 
				Node temp = head; 
				while (temp.next != null) 
				{ 
					temp = temp.next; 
				} 
				temp.next = newNode; 
			} 
			JOptionPane.showMessageDialog(this, "Inserted at rear: " + data); 
			}
			catch (NumberFormatException ex) 
			{ 
				JOptionPane.showMessageDialog(this, "Invalid input!"); 
			}
		});
		btnInsertrear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnInsertrear.setBounds(990, 184, 195, 35);
		backgroundPanel.add(btnInsertrear);
		
		JButton btnInsertInter = new JButton("INSERT-INTERMEDIATE");
		btnInsertInter.addActionListener(e->{
			try 
			{ 
				double data = Double.parseDouble(SinglyInsertInterField.getText().trim()); 
				int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position:")); 
				Node newNode = new Node(data); 
				if (position == 0) 
				{ 
				newNode.next = head; 
				head = newNode; 
				JOptionPane.showMessageDialog(this, "Inserted at position 0: " + data); 
				return; 
				}
				 Node temp = head;
				for (int i = 0; i < position - 1; i++) 
				{ 
				if (temp != null) 
				{ 
				temp = temp.next; 
				} 
				else 
				{ 
				JOptionPane.showMessageDialog(this, "Position out of range!"); 
				return; 
				} 
				} 
				newNode.next = temp.next; 
				temp.next = newNode; 
				JOptionPane.showMessageDialog(this, "Inserted at position " + position + ": " + data); 
			} 
			catch (NumberFormatException ex) 
			{ 
				JOptionPane.showMessageDialog(this, "Invalid input!"); 
			}
		});
		btnInsertInter.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnInsertInter.setBounds(990, 261, 285, 35);
		backgroundPanel.add(btnInsertInter);
		
		JButton btnDeletefront = new JButton("DELETE-FRONT");
		btnDeletefront.addActionListener(e->{
			if (head == null) 
			{ 
				JOptionPane.showMessageDialog(this, "List is empty!"); 
			} 
			else 
			{ 
				double data = head.data; head = head.next; SinglyDeleteFrontField.setText(String.valueOf(data)); 
				JOptionPane.showMessageDialog(this, "Deleted from front: " + data);
			}
		});
		btnDeletefront.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnDeletefront.setBounds(990, 337, 195, 35);
		backgroundPanel.add(btnDeletefront);
		
		JLabel singlyInsertRearElementLabel_1 = new JLabel("ELEMENT");
		singlyInsertRearElementLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		singlyInsertRearElementLabel_1.setBounds(372, 194, 134, 26);
		backgroundPanel.add(singlyInsertRearElementLabel_1);
		
		JLabel singlyInsertInterElementLabel_1_1 = new JLabel("ELEMENT");
		singlyInsertInterElementLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		singlyInsertInterElementLabel_1_1.setBounds(372, 271, 134, 26);
		backgroundPanel.add(singlyInsertInterElementLabel_1_1);
		
		SinglyInsertRearField = new JTextField();
		SinglyInsertRearField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyInsertRearField.setColumns(10);
		SinglyInsertRearField.setBounds(492, 184, 121, 35);
		backgroundPanel.add(SinglyInsertRearField);
		
		SinglyInsertInterField = new JTextField();
		SinglyInsertInterField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyInsertInterField.setColumns(10);
		SinglyInsertInterField.setBounds(492, 261, 121, 35);
		backgroundPanel.add(SinglyInsertInterField);
		
		JLabel lblDeletedelementFront = new JLabel("DELETED-ELEMENT");
		lblDeletedelementFront.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblDeletedelementFront.setBounds(268, 347, 212, 26);
		backgroundPanel.add(lblDeletedelementFront);
		
		SinglyDeleteFrontField = new JTextField();
		SinglyDeleteFrontField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyDeleteFrontField.setColumns(10);
		SinglyDeleteFrontField.setBounds(492, 337, 121, 35);
		backgroundPanel.add(SinglyDeleteFrontField);
		
		JButton btnDeleterear = new JButton("DELETE-REAR");
		btnDeleterear.addActionListener(e->{
			{ if (head == null) 
			{ 
				JOptionPane.showMessageDialog(this, "List is empty!"); 
			} 
			else if (head.next == null) 
			{ 
				double data = head.data; 
				head = null; 
				SinglyDeletedElementRearField.setText(String.valueOf(data)); 
				JOptionPane.showMessageDialog(this, "Deleted from rear: " + data); 
			} 
			else 
			{ 
				Node temp = head; 
				while (temp.next.next != null) 
				{ 
					temp = temp.next; 
				} 
				double data = temp.next.data; 
				temp.next = null; 
				SinglyDeletedElementRearField.setText(String.valueOf(data)); 
				JOptionPane.showMessageDialog(this, "Deleted from rear: " + data);
			}
			}
		});
		btnDeleterear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnDeleterear.setBounds(990, 414, 195, 35);
		backgroundPanel.add(btnDeleterear);
		
		JButton btnDeleteintermediate = new JButton("DELETE-INTERMEDIATE");
		btnDeleteintermediate.addActionListener(e->{
			{ 
				try 
				{ 
					int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position to delete:")); 
					if (head == null) 
					{ 
						JOptionPane.showMessageDialog(this, "List is empty!"); 
						return; 
					} 
					if (position == 0) 
					{ 
						double data = head.data; 
						head = head.next; 
						SinglyDeletedElementInterField.setText(String.valueOf(data)); 
						JOptionPane.showMessageDialog(this, "Deleted from position 0: " + data); 
						return; 
					} 
					Node temp = head; 
					for (int i = 0; i < position - 1; i++) 
					{ 
						if (temp != null) 
						{ 
							temp = temp.next; 
						} 
						else 
						{ 
							JOptionPane.showMessageDialog(this, "Position out of range!"); 
							return; 
						} 
					} 
					if (temp.next == null) 
					{ 
						JOptionPane.showMessageDialog(this, "Position out of range!"); 
					} 
					else 
					{ 
						double data = temp.next.data; 
						temp.next = temp.next.next; 
						SinglyDeletedElementInterField.setText(String.valueOf(data)); 
						JOptionPane.showMessageDialog(this, "Deleted from position " + position + ": " + data); 
					} 
				} 
				catch (NumberFormatException ex) 
				{ 
					JOptionPane.showMessageDialog(this, "Invalid input!");
				}
			}
		});
		btnDeleteintermediate.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnDeleteintermediate.setBounds(990, 496, 286, 35);
		backgroundPanel.add(btnDeleteintermediate);
		
		JButton DisplayFrwdBtn = new JButton("DISPLAY-FORWARD");
		DisplayFrwdBtn.addActionListener(e->{
			if (head == null) 
			{ 
				SinglyDisplayFrwdField.setText("List is empty"); 
			} 
			else 
			{ 
				Node temp = head; StringBuilder sb = new StringBuilder(); 
				while (temp != null) 
				{ 
					sb.append(temp.data).append(" -> "); 
					temp = temp.next; 
				} 
				SinglyDisplayFrwdField.setText(sb.substring(0, sb.length() - 4)); // Remove last " -> "
			}
		});
		DisplayFrwdBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		DisplayFrwdBtn.setBounds(990, 581, 249, 35);
		backgroundPanel.add(DisplayFrwdBtn);
		
		JButton DisplaBackBtn = new JButton("DISPLAY-BACKWARD");
		DisplaBackBtn.addActionListener(e->{
			if (head == null) 
			{ 
				SinglyDisplayBackField.setText("List is empty"); 
			} 
			else
			{
				Node prev = null, current = head, next; 
				StringBuilder sb = new StringBuilder(); 
				// Reverse the linked list 
				while (current != null) 
				{ 
					next = current.next; 
					current.next = prev; 
					prev = current; 
					current = next; 
				} // Now prev is the head of the reversed list 
				Node temp = prev; 
				while (temp != null) 
				{ 
					sb.append(temp.data).append(" -> "); 
					temp = temp.next; 
				} // Reverse the list again to restore original order 
				current = prev; 
				prev = null; 
				while (current != null) 
				{ 
					next = current.next; 
					current.next = prev; 
					prev = current; 
					current = next; 
				} 
				head = prev; // Restore head to original 
				SinglyDisplayBackField.setText(sb.substring(0, sb.length() - 4));
			}
		});
		DisplaBackBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		DisplaBackBtn.setBounds(990, 661, 249, 35);
		backgroundPanel.add(DisplaBackBtn);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(e->{
			this.dispose();
		});
		btnBack.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnBack.setBounds(675, 767, 195, 35);
		backgroundPanel.add(btnBack);
		
		JLabel lblDeletedelementRear = new JLabel("DELETED-ELEMENT");
		lblDeletedelementRear.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblDeletedelementRear.setBounds(268, 424, 212, 26);
		backgroundPanel.add(lblDeletedelementRear);
		
		SinglyDeletedElementRearField = new JTextField();
		SinglyDeletedElementRearField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyDeletedElementRearField.setColumns(10);
		SinglyDeletedElementRearField.setBounds(492, 414, 121, 35);
		backgroundPanel.add(SinglyDeletedElementRearField);
		
		SinglyDeletedElementInterField = new JTextField();
		SinglyDeletedElementInterField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyDeletedElementInterField.setColumns(10);
		SinglyDeletedElementInterField.setBounds(492, 496, 121, 35);
		backgroundPanel.add(SinglyDeletedElementInterField);
		
		SinglyDisplayFrwdField = new JTextField();
		SinglyDisplayFrwdField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyDisplayFrwdField.setColumns(10);
		SinglyDisplayFrwdField.setBounds(492, 581, 372, 35);
		backgroundPanel.add(SinglyDisplayFrwdField);
		
		SinglyDisplayBackField = new JTextField();
		SinglyDisplayBackField.setHorizontalAlignment(SwingConstants.CENTER);
		SinglyDisplayBackField.setColumns(10);
		SinglyDisplayBackField.setBounds(492, 661, 372, 35);
		backgroundPanel.add(SinglyDisplayBackField);
		
		JLabel lblDeletedElementInter = new JLabel("DELETED-ELEMENT");
		lblDeletedElementInter.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblDeletedElementInter.setBounds(268, 506, 212, 26);
		backgroundPanel.add(lblDeletedElementInter);
		
		JLabel DisplayFrwdLabel = new JLabel("ELEMENTS");
		DisplayFrwdLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		DisplayFrwdLabel.setBounds(352, 591, 134, 26);
		backgroundPanel.add(DisplayFrwdLabel);
		
		JLabel DisplayBackLabel = new JLabel("ELEMENTS");
		DisplayBackLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		DisplayBackLabel.setBounds(346, 671, 134, 26);
		backgroundPanel.add(DisplayBackLabel);
	}
}
