/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Veld extends HComponent {
   String[] veld={
   "-------------------------------",
   "-..............-..............-",
   "-.-----.-------..------.-----.-",   
   "-..............-..............-", 
   "-------.------...------.-----.-",   
   "-------------------------------",
   };
   int SPRITE_SIZE=20;
   public int px=SPRITE_SIZE*1;
   public int py=SPRITE_SIZE*1;
   int hoek=40;
   int r=1;
   int tel=0;
   boolean bekopen=true;
   public Veld()
   {
       this.setBounds(0,0,720,576);
       
   }
         
   public void timertick()
   {
       tel++;
       if (tel>10)      { bekopen=!bekopen; tel=0; }
       int backuppx=px;
       int backuppy=py;
       if (r==1) { px++; }
       if (r==2) { py--; }
       if (r==3) { px--; }
       if (r==4) { py++; }
       int lijn=(py)/SPRITE_SIZE;
       int kar=(px)/SPRITE_SIZE;
       int lijn2=lijn+(py%SPRITE_SIZE>0?1:0);
       int kar2=kar+(px%SPRITE_SIZE>0?1:0);
      
       
       if ((veld[lijn2].charAt(kar2)!='.') || (veld[lijn].charAt(kar)!='.'))
       {
           px=backuppx;
           py=backuppy;
           r++;
           if (r>4) r=1;
       }
       
       this.repaint();
   }
   public void paint(Graphics g)
   {
       g.setColor(Color.BLACK);
       g.fillRect(0,0,720,576);
       g.setColor(Color.PINK);
       for (int i=0;i<veld.length;i++)
       {
           for (int j=0;j<veld[i].length();j++)
           {
               System.out.print(veld[i].charAt(j));
               if (veld[i].charAt(j)=='.')
               {
                   g.fillOval(j*SPRITE_SIZE+SPRITE_SIZE/2, i*SPRITE_SIZE+SPRITE_SIZE/2, 5, 5);
               }
           }
           System.out.println("");        
   }
   g.setColor(Color.YELLOW);
  // g.drawOval(px,py,SPRITE_SIZE,SPRITE_SIZE);
   int rot=90*(r-1);
   if (bekopen)
   g.fillArc(px, py, SPRITE_SIZE, SPRITE_SIZE, rot+hoek, 360-hoek*2);
   else
     g.fillArc(px, py, SPRITE_SIZE, SPRITE_SIZE, 0, 360);
 
   }
}
