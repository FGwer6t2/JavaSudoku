
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class JavaSudoku extends JPanel {
	private static final int CLUSTER = 3;
    private static final int MAX_ROWS = 9;
    private static final float FIELD_PTS = 32f;
    private static final int GAP = 3;
    public static final int TIMER_DELAY = 2 * 1000;
    private static JTextField[][] fieldGrid = new JTextField[MAX_ROWS][MAX_ROWS];
	private static Random rand = new Random();
	private static int[][] arrOut = new int[9][9];
	 public static void JavaSudoku() {
         
	        JFrame frame = new JFrame("Sudoku");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBackground(Color.decode("#1141113"));
	        Font font = new Font("Sans Serif", Font.PLAIN, 20);
	        JMenuBar menuBar = new JMenuBar();
	         
	        JMenu fileMenu = new JMenu("Menu");
	        fileMenu.setFont(font);
	        fileMenu.setForeground(Color.decode("#D5F6FF"));
	        fileMenu.setBackground(Color.decode("#1141113"));
	        
	        JMenuItem menuButton = new JMenuItem("Main Lobby");
	        menuButton.setFont(font);
	        menuButton.setForeground(Color.decode("#D5F6FF"));
	        menuButton.setBackground(Color.decode("#1141113"));
	        fileMenu.add(menuButton);
	        
	        JMenuItem diffButton = new JMenuItem("Difficulty");
	        diffButton.setFont(font);
	        diffButton.setBackground(Color.decode("#1141113"));
	        diffButton.setForeground(Color.decode("#D5F6FF"));
	        fileMenu.add(diffButton);
	        
	        JButton help = new JButton("Подсказка");
	        help.setFont(font);
	        help.setBackground(Color.decode("#2B272A"));
	        help.setSize(220,75);
	        help.setLocation(49,86);
	        help.setForeground(Color.decode("#D5F6FF"));
	        frame.add(help);
	        
	        JButton clear = new JButton("Стереть");
	        clear.setFont(font);
	        clear.setBackground(Color.decode("#2B272A"));
	        clear.setSize(220,75);
	        clear.setLocation(49,241);
	        clear.setForeground(Color.decode("#D5F6FF"));
	        frame.add(clear);
	        
	        JButton note = new JButton("Заметки");
	        note.setFont(font);
	        note.setBackground(Color.decode("#2B272A"));
	        note.setSize(220,75);
	        note.setLocation(49,384);
	        note.setForeground(Color.decode("#D5F6FF"));
	        frame.add(note);
	        
	        fileMenu.addSeparator();
	         
	        JMenuItem exitItem = new JMenuItem("Exit");
	        exitItem.setFont(font);
	        exitItem.setBackground(Color.decode("#1141113"));
	        exitItem.setForeground(Color.decode("#D5F6FF"));
	        fileMenu.add(exitItem);
	         
	        exitItem.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);             
	            }           
	        });
	        JPanel[][] panels = new JPanel[CLUSTER][CLUSTER];
	        for (int i = 0; i < panels.length; i++) {
	            for (int j = 0; j < panels[i].length; j++) {
	                panels[i][j] = new JPanel(new GridLayout(CLUSTER, CLUSTER, 1, 1));
	                panels[i][j].setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
	                panels[i][j].setSize(150,150);
	                panels[i][j].setLocation(308+(j*150),49+(i*150));
	                frame.add(panels[i][j]);
	                	            }
	        }
	        for (int row = 0; row < fieldGrid.length; row++) {
	            for (int col = 0; col < fieldGrid[row].length; col++) {
	                fieldGrid[row][col] = createField(row, col);
	                fieldGrid[row][col].setBackground(Color.decode("#2B272A"));
	                fieldGrid[row][col].setBorder(null);
	                fieldGrid[row][col].setForeground(Color.decode("#D5F6FF"));
	                int i = row / 3;
	                int j = col / 3;
	                panels[i][j].add(fieldGrid[row][col]);
	                panels[i][j].setBackground(Color.decode("#1141113"));
	            }
	        }

	        class JTextFieldLimit extends PlainDocument {
		    	  private int limit;
		    	  JTextFieldLimit(int limit) {
		    	    super();
		    	    this.limit = limit;
		    	  }

		    	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    	    if (str == null)
		    	      return;

		    	    if ((getLength() + str.length()) <= limit) {
		    	      super.insertString(offset, str, attr);
		    	    }
		    	  }
		    	}
	        
	    	int t = 5;
			while (t-- > 0) {
			    int[][] arr = getRandomTable();
			    //int[][] arrOut = new int[arr.length][arr.length];
			    for (int i = 0, n = arr.length; i < n; i++) {
		            for (int j = 0, m = arr[i].length; j < m; j++) {
		            	arrOut[i][j] = arr[i][j];
		            }
		        }
			    for (int i = 0; i < arrOut.length; i++)
			    {
			    	for (int j = 0; j < arrOut.length; j++)
			    	{
		            if (rand.nextInt(2) == 0) {
		                arrOut[i][j] = 0;
		            }
			    	}
		        }
			 /* for (int[] r : arr) {
				System.out.println(Arrays.toString(r));
			}
				System.out.println("----");*/
				
			    for (int i = 0, n = arrOut.length; i < n; i++) {
		            for (int j = 0, m = arrOut[i].length; j < m; j++) {
		            	if(arrOut[i][j]==0)
		            	{
		            		fieldGrid[i][j].setText("");
		            		fieldGrid[i][j].setEditable(true);
		            		fieldGrid[i][j].setDocument(new JTextFieldLimit(1));
		            		
		            	}
		            	else
		            	{
		            		fieldGrid[i][j].setText(String.valueOf(arrOut[i][j]));
		            		fieldGrid[i][j].setEditable(false);
		            	}
		            }
		        }
			    
			    
			}
	        
	        frame.setLayout(new BorderLayout());
	        menuBar.add(fileMenu);
	    
	        frame.setJMenuBar(menuBar);
	        frame.getContentPane().setBackground(Color.decode("#141113"));
	        frame.setPreferredSize(new Dimension(270, 225));
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        
	        
	        frame.setBounds(100, 100, 800, 600); 
	        
	        menuBar.setBackground(Color.BLACK);
	        frame.setVisible(true);
	       /* for (int i = 0; i < arrOut.length; i++) {
		        for (int j = 0; j < arrOut.length; j++) {
		            JTextField field = fieldGrid[i][j];
		            field.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    String text = field.getText();
		                    if (text.matches("\\d")) {
		                        int value = Integer.parseInt(text);
		                        if (value == arrOut[i][j])
		                        {
		                            field.setBackground(Color.GREEN);
		                        } 
		                        else 
		                        {
		                            field.setBackground(Color.RED);
		                        }
		                    } else {
		                        field.setBackground(Color.RED);
		                    }
		                }
		            });
		        }
		    } */
	    }
	
	 private static JTextField createField(int row, int col) {
	        JTextField field = new JTextField(2);
	        field.setHorizontalAlignment(JTextField.CENTER);
	        field.setFont(field.getFont().deriveFont(Font.BOLD, FIELD_PTS));

	        return field;
	    }
	 
	 
	    private class SolveAction extends AbstractAction {

	        public SolveAction(String name) {
	            super(name);
	            int mnemonic = (int) name.charAt(0);
	            putValue(MNEMONIC_KEY, mnemonic);
	        }
	        public void actionPerformed(ActionEvent e) {
	            new Timer(TIMER_DELAY, new ActionListener() {
	                private int i = 0;
	                private int j = 0;
	                public void actionPerformed(ActionEvent e) {
	                    if (i == MAX_ROWS) {
	                        ((Timer) e.getSource()).stop();
	                    }
	                    if (j == MAX_ROWS) {
	                        i++;
	                        j = 0;
	                    }
	                    int number = (int) (MAX_ROWS * Math.random()) + 1;
	                    fieldGrid[i][j].setBackground(Color.decode("#141113"));
	                    fieldGrid[i][j].setText(String.valueOf(number));
	                    j++;
	                }
	            }).start();
	        }
	    }

	    private static int[][] generateTable() {
	        int[][] arr = new int[9][9];
	        
	        Random r = new Random();
	        
	        for (int i = 0; i < arr.length;) {
	            int j = r.nextInt(i + 1);
	            arr[0][i] = arr[0][j];
	            arr[0][j] = ++i;
	        }
	        int shift = r.nextBoolean() ? 1 : arr.length - 1;
	        for (int i = 1; i < arr.length; i++) {
	            for (int j = 0; j < arr.length; j++) {
	                arr[i][j] = arr[i - 1][(j + shift) % arr.length];
	            }
	        }
	        return arr;
	    } 
	    
	    private static void transpose(int[][] arr) {
	        for (int i = 0, n = arr.length; i < n; i++) {
	            for (int j = i + 1, m = arr[i].length; j < m; j++) {
	                int tmp = arr[i][j];
	                arr[i][j] = arr[j][i];
	                arr[j][i] = tmp;
	            }
	        }
	    }
	    
	    private static void swapRows(int r1, int r2, int[][] arr) {
	        int[] tmp = arr[r1];
	        arr[r1] = arr[r2];
	        arr[r2] = tmp;
	    }

	    private static void swapCols(int c1, int c2, int[][] arr) {
	        for (int i = 0, n = arr.length; i < n; i++) {
	            int tmp = arr[i][c1];
	            arr[i][c1] = arr[i][c2];
	            arr[i][c2] = tmp;
	        }
	    }

	    private static void rotateRows(int i, int[][] arr) {
	        Collections.rotate(Arrays.asList(arr), i);
	    }
	    
	    public static int[][] getRandomTable() {
	        int[][] arr = generateTable();
	        
	        Random r = new Random();
	        int shuffles = 20 + r.nextInt(81);
	        
	        while (shuffles-- > 0) {
	            int i = r.nextInt(9);
	            int j = r.nextInt(9);
	            if (i == j) {
	                if (r.nextBoolean())
	                    transpose(arr);
	                else 
	                    rotateRows(r.nextBoolean() ? i : -i, arr);
	            } else if (r.nextBoolean()) {
	                swapRows(i, j, arr);
	            } else{
	                swapCols(i, j, arr);
	            }
	        }

	        return arr;
	    }

	  
	    
	    
	    
	    
public static void main(String[] args) {

	
	  javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              JFrame.setDefaultLookAndFeelDecorated(true);
              JavaSudoku();
                          
          }
      });
	
	  
	  
}
}