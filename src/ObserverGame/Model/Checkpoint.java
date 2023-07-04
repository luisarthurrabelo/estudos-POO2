package ObserverGame.Model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.SwingUtilities;

import ObserverGame.View.Game;

public class Checkpoint implements Observer{

    private int x;
    private int y;
    private int size;

    private List<Checkpoint> checkpoints;
    private boolean newCheckpointsGenerated = false;

    public Checkpoint(int x, int y, List<Checkpoint> checkpoints) {
        this.x = x;
        this.y = y;
        size = 20;
        this.checkpoints = checkpoints;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void playerPassed(Player player) {
        if (!newCheckpointsGenerated) {
            player.increaseCheckpoints(1);
            generateNewCheckpoints(2, player);
            checkpoints.remove(this);
            notifyObservers(player);
            newCheckpointsGenerated = true;
        }
    }

    public void generateNewCheckpoints(int count, Player player) {

        Random random = new Random();

        // Implemente a lógica para gerar novos checkpoints
        for (int i = 0; i < count; i++) {
            int newX = random.nextInt(800); // Gera um valor aleatório entre 0 e 800 para a coordenada X
            int newY = random.nextInt(600); // Gera um valor aleatório entre 0 e 600 para a coordenada Y

            Checkpoint newCheckpoint = new Checkpoint(newX, newY, checkpoints);
            checkpoints.add(newCheckpoint);
        }
        notifyObservers(player);
    }

    private void notifyObservers(Player player) {
        for (Checkpoint checkpoint : checkpoints) {
            player.addObserver(checkpoint);
        }
    }

    @Override
    public void update(Observable subject, Object arg) {

        Player player = (Player)subject;

        if (!checkpoints.contains(this)) {
            return; // O checkpoint não faz mais parte da lista de checkpoints ativos
        }

        //se estiver em distancia certa
        if(player.getX() >= x && player.getX() <= x + size && player.getY() >= y && player.getY() <= y + size) {
            System.out.println("O player capturou um checkpoint.");
            playerPassed(player);
        }
    }
}
