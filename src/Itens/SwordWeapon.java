package Itens;

public class SwordWeapon extends Weapon {

    @Override
    public String toString() {
        return "Espada reta";
    }

    @Override
    public void Ataque() {
        System.out.println("Está espada causa 30 de dano em seus inimigos quando empunhada");
    }
}
