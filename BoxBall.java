import java.awt.Color;

/**
 * Class BoxBall - a ball that bounces inside a rectangular box on a Canvas.
 *
 * @author Ernesto Cuellar
 * @version 2026.03.27
 */
public class BoxBall
{
    private int x, y;            
    private int dx, dy;          
    private int size;            
    private Color color;         
    private Canvas canvas;       

    private int boxX, boxY, boxWidth, boxHeight; 

    /**
     * Constructor for objects of class BoxBall
     * @param canvas the Canvas to draw on
     * @param boxX the x-coordinate of the top-left corner of the box
     * @param boxY the y-coordinate of the top-left corner of the box
     * @param boxWidth the width of the box
     * @param boxHeight the height of the box
     */
    public BoxBall(Canvas canvas, int boxX, int boxY, int boxWidth, int boxHeight)
    {
        this.canvas = canvas;
        this.boxX = boxX;
        this.boxY = boxY;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;

        this.size = 20; 

        
        x = boxX + (int)(Math.random() * (boxWidth - size));
        y = boxY + (int)(Math.random() * (boxHeight - size));

        
        do {
            dx = -7 + (int)(Math.random() * 15); 
        } while(dx == 0);
        do {
            dy = -7 + (int)(Math.random() * 15);
        } while(dy == 0);

        
        color = new Color(50 + (int)(Math.random() * 200),
                          50 + (int)(Math.random() * 200),
                          50 + (int)(Math.random() * 200));
    }

    /**
     * Move the ball, bouncing off the edges of the box.
     */
    public void move()
    {
        x += dx;
        y += dy;

        
        if(x <= boxX) {
            x = boxX;
            dx = -dx;
        }
        if(x + size >= boxX + boxWidth) {
            x = boxX + boxWidth - size;
            dx = -dx;
        }

        
        if(y <= boxY) {
            y = boxY;
            dy = -dy;
        }
        if(y + size >= boxY + boxHeight) {
            y = boxY + boxHeight - size;
            dy = -dy;
        }
    }

    /**
     * Draw the ball on the canvas
     */
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(x, y, size);
    }
}
