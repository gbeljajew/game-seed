package bin;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.JOptionPane;


/**
 * this is an static class -> no instance needet.<br/>
 * it contains some methods to load sprites from files.<br/>
 * 
 * constants are used for RPGM2k NPC Sprites
 * @author gbeljajew
 */
public class Glob
{
    
    public static final int DIR_UP=0;
    public static final int DIR_RIGHT=1;
    public static final int DIR_DOWN=2;
    public static final int DIR_LEFT=3;
    public static final int[] STEP={1,0,1,2};
    
    public static Dimension dim = new Dimension(1024,768);
	
	
    /**
     * 
     * transforms BufferedImage to Image
     * 
     * @param bufferedImage 
     * @return 
     */
    public static Image toImage(BufferedImage bufferedImage) 
    {
        if(bufferedImage == null)throw new NullPointerException();
        return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
    }
	
    /**
     * loads a single Image from file
     * 
     * 
     * @param path is path to file with sprite
     * @return null if there are some problems
     */
    public static Image getImage(String path)
    {
        File f = new File(path);
        BufferedImage bi;
        
        try {
            bi = ImageIO.read(f);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File " + path + " not found");
            return null;
        }
        return toImage(bi);
        
    }
	
    /**
     * loads sprites from a file and puts it in an array as Image
     * one row after another
     * 
     * 
     * @param path path to file
     * @param dx how wide is one sprite
     * @param dy how high is one sprite
     * @return an array of sprites
     */
    public static Image[] getTiles(String path,int dx, int dy) 
    {
        File f= new File(path);
        BufferedImage bi;
        Image[] erg;
        
        try {
            bi = ImageIO.read(f);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File " + path + " not found");
            return null;
        }
        
        BufferedImage bis;
        int mx=bi.getWidth()/dx;
        int my=bi.getHeight()/dy;
        erg = new Image[mx*my];
        int ix, iy;
        for(iy=0;iy<my;iy++)
        {
            for(ix=0;ix<mx;ix++)
            {
                bis=bi.getSubimage(dx*ix, dy*iy, dx, dy);
                erg[ix+iy*mx]=toImage(bis);
            }
        }
        return erg;
    }
    
    /**
     * load RPGM2k NPC (or something like that) Sprites<br/>
     * 
     * you can use it to load other sprite maps if you wish.<br/>
     * 
     * 
     * @param path path to file
     * @param width width of sprite in pixel
     * @param high high of sprite in pixel
     * @return Image[step(0..2)][direction(0..3)] if you separated one NPC in one file 
     */
    public static Image[][] getHeroAnimation(String path, int width, int high) 
    {
        
        BufferedImage bi;
        bi = getBufferedImage(path);
        BufferedImage b;
        
        if(bi == null)
            return null;
        
        Image[][] erg=new Image[bi.getWidth()/width][bi.getHeight()/high];

        for(int ix=0;ix<erg.length;ix++)
        {
            for(int iy=0;iy<erg[ix].length;iy++)
            {
                b=bi.getSubimage(ix*width, iy*high, width, high);
                erg[ix][iy]=toImage(b);
            }
        }
        return erg;
    }
    
    /**
     * 
     * loads a BufferedImage from file<br/>
     * use getImage() instead
     * 
     * @param path
     * @return 
     */
    public static BufferedImage getBufferedImage(String path) 
    {
        File f= new File(path);
        BufferedImage bi;
        
        try {
            bi = ImageIO.read(f);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File " + path + " not found");
            return null;
        }
        
        return bi;
    }
	
}   