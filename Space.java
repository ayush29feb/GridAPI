import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
        
public class Space extends JPanel implements ActionListener {
    Timer t = new Timer(50, this);
    int Grid[] = {400, 400, 5, 50}; // [0]OriginX(PointX), [1]OriginY(PointY), [2]OneUnitBox(cm), [3]OneUnitBoxSize(px)
    double curX=0,curY=0;
    
    //Visibilities
    boolean grid = true;
    //Contains All the Option Facilities
    Options options = new Options();
    
    
    public Space() {
        activateListeners();
        
    }
        
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(grid){drawGrids(g);}
     
        t.start(); // Updates The Graph
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public static void main(String args[]){
        JFrame jf = new JFrame();
        Space m = new Space();
        
        m.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(m);
    }

    private void activateListeners(){
        this.addMouseWheelListener(new MouseFunctions(this));
        this.addMouseListener(new MouseFunctions(this));
        this.addMouseMotionListener(new MouseFunctions(this));
        
        this.setFocusable(true);
        this.addKeyListener(new KeyFunctions(this));
        
    }
    
   
    
    public void drawGrids(Graphics g){
        g.setColor(Color.decode("0xFFCCFF"));
        for(int x1 = this.Grid[0] + this.Grid[3]; x1<=this.getWidth(); x1+=this.Grid[3]){
            g.drawLine(x1, 0, x1, this.getHeight());
            g.setColor(Color.black);
            g.drawString(Integer.toString((x1 - this.Grid[0])*this.Grid[2]/this.Grid[3]), x1 - 5, this.Grid[1] + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = this.Grid[0] - this.Grid[3]; x1>=0; x1-=this.Grid[3]){
            g.drawLine(x1, 0, x1, this.getHeight());
            g.setColor(Color.black);            
            g.drawString(Integer.toString((x1 - this.Grid[0])*this.Grid[2]/this.Grid[3]), x1 - 5, this.Grid[1] + 20);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = this.Grid[1] + this.Grid[3]; x1<=this.getHeight(); x1+=this.Grid[3]){
            g.drawLine(0, x1, this.getWidth(), x1);          
            g.setColor(Color.black);            
            g.drawString(Integer.toString((this.Grid[1] - x1)*this.Grid[2]/this.Grid[3]), this.Grid[0] - 20 , x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        for(int x1 = this.Grid[1] - this.Grid[3]; x1>=0; x1-=this.Grid[3]){
            g.drawLine(0, x1, this.getWidth(), x1);             
            g.setColor(Color.black);            
            g.drawString(Integer.toString((this.Grid[1] - x1)*this.Grid[2]/this.Grid[3]), this.Grid[0] - 20, x1 - 10);
            g.setColor(Color.decode("0xFFCCFF"));
        }
        
        g.setColor(Color.black);
        g.drawLine(Grid[0], 0, Grid[0], this.getHeight());
        g.drawLine(0, Grid[1], this.getWidth(), Grid[1]);
        g.drawString("0", this.Grid[0] + 5, this.Grid[1] + 20);
        g.drawString("UnitBoxSize:" + this.Grid[2], this.getWidth() - 100, 30);
        g.drawString("X:" + this.curX + "Y:" + this.curY, 5, 30);
    }
    
    
    public int getGridX(double x){
        int x1 = (int) (this.Grid[0] + (x * this.Grid[3])/this.Grid[2]);
        return x1;
    }
    
    public int getGridY(double y){
        int y1 = (int) (this.Grid[1] - (y * this.Grid[3])/this.Grid[2]);
        return y1;
    }
    
    public double getRealX(int x){
        double x1 = x - this.Grid[0];
        x1 = x1/this.Grid[3];
        x1 = x1*this.Grid[2];        
        return x1;
    }   

    public double getRealY(int y){
        double y1 = this.Grid[1] - y;
        y1 = y1/this.Grid[3];
        y1 = y1*this.Grid[2];
        return y1;
    }
}