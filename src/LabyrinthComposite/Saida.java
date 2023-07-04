package LabyrinthComposite;

import Personagem.Personagem;

public class Saida implements Composite {

    private static Saida instance;

    private Saida() {
        super();
    }

    public static Saida getInstance() {
        if (instance == null) {
            instance = new Saida();
        }
        return instance;
    }

    @Override
    public void andar(Personagem p) {
        System.out.println();
        System.out.println("Saída encontrada. Personagem " + p.getName() + " escapou do labirinto...");
    }

    @Override
    public void lutar(Personagem p) {
    }

    @Override
    public void andarInterface(Personagem p) {
        System.out.println();
        System.out.println("Saída encontrada. Personagem " + p.getName() + " escapou do labirinto...");
    }

    @Override
    public void lutarInterface(Personagem p) {
    }
}
