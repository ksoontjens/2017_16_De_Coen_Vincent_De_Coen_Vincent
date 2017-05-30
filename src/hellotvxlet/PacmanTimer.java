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
    private PacmanVeld veld;
    private HComponent context;
    private String direction = "";
    private String nextDirection = "";
    private int position;
    
    
    public PacmanTimer(Pacman pacman, PacmanVeld veld, HComponent context){
        this.pacman = pacman;
        this.veld = veld;
        this.context = context;
    }
    
    public void setDirection(String direction){
        this.direction = direction;
    }
    
    public String getDirection(String direction){
        return this.direction;
    }
    
    public String setNextDirection(String direction){
        return this.nextDirection = direction;
    }
    
    public String getNextDirection(String direction){
        return this.nextDirection;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public void run(){
        int veldX = (int) Math.round((double)pacman.getX() / (double)Pacman.SPRITE_SIZE);
        int veldY = (int) Math.round((double)pacman.getY() / (double)Pacman.SPRITE_SIZE);
        
        if(!this.nextDirection.equals("")){
            if(this.nextDirection.equals("left")){
                veldX--;
            }else if(this.nextDirection.equals("right")){
                veldX++;
            }else if(this.nextDirection.equals("up")){
                veldY--;
            }else if(this.nextDirection.equals("down")){
                veldY++;
            }
            
            if(veld.veld[veldY].charAt(veldX) != '-'){
                this.direction = this.nextDirection;
                this.nextDirection = "";
            }
        }

        if(!pacman.hasCollided(direction)){
           pacman.move(context, direction, position);
        }
       
    }
}
