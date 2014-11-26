import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyFunctions implements KeyListener{
    Grid grid;

    public KeyFunctions(Grid grid) {
        this.grid = grid;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char KeyChar = e.getKeyChar();        
        if(KeyChar == ']'){
            grid.boxUnit++;            
        }
        if(KeyChar == '[' && grid.boxUnit>1){
            grid.boxUnit--;
        }
        if(KeyChar == 'g'){
            if(grid.showGrid) {
                grid.showGrid = false;
            } else { 
                grid.showGrid = true;
            }
        }if(KeyChar == '0'){
            grid.originX = grid.getWidth()/2;
            grid.originY = grid.getHeight()/2;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == 38){
            grid.originY += 10;
        }
        if(c == 37){
            grid.originX += 10;
        }
        if(c == 40){
            grid.originY -= 10;
        }
        if(c == 39){
            grid.originX -= 10;
        }//zoom in
        if(c == 107){
            grid.boxSize += 10;
        }//Zoom out
        if(c == 109){
            grid.boxSize -=10;
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
