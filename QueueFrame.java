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

public class QueueFrame extends JFrame {
	private JTextField queueSizeInputField;
	private JTextField queueElementInputField;
	private JTextField queueDeletedElementField;
	private JTextField queueDisplayField;
	
	private int q[];
	private int size;
	private int elem;
	private int rear=-1;
	private int front =-1;
	
	public QueueFrame(JFrame homeFrame) {
		
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
	        setContentPane(backgroundPanel);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUEUE DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblNewLabel.setBounds(601, 26, 285, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel queueSizeLabel = new JLabel("QUEUE-SIZE");
		queueSizeLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueSizeLabel.setBounds(298, 163, 136, 26);
		getContentPane().add(queueSizeLabel);
		
		queueSizeInputField = new JTextField();
		queueSizeInputField.setHorizontalAlignment(SwingConstants.CENTER);
		queueSizeInputField.setColumns(10);
		queueSizeInputField.setBounds(444, 158, 121, 35);
		getContentPane().add(queueSizeInputField);
		
		JButton queueCreateBtn = new JButton("CREATE");
		queueCreateBtn.addActionListener(e-> {
			try
			{
				int inputSize = Integer.parseInt(queueSizeInputField.getText().trim());
				this.size=inputSize;
				if(size>0)
				{
					q=new int[size];
					JOptionPane.showMessageDialog(this, "Queue of size " + size+" has been created successfully!");

				}
				else
				JOptionPane.showMessageDialog(this, "Size of the queue cannot be zero!");

			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this, "Enter valid integer for the queue size!");
			}
			
			
		});
		queueCreateBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueCreateBtn.setBounds(860, 158, 144, 35);
		getContentPane().add(queueCreateBtn);
		
		JLabel queueElementLabel = new JLabel("ELEMENT");
		queueElementLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueElementLabel.setBounds(298, 298, 134, 26);
		getContentPane().add(queueElementLabel);
		
		queueElementInputField = new JTextField();
		queueElementInputField.setHorizontalAlignment(SwingConstants.CENTER);
		queueElementInputField.setColumns(10);
		queueElementInputField.setBounds(442, 293, 121, 35);
		getContentPane().add(queueElementInputField);
		
		JButton queueElementInsertBtn = new JButton("INSERT");
		queueElementInsertBtn.addActionListener(e-> {
			try
			{
				elem=Integer.parseInt(queueElementInputField.getText().trim());
				if(rear==size-1)
				{
					JOptionPane.showMessageDialog(this, "OOPS! Queue is full");
				}
				else
				{
					rear=rear+1;
					q[rear]=elem;
					JOptionPane.showMessageDialog(this, "Element " + elem + " has been inserted successfully!");

				}
			}
			catch(NumberFormatException ex)
			{
				if(size<0)
				JOptionPane.showMessageDialog(this, "OOPS! Create a Queue first!");
				else
					JOptionPane.showMessageDialog(this, "Please enter an element to insert!");


			}
		});
		queueElementInsertBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueElementInsertBtn.setBounds(860, 293, 144, 35);
		getContentPane().add(queueElementInsertBtn);
		
		JLabel queueElementDeletedLabel = new JLabel("ELEMENT-DELETED");
		queueElementDeletedLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueElementDeletedLabel.setBounds(298, 439, 211, 26);
		getContentPane().add(queueElementDeletedLabel);
		
		queueDeletedElementField = new JTextField();
		queueDeletedElementField.setHorizontalAlignment(SwingConstants.CENTER);
		queueDeletedElementField.setColumns(10);
		queueDeletedElementField.setBounds(536, 434, 121, 35);
		getContentPane().add(queueDeletedElementField);
		
		JButton queueElementDeleteBtn = new JButton("DELETE");
		queueElementDeleteBtn.addActionListener(e->{
			try
			{
				if(rear==-1 || rear==front)
				{
					queueDeletedElementField.setText("");
					JOptionPane.showMessageDialog(this, "OOPS! Queue is empty cannot delete!");

				}
				else
				{
					front=front+1;
					queueDeletedElementField.setText(String.valueOf(q[front]));
					JOptionPane.showMessageDialog(this, "Element " + q[front] + " has been deleted successfully!");
					q[front]=0;

				}
				
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this, "");
			}
		});
		queueElementDeleteBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueElementDeleteBtn.setBounds(860, 434, 144, 35);
		getContentPane().add(queueElementDeleteBtn);
		
		JButton queueBackBtn = new JButton("BACK");
		queueBackBtn.addActionListener( e ->{
			this.setVisible(false);
            homeFrame.setVisible(true);
		});
		queueBackBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueBackBtn.setBounds(704, 666, 144, 35);
		getContentPane().add(queueBackBtn);
		
		queueDisplayField = new JTextField();
		queueDisplayField.setColumns(10);
		queueDisplayField.setBounds(500, 553, 348, 35);
		backgroundPanel.add(queueDisplayField);
		
		JButton queueDisplaybtn = new JButton("DISPLAY");
		queueDisplaybtn.addActionListener(e->{
			try
			{
				if(size<=0)
				{
					JOptionPane.showMessageDialog(this, "OOPS! Queue is empty cannot Display!");
				}
				else
				{
					StringBuilder s = new StringBuilder();
					for(int i=0;i<=rear;i++)
					{
						s.append(q[i]+" ");
					}
					queueDisplayField.setText(s.toString());
				}
			}
			catch(NullPointerException ex)
			{
				
			}
		});
		queueDisplaybtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
		queueDisplaybtn.setBounds(860, 554, 144, 35);
		backgroundPanel.add(queueDisplaybtn);
		
		JLabel QueueElementsLabel = new JLabel("QUEUE-ELEMENTS");
		QueueElementsLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
		QueueElementsLabel.setBounds(298, 562, 206, 26);
		backgroundPanel.add(QueueElementsLabel);
	}
}
