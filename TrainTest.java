import org.junit.*;
import static org.junit.Assert.*;


public class TrainTest {


    @Test
    public void testEngineConstructor() {
        Engine e = new Engine(FuelType.STEAM, 50.0, 100.0);
        assertEquals(FuelType.STEAM, e.getFuelType());
        assertEquals(50.0, e.getCurrentFuel(), 0.001);
        assertEquals(100.0, e.getMaxFuel(), 0.001);
    }

    @Test
    public void testEngineGol() {
        Engine e = new Engine(FuelType.ELECTRIC, 50.0, 100.0);
        boolean result = e.go();
        assertTrue(result);
        assertEquals(30.0, e.getCurrentFuel(), 0.001);
    }


    @Test
    public void testCarAddPassenger() {
        Car car = new Car(2);
        Passenger p = new Passenger("Alice");
        boolean added = car.addPassenger(p);
        assertTrue(added);
        assertEquals(1, car.getCapacity() - car.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        Car car = new Car(2);
        Passenger p = new Passenger("Bob");
        car.addPassenger(p);
        boolean removed = car.removePassenger(p);
        assertTrue(removed);
        assertEquals(0, car.getCapacity() - car.seatsRemaining());
    }


    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car = new Car(1);
        Passenger p = new Passenger("Charlie");
        p.boardCar(car);
        assertEquals(0, car.seatsRemaining());
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car car = new Car(1);
        Passenger p1 = new Passenger("Daniel");
        Passenger p2 = new Passenger("Ella");
        p1.boardCar(car);
        p2.boardCar(car);  // should fail silently
        assertEquals(0, car.seatsRemaining());
    }


    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.STEAM, 50.0, 100.0, 3, 5);
        assertNotNull(train.getCar(0));
        assertNotNull(train.getCar(2));
        assertNull(train.getCar(3)); 
    }

    @Test
    public void testTrainPassengerCount() {
        Train train = new Train(FuelType.STEAM, 50.0, 100.0, 2, 4);
        Passenger p1 = new Passenger("Fiona");
        Passenger p2 = new Passenger("George");
        p1.boardCar(train.getCar(0));
        p2.boardCar(train.getCar(1));
        assertEquals(6, train.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.OTHER, 30.0, 80.0, 2, 1);
        Car car = train.getCar(1);
        assertNotNull(car);
        assertEquals(1, car.getCapacity());
    }

    @Test
    public void testTrainPrintManifest() {
        Train train = new Train(FuelType.INTERNAL_COMBUSTION, 60.0, 100.0, 1, 1);
        train.printManifest();  
    }

}
