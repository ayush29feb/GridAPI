import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Grid extends JPanel implements ActionListener{

	// Private Fields
	private int width, height;
	
	private Timer t = new Timer(50, this);
	private double curX = 0, curY = 0;

	//Public Fields
	public int originX, originY, boxSize, boxUnit;
	public boolean showGrid = true;

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

        activateListeners();
	}

	public Grid(){
		this(Toolkit.getDefaultToolkit().getScreenSize().width, 
			 Toolkit.getDefaultToolkit().getScreenSize().height);
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
        width = this.getWidth();
        height = this.getHeight();
        repaint();
    }

    // Returns Pixel
    public int getGridX(double x){
        int x1 = (int) (originX + (x * boxSize)/boxUnit);
        return x1;
    }
    
    public int getGridY(double y){
        int y1 = (int) (originY - (y * boxSize)/boxUnit);
        return y1;
    }
    
    // Returns number on the co-ordinate system
    public double getRealX(int x){
        double x1 = x - originX;
        x1 = x1 / boxSize;
        x1 = x1 * boxUnit;        
        return x1;
    }   

    public double getRealY(int y){
        double y1 = originY - y;
        y1 = y1/boxSize;
        y1 = y1*boxUnit;
        return y1;
    }

    public double getCurX(){
    	return curX;
    }

    public double getCurY(){
    	return curY;
    }

	public void setCurX(double x){
    	curX = x;
    }

    public void setCurY(double y){
    	curY = y;
    }

    public void drawGrids(Graphics g){
        g.setColor(Color.decode("0xFFCCFF"));
        for(int x1 = originX + boxSize; x1 <= width; x1 += boxSize){
            g.drawLine(x1, 0, x1, height);
            g.setColor(Color.black);
            g.drawString(Integer.toString((x1 - originX) * boxUnit / boxSize), x1 - 5, originY + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originX - boxSize; x1 >= 0; x1 -= boxSize){
            g.drawLine(x1, 0, x1, height);
            g.setColor(Color.black);            
            g.drawString(Integer.toString((x1 - originX) * boxUnit / boxSize), x1 - 5, originY + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originY + boxSize; x1 <= height; x1 += boxSize){
            g.drawLine(0, x1, width, x1);          
            g.setColor(Color.black);            
            g.drawString(Integer.toString((originY - x1) * boxUnit / boxSize), originX - 20 , x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = originY - boxSize; x1 >= 0; x1 -= boxSize){
            g.drawLine(0, x1, width, x1);             
            g.setColor(Color.black);            
            g.drawString(Integer.toString((originY - x1) * boxUnit / boxSize), originX - 20, x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        g.setColor(Color.black);
        g.drawLine(originX, 0, originX, height);
        g.drawLine(0, originY, width, originY);
        g.drawString("0", originX + 5, originY + 20);
        g.drawString("UnitBoxSize:" + boxUnit, width - 100, 30);
        g.drawString("X:" + curX + "Y:" + curY, 5, 30);
    }

	private void activateListeners(){
        addMouseWheelListener(new MouseFunctions(this));
        addMouseListener(new MouseFunctions(this));
        addMouseMotionListener(new MouseFunctions(this));
        setFocusable(true);
        addKeyListener(new KeyFunctions(this));
        
    }
}