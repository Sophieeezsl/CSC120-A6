import java.util.Scanner;
/**
 * The Engine class represents an engine in the train that uses fuel to run.
 *
 * @author Sophie Zhang
 * @version 1.0
 * @since 2025-02
 */

public class Engine implements EngineRequirements {

    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;
    
    /**
     * Constructor for Engine 
     * @param f Enine's fuel type 
     * @param currentFuelLevel Engine's current fuel level 
     * @param maxFuelLevel Engine's max fuel level 
     */
    
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f; 
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel; 
    }

    public FuelType getFuelType() {
        return this.f; 
    }

    public double getMaxFuel() {
        return this.maxFuelLevel; 
    }

    public double getCurrentFuel() {
        return this.currentFuelLevel; 
    }

    public void refuel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to refuel? (Y/N): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("y")) {
            this.currentFuelLevel = this.maxFuelLevel;
            System.out.println("Refuel completed");
        }
        else{
            System.out.println("No refuelling.");
        }
        scanner.close();

    }

    public Boolean go() {
        if (this.currentFuelLevel >=20){
            this.currentFuelLevel -= 20;
            System.out.println("Engine starting. Remaining fuel:");
            System.out.println(this.currentFuelLevel);
            return true; 
        }
        else{
            System.out.println("There is not enough fuel.");
            return false;
        }
    }

    public String toString() {
        return ("Engine has fuel type: " + this.f + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel); 
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0., 100.); 
        System.out.println(myEngine);

        Engine myOtherEngine = new Engine(FuelType.STEAM, 50., 100.);
        System.out.println(myOtherEngine);

        myOtherEngine.refuel();
        myOtherEngine.go();
    }

}