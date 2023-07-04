package AbstractFactoryPersonagem;

import Itens.Weapon;
import Vehicles.Vehicle;

public class UtilityItens {

    // Variáveis de Inst ância
    private Weapon weapon;
    private Vehicle vehicle;

    // Constructores
    public UtilityItens(AbstractFabric fabrica) {

        weapon = fabrica.createWeapon();
        vehicle = fabrica.createVehicle();
    }

    // Métodos
    public void showItens() {

        System.out.println("=====================");
        System.out.println(weapon.toString());
        weapon.Ataque();
        System.out.println();
        System.out.println(vehicle.toString());
        vehicle.Velocidade();
        System.out.println("=====================");
    }
}
