package State;

import Strategy_Actions.Attack.MediumAttack;
import Strategy_Actions.Jump.MediumJump;
import Strategy_Actions.Movement.MediumMovement;
import Personagem.Personagem;

public class StateNormal extends State {

    public StateNormal(Personagem personagem) {
        super(personagem);
        setAttack(new MediumAttack());
        setMovement(new MediumMovement());
        setJump(new MediumJump());
    }

    @Override
    public void setLimites() {
        this.setLowerLimit(30);
        this.setUpperLimit(70);
    }

    @Override
    public void checkStateChange() {
        if (this.getPersonagem().getLife() < this.getLowerLimit())
            this.getPersonagem().setState(new StateDanger(this.getPersonagem()));

        else if (this.getPersonagem().getLife() > this.getUpperLimit())
            this.getPersonagem().setState(new StateStrong(this.getPersonagem()));
    }

    public String getStateName() {
        return "Normal";
    }
}
