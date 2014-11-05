import java.awt.Graphics2D;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
public class GUIPanel2
{
    BufferedImage title;
    Graphics2D g;

    public GUIPanel2() throws IOException
    {

        title=ImageIO.read(new File("VTSailBOT+Logo.png"));
        g=(Graphics2D)title.getGraphics();
        drawOn();
    }

    public BufferedImage getBufferedImage()
    {
        return title;
    }

    private void drawOn()
    {
        g.setColor(Color.BLUE);
        g.fillRect(30, 10, 500, 15);
    }

}
