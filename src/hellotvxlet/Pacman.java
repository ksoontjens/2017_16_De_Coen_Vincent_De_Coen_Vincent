/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Pacman {
    private int x = 15;
    private int y = 15;
    private Image pacman;
    private Punten punten;
    
    public int hoek=30;
    public int r=1;
    public boolean bekopen=true;
    
    public int px=SPRITE_SIZE*1;
    public int py=SPRITE_SIZE*1;
    
    public static int SPRITE_SIZE=15;
    
    public Pacman(Image image){
        this.pacman = image;
        this.punten = new Punten();
    }
    
    public Image getImage(){
        return this.pacman;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public boolean hasCollided(String direction){
        String[] veld = PacmanVeld.veld;
        
        int veldX = (this.x / Pacman.SPRITE_SIZE); //this.x / Pacman.SPRITE_SIZE;
        int veldY = (this.y / Pacman.SPRITE_SIZE); //this.y / Pacman.SPRITE_SIZE;
        
        System.out.println("y: " + veldY);
        System.out.println("x: " + veldX);
        
        if(veldX == 0 || veldY == 0){
            return true;
        }
        
        if(direction.equals("left") && veld[veldY].charAt(veldX - 1) == '-'){
            return true;
        }
        
        if(direction.equals("right") && veld[veldY].charAt(veldX + 1) == '-'){
            return true;
        }
        
        if(direction.equals("up") && veld[veldY - 1].charAt(veldX) == '-'){
            return true;
        }
        
        if(direction.equals("down") && veld[veldY + 1].charAt(veldX) == '-'){
            return true;
        }
        
        if(veld[veldY].charAt(veldX) == '*'){
            punten.takePunt();
            System.out.println(punten.punten);
            
            char[] newVeld = veld[veldY].toCharArray();
            newVeld[veldX] = ',';
            
            veld[veldY] = String.valueOf(newVeld);
            
            
        }
        
        return false;
    }
    
    public void paintPacman(Graphics g){
        g.setColor(Color.YELLOW);
    
        int rot = 90 * (r - 1);
        if (bekopen) {
            g.fillArc(x, y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, rot + hoek, 360 - hoek * 2);
        } else {
            g.fillArc(x, y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, 0, 360);
        }
    }
    
    public void move(HComponent context, String direction, int position){
        
        if(direction.equals("left")){
            this.setX(this.getX() - position);
        }
        
        if(direction.equals("right")){
            this.setX(this.getX() + position);
        }

        if (direction.equals("up")) {
            this.setY(this.getY() - position);
        }
        
        if (direction.equals("down")) {
            this.setY(this.getY() + position);
        }
        
        context.repaint();
        
    }
   
    
}
