package ObserverGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ObserverGame.Model.Player;
import ObserverGame.View.Game;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int x = 1024;
        int y = 768;  
        
        JFrame frame = new JFrame("RoboCup");
        Game game = new Game();

        JLabel label = new JLabel();
        
        label.setBounds(0, 0, x, y);

        game.setLayout(null);
        game.add(label);
        
        frame.add(game);
        frame.setSize(x, y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        Player player = game.getPlayer();
        
        while (game.getPlayer().getLife() > 0) {
            player.show();           
            game.repaint();
            Thread.sleep(50);
        }
    }
}
