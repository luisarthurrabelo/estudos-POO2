package AbstractFactoryPersonagem;

import Itens.CryogenicWeapon;
import Itens.Weapon;
import Vehicles.CarVehicle;
import Vehicles.Vehicle;

public class ConcreteFabricModern extends AbstractFabric {

    @Override
    public Weapon createWeapon() {
        return new CryogenicWeapon();
    }

    @Override
    public Vehicle createVehicle() {
        return new CarVehicle();
    }
}
