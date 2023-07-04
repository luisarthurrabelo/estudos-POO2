package DamageDecorator;

import Personagem.DamageGiven;

public class Power_02 extends DamageDecorator {
    public Power_02(DamageGiven damageDecorate) {
        super(damageDecorate);
        setDamageQt(20);
        setDamagePowers("Poder 02");
    }
}
