package PersonagemFactory;

import Personagem.Personagem;

public class Match {

    Personagem[] squad = new Personagem[4];

    final void Jogar(String classe1, String nome1, String classe2, String nome2, String classe3, String nome3,
            String classe4, String nome4) {

        squad = new Personagem[] { PersonagemFactory.getPersonagem(classe1, nome1),
                PersonagemFactory.getPersonagem(classe2, nome2),
                PersonagemFactory.getPersonagem(classe3, nome3),
                PersonagemFactory.getPersonagem(classe4, nome4) };
    }

    public void showSquad() {
        if (squad != null) {
            for (int i = 0; i < squad.length; i++) {
                System.out.println("Personagem novo: " + squad[i].getName() + ", ");
                squad[i].showInventory();
                System.out.println("..\n");
            }
        }
    }
}
