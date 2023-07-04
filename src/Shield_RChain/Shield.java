package Shield_RChain;

public abstract class Shield {

    private Shield successor;

    public void setSuccessor(Shield successor) {
        this.successor = successor;
    }

    public Shield getSuccessor() {
        return this.successor;
    }

    public abstract int discountDamage(int damage);
}
