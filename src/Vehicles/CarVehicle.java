package Vehicles;

public class CarVehicle extends Vehicle {

    @Override
    public String toString() {
        return "Carro";
    }

    @Override
    public void Velocidade() {
        System.out.println("Este veículo permite que você se movimente 4x mais rápido");
    }
}