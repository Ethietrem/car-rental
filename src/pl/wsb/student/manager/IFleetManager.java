package pl.wsb.student.manager;
import pl.wsb.student.exceptions.FleetException;
import pl.wsb.student.model.Vehicle;

public interface IFleetManager {
    String recoverVehicle(Vehicle vehicle) throws FleetException;
    Vehicle rentVehicle(String buyer) throws FleetException;

}