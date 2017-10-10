/*
 * @author Kevin Madison
 * CS 1632 Quality Assurance
 * Deliverable 2
 * Instructor: Bill Laboon
*/

import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;
import org.mockito.Mockito.*;
import java.util.*;

public class CitySim9005Test {
    
	/*
     * Testing: Seed produces similar output.
     * Passing two similar seeds shall produce a similar path, stubbing from the main method in CitySim9005.java
     */
    @Test
    public void testReproducablePath(){
    	int seed = 123874;
    	int num;//used for random number
    	Random generator = new Random(seed);
    	
    	num = generator.nextInt(4);//driver's starting path
		Driver driver1 = new Driver(1, num);
		
		num = generator.nextInt(2);
		driver1.drive(num);
		
		
		generator = new Random(seed); //re-create the random number generator
		num = generator.nextInt(4); //driver's starting path
		Driver driver2 = new Driver(2, num);
		
		
		num = generator.nextInt(2);
		driver2.drive(num);
		
		String driverLocation1 = driver1.currentCity.currentLocation.getName();
		String driverLocation2 = driver2.currentCity.currentLocation.getName();
		assertEquals(driverLocation1, driverLocation2);

    }  
    
    
    /*
     * Testing: Edge cases of the setCurrentLocation() method in the City class.
     * This class shall accept integers 0-3 and therefore and will return -1 for any other numbers.
     * Create a city and attempt to create new starting locations for integers 0-3, negative numbers, 4, and large integers.
     * The Method should return 1 if it is successful, and a -1 if unsuccessful.
     */
    @Test
    public void testSetCurrentLocation(){
    	int result;
		City testCity = new City();
		
		//Testing hotel
		result = testCity.setCurrentLocation(0);
		assertEquals(result, 1);
		
		//testing diner
		result = testCity.setCurrentLocation(1);
		assertEquals(result, 1);
		
		//testing library
		result = testCity.setCurrentLocation(2);
		assertEquals(result, 1);
		
		//testing coffee
		result = testCity.setCurrentLocation(3);
		assertEquals(result, 1);
		
		//testing edge case: negative number
		result = testCity.setCurrentLocation(-1);
		assertEquals(result, -1);
		
		//testing edge case: 4
		result = testCity.setCurrentLocation(4);
		assertEquals(result, -1);
		
		//testing edge cage: large integer
		result = testCity.setCurrentLocation(123456789);
		assertEquals(result, -1);
		
    }
    

    
    /*
     * Testing: Edge cases of the moveLocation() method in the City class.
     * This class shall accept integers 0-1 which represent either a street or avenue. Other inputs should return an empty string.
     * Create a starting location, hotel, and attempt to move it with 0, 1, a negative number, edge case of 2, and a large integer.
     * The method should return the correct street or avenue name or 0/1, however it should return an empty string if these are not valid.
     */
    @Test
    public void testMoveLocation(){
    	String result;
		City testCity = new City();
		testCity.setCurrentLocation(0);//set current location to hotel
		
		//Testing 0 - should use Bill St.
		result = testCity.moveLocation(0);
		assertEquals(result, "Bill St.");
		
		//Testing 1 - should use Fourth Ave.
		testCity.setCurrentLocation(0); //reset location
		result = testCity.moveLocation(1);
		assertEquals(result, "Fourth Ave.");
		
		//Testing negative number - Should return and empty string by default
		testCity.setCurrentLocation(0); //reset location
		result = testCity.moveLocation(-1);
		assertEquals(result, "");

		//Testing edge case at 2 - should return an empty string by default
		testCity.setCurrentLocation(0); //reset location
		result = testCity.moveLocation(2);
		assertEquals(result, "");
		
		//Testing large integer
		testCity.setCurrentLocation(0); //reset location
		result = testCity.moveLocation(123456789);
		assertEquals(result, "");
		
		
		
		
    }
    
    /*
     * Testing: Path from Hotel to Diner via Fourth Ave
     */
    @Test
    public void testHotelFourthAve(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(0); //set location to Hotel
    	tempCity.moveLocation(1);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Diner");
    }
    
    /*
     * Testing: Path from Diner to Philadelphia via Fourth Ave
     */
    @Test
    public void testDinerFourthAve(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(1); //set location to Hotel
    	tempCity.moveLocation(1);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Philadelphia");
    }
    
    /*
     * Testing: Path from Library to Cleveland via Fifth Ave
     */
    @Test
    public void testLibraryFifthAve(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(2); //set location to Hotel
    	tempCity.moveLocation(1);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Cleveland");
    }
    
    /*
     * Testing: Path from Coffee to Library via Fifth Ave
     */
    @Test
    public void testCoffeeFifthAve(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(3); //set location to Hotel
    	tempCity.moveLocation(1);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Library");
    }
    
    /*
     * Testing: Path from Hotel to Library via Bill St.
     */
    @Test
    public void testHotelBillSt(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(0); //set location to Hotel
    	tempCity.moveLocation(0);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Library");
    }
    
    /*
     * Testing: Path from Library to Hotel via Bill St.
     */
    @Test
    public void testLibraryBillSt(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(2); //set location to Hotel
    	tempCity.moveLocation(0);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Hotel");
    }
    
    /*
     * Testing: Path from Diner to Coffee via Phil St.
     */
    @Test
    public void testDinerPhilSt(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(1); //set location to Hotel
    	tempCity.moveLocation(0);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Coffee");
    }
    
    /*
     * Testing: Path from Coffee to Diner via Phil St.
     */
    @Test
    public void testCoffeePhilSt(){
    	City tempCity = new City();
    	tempCity.setCurrentLocation(3); //set location to Hotel
    	tempCity.moveLocation(0);
    	
    	String currentLocation = tempCity.currentLocation.getName();
    	assertEquals(currentLocation, "Diner");
    }
    
    
    
}
