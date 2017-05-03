package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Timer;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet {

    private static Font font;
    private HScene scene;
     Veld mveld=new Veld();

    /** Creates a new instance of HelloTVXlet */
    public HelloTVXlet() {
    }

    public void initXlet(XletContext context) {

     
        scene = HSceneFactory.getInstance().getDefaultHScene();
       
        scene.add(mveld, BorderLayout.CENTER);
        scene.validate();
        Timer t=new Timer();
        
        MijnTimerTask tt=new MijnTimerTask() ;
        
        tt.setCallback(this);
        
        t.scheduleAtFixedRate(tt, 0, 10);
               
    }

    public void startXlet() {
       
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
       
        scene = null;
    }
    
    public void callback()
    {
        mveld.timertick();
    }
}
