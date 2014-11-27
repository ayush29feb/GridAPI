import java.awt.*;

public class GridAPIClient {
	
	public static void main(String[] args) {
		YourGrid graph = new YourGrid(600, 600);
		
	}
}

class YourGrid extends Grid {
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

	public YourGrid(int width, int height, int originX, int originY, int boxSize, int boxUnit) {
		super(width, height, originX, originY, boxSize, boxUnit);
	}

	public YourGrid() {
		super(Toolkit.getDefaultToolkit().getScreenSize().width, 
			 Toolkit.getDefaultToolkit().getScreenSize().height);
	}

	public YourGrid(int width, int height) {
		super(width, height, width/2, height/2);
	}

	public YourGrid(int width, int height, int originX, int originY) {
		super(width, height, originX, originY, 50, 5);
	}
}