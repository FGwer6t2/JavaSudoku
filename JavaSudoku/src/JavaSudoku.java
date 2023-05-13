import javax.swing.JFrame;
import java.awt.Color;

public class JavaSudoku extends JFrame {

	 public JavaSudoku(){
		    super("Sudoku");
		    setBounds(100, 100, 800, 550); 
		    
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		  }

public static void main(String[] args) {
	JavaSudoku app = new JavaSudoku(); 
	app.getContentPane().setBackground( Color.decode("#141113") );
	app.setVisible(true);
}
}