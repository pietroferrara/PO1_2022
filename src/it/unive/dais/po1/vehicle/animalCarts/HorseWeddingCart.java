package it.unive.dais.po1.vehicle.animalCarts;

public class HorseWeddingCart extends HorseCart {

    public HorseWeddingCart(double initialSpeed, double load) {
        super(initialSpeed, load);
    }

    public void fireworks() {
        System.out.println("Bum");
    }
}
