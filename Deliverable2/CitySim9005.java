/**
 * 
 * @author Kevin Madison
 * CS 1632 Quality Assurance
 * Instructor: Bill Laboon
 * 
 * CitySim9005:
 * 	Running this program with a single integer argument as the seed will produce 5 drivers who will traverse the city in a psuedorandom way. 
 * 	In the code below, I chose to use a random integer between 0-11 because there are 4 possible locations, and two possible directions from each location. Since 12 is divisable by 4 and 2, I thought this was a suitable range.
 * 
 */

import java.util.Random;

public class CitySim9005 {
	public static void main(String[] args){
		// Initialize Local Variables
		long seed;
		Random generator;
		int num;
		
		// BEGIN: Check argument for if there is only one integer argument
		if(args.length > 1 || args.length < 1){
			System.out.println("Please enter one integer argument.");
			return;
		}
		
		try{
			//if the argument is an integer, create the seed
			seed = Long.parseLong(args[0]);	
		}catch(IllegalArgumentException e){
			System.out.println("Please enter one integer argument.");
			return;
		}
		// END CHECK ARGUMENT
		
		// 
		generator = new Random(seed);
		
		// Loop for each driver (1-5), create a path
		for(int i = 1; i < 6; i++){
			num = generator.nextInt(4);//driver's starting path
			Driver currentDriver = new Driver(i, num);
			
			while(currentDriver.checkOutside() == false){
				num = generator.nextInt(2);
				currentDriver.drive(num);
				
				if(currentDriver.checkOutside() == true){
					currentDriver.printOutside();
				}else{
					currentDriver.printRoute();
				}
			}
			System.out.println("-----");
		}
		
	}
}
