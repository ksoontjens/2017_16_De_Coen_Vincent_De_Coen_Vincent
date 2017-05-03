/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class PacmanTimer extends TimerTask{
    private Pacman pacman;
    private HComponent context;
    private char direction;
    private int position;
    
    public PacmanTimer(Pacman pacman, HComponent context){
        this.pacman = pacman;
        this.context = context;
    }
    
    public void setDirection(char direction){
        this.direction = direction;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public void run(){
        pacman.move(context, direction, position);
    }
}
