import java.util.ArrayList;
/**
 * The Car class represents a train car that holds passengers.
 *
 * @author Sophie Zhang
 * @version 1.0
 * @since 2025-02
 */

public class Car implements CarRequirements{

    //Attributes
    private ArrayList<Passenger> passengers;
    private int maxcapacity;

    /**
     * Constructs a Car with a specified maximum capacity.
     *
     * @param maxcapacity The maximum number of passengers the car can hold
     */

    public Car(int maxcapacity) {
        this.passengers = new ArrayList<>(); 
        this.maxcapacity = maxcapacity;
    }

    public int getCapacity(){
        return maxcapacity;
    }
    /**
     * Calculates and returns the number of remaining seats in the car.
     *
     * @return The number of seats still available
     */

    public int seatsRemaining(){
        return maxcapacity - passengers.size();
    }

    /**
     * Adds a passenger to the car.
     *
     * @param p The passenger to be added
     * @return If the passenger can be successfully added
     */

    public Boolean addPassenger(Passenger p){
            if(seatsRemaining() > 0){
                passengers.add(p);
                return true;
            }
            else{
                return false;}
            }
    /**
     * Remove a passenger from the car.
     *
     * @param p The passenger to be removed
     * @return If the passenger can be successfully removed
     */

    public Boolean removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
            return true;
        }
        return false; 
    }

    /**
     * Prints the list of passengers currently on board.
     * If the car is empty, prints "This car is EMPTY."
     */

    public void printManifest(){
        if (passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Here's the list of passengers:");
            for (Passenger p : passengers) {
                System.out.println(p.getName());
            }
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
        car.printManifest(); 

        p2.getOffCar(car);
        car.printManifest();
    }

}
