package DamageDecorator;

import Personagem.DamageGiven;

public class Power_03 extends DamageDecorator {
    public Power_03(DamageGiven damageDecorate) {
        super(damageDecorate);
        setDamageQt(30);
        setDamagePowers("Poder 03");
    }
}
