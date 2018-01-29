/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package licrystsystem.main;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Diego
 */
public class Splash extends JWindow{
    
    private AbsoluteConstraints absc1, absc2;
    private AbsoluteLayout absl;
    ImageIcon image;
    JLabel jLabel;
    JProgressBar bar;
    
    public Splash(){
    
        absl = new AbsoluteLayout();
        absc1 = new AbsoluteConstraints(0, 0);
        absc2 = new AbsoluteConstraints(0, 200);
        jLabel = new JLabel();
        image = new ImageIcon(getClass().getResource("/licrystsystem/images/splash.png"));
        bar = new JProgressBar();
        bar.setPreferredSize(new Dimension(500, 15));
        jLabel.setIcon(image);
        this.getContentPane().setLayout(absl);
        this.getContentPane().add(jLabel, absc1);
        this.getContentPane().add(bar, absc2);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
           
    }
    
    public void exit(){
        this.dispose();
    }
    
    public void setBarValue(int value){
        bar.setValue(value);
    }
}
