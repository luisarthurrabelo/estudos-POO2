package Itens;

public class CryogenicWeapon extends Weapon {

    @Override
    public String toString() {
        return "Arma criogenica";
    }

    @Override
    public void Ataque() {
        System.out.println("Está arma congela os inimigos quando usada");
    }
}
