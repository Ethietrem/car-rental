package pl.wsb.student.model;

public class Car extends Vehicle{
    private static final int PRICE = 10;

    public Car(String brand, String model, int horsePower) {
        super(brand, model, horsePower);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

}