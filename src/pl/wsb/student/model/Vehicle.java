package pl.wsb.student.model;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int horsePower;


    public Vehicle(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public abstract int getPrice();

}