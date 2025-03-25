/**
 * The Passenger class represents an individual passenger who can board and get off train cars.
 * interacts with the Car class
 *
 * @author Sophie Zhang
 * @version 1.0
 * @since 2025-02
 */

public class Passenger implements PassengerRequirements {

    //Attributes
    private String name;

    /**
     * Constructs a Passenger with the specified name.
     *
     * @param name The name of the passenger
     */

    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The passenger's name
     */

    public String getName() {
        return name;
    }

    /**
     * Attempts to board the passenger onto one specific car.
     * If successful, print a confirmation message.
     * If the car is full, print an error message.
     *
     * @param c The car
     */

    public void boardCar(Car c){
        if (c.addPassenger(this)) { 
            System.out.println(name + " has boarded the car.");
        } 
        else {
            System.out.println(name + " could not board. The car is full!");
        }
    }

    /**
     * Attempts to remove the passenger from the specific car.
     * If successful, prints a confirmation message.
     * If the passenger is not on the car, prints an error message.
     *
     * @param c The car
     */

    public void getOffCar(Car c){
        if (c.removePassenger(this)) {
            System.out.println(name + " has gotten off the car.");
        } 
        else {
            System.out.println(name + " is not in this car.");
        }
    }

    /**
     * Test run.
     *
     * @param args Command line arguments
     */

    public static void main(String[] args) {
        Car car = new Car(2);
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Charlie");

        p1.boardCar(car); 
        p2.boardCar(car); 
    }
}
