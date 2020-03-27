package pl.wsb.student.main;
import pl.wsb.student.exceptions.FleetException;
import pl.wsb.student.manager.FleetManager;
import pl.wsb.student.manager.IFleetManager;
import pl.wsb.student.model.Vehicle;

/*
Program umieszczony jest w try-catch który ma na celu sprawdzenia czy możę
wykonać program czy nie, jak nie to spowoduje błąd i teraz jest podział
na błędy związane z flotą oraz inne nie związane - systemowe.
*/

public class App {
    public static void main(String[] args) {
        try {
            IFleetManager fleetManager = new FleetManager();
            Vehicle rentedVehicle = fleetManager.rentVehicle("Klaudia");
            System.out.println(
                    String.format(
                            "Wypożyczony pojazd - %s, %s",
                            rentedVehicle.getBrand(),
                            rentedVehicle.getModel()
                    )
            );
            Vehicle secondRentedVehicle = fleetManager.rentVehicle("Karolina");
            System.out.println(
                    String.format(
                            "Kolejny wypożyczony pojazd - %s, %s",
                            secondRentedVehicle.getBrand(),
                            secondRentedVehicle.getModel()
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(rentedVehicle)
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(secondRentedVehicle)
                    )
            );
        }
        catch (FleetException ex) {
            System.err.println("Przykro nam, wystąpił błąd obsługi wypożyczenia"
                    + " lub zwrotu pojazdu...");
        }
        catch (Exception ex) {
            System.err.println("Przykro nam, wystąpił błąd aplikacji...");
        }
    }
}