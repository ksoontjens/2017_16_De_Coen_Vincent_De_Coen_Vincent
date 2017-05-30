/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import java.util.Timer;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;

import org.havi.ui.HComponent;
/**
 *
 * @author student
 */
public class SpelComponent extends HComponent implements UserEventListener{
    
    private MediaTracker mt;
    private UserEventRepository repo;
    private EventManager eManager;
    private Pacman pacman;
    private PacmanTimer pacmanTimer;
    private PacmanVeld pacmanVeld;
    private Timer timer;
    private Punten punten;
    
    private boolean start = false;
    
    public SpelComponent(){
        mt = new MediaTracker(this);
        repo = new UserEventRepository("repo");
        eManager = EventManager.getInstance();
        
        Image pacmanImage = this.getToolkit().getImage("pacman.jpg");
        pacman = new Pacman(pacmanImage);
        pacmanVeld = new PacmanVeld();
        pacmanTimer = new PacmanTimer(pacman, pacmanVeld, this);
        timer = new Timer();
        punten = new Punten();
        
        init();
    }
    
    public void init(){
        mt.addImage(pacman.getImage(), 1);
        
        try{
            mt.waitForAll();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        repo.addAllArrowKeys();
        eManager.addUserEventListener(this, repo);
        
        timer.scheduleAtFixedRate(pacmanTimer, 0, 80);
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
      
        pacmanVeld.buildVeld(g, this);
        
        pacman.paintPacman(g);
        
              
        //g.drawImage(pacman.getImage(), pacman.getX(), pacman.getY(), null);
        
        
    }
    
    public void userEventReceived(UserEvent e){
        
        
        if(e.getType() == HRcEvent.KEY_PRESSED){
                     
          if(e.getCode()==HRcEvent.VK_LEFT){
              pacmanTimer.setNextDirection("left");
          }
          
          if(e.getCode()==HRcEvent.VK_RIGHT){              
              pacmanTimer.setNextDirection("right");
          }
          
          if(e.getCode()==HRcEvent.VK_UP){
             pacmanTimer.setNextDirection("up");
          }
          
          if(e.getCode()==HRcEvent.VK_DOWN){
             pacmanTimer.setNextDirection("down");
          }
          
          pacmanTimer.setPosition(8);
                      
        }
    }

    void callback() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
