import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Grid extends JPanel implements ActionListener{

	// Private Fields
	private int width, height, originX, originY, boxSize, boxUnit;
	private boolean showGrid = true;
	private Timer t = new Timer(50, this);
	private double curX, curY;

	public Grid(int width, int height, int originX, int originY, int boxSize, int boxUnit) {
		
		// Instantiate the variables
		this.width = width;
		this.height = height;
		this.originX = originX;
		this.originY = originY;
		this.boxSize = boxSize;
		this.boxUnit = boxUnit;

		// Creates a window
		JFrame window = new JFrame();
		setSize(this.width, this.height);
		window.setSize(this.width, this.height);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this);

        // activateListeners();
	}

	public Grid(){
		this(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
	}

	public Grid(int width, int height){
		this(width, height, width/2, height/2);
	}

	public Grid(int width, int height, int originX, int originY){
		this(width, height, originX, originY, 50, 5);
	}

	@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if (showGrid) {
        	drawGrids(g);
        }
     
        t.start(); // Updates The Graph
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public void drawGrids(Graphics g){
        g.setColor(Color.decode("0xFFCCFF"));
        for(int x1 = originX + boxSize; x1 <= this.getWidth(); x1 += boxSize){
            g.drawLine(x1, 0, x1, this.getHeight());
            g.setColor(Color.black);
            g.drawString(Integer.toString((x1 - originX) * boxUnit / boxSize), x1 - 5, originY + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originX - boxSize; x1 >= 0; x1 -= boxSize){
            g.drawLine(x1, 0, x1, this.getHeight());
            g.setColor(Color.black);            
            g.drawString(Integer.toString((x1 - originX) * boxUnit / boxSize), x1 - 5, originY + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originY + boxSize; x1 <= this.getHeight(); x1 += boxSize){
            g.drawLine(0, x1, this.getWidth(), x1);          
            g.setColor(Color.black);            
            g.drawString(Integer.toString((originY - x1) * boxUnit / boxSize), originX - 20 , x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originY - boxSize; x1 >= 0; x1 -= boxSize){
            g.drawLine(0, x1, this.getWidth(), x1);             
            g.setColor(Color.black);            
            g.drawString(Integer.toString((originY - x1) * boxUnit / boxSize), originX - 20, x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        g.setColor(Color.black);
        g.drawLine(originX, 0, originX, this.getHeight());
        g.drawLine(0, originY, this.getWidth(), originY);
        g.drawString("0", originX + 5, originY + 20);
        g.drawString("UnitBoxSize:" + boxUnit, this.getWidth() - 100, 30);
        g.drawString("X:" + this.curX + "Y:" + this.curY, 5, 30);
    }

	// private void activateListeners(){
 //        addMouseWheelListener(new MouseFunctions(this));
 //        addMouseListener(new MouseFunctions(this));
 //        addMouseMotionListener(new MouseFunctions(this));
 //        setFocusable(true);
 //        addKeyListener(new KeyFunctions(this));
        
 //    }
}