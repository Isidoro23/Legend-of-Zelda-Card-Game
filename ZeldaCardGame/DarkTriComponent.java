
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Polygon;
import java.awt.Color;
public class DarkTriComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        //Top polygon
        int xpoints[] = {80, 135, 190};
        int ypoints[] = {135, 220, 135};
        int npoints = 3;
        g2.setColor(new Color(0,0,0));
        g2.fillPolygon(xpoints, ypoints, 3);
        g2.drawPolygon(xpoints, ypoints, npoints);
        
        //Left Polygon
        int xpoints1[] = {25, 80, 135};
        int ypoints1[] = {50, 135, 50};
        int npoints1 = 3;
        g2.setColor(new Color(0,0,0));
        g2.fillPolygon(xpoints1, ypoints1, 3);
        g2.drawPolygon(xpoints1, ypoints1, npoints1);
        
        //Right Polygon
        int xpoints2[] = {135, 190, 245};
        int ypoints2[] = {50, 135, 50};
        int npoints2 = 3;
        g2.setColor(new Color(0,0,0));
        g2.fillPolygon(xpoints2, ypoints2, 3);
        g2.drawPolygon(xpoints2, ypoints2, npoints2);
        
        g2.drawString("Your soul has been consumed and sent to the",20, 275);
        g2.drawString("void until the next victim meets the same fate.", 20, 300);
        
    }
}