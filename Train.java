import java.util.ArrayList;

public class Train implements TrainRequirements{

    private String name;
    private Engine engine; 
    private ArrayList<Car> cars;

    /**
     * 
     */
    public Train(String name){
        this.name = name;
    }

    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
    this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity); 
    this.cars = new ArrayList<Car>();  // 创建空的 ArrayList
    for (int i = 0; i < nCars; i++) {  // 循环创建 nCars 个车厢
        this.cars.add(new Car(passengerCapacity));  
        }
    }

    public String getName() {
        return name;
    }

    public Engine getEngine(){
            return this.engine;

    }
    public Car getCar(int i) {
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }
        else{
            return null;
        }
    }


    public int getMaxCapacity(){
        int totalCapacity = 0;
        for (Car car : cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }

    public int seatsRemaining(){
        int remainingSeats = 0;
        for (Car car : cars) {
            remainingSeats += car.seatsRemaining();
        }
        return remainingSeats;
    }

    public void printManifest(){
        boolean empty = true; 
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + i + ":");
            cars.get(i).printManifest();  

            if (cars.get(i).seatsRemaining() != cars.get(i).getCapacity()) {
                empty = false;
            }
        }
        if (empty) {
            System.out.println("This train is EMPTY.");
        }
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 50.0, 100.0, 3, 2);
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");
    
        p1.boardCar(train.getCar(0));  
        p2.boardCar(train.getCar(1));  
        p3.boardCar(train.getCar(2));  
    
        train.printManifest();
    }
}
