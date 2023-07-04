import Enemy.Enemy;
import LabyrinthComposite.*;
import AbstractFactoryPersonagem.*;
import Personagem.*;
import Shield_RChain.Shield;
import Shield_RChain.ShieldLife;

public class App {
        public static void main(String[] args) throws Exception {

                // Instancia o Personagem
                Personagem p1 = new PersonagemAssault("Fenix");
                Enemy enemy1 = new Enemy(15, "inimigo 1");
                Enemy enemy2 = new Enemy(30, "inimigo 2");

                Composite labyrinth = new Sala(
                                        new Sala(
                                                Abismo.getInstance(),
                                                        new Sala(
                                                                new Sala(
                                                                        Abismo.getInstance(),
                                                                                new Sala(
                                                                                        Abismo.getInstance(),
                                                                                                Saida.getInstance(),
                                                                                                "Sala 06",
                                                                                                enemy2),
                                                                                "Sala 05",
                                                                                enemy1),
                                                                Saida.getInstance(),
                                                                "Room 04",
                                                                enemy2),
                                                "Room 02",
                                                enemy1),
                                        new Sala(
                                                Abismo.getInstance(),
                                                Saida.getInstance(),
                                                "Sala 03",
                                                enemy2),
                                "Room 01",
                                enemy2);

                Shield shield_5 = new ShieldLife(5);
                Shield shield_2 = new ShieldLife(2);
                Shield shield_1 = new ShieldLife(1);
                Shield shield_3 = new ShieldLife(3);

                shield_5.setSuccessor(shield_2);
                shield_2.setSuccessor(shield_1);
                shield_1.setSuccessor(shield_3);

                // Colocando os Escudos no Personagem
                p1.setShield(shield_5);

                p1.callPowers("01");
                p1.callPowers("02");
                p1.callPowers("03");

                // p1.damage(80);

                // System.out.println(p1.damageGiven.getDamageQt());
                // System.out.println(p1.damageGiven.getDamagePowers());

                // Simulação Jogador-Labirinto(Aleatório)
                Thread t1 = new Thread(new JogoAuto(labyrinth, p1));
                t1.start();

                // AbstractFabric medieval = new ConcreteFabricMedieval();
                // UtilityItens itens = new UtilityItens(medieval);
                // itens.showItens();
        }
}
