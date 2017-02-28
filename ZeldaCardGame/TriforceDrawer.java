
import javax.swing.JFrame;
public class TriforceDrawer
{
   public void drawTri() 
    {
        JFrame frame = new JFrame();
        
        frame.setSize(300, 400);
        frame.setTitle("THE GOLDEN TRIANGLE OF POWER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TriforceComponent Nine = new TriforceComponent();
        frame.add(Nine);
        
        frame.setVisible(true);
    } 
}
