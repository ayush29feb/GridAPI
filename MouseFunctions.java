import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;

public class MouseFunctions implements MouseWheelListener,MouseInputListener{

    Space space;
    int MouseTemp[] = {0,0};
    
    public MouseFunctions(Space space) {
        this.space = space;
    }
    
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getUnitsToScroll() > 0 && this.space.Grid[3] > 20){
            this.space.Grid[3]-=10;            
        }
        if(e.getUnitsToScroll() < 0 && this.space.Grid[3] < this.space.getWidth()/3){
            this.space.Grid[3]+=10;
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
        this.space.Grid[0] += diffx;
        int diffy = e.getY() - this.MouseTemp[1];
        this.space.Grid[1] += diffy;

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
        this.space.curX = ((double)Math.round(space.getRealX(e.getX())*100))/100;
        this.space.curY = ((double)Math.round(space.getRealY(e.getY())*100))/100;;
    }
    
}
