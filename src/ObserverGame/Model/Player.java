package ObserverGame.Model;

import java.util.Observable;

public class Player extends Observable {
    private String nome;
    private int life;
    private int checkpoints;
    private int x;
    private int y;
    

    public int getLife() {
        return life;
    }

    public int getCheckpoints() {
        return this.checkpoints;
    } 

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }    
    
    public void setX(int x) {
        this.x = x; 
    }           
    
    public void setY(int y) {
        this.y = y; 
    }     

    public void leftMove(){
        setX(getX()-10);
    }
    
    public void rightMove(){
        setX(getX()+10);
    }
    
    public void upMove(){
        setY(getY()-10);
    }

    public void downMove(){
        setY(getY()+10);
    }

    public Player(int x, int y, String nome){
        this.x = x;
        this.y = y;
        this.nome = nome;
        life = 10;
    }

    public void takeDamage(int damage){
        life = life - damage;
    }

    public void increaseCheckpoints(int cp) {
        checkpoints = checkpoints + cp; 
    }
    
    public String toString(){
        return this.nome;
    }

    public void show(){
        setChanged();
        notifyObservers();
    }
}
