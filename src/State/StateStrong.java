package State;

import Strategy_Actions.Attack.StrongAttack;
import Strategy_Actions.Jump.HigherJump;
import Strategy_Actions.Movement.FastMovement;
import Personagem.Personagem;

public class StateStrong extends State {

    private StateNormal normalState = new StateNormal(this.getPersonagem());

    public StateStrong(Personagem character) {
        super(character);
        setAttack(new StrongAttack());
        setMovement(new FastMovement());
        setJump(new HigherJump());
    }

    @Override
    public void setLimites() {
        this.setLowerLimit(70);
        this.setUpperLimit(100);
    }

    @Override
    public void checkStateChange() {
        if (this.getPersonagem().getLife() <= 0.0)
            this.getPersonagem().setState(new StateDead(this.getPersonagem()));

        else if (this.getPersonagem().getLife() < normalState.getLowerLimit())
            this.getPersonagem().setState(new StateDanger(this.getPersonagem()));

        else if (this.getPersonagem().getLife() < this.getLowerLimit()
                && this.getPersonagem().getLife() < this.getUpperLimit())
            this.getPersonagem().setState(new StateNormal(this.getPersonagem()));
    }

    public String getStateName() {
        return "Strong";
    }
}
