package ObserverGame.Controller;

import ObserverGame.Model.Player;

public class DownMove implements Command{

    private Player j;
    
    public DownMove(Player j){
        this.j = j;
    }    
    
    public void execute(){
        j.downMove();           
    }    
    
}
