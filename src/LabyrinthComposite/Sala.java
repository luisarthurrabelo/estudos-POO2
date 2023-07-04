package LabyrinthComposite;

import java.util.Random;
import java.util.Scanner;

import Enemy.Enemy;
import Personagem.Personagem;

public class Sala implements Composite {

    private Composite path1;
    private Composite path2;
    private String name;
    private Enemy enemy;
    private boolean playerAlive = true;
    Scanner scanner = new Scanner(System.in);

    public Sala(Composite c1, Composite c2, String name, Enemy enemy) {

        this.path1 = c1;
        this.path2 = c2;
        this.name = name;
        this.enemy = enemy;
    }

    @Override
    public void andar(Personagem p) {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println("========================================");
        System.out.println("Personagem " + p.getName() + " entrou na sala " + this.name);
        System.out.println("========================================");

        lutar(p);

        if (!playerAlive) {
            System.out.println("Personagem " + p.getName() + " morreu para o inimigo " + enemy.getName());
        } else {
            double valor = Math.random();

            if (valor < 0.5) {
                System.out.println("Personagem " + p.getName() + " pegou o caminho 1\n");
                path1.andar(p);
            } else {
                System.out.println("Personagem " + p.getName() + " pegou o caminho 2\n");
                path2.andar(p);
            }
        }

    }

    @Override
    public void lutar(Personagem p) {

        System.out.println("========================================");
        System.out.println("Personagem " + p.getName() + " se deparou com o " + enemy.getName());
        p.damage(enemy.getDamage());
        System.out.println("========================================");

        if (p.getLife() <= 0) {
            playerAlive = false;
        } else {
            playerAlive = true;
        }
    }

    @Override
    public void andarInterface(Personagem p) {

        lutarInterface(p);

        if (!playerAlive) {
            System.out.println("Personagem " + p.getName() + " morreu para o inimigo " + enemy.getName());
        } else {

            System.out.println();
            System.out.println("Você chegou a uma encruzilhada. Qual caminho você deseja escolher?");
            System.out.println("1. Caminho da esquerda");
            System.out.println("2. Caminho da direita");

            System.out.print("Digite o número correspondente ao caminho desejado: ");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                System.out.println("Você escolheu o caminho da esquerda. Boa sorte!");
                path1.andarInterface(p);
            } else if (escolha == 2) {
                System.out.println("Você escolheu o caminho da direita. Boa sorte!");
                path2.andarInterface(p);
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    @Override
    public void lutarInterface(Personagem p) {
        Random random = new Random();
        int valorGerado = random.nextInt(10) + 1;

        System.out.println("\nUm inimigo se aproxima!");
        System.out.println("Você precisa adivinhar o valor gerado entre 1 e 10 para vencê-lo.");

        System.out.print("Digite sua resposta: ");
        int resposta = scanner.nextInt();

        if (resposta == valorGerado) {
            System.out.println("Você acertou! O inimigo é vencido sem causar danos.");
        } else {
            System.out.println("Você errou! O inimigo te ataca.");
            p.damage(enemy.getDamage());
            if (p.getLife() <= 0) {
                playerAlive = false;
            } else {
                playerAlive = true;
            }
        }
    }

}
