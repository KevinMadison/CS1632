import java.util.Random;

public class CitySim9005 {
	public static void main(String[] args){
		// Initialize Local Variables
		long seed;
		Random generator;
		int num, num2;
		
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
			num = generator.nextInt(12);
			num2 = generator.nextInt(12);
			Driver currentDriver = new Driver(num, num2);
			
			while(currentDriver.done == false){
				System.out.println("Driver "+ i +" heading from "+ currentDriver.from +" to "+ currentDriver.to +" via "+ currentDriver.onPath);
				num = generator.nextInt(12);
				currentDriver.nextPath(num);
			}
			System.out.println("Driver "+ i +" heading from "+ currentDriver.from +" to Outside City via "+ currentDriver.onPath);
			System.out.println("Driver "+ i +" has gone to "+currentDriver.to +"!");
			
			System.out.println("-----");
		}
		
	}
	
	public String printTravel(int driver, String from, String to, String street){
		String returnPath = "Driver"+ driver +"heading from "+ from +"to"+ to +" via "+street;
		System.out.println(returnPath);
		return returnPath;
	}
	
}
