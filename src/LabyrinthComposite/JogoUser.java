package LabyrinthComposite;

import Personagem.Personagem;

public class JogoUser extends Jogo {

    public JogoUser(Composite labirinto, Personagem p) {
        super(labirinto, p);
    }

    @Override
    public void selecionarCaminho() {
        this.getLabyrinth().andarInterface(this.getPersonagem());
    }

    @Override
    public void lutar() {
        this.getLabyrinth().lutarInterface(this.getPersonagem());
    }

}
