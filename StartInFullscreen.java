/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *there is no need to change this class
 * it is used only for starting game
 * 
 * you can change TIMER_DELAY to change FPS
 * 
 * FPS = 1000/TIMER_DELAY;
 * 
 * @author gbeljajew
 */
public class StartInFullscreen {

    private static final int TIMER_DELAY = 20;
    
    public static void main(String[] args) 
    {
        
        JFrame frame = new JFrame("titel comes here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        final GamePanel panel = new GamePanel();
        panel.init();
        frame.setContentPane(panel);
        
        Dimension desctop = Toolkit.getDefaultToolkit().getScreenSize();
        
        frame.setUndecorated(true);
        frame.setBounds(0, 0, desctop.width, desctop.height);
        
        Timer t = new Timer(TIMER_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.update();
                panel.repaint();
            }
        });
        
        frame.setVisible(true);
        
        t.start();
    }
    
}
