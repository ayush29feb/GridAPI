import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;

public class MouseFunctions implements MouseWheelListener, MouseInputListener{

    Grid grid;
    int MouseTemp[] = {0, 0};
    
    public MouseFunctions(Grid grid) {
        this.grid = grid;
    }
    
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getUnitsToScroll() > 0 && grid.boxSize > 20){
            grid.boxSize -= 10;            
        }
        if(e.getUnitsToScroll() < 0 && grid.boxSize < grid.getWidth()/3){
            grid.boxSize += 10;
        }        

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.MouseTemp[0] = e.getX();
        this.MouseTemp[1] = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int diffx = e.getX() - this.MouseTemp[0];
        grid.originX += diffx;
        int diffy = e.getY() - this.MouseTemp[1];
        grid.originY += diffy;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        grid.setCurX(((double)Math.round(grid.getRealX(e.getX()) * 100)) / 100);
        grid.setCurY(((double)Math.round(grid.getRealY(e.getY()) * 100)) / 100);
    }
    
}
