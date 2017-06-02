/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Ghost {
    
    private int x;
    private int y;
    private int veldX;
    private int veldY;
    private Color color;
    private String direction = "up";
    private ArrayList directions = new ArrayList();
    private ArrayList prevDirections = new ArrayList();
    String[] veld = PacmanVeld.veld;
    
    public Ghost(int veldX, int veldY, Color color){
        this.x = veldX * Pacman.SPRITE_SIZE;
        this.y = veldY * Pacman.SPRITE_SIZE;
        this.color = color;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void paintGhost(Graphics g){
        g.setColor(this.color);
        
        g.fillRoundRect(this.x, this.y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, 4, 14);
    }
    
    public boolean otherCoursePossible(){
        int initialSize = directions.size();
        
        if(veld[veldY].charAt(veldX - 1) != '-'){
            directions.add("left");
        }
        if(veld[veldY].charAt(veldX + 1) != '-'){
            directions.add("right");
        }
        if(veld[veldY].charAt(veldY - 1) != '-'){
            directions.add("up");
        }
        if(veld[veldY].charAt(veldX + 1) != '-'){
            directions.add("down");
        }
        
        if(initialSize != directions.size()){
            return true;
        }else{
            return false;
        }
        
    }
    
    public void changeCourse(){
        if(veld[veldY].charAt(veldX - 1) != '-'){
            directions.add("left");
        }
        
        if(veld[veldY].charAt(veldX + 1) != '-'){
            directions.add("right");
        }
        
        if(veld[veldY - 1].charAt(veldX) != '-'){
            directions.add("up");
        }
        
        if(veld[veldY + 1].charAt(veldX) != '-'){
            directions.add("down");
        }
        
        int numberOfDirections = directions.size();
        
        if(numberOfDirections == 0){
            return;
        }
        
        Random random = new Random(System.currentTimeMillis());

        int randomDirection = random.nextInt(directions.size());
       
        this.direction = directions.get(randomDirection).toString();
        
        directions.clear();
    }
    
    public boolean hasCollidedExperiment(){
        veldX = (int) Math.round((double)this.x / (double)Pacman.SPRITE_SIZE);
        veldY = (int) Math.round((double)this.y / (double)Pacman.SPRITE_SIZE);
        
        if(veld[veldY].charAt(veldX - 1) != '-'){
            prevDirections.add("left");
        }
        
        if(veld[veldY].charAt(veldX + 1) != '-'){
            prevDirections.add("right");
        }
        
        if(veld[veldY - 1].charAt(veldX) != '-'){
            prevDirections.add("up");
        }
        
        if(veld[veldY + 1].charAt(veldX) != '-'){
            prevDirections.add("down");
        }
        
        if(prevDirections.size() != directions.size()){
            Random random = new Random();
            
            /* spastische geesten vermijden */
            int randomDirection = random.nextInt(100);
            
            for(int directionItem = 0; directionItem < directions.size(); directionItem++){
               //Change direction on collision
               if(prevDirections.get(directionItem) == direction){
                    this.setX(veldX * Pacman.SPRITE_SIZE);
                    this.setY(veldY * Pacman.SPRITE_SIZE);
                    changeCourse();
               }
            }
            
            //change direction maybe on intersect
            if(randomDirection < 25){
                this.setX(veldX * Pacman.SPRITE_SIZE);
                this.setY(veldY * Pacman.SPRITE_SIZE);
            
                changeCourse();
            }
        }
        
        prevDirections.clear();
        
        return false;
    }
    
    public boolean hasCollided(){
        
        
        veldX = (int) Math.round((double)this.x / (double)Pacman.SPRITE_SIZE);
        veldY = (int) Math.round((double)this.y / (double)Pacman.SPRITE_SIZE);        
        
        if(veldX == 0 || veldY == 0){
            changeCourse();
        }
        
        if(this.direction.equals("left") && veld[veldY].charAt(veldX - 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            changeCourse();
        }
        
        if(this.direction.equals("right") && veld[veldY].charAt(veldX + 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            changeCourse();
        }
        
        if(this.direction.equals("up") && veld[veldY - 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            changeCourse();
        }
        
        if(this.direction.equals("down") && veld[veldY + 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            changeCourse();
        }
        
        return false;
    }
    
    public void move(HComponent context, int position){
        
        if(this.direction.equals("left")){
            this.setX(this.getX() - position);
        }
        
        if(this.direction.equals("right")){
            this.setX(this.getX() + position);
        }

        if(this.direction.equals("up")) {
            this.setY(this.getY() - position);
        }
        
        if(this.direction.equals("down")) {
            this.setY(this.getY() + position);
        }
        
        context.repaint();
        
    }
}
