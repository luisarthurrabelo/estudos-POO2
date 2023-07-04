package ObserverGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import ObserverGame.Model.*;
import ObserverGame.Controller.*;

//A camada de visao faz referencia tanto ao modelo quanto ao controle, ja que precisa se comunicar com ambas

public class Game extends JPanel {

    private static Enemy j1;
    private static Enemy j2;
    private static Enemy j3;
    private static Enemy j4;
    private static Enemy j5;
    private static Enemy j6;
    private static Enemy j7;
    private List<Checkpoint> checkpoints;
    private static Player player;
    private static Control c; 
    
    public Player getPlayer() {
        return Game.player;
    }
    
    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);

        player = new Player(512, 384, "Luis");
        j1 = new Enemy(10,450);
        j2 = new Enemy(400,20);
        j3 = new Enemy(50,50);
        j4 = new Enemy(100,100);
        j5 = new Enemy(350,100);
        j6 = new Enemy(20,300);
        j7 = new Enemy(400,400);

        checkpoints = new ArrayList<>();
        checkpoints.add(new Checkpoint(200, 300, checkpoints));
        checkpoints.add(new Checkpoint(400, 200, checkpoints));
        
        c = new Control();
        c.setCommand(new LeftMove(player),0);
        c.setCommand(new RightMove(player),1);
        c.setCommand(new UpMove(player),2);
        c.setCommand(new DownMove(player),3);
                
        player.addObserver(j1);
        player.addObserver(j2);
        player.addObserver(j3);        
        player.addObserver(j4);        
        player.addObserver(j5);        
        player.addObserver(j6);        
        player.addObserver(j7); 
        
        for (Checkpoint checkpoint : checkpoints) {
            player.addObserver(checkpoint);
        }
    }       
    
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT){                
                c.pressionar(0);    
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                c.pressionar(1);    
               
            if (e.getKeyCode() == KeyEvent.VK_UP)
                c.pressionar(2);    
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                c.pressionar(3);    
               
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                c.pressionar(4);    

            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                c.pressionar(5);    

            if (e.getKeyCode() == KeyEvent.VK_R)
                c.replay();    
                
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }    
    
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
               
        for (Checkpoint checkpoint : checkpoints) {
            g2d.setColor(Color.RED);
            g2d.fillRect(checkpoint.getX(), checkpoint.getY(), 20, 20);
        }

        g2d.setColor(Color.BLUE);
        g2d.fillOval(player.getX(), player.getY(), 20, 20);

        g2d.setColor(Color.BLACK);        
        g2d.fillOval(j1.getX(), j1.getY(), 20, 20);

        g2d.setColor(Color.BLACK);                
        g2d.fillOval(j2.getX(), j2.getY(), 20, 20);

        g2d.setColor(Color.BLACK);        
        g2d.fillOval(j3.getX(), j3.getY(), 20, 20);

        g2d.setColor(Color.BLACK);        
        g2d.fillOval(j4.getX(), j4.getY(), 20, 20);

        g2d.setColor(Color.BLACK);                
        g2d.fillOval(j5.getX(), j5.getY(), 20, 20);

        g2d.setColor(Color.BLACK);                
        g2d.fillOval(j6.getX(), j6.getY(), 20, 20);

        g2d.setColor(Color.BLACK);                        
        g2d.fillOval(j7.getX(), j7.getY(), 20, 20);
    }
}
