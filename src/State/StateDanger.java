package State;

import Strategy_Actions.Attack.WeakAttack;
import Strategy_Actions.Jump.LowerJump;
import Strategy_Actions.Movement.SlowMovement;
import Personagem.Personagem;

public class StateDanger extends State {

    public StateDanger(Personagem character) {
        super(character);
        setAttack(new WeakAttack());
        setMovement(new SlowMovement());
        setJump(new LowerJump());
    }

    @Override
    public void setLimites() {
        this.setLowerLimit(0);
        this.setUpperLimit(30);
    }

    @Override
    public void checkStateChange() {
        if (this.getPersonagem().getLife() <= this.getLowerLimit())
            this.getPersonagem().setState(new StateDead(this.getPersonagem()));

        else if (this.getPersonagem().getLife() > this.getUpperLimit())
            this.getPersonagem().setState(new StateNormal(this.getPersonagem()));
    }

    public String getStateName() {
        return "Danger";
    }
}
