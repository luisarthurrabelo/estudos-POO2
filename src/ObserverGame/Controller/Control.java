package ObserverGame.Controller;

import java.util.ArrayList;

public class Control {
    
    private Command[] c = new Command[6];
    private ArrayList<Command> log = new ArrayList<Command>();
    
    public void setCommand(Command c, int i){
        this.c[i] = c;
    }
    
    public void pressionar(int i){
        this.c[i].execute();
        log.add(c[i]);
    }
    
    public void executa(Command c){
        c.execute();
        log.add(c);
        
    }    
    
    public void showLog(){
        for (Command c : log)
            System.out.println(c.toString());
    }    
    
    public void replay(){
        for (Command c : log)
            c.execute();
    }    
    
}
