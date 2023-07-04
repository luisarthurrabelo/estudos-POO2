package ObserverGame.Controller;

import ObserverGame.Model.Player;

public class UpMove implements Command{

    private Player j;

    public UpMove(Player j){
        this.j = j;
    }    
    
    public void execute(){
        j.upMove();           
    }  
}
