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
public class Title
{
    BufferedImage title;
    BufferedImage logo;
    Graphics2D g;

    public Title() throws IOException
    {
        title=new BufferedImage(1000,100, BufferedImage.TYPE_4BYTE_ABGR);
        logo=title.getSubimage(270, 0, 460, 100);
        logo=ImageIO.read(new File("VTSailBOT+Logo.png"));
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
        g.fillRect(0, 0, 270, 100);
        g.setColor(Color.GREEN);
        g.fillRect(730, 0, 270, 100);
        g.drawImage(logo, 270, 0, 460, 100, null);
    }

}