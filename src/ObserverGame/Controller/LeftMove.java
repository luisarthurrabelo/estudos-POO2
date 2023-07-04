package ObserverGame.Controller;

import ObserverGame.Model.Player;

public class LeftMove implements Command{

    private Player j;

    public LeftMove(Player j){
        this.j = j;
    }    
    
    public void execute(){
        j.leftMove();           
    }    
}
