package pl.wsb.student.model;

public class Motor extends Vehicle{
    private static final int PRICE = 8;

    public Motor(String brand, String model, int horsePower) {
        super(brand, model, horsePower);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

}