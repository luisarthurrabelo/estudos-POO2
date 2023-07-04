package DamageDecorator;

import Personagem.DamageGiven;

public abstract class DamageDecorator extends DamageGiven {

    private DamageGiven damageDecorate;

    public DamageDecorator(DamageGiven damageDecorate) {
        this.damageDecorate = damageDecorate;
    }

    public int getDamageQt() {
        return damageDecorate.getDamageQt() + super.getDamageQt();
    }

    public String getDamagePowers() {
        return damageDecorate.getDamagePowers() + ", " + super.getDamagePowers();
    }
}
