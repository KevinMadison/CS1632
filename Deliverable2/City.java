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


public class City {
	
	public Location hotel, diner, library, coffee;//CITY LOCATIONS
	public Location cleveland, philly;//OUTSIDE LOCATIONS
	public Location currentLocation;//DRIVER'S CURRENT LOCATION
	
	public Path bill, phil; //CITY STREETS
	public Path fourth, fifth; //CITY AVENUES
	
	
	public City(){
		this.createLocations();
		this.createPaths();
	}
	
	//creates all inner and outer locations
	public int createLocations(){
		
		//Create City Locations
		hotel = new Location("Hotel", 0);
		diner = new Location("Diner", 1);
		library = new Location("Library", 2);
		coffee = new Location("Coffee", 3);
		//Create Outside City Locations
		cleveland = new Location("Cleveland", 4);
		philly = new Location("Philadelphia", 5);
		return 1;
	}
	
	//adds each path to all locations
	public int createPaths(){
		Path tempStreet, tempAvenue;
		
		//Add Paths from location: hotel
		tempStreet = new Path("Bill St.", library);
		tempAvenue = new Path ("Fourth Ave.", diner);
		hotel.addStreetPath(tempStreet);
		hotel.addAvenuePath(tempAvenue);
		
		//Add Paths from location: diner
		tempStreet = new Path("Phil St.", coffee);
		tempAvenue = new Path ("Fourth Ave.", philly);
		diner.addStreetPath(tempStreet);
		diner.addAvenuePath(tempAvenue);
		
		//Add Paths from location: library
		tempStreet = new Path("Bill St.", hotel);
		tempAvenue = new Path ("Fifth Ave.", cleveland);
		library.addStreetPath(tempStreet);
		library.addAvenuePath(tempAvenue);
		
		//Add Paths from location: coffee
		tempStreet = new Path("Phil St.", diner);
		tempAvenue = new Path ("Fifth Ave.", library);
		coffee.addStreetPath(tempStreet);
		coffee.addAvenuePath(tempAvenue);
	
		
		return 1;
	}
	
	//pass in a random integer 0-3, to determine the starting location
	public int setCurrentLocation(int i){
		switch(i){
			case 0:
				currentLocation = hotel;
				break;
			case 1:
				currentLocation = diner;
				break;
			case 2:
				currentLocation = library;
				break;
			case 3:
				currentLocation = coffee;
				break;
			default:
				return -1;
		}
		
		
		return 1;
	}
	
	//moves the currentLocation to the next location
	public String moveLocation(int i){
		String pathName;
		switch(i){
			case 0:
				pathName = currentLocation.street.getPathName();
				currentLocation = currentLocation.street.getTo();
				break;
			case 1:
				pathName = currentLocation.avenue.getPathName();
				currentLocation = currentLocation.avenue.getTo();
				break;
			default:
				return "";
		}
		
		
		return pathName;
	}
}
