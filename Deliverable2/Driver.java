/**
 * 
 * @author Kevin Madison
 *
 *  CITY MAP:
 *                 ---> [Hotel] ----> [Diner] ----> Fourth Ave. (to Philadelphia)
 *                       ^  |          ^  |
 *               Bill St.|  |          |  | Phil St.
 *                       |  V          |  V
 * (to Cleveland) <--- [Library] <-- [Coffee] <--- Fifth Ave.
 */

public class Driver {
	//CITY LOCATIONS
	private final String HOTEL = "Hotel";
	private final String DINER = "Diner";
	private final String LIBRARY = "Library";
	private final String COFFEE = "Coffee";
	
	//OUSIDE LOCATIONS
	private final String CLEVELAND = "Cleveland";
	private final String PHILLY = "Philadelphia";
	
	//TWO WAY STREETS
	private final String BILL_ST = "Bill St.";
	private final String PHIL_ST = "Phil St.";
	
	//AVENUES
	private final String FOURTH_AVE = "Fourth Ave.";
	private final String FIFTH_AVE = "Fifth Ave.";
	
	//DRIVER'S CURRENT DATA
	public String from;
	public String to;
	public String onPath;
	public boolean done;
	public boolean start;
	
	public Driver(int num, int startingLocation){
		from = startingLocation(startingLocation);
		start = true;
		nextPath(num);
		 
	}
	
	public String startingLocation(int randomNumber){
		String startingLocation;
		
		if(randomNumber < 3){
			startingLocation = HOTEL;
		}else if(randomNumber < 6){
			startingLocation = DINER;
		}else if (randomNumber < 9){
			startingLocation = LIBRARY;
		}else{
			startingLocation = COFFEE;
		}
		
		return startingLocation;
	}
	
	public String nextPath(int randomNumber){
		if(done == true){
			return from;
		}
		
		if(start == false){
			from = to;
		}
		
		switch(from){
			case "Hotel":
				if(randomNumber < 6){
					onPath = FOURTH_AVE;
					to = DINER;
				}else{
					onPath = BILL_ST;
					to = LIBRARY;
				}
				break;
			case "Diner":
				if(randomNumber < 6){
					onPath = FOURTH_AVE;
					to = PHILLY;
					done = true;
				}else{
					onPath = PHIL_ST;
					to = COFFEE;
				}				
				break;
			case "Library":
				if(randomNumber < 6){
					onPath = FIFTH_AVE;
					to = CLEVELAND;
					done = true;
				}else{
					onPath = BILL_ST;
					to = HOTEL;
				}
				break;
			default://COFFEE SHOP
				if(randomNumber < 6){
					onPath = FIFTH_AVE;
					to = LIBRARY;
				}else{
					onPath = PHIL_ST;
					to = DINER;
				}
				break;
			
		}
		
		if(start == true){
			start = false;
		}
		return onPath;
	}
}
