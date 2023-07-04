package State;

import Strategy_Actions.Attack.AttackAction;
import Strategy_Actions.Jump.JumpAction;
import Strategy_Actions.Movement.MovementAction;
import Personagem.Personagem;

public abstract class State {

    private Personagem personagem;
    private int lowerLimit;
    private int upperLimit;

    private AttackAction attack = null;
    private MovementAction run = null;
    private JumpAction jump = null;

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public State(Personagem personagem) {
        this.personagem = personagem;
        setLimites();
    }

    public abstract void setLimites();

    public abstract void checkStateChange();

    public double getUpperLimit() {
        return this.upperLimit;
    }

    public double getLowerLimit() {
        return this.lowerLimit;
    }

    public abstract String getStateName();

    public void setUpperLimit(int d) {
        this.upperLimit = d;
    }

    public void setLowerLimit(int d) {
        this.lowerLimit = d;
    }

    public int attack() {
        return this.attack.damage();
    }

    public void run() {
        this.run.speed();
    }

    public void jump() {
        this.jump.height();
    }

    public void setAttack(AttackAction attack) {
        this.attack = attack;
    }

    public void setMovement(MovementAction run) {
        this.run = run;
    }

    public void setJump(JumpAction jump) {
        this.jump = jump;
    }
}
