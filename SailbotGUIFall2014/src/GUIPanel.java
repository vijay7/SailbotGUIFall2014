import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Vijay
 * @version Nov 5, 2014
 */
public class GUIPanel
    extends JPanel
{
    BufferedImage title;
    public GUIPanel() throws IOException
    {
        setLayout(new BorderLayout());
        setBackground(new Color(102, 0, 0));
        GUIPanel2 a=new GUIPanel2();
        title=a.getBufferedImage();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(title, 200, 0, 600, 90, null);
    }
}
