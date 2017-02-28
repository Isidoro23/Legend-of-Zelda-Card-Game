
import javax.swing.JFrame;
public class DarkTriViewer
{
    public void drawDark()
    {
        JFrame frame = new JFrame();
        
        frame.setSize(300, 400);
        frame.setTitle("TRIFORCE!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DarkTriComponent Nine = new DarkTriComponent();
        frame.add(Nine);
        
        frame.setVisible(true);
    } 
}
