/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * this class will contain all you game logic and graphic<br/>
 * use it for smaller games
 * 
 * @author gbeljajew
 */
public class GamePanel extends JPanel
{
    public static final int width = 800;
    public static final int high = 600;
    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(width, high));
    }
    
    
    
    
    
    public void init()
    {
        //here comes initiation of your game
    }
    
    public void update()
    {
        //this one will be startet every time before redrawing
    }

    @Override
    public void paint(Graphics g1) 
    {
        Graphics2D g = (Graphics2D)g1;
        //here comes all drawing
    }
    
    
    
}
