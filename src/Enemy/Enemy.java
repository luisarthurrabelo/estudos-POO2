package Enemy;

public class Enemy {

    private int damage;
    private String name;

    public Enemy(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
