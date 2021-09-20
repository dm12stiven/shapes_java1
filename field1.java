package field1;
import javax.swing.JFrame;

		public class field1 extends JFrame {
		    public field1() {
		//создается элемент класса, производный от класс  Jpanel
		        add(new Board());   // 2
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 4
		        setSize(940, 830);
		        setLocationRelativeTo(null);
		        setTitle("Donut");
		        setVisible(true);
		    }

		    public static void main(String[] args) {
		        new field1();  // 1
		    }
		

		
		
		
		
		
		
	}


