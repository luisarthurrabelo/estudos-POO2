package AbstractFactoryPersonagem;

import Itens.SwordWeapon;
import Itens.Weapon;
import Vehicles.HorseVehicle;
import Vehicles.Vehicle;

public class ConcreteFabricMedieval extends AbstractFabric {

    @Override
    public Weapon createWeapon() {
        return new SwordWeapon();
    }

    @Override
    public Vehicle createVehicle() {
        return new HorseVehicle();
    }
}
