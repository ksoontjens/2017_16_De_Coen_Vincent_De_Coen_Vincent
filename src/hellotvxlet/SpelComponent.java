/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
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
    
    /*Characters*/
    private Pacman pacman;
    private Ghost ghostBlue;
    private Ghost ghostOrange;
    private Ghost ghostRed;
    private Ghost ghostYellow;
    private Graphics g;
    
    
    private PacmanTimer pacmanTimer;
    private PacmanVeld pacmanVeld;
    
    private Timer timer;
    private Punten punten;
    
    private boolean start = false;
    
    public SpelComponent(){
        mt = new MediaTracker(this);
        repo = new UserEventRepository("repo");
        eManager = EventManager.getInstance();
        
        pacman = new Pacman();
        ghostBlue = new Ghost(14, 11, Color.CYAN);
        ghostOrange = new Ghost(15, 11, Color.ORANGE);
        ghostRed = new Ghost(11, 11, Color.RED);
        ghostYellow = new Ghost(13, 11, Color.YELLOW);
        
        pacmanVeld = new PacmanVeld();
        
        Ghost[] ghosts = {ghostBlue, ghostOrange, ghostRed, ghostYellow};   
        pacmanTimer = new PacmanTimer(pacman, pacmanVeld, this, ghosts);
        
        timer = new Timer();
        punten = new Punten();
        
        init();
    }
    
    public void init(){
        
        
        try{
            mt.waitForAll();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        repo.addAllArrowKeys();
        eManager.addUserEventListener(this, repo);
        
        timer.scheduleAtFixedRate(pacmanTimer, 0, 60);
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        this.g = g;
        
      
        pacmanVeld.buildVeld(g, this);
        
        pacman.paintPacman(g);
        
        ghostBlue.paintGhost(g);
        ghostOrange.paintGhost(g);
        ghostRed.paintGhost(g);
        ghostYellow.paintGhost(g);
        
        punten.paintScore(g);
              
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
          
          pacmanTimer.setPosition(6);
                      
        }
    }

    void callback() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
