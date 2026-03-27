import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing balls bouncing inside a box
 * using the Canvas class.
 *
 * @author Ernesto Cuellar
 * @version 2016.02.29
 */
public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BoxBall> balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        balls = new ArrayList<>();
    }

    /**
     * Simulate balls bouncing inside a box
     * @param numBalls The number of balls to create (5-30 recommended)
     */
    public void boxBounce(int numBalls)
    {
        int boxX = 50, boxY = 50, boxWidth = 500, boxHeight = 300;

        
        balls.clear();

        
        for(int i = 0; i < numBalls; i++)
        {
            balls.add(new BoxBall(myCanvas, boxX, boxY, boxWidth, boxHeight));
        }

        
        for(int t = 0; t < 500; t++) // run 500 "ticks"
        {
            myCanvas.wait(50); 

            
            myCanvas.erase();  

            
            drawBox(boxX, boxY, boxWidth, boxHeight);

            
            for(BoxBall ball : balls)
            {
                ball.move();
                ball.draw();
            }
        }
    }

    /**
     * Helper method to draw the box outline
     */
    private void drawBox(int x, int y, int width, int height)
    {
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(x, y, x + width, y);                 
        myCanvas.drawLine(x, y, x, y + height);                
        myCanvas.drawLine(x + width, y, x + width, y + height); 
        myCanvas.drawLine(x, y + height, x + width, y + height); 
    }
}
