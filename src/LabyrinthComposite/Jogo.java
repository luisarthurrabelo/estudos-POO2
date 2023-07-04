package LabyrinthComposite;

import Personagem.Personagem;

public abstract class Jogo implements Runnable {

    private Composite labyrinth;
    private Personagem p;

    public Jogo(Composite labirinto, Personagem p) {
        this.labyrinth = labirinto;
        this.p = p;
    }

    public final void jogar() {
        selecionarCaminho();
    }

    public void run() {
        jogar();
    }

    public abstract void selecionarCaminho();

    public abstract void lutar();

    public Composite getLabyrinth() {
        return labyrinth;
    }

    public Personagem getPersonagem() {
        return p;
    }
}
