
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;

/*public class SudokuMCVE extends JPanel {
    private static final int CLUSTER = 3;
    private static final int MAX_ROWS = 9;
    private static final float FIELD_PTS = 32f;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
    private static final Color SOLVED_BG = Color.LIGHT_GRAY;
    public static final int TIMER_DELAY = 2 * 1000;
    private JTextField[][] fieldGrid = new JTextField[MAX_ROWS][MAX_ROWS];

    public SudokuMCVE() {
        JPanel mainPanel = new JPanel(new GridLayout(CLUSTER, CLUSTER));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        mainPanel.setBackground(BG);
        JPanel[][] panels = new JPanel[CLUSTER][CLUSTER];
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel(new GridLayout(CLUSTER, CLUSTER, 1, 1));
                panels[i][j].setBackground(BG);
                panels[i][j].setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
                mainPanel.add(panels[i][j]);
            }
        }

        for (int row = 0; row < fieldGrid.length; row++) {
            for (int col = 0; col < fieldGrid[row].length; col++) {
                fieldGrid[row][col] = createField(row, col);
                int i = row / 3;
                int j = col / 3;
                panels[i][j].add(fieldGrid[row][col]);
            }
        }

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(new JButton(new SolveAction("Solve")), BorderLayout.PAGE_END);
    }

    private JTextField createField(int row, int col) {
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

        @Override
        public void actionPerformed(ActionEvent e) {
            new Timer(TIMER_DELAY, new ActionListener() {
                private int i = 0;
                private int j = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    // MAX_ROWS is 9
                    if (i == MAX_ROWS) {
                        ((Timer) e.getSource()).stop();
                    }
                    if (j == MAX_ROWS) {
                        i++;
                        j = 0;
                    }
                    int number = (int) (MAX_ROWS * Math.random()) + 1;
                    fieldGrid[i][j].setBackground(SOLVED_BG);
                    fieldGrid[i][j].setText(String.valueOf(number));

                    j++;
                }
            }).start();
        }
    }
    private static void createAndShowGui() {
        SudokuMCVE mainPanel = new SudokuMCVE();

        JFrame frame = new JFrame("SudokuMCVE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
*/

public class JavaSudoku extends JPanel {
	private static final int CLUSTER = 3;
    private static final int MAX_ROWS = 9;
    private static final float FIELD_PTS = 32f;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
//    private static final Color SOLVED_BG = Color.LIGHT_GRAY;
    public static final int TIMER_DELAY = 2 * 1000;
    private static JTextField[][] fieldGrid = new JTextField[MAX_ROWS][MAX_ROWS];
	
	 public static void JavaSudoku() {
         
	        JFrame frame = new JFrame("Sudoku");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        Font font = new Font("Sans Serif", Font.PLAIN, 20);
	        JMenuBar menuBar = new JMenuBar();
	         
	        JMenu fileMenu = new JMenu("Menu");
	        fileMenu.setFont(font);
	        fileMenu.setForeground(Color.decode("#D5F6FF"));
	        
	        JMenuItem menuButton = new JMenuItem("Main Lobby");
	        menuButton.setFont(font);
	        menuButton.setForeground(Color.WHITE);
	        fileMenu.add(menuButton);
	        
	        JMenuItem diffButton = new JMenuItem("Difficulty");
	        diffButton.setFont(font);
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
	        fileMenu.add(exitItem);
	         
	        exitItem.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);             
	            }           
	        });
	        
	        //JPanel mainPanel = new JPanel();
	        //mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
	        //mainPanel.setBackground(Color.decode("#141113"));
	        //mainPanel.setSize(450,450);
	        //mainPanel.setLocation(508,49);
	       // mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	        JPanel[][] panels = new JPanel[CLUSTER][CLUSTER];
	        for (int i = 0; i < panels.length; i++) {
	            for (int j = 0; j < panels[i].length; j++) {
	                panels[i][j] = new JPanel(new GridLayout(CLUSTER, CLUSTER, 1, 1));
	                panels[i][j].setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
	                panels[i][j].setSize(150,150);
	                panels[i][j].setLocation(308+(i*150),49+(j*150));
	                frame.add(panels[i][j]);
	                	            }
	        }
	        for (int row = 0; row < fieldGrid.length; row++) {
	            for (int col = 0; col < fieldGrid[row].length; col++) {
	                fieldGrid[row][col] = createField(row, col);
	                //fieldGrid[row][col].back;
	                int i = row / 3;
	                int j = col / 3;
	                panels[i][j].add(fieldGrid[row][col]);
	                panels[i][j].setBackground(Color.decode("#1141113"));
	            }
	        }

	        frame.setLayout(new BorderLayout());
	        //frame.add(mainPanel/*,BorderLayout.CENTER*/);
	        //mainPanel.setSize(450,450);
	        //frame.add(new JButton(new SolveAction("Solve")), BorderLayout.PAGE_END);
	        	        
	        menuBar.add(fileMenu);
	        menuBar.setBackground(Color.decode("#141113"));
	        //fileMenu.getBackground(Color.white);
	       // menuBar.setBackground( Color.decode("#141113") );
	        // menuBar.setForeground(Color.decode("#D5F6FF"));
	        //frame.setForeground(Color.decode("#D5F6FF"));
	        frame.setJMenuBar(menuBar);
	        frame.setBackground(Color.decode("#141113"));
	        frame.setPreferredSize(new Dimension(270, 225));
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        
	        frame.setBounds(100, 100, 800, 600); 
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

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new Timer(TIMER_DELAY, new ActionListener() {
	                private int i = 0;
	                private int j = 0;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // MAX_ROWS is 9
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

	   /* private static void createAndShowGui() {
	        SudokuMCVE mainPanel = new SudokuMCVE();

	        JFrame frame = new JFrame("SudokuMCVE");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.getContentPane().add(mainPanel);
	        frame.pack();
	        frame.setLocationByPlatform(true);
	        frame.setVisible(true);
	    }*/
	 
	 
public static void main(String[] args) {

	  javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              JFrame.setDefaultLookAndFeelDecorated(true);
              JavaSudoku();
    //          SwingUtilities.invokeLater(() -> {
      //            createAndShowGui();
        //      });              
          }
      });
}
}