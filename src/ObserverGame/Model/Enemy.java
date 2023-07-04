package ObserverGame.Model;

import java.util.Observable;
import java.util.Observer;

public class Enemy implements Observer{
    private int x;
    private int y;
    private double speed = 0;
    private double speedMultiplier = 1;
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }    

    public void setX(int x){
        this.x = x; 
    }           
    
    public void setY(int y){
        this.y = y; 
    }               
    
    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        speed = speedMultiplier;
    }

    public void IncreaseSpeed(int checkpoint) {
        speed = checkpoint;
    }
    
    public void update(Observable subject, Object arg) {

        Player player = (Player)subject;
        IncreaseSpeed(player.getCheckpoints());

        //se estiver em distancia de atacar
        if(((this.x - player.getX()) == 0) && ((this.y - player.getY()) == 0)) {
            System.out.println("Um inimigo atacou o jogador..." );
            player.takeDamage(3);
        }
        else {
           //se precisa andar para frente
           if (player.getX() > this.x) 
            this.x = this.x+(int)(speed*Math.random());
           else 
            this.x = this.x-(int)(speed*Math.random());
           //se precisa andar para tras
           if (player.getY() > this.y) 
            this.y = this.y+(int)(speed*Math.random());
           else 
            this.y = this.y-(int)(speed*Math.random());
     
        }          
    }
}
