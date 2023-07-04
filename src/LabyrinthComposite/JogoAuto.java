package LabyrinthComposite;

import Personagem.Personagem;

public class JogoAuto extends Jogo {

    public JogoAuto(Composite labirinto, Personagem p) {
        super(labirinto, p);
    }

    @Override
    public void selecionarCaminho() {
        this.getLabyrinth().andar(this.getPersonagem());
    }

    @Override
    public void lutar() {
        this.getLabyrinth().lutar(this.getPersonagem());
    }

}
