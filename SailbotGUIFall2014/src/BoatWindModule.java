import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
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
public class BoatWindModule
{
    BufferedImage module;
    Graphics2D g;
    double direction=0;
    double magnitude=0;

    public BoatWindModule() throws IOException
    {
        module=new BufferedImage(250,250, BufferedImage.TYPE_4BYTE_ABGR);
        //logo=title.getSubimage(270, 0, 460, 100);
        //logo=ImageIO.read(new File("VTSailBOT+Logo.png"));
        g=(Graphics2D)module.getGraphics();
        drawOn();
    }

    public BufferedImage getBufferedImage()
    {
        return module;
    }

    private void drawOn()
    {
        //GENERALIZE THE NUMBERS USING VARIABLES LATER
        g.setColor(Color.RED);
        int red = 4;
        String name = "this better work";
        g.fillRect(0, 0, 250, 250);
    }
    

    private void drawArrow(double direction)
    {
        Point center=new Point(125,125);
        int tipX;
        int tipY;
        //Erase old arrow
        g.setColor(Color.WHITE);
        tipX=?;
        tipY=?;
        g.fill(createArrowShape(center, new Point(tipX, tipY)));

        //Draw new one
        g.setColor(Color.BLUE);
        tipX=?;
        tipY=?;
        g.fill(createArrowShape(center, new Point(a) ));
    }


    private void displayMagnitude(double newMagnitude)
    {
        //Change text
    }
    public void redraw(double newMagnitude, double newDirection)
    {
        drawArrow(newDirection);
        displayMagnitude(newMagnitude);
    }

    public static Shape createArrowShape(Point fromPt, Point toPt)
    {
        Polygon arrowPolygon = new Polygon();
        arrowPolygon.addPoint(-6, 1);
        arrowPolygon.addPoint(3, 1);
        arrowPolygon.addPoint(3, 3);
        arrowPolygon.addPoint(6, 0);
        arrowPolygon.addPoint(3, -3);
        arrowPolygon.addPoint(3, -1);
        arrowPolygon.addPoint(-6, -1);

        Point midPoint = midpoint(fromPt, toPt);

        double rotate = Math.atan2(toPt.y - fromPt.y, toPt.x - fromPt.x);

        AffineTransform transform = new AffineTransform();
        transform.translate(midPoint.x, midPoint.y);
        double ptDistance = fromPt.distance(toPt);
        double scale = ptDistance / 12.0; // 12 because it's the length of the
// arrow polygon.
        transform.scale(scale, scale);
        transform.rotate(rotate);

        return transform.createTransformedShape(arrowPolygon);
    }


    private static Point midpoint(Point p1, Point p2)
    {
        return new Point((int)((p1.x + p2.x) / 2.0), (int)((p1.y + p2.y) / 2.0));
    }
}