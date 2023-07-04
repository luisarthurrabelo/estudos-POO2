package Shield_RChain;

public class ShieldLife extends Shield {

    private int shieldLife;

    public ShieldLife(int life) {
        this.shieldLife = life;
    }

    @Override
    public int discountDamage(int damage) {

        int discountDamage = damage - shieldLife;

        if (discountDamage != 0 && getSuccessor() != null) {
            return getSuccessor().discountDamage(discountDamage);

        } else {
            if (discountDamage < 0) {
                return 0;
            }
            return discountDamage;
        }
    }
}
