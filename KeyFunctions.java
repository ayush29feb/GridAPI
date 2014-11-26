import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyFunctions implements KeyListener{
    Space space;

    public KeyFunctions(Space space) {
        this.space = space;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char KeyChar = e.getKeyChar();        
        if(KeyChar == ']'){
            this.space.Grid[2]++;            
        }
        if(KeyChar == '[' && this.space.Grid[2]>1){
            this.space.Grid[2]--;
        }
        if(KeyChar == 'g'){
            if(this.space.grid){this.space.grid = false;}else{this.space.grid = true;}
        }if(KeyChar == '0'){
            this.space.Grid[0] = this.space.getWidth()/2;
            this.space.Grid[1] = this.space.getHeight()/2;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == 38){
            this.space.Grid[1] += 10;
        }
        if(c == 37){
            this.space.Grid[0] += 10;
        }
        if(c == 40){
            this.space.Grid[1] -= 10;
        }
        if(c == 39){
            this.space.Grid[0] -= 10;
        }//zoom in
        if(c == 107){
            this.space.Grid[3] += 10;
        }//Zoom out
        if(c == 109){
            this.space.Grid[3] -=10;
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
