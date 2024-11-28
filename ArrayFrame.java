import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ArrayFrame extends JFrame {
    private int size;
    private int arr[]=null;
    private int elem;
    private int pos;
    private JTextField arraySizeInput;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public ArrayFrame(JFrame homeFrame) {
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
        backgroundPanel.setLayout(null); // Use absolute layout for placing components

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components to the background panel
        JLabel arrayDs = new JLabel("ARRAY DATA STRUCTURE");
        arrayDs.setForeground(new Color(255, 255, 0));
        arrayDs.setFont(new Font("Sitka Text", Font.BOLD, 24));
        arrayDs.setBounds(603, 20, 310, 32);
        backgroundPanel.add(arrayDs);

        JLabel arraySize = new JLabel("ARRAY-SIZE");
        arraySize.setHorizontalAlignment(SwingConstants.CENTER);
        arraySize.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arraySize.setBounds(232, 154, 160, 38);
        backgroundPanel.add(arraySize);

        arraySizeInput = new JTextField();
        arraySizeInput.setBounds(380, 159, 137, 28);
        backgroundPanel.add(arraySizeInput);
        arraySizeInput.setColumns(10);

        JButton arrayCreate = new JButton("CREATE");
        arrayCreate.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayCreate.setBounds(590, 157, 160, 33);
        backgroundPanel.add(arrayCreate);
        arrayCreate.addActionListener( e->{
        	try 
        	{
        		int inputSize = Integer.parseInt(arraySizeInput.getText().trim());
        		
        		if(inputSize<=0)
        		{
        			JOptionPane.showMessageDialog(this,"Array size must be greater than zero(0)");
        			return;
        		}
        		
        		int arr[] = new int[inputSize];
        		this.size=inputSize;
        		this.arr=arr;
    			JOptionPane.showMessageDialog(this,"Array of size " + inputSize +" has been created !");

        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this,"Please enter a valid integer for array size");
        	}
        });
        

        JLabel arrayElementInput = new JLabel("ELEMENT");
        arrayElementInput.setHorizontalAlignment(SwingConstants.CENTER);
        arrayElementInput.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayElementInput.setBounds(232, 264, 137, 38);
        backgroundPanel.add(arrayElementInput);

        JTextField arrayElementInputField = new JTextField();
        arrayElementInputField.setBounds(355, 269, 137, 28);
        backgroundPanel.add(arrayElementInputField);
        arrayElementInputField.setColumns(10);

        JLabel arrayElementPosition = new JLabel("POSITION");
        arrayElementPosition.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayElementPosition.setBounds(518, 264, 154, 38);
        backgroundPanel.add(arrayElementPosition);

        JTextField arrayElementPositionField = new JTextField();
        arrayElementPositionField.setColumns(10);
        arrayElementPositionField.setBounds(632, 269, 137, 28);
        backgroundPanel.add(arrayElementPositionField);

        JButton arrayInsert = new JButton("INSERT");
        arrayInsert.addActionListener(e -> {
        	try
        	{
        	elem=Integer.parseInt(arrayElementInputField.getText().trim());
        	pos=Integer.parseInt(arrayElementPositionField.getText().trim());
        	if(pos>=0 && pos<=arr.length-1)
        	{
        		arr[pos]=elem;
        		JOptionPane.showMessageDialog(this,"Element " + elem + " has been inserted successfully!");
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(this, "Enter a valid position to insert!");
        	}
        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "Enter element and position to insert!");
        	}
        	
        });
        arrayInsert.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayInsert.setBounds(843, 267, 160, 33);
        backgroundPanel.add(arrayInsert);

        JLabel arrayElementPosition_1 = new JLabel("POSITION");
        arrayElementPosition_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayElementPosition_1.setBounds(251, 371, 154, 38);
        backgroundPanel.add(arrayElementPosition_1);

        JTextField arrayElementPosition_1Field = new JTextField();
        arrayElementPosition_1Field.setColumns(10);
        arrayElementPosition_1Field.setBounds(355, 376, 137, 28);
        backgroundPanel.add(arrayElementPosition_1Field);

        JButton arrayDelete = new JButton("DELETE");
        arrayDelete.addActionListener(e -> {
        	try
        	{
        		if(size>0)
        		{
        			pos=Integer.parseInt(arrayElementPosition_1Field.getText().trim());
            		if(pos>=0 && pos<=arr.length-1)
            		{
            			JOptionPane.showMessageDialog(this, "Element " + arr[pos] + " has been deleted successfully!");
            			arr[pos] = 0;
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(this, "Please enter a valid position to delete");
            		}
        		}
        		
        			JOptionPane.showMessageDialog(this, "Please create an array first!");
        		
        		
        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "Please enter a  position to delete");
        	}

        });
        
        arrayDelete.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayDelete.setBounds(590, 371, 160, 33);
        backgroundPanel.add(arrayDelete);

      JTextField  arrayElementsDisplay = new JTextField();
      arrayElementsDisplay.setColumns(10);
      arrayElementsDisplay.setBounds(458, 500, 375, 28);
        backgroundPanel.add(arrayElementsDisplay);

        JButton arrayDisplay = new JButton("DISPLAY");
        arrayDisplay.addActionListener(e-> {
        	try
        	{
        		if(size>0)	
            	{
            		StringBuilder s = new StringBuilder();
            		for(int i=0;i<arr.length;i++)
            		{
            			s.append(arr[i]+" ");
            			
            		}
            		
            		arrayElementsDisplay.setText(s.toString());
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(this, "OOPS! Array is empty.");
            	}
        		
        	}
        	catch(NumberFormatException ex)
        	{
        		JOptionPane.showMessageDialog(this, "OOPS! Create an array first!");
        	}

        	
        });
        arrayDisplay.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayDisplay.setBounds(843, 498, 160, 33);
        backgroundPanel.add(arrayDisplay);

        JLabel arrayElementPosition_1_1 = new JLabel("ARRAY-ELEMENTS");
        arrayElementPosition_1_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
        arrayElementPosition_1_1.setBounds(251, 500, 197, 38);
        backgroundPanel.add(arrayElementPosition_1_1);

        // Set the background panel as the content pane
        setContentPane(backgroundPanel);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 20));
        btnNewButton.setBounds(613, 634, 137, 38);
        btnNewButton.addActionListener(e -> {
            // Hide ArrayFrame and show Home frame
            this.setVisible(false);
            homeFrame.setVisible(true);
        });
        backgroundPanel.add(btnNewButton);

        // Additional UI components (omitted for brevity)
        // ...

        // Set the background panel as the content pane
        setContentPane(backgroundPanel);
    }
}
