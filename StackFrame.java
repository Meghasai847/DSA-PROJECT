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

public class StackFrame extends JFrame {
	private JTextField stackSizeIntputField;
	private JTextField stackElementInsertField;
	private JTextField stackDeletedElementField;
	private JTextField stackDisplayField;
	
	private int arr[]=null;
	private int size;
	private int elem;
	private int top=-1;
	
    public StackFrame(JFrame homeFrame) {
        // Load the background image
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
        setContentPane(backgroundPanel); // Set the custom panel as the content pane

        // Frame configuration
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components to the background panel
        JLabel lblNewLabel = new JLabel("STACK DATA STRUCTURE");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        lblNewLabel.setBounds(590, 24, 267, 26);
        backgroundPanel.add(lblNewLabel); // Add to the background panel
        
        JLabel stackSizeLabel = new JLabel("STACK-SIZE");
        stackSizeLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackSizeLabel.setBounds(299, 155, 121, 26);
        backgroundPanel.add(stackSizeLabel);
        
        stackSizeIntputField = new JTextField();
        stackSizeIntputField.setHorizontalAlignment(SwingConstants.CENTER);
        stackSizeIntputField.setBounds(450, 146, 121, 35);
        backgroundPanel.add(stackSizeIntputField);
        stackSizeIntputField.setColumns(10);
        
        JButton stackCreateBtn = new JButton("CREATE");
        stackCreateBtn.addActionListener(e -> {
        	try
        	{
        		int inputSize=Integer.parseInt(stackSizeIntputField.getText().trim());
        		this.size=inputSize;
        		if(inputSize<=0)
        		{
        			JOptionPane.showMessageDialog(this, "Stack size must be greater than zero(0)");
        			return;
        		}
        		int arr[] = new int[inputSize];
        		this.arr=arr;
    			JOptionPane.showMessageDialog(this,"Stack of size " + inputSize +" has been created !");

        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "Please enter a valid integer for stack size!");
        	}
        });
        stackCreateBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackCreateBtn.setBounds(894, 152, 144, 35);
        backgroundPanel.add(stackCreateBtn);
        
        JLabel stackElementLabel = new JLabel("ELEMENT");
        stackElementLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackElementLabel.setBounds(299, 287, 134, 26);
        backgroundPanel.add(stackElementLabel);
        
        stackElementInsertField = new JTextField();
        stackElementInsertField.setHorizontalAlignment(SwingConstants.CENTER);
        stackElementInsertField.setColumns(10);
        stackElementInsertField.setBounds(450, 282, 121, 35);
        backgroundPanel.add(stackElementInsertField);
        
        JButton stackPushBtn = new JButton("PUSH");
        stackPushBtn.addActionListener(e->{
        	
        	try
        	{
        		elem=Integer.parseInt(stackElementInsertField.getText().trim());
        		if(top==size-1)
            	{
            		JOptionPane.showMessageDialog(this, "OOPS! Stack is full.");
            	}
            	else
            	{
            		top=top+1;
            		arr[top]=elem;
            		JOptionPane.showMessageDialog(this, "Element " + elem + " has been pushed successfully");
            	}
        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "Please enter the element to push!");
        	}
        	
        	
        	
        });
        stackPushBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackPushBtn.setBounds(894, 282, 144, 35);
        backgroundPanel.add(stackPushBtn);
        
        JLabel stackElementDeletedLabel = new JLabel("ELEMENT-DELETED");
        stackElementDeletedLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackElementDeletedLabel.setBounds(299, 411, 206, 26);
        backgroundPanel.add(stackElementDeletedLabel);
        
        stackDeletedElementField = new JTextField();
        stackDeletedElementField.setHorizontalAlignment(SwingConstants.CENTER);
        stackDeletedElementField.setColumns(10);
        stackDeletedElementField.setBounds(526, 402, 121, 35);
        backgroundPanel.add(stackDeletedElementField);
        
        JButton stackPopBtn = new JButton("POP");
        stackPopBtn.addActionListener(e-> {
        	if(top==-1)
        	{
        		stackDeletedElementField.setText("Nothing");
        		JOptionPane.showMessageDialog(this, "OOPS! Stack is empty cannot Pop.");
        	}
        	else
        	{
        		int val=arr[top];
        		stackDeletedElementField.setText(String.valueOf(val));
        		arr[top]=0;
        		top=top-1;
        		JOptionPane.showMessageDialog(this, "Element " + val + " has been popped out successfully!");
        	}
        });
        stackPopBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackPopBtn.setBounds(894, 402, 144, 35);
        backgroundPanel.add(stackPopBtn);
        
        stackDisplayField = new JTextField();
        stackDisplayField.setBounds(524, 539, 348, 35);
        backgroundPanel.add(stackDisplayField);
        stackDisplayField.setColumns(10);
        
        JButton stackDisplaybtn = new JButton("DISPLAY");
        stackDisplaybtn.addActionListener(e->{
        	if(top==-1)
        	{
        		stackDisplayField.setText("");
        		JOptionPane.showMessageDialog(this, "OOPS! Stack is empty cannot display.");
        	}
        	else
        	{
        		StringBuilder s = new StringBuilder();
        		for(int i=0;i<=top;i++)
        		{
        			s.append(arr[i]+" ");
        			
        		}
        		stackDisplayField.setText(s.toString());
        	}
        });
        stackDisplaybtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackDisplaybtn.setBounds(894, 540, 144, 35);
        backgroundPanel.add(stackDisplaybtn);
        
      
        JButton stackBackBtn = new JButton("BACK");
        stackBackBtn.addActionListener(e -> {
        	this.setVisible(false);
            homeFrame.setVisible(true);
        });
        stackBackBtn.setFont(new Font("Sitka Text", Font.BOLD, 20));
        stackBackBtn.setBounds(736, 667, 121, 35);
        backgroundPanel.add(stackBackBtn);
        
        JLabel StackelementsLabel = new JLabel("STACK-ELEMENTS");
        StackelementsLabel.setFont(new Font("Sitka Text", Font.BOLD, 20));
        StackelementsLabel.setBounds(308, 544, 206, 26);
        backgroundPanel.add(StackelementsLabel);
    }
}
