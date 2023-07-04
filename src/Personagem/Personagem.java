package Personagem;

import DamageDecorator.*;
import LifeManager.Damage;
import LifeManager.Heal;
import Shield_RChain.Shield;
import State.*;

public abstract class Personagem {

    public State state;
    private String name;

    protected String[] inventory;

    private int life;
    public Shield shields;
    public DamageGiven damageGiven;

    private Damage damageTaken;
    private Heal heal;

    public void setDamage(Damage damage) {
        this.damageTaken = damage;
    }

    public void setHeal(Heal heal) {
        this.heal = heal;
    }

    public Personagem(String name) {
        this.name = name;
        this.state = new StateNormal(this);
        this.damageGiven = new DamageGiven();
        this.life = 70;
        setDamageGiven();

        setDamage(new Damage());
        setHeal(new Heal());
    }

    public void damage(int valor) {

        if (shields != null) {
            valor = shields.discountDamage(valor);
        }

        this.life = this.damageTaken.damage(this.life, valor);
        state.checkStateChange();
        recalculateDamageGiven();

        System.out.println("Damage = " + valor);
        System.out.println("Life   = " + this.getLife());
        System.out.println("State  = " + this.state.getClass().getName());
        System.out.println("\n");
    }

    public void heal(int valor) {
        this.life = this.heal.heal(this.life, valor);
        state.checkStateChange();
        recalculateDamageGiven();

        System.out.println("Heal   = " + valor);
        System.out.println("Life   = " + this.getLife());
        System.out.println("State  = " + this.state.getClass().getName());
        System.out.println("\n");
    }

    public void callPowers(String tipo) {

        switch (tipo) {
            case "01":
                this.damageGiven = new Power_01(damageGiven);
                break;
            case "02":
                this.damageGiven = new Power_02(damageGiven);
                break;
            case "03":
                this.damageGiven = new Power_03(damageGiven);
                break;
            default:
                throw new IllegalArgumentException("Poder inválido");
        }
    }

    public int getLife() {
        return this.life;
    }

    public String getName() {
        return this.name;
    }

    public void showInventory() {

        for (String item : this.inventory) {
            System.out.print(item + ", ");
        }
    }

    public void setDamageGiven() {
        damageGiven.setDamageQt(this.getState().attack());
        damageGiven.setDamagePowers(this.getState().getStateName());
    }

    private void recalculateDamageGiven() {
        // Não consegui implementar
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public DamageGiven getDamageGiven() {
        return this.damageGiven;
    }

    public void setShield(Shield shields) {
        this.shields = shields;
    }
}
