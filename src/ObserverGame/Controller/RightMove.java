package ObserverGame.Controller;

import ObserverGame.Model.Player;

public class RightMove implements Command{

    private Player j;

    public RightMove(Player j){
        this.j = j;
    }    
    
    public void execute(){
        j.rightMove();           
    }    
    
}
