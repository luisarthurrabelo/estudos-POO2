package LabyrinthComposite;

import Personagem.Personagem;

public class Abismo implements Composite {

    private static Abismo instance;

    private Abismo() {
        super();
    }

    public static Abismo getInstance() {
        if (instance == null) {
            instance = new Abismo();
        }
        return instance;
    }

    @Override
    public void andar(Personagem p) {
        System.out.println();
        System.out.println("Abismo encontrado. Personagem " + p.getName() + " morreu...");
    }

    @Override
    public void lutar(Personagem p) {
    }

    @Override
    public void andarInterface(Personagem p) {
        System.out.println();
        System.out.println("Abismo encontrado. Personagem " + p.getName() + " morreu...");
    }

    @Override
    public void lutarInterface(Personagem p) {
    }
}
