package AbstractFactoryPersonagem;

import Itens.Weapon;
import Vehicles.Vehicle;

public abstract class AbstractFabric {

    abstract public Weapon createWeapon();

    abstract public Vehicle createVehicle();
}
