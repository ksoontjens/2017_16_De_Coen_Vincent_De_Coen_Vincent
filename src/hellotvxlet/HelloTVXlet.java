package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

  
    public HelloTVXlet() {
        
    }
    
    private HScene scene;

    public void initXlet(XletContext context) {
      scene = HSceneFactory.getInstance().getDefaultHScene();
      
      SpelComponent sComp = new SpelComponent();
      
      sComp.setBounds(0, 0, 720, 576);
      
      scene.add(sComp);
      scene.validate();
      scene.setVisible(true);
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void actionPerformed(ActionEvent arg0){
        
    }
}
