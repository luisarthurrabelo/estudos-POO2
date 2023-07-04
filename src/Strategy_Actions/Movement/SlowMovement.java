package Strategy_Actions.Movement;

public class SlowMovement implements MovementAction {

    @Override
    public void speed() {
        System.out.println("Movimentação Lenta");
    }
}
