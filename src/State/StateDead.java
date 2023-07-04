package State;

import Personagem.Personagem;
import Strategy_Actions.Attack.WeakAttack;
import Strategy_Actions.Jump.LowerJump;
import Strategy_Actions.Movement.SlowMovement;

public class StateDead extends State {

    public StateDead(Personagem personagem) {
        super(personagem);
        setAttack(new WeakAttack());
        setMovement(new SlowMovement());
        setJump(new LowerJump());
    }

    @Override
    public void setLimites() {
        this.setLowerLimit(0);
        this.setUpperLimit(0);
    }

    @Override
    public void checkStateChange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkStateChange'");
    }

    public String getStateName() {
        return "Dead";
    }
}
