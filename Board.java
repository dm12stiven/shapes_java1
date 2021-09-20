package field1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Timer;




public class Board extends JPanel implements ActionListener {
	
	Timer timer;
	float x, y;
	int fy ;
	static int l;
	int stepconst = 15; // количество шагов до перемены направл
	boolean isOn = false;
	boolean destroy;
	int count;
	int SPEED = 25; // 1/скорость (скорость наоборот - пауза в миллисекудах)
	
	  Random random = new Random();
	  Shapes shapes = new Shapes();
	  ArrayList<Integer> ax = new ArrayList<Integer>();
	  ArrayList<Integer> ay = new ArrayList<Integer>();
	
	
	
	public Board() {    //   3
	setBackground(Color.BLACK);

	setDoubleBuffered(true);
	x = y = 0;
	timer = new Timer(SPEED, this); // Создаем объект timer
	        timer.start();      
	// Каждые 25 ms timer будет вызывать метод actionPerformed
	}
	
	 public void paint(Graphics g)   // 3

	 {
	    super.paint(g);// статическая функция базового класса
      shapes.paint(g);                   }
	 
	 
	
	public class Shape {
		 
		 int x ; int y; int dx; int dy;int colr = random.nextInt(170); int l; int steps = 0; boolean xory; boolean horordig; boolean stop ;int stoppointx;
		 int id ;
		 
		 Shape(){
				 
		            x = random.nextInt(700); 
		            y = random.nextInt(700);
		           dx = random.nextBoolean()? 1 : -1; // инит одно из двух 
		            dy = random.nextBoolean()? 1 : -1;
		            horordig = random.nextBoolean();
		            
		            xory = random.nextBoolean();
		            stop = false;
		            stoppointx = random.nextInt(180);
		          
		            id = Board.l;
		            
		                }
		 
	
		 	public void move()                      // метод только внутри класса Shape.( его собственный)  
		{ if ( !stop ) {
			if(horordig == true) {
		
		
				if(xory==true) {x+=dx;} else{y+=dy;}
			    } else {
			    	x+=dx;y+=dy;
			    	
			    };steps++;
				
				if(steps>stepconst) {
					dx = random.nextBoolean()? 1 : -1; // блок перемены // Оверрайд dx dy; Этот кусок делается один раз ( не маин_луп)/ 
					
		            dy = random.nextBoolean()? 1 : -1;
		            xory = random.nextBoolean();
		            horordig = random.nextBoolean();
		            steps = 0;
				}
			
		
			if(x== 200) {dx = -dx; destroy = true;
			//stop = true; 
			}
			if(y== 200) {dy = -dy;    }
			if(y== -200) {dx = -dx;    }
			if(y== -200) {dy = -dy;}
			
		 }}
	 
	
		public void paint( Graphics g ) {  
			
			 g.setColor(Color.getHSBColor(colr, colr+20, colr));
		        g.fillOval(x+30, y+30, 18, 18);
		       	 }
		
		int getX() { return x; }
		int getY() { return y; }
		
	public void stop() {
		
		stop = true;
	} 
	
	}
	
	
	
	public class Shapes  {
		
		   public ArrayList<Shape> shapes = new ArrayList<Shape>();  int cordar[] = new int [100]; 

	        Shapes() {
	            add();          // в конструкторе Shapes - только один метод 
	        }

	        void add() { shapes.add(new Shape()); l++; }
	        void move() { for (Shape s : shapes) s.move();}
	        
	         
	        void paint(Graphics g) { for (Shape s : shapes) s.paint(g);} 
	        
	        
	        ArrayList<Shape> getShapes() { return shapes; }
	        
	        boolean IsShapeHitShape  ;     /// задачка века... 
	        public void allplus() { for (Shape s : shapes) s.x+=20;  };
	       
	       
	       
	       int [] crdr() { return cordar ;}
	  
	        }
	
	 
	 public void loop() {
		 
	
		if(fy == 18) { isOn = !isOn; count++;shapes.add(); }  // пробуем! - напоролись на = , ==
		 
		 
		if(fy == - 18) {isOn = !isOn; shapes.add();}
		 if (isOn == true ) {
			 
			 fy++;
		 }
		if (isOn == false) {
			fy--;
			}
		
	  }
	 
	 
	 
	 
		public void update() {
		l = shapes.shapes.size(); 
		
		ax.clear();ay.clear();
		  // shapes.lenght
		 	 		 if(l >= 2) {
			 			 
			 for (int i = 0;i<l;i++) {
			
				 	 ax.add(new Integer(shapes.shapes.get(i).getX()));
				 	ay.add(new Integer(shapes.shapes.get(i).getY()));
				 	
				 }
			 System.out.println(ax.size()); System.out.println(ay.size());
			 		
			 outterLoop:  for (int k = 0; k < (ax.size()-1) ; k++) {
			 		        for (int j = 0; j < (ay.size()-1); j++) {
			 		            if (ax.get(j) == 5 || ax.get(j) == 10 || ax.get(j) == 15 || ax.get(j) == 20) {
			 		                System.out.println(ax.get(j));
			 		                shapes.shapes.remove(j);break outterLoop;} // што это я написал такое
			 		            
			 		            }
			 		 }}
			 		 
			if (destroy == true) { }
			 		 
			 		 // Здесь пишем все сравнения массивов поиск одинаковых итд.
			 		 System.out.println(ax.size()); 
			 		 		 		 }
	 
	 public void actionPerformed(ActionEvent e) { 
		 //  6 
		// x += 0.1;                                     // как реализовать счётчик - паровоз. Паровозик....хмм. Попробуем через boolean. Тупым способом.
	//	 y += 1;
		 repaint();
		 loop();
		 shapes.move();
	//	 shapes.check();
		 update();
			
	
}}
