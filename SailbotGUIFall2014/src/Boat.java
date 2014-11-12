

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Rachael
 */
public class Boat extends JPanel{
    private BufferedImage boatImage;
    
    Graphics bufferSail;
    Graphics bufferRudder;
    Graphics page;
    
    double winch;
    double rudder;
    double oldWinch;
    double oldRudder;
    
    Polygon lineSail;
    Polygon lineRudder;
    
    Point origin;
    Point originSail;
    Point originRudder;
    Point toSail;
    Point toRudder;
    
    AffineTransform transformSail;
    AffineTransform transformRudder;
    
    
    Boat (double winch, double rudder, Graphics page, Point origin) {
        this.winch = oldWinch;
        this.rudder = oldRudder;
        this.page = page;
        this.origin = origin;
        
        try{
            boatImage = ImageIO.read(new File("BirdsEyeViewSailboat.jpeg"));
        }
        catch(IOException e){
            System.out.println("Caught IOException"+e.getMessage());
        }    
        
    }
    
    private static Point midpoint(Point p1, Point p2){
        return new Point((int)((p1.x + p2.x) / 2.0), (int)((p1.y + p2.y) / 2.0));
    }
    
    public AffineTransform rotate(double radians)    {
        AffineTransform transform = new AffineTransform();
        transform.rotate(radians, 135, 135);
        return transform;
    }
    
    public void drawImage(){
        page.drawImage(boatImage,origin.x,origin.y,null);
        lineSail = new Polygon(); 
        lineRudder = new Polygon();
        
        Point max = new Point(origin.x+350,origin.y+375);
        Point center = midpoint(max,origin);
        
        originSail = new Point(center.x,origin.y+295);
        originRudder = new Point(center.x,origin.y+100);
        
        toSail = new Point(originSail.x,originSail.y-100);
        toRudder = new Point(originRudder.x,originRudder.y-65);

        transformSail = new AffineTransform();
        transformRudder = new AffineTransform();
        transformSail.translate(originSail.x, originSail.y);
        transformRudder.translate(originRudder.x, originRudder.y);
        
        double ptDistanceSail = originSail.distance(toSail);
        double ptDistanceRudder = originRudder.distance(toRudder);
        double scaleSail = ptDistanceSail / 12.0; // 12 because it's the length of the
// arrow polygon.
        double scaleRudder = ptDistanceRudder / 6.0; 
        transformSail.scale(scaleSail, scaleSail);
        transformRudder.scale(scaleRudder, scaleRudder);

        transformSail.createTransformedShape(lineSail);
        transformRudder.createTransformedShape(lineRudder);
    }
   
    public void updateImage(double radiansSail, double radiansRudder){ 
        if (radiansSail>=50 && radiansSail<=90){            
            transformSail.rotate(radiansSail);
        }
        else if(radiansRudder>=0 && radiansSail<=180){
            transformRudder.rotate(radiansRudder);    
        }
        else{
            System.out.println("Input out of Bounds: Domain = 50,90");
        }
    }
}
