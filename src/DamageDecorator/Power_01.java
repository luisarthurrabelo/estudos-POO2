package DamageDecorator;

import Personagem.DamageGiven;

public class Power_01 extends DamageDecorator {
    public Power_01(DamageGiven damageDecorate) {
        super(damageDecorate);
        setDamageQt(10);
        setDamagePowers("Poder 01");
    }

}
