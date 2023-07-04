package Vehicles;

public class HorseVehicle extends Vehicle {

    @Override
    public String toString() {
        return "Cavalo";
    }

    @Override
    public void Velocidade() {
        System.out.println("Este veículo permite que você se movimente 2x mais rápido");
    }
}
