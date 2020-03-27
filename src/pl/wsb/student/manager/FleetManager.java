package pl.wsb.student.manager;
import java.util.ArrayList;
import java.util.HashMap;
import pl.wsb.student.exceptions.FleetException;
import pl.wsb.student.model.Car;
import pl.wsb.student.model.Motor;
import pl.wsb.student.model.Vehicle;
import org.apache.commons.lang3.StringUtils;

public class FleetManager implements IFleetManager{
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    private ArrayList<Vehicle> fleetInPlace = new ArrayList<>();
    private HashMap<Vehicle, String> fleetInUse = new HashMap<>();

    public FleetManager() {
        this.initFleet();
    }

    private void initFleet() {
        this.fleet.add(new Car("Mazda", "MX-5", 140));
        this.fleet.add(new Car("Renault", "Megane", 97));
        this.fleet.add(new Car("Ford", "Mustang", 450));
        this.fleet.add(new Motor("Honda", "Hornet", 75));
        this.fleet.add(new Motor("Suzuki", "Bandit", 89));
        this.fleetInPlace.addAll(this.fleet);
    }

    @Override
    public Vehicle rentVehicle(String buyer) throws FleetException {
        if (this.fleetInPlace.size() <= 0) {
            throw new FleetException("No available vehicles to rent...");
        }
        if (StringUtils.isBlank(buyer)) {
            throw new FleetException("Unspecified buyer name - cannot rent a vehicle...");
        }
        Vehicle vehicle = this.fleetInPlace.remove(0);
        this.fleetInUse.put(
                vehicle,
                buyer
        );
        return vehicle;
    }

    @Override
    public String recoverVehicle(Vehicle vehicle) throws FleetException {
        if (this.fleetInUse.size() <= 0) {
            throw new FleetException("No rented vehicles found...");
        }   //if
        if (vehicle == null) {
            throw new FleetException("Please provide vehicle to recover...");
        }   //if
        if (this.fleetInUse.get(vehicle) == null) {
            throw new FleetException("Provided vehicle is not rented...");
        }
        String buyer = this.fleetInUse.remove(vehicle);
        this.fleetInPlace.add(vehicle);
        return buyer;
    }
}