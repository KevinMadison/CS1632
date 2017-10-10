
public class Driver {
	public int driverNumber;
	public City currentCity;
	public String from, to, path;
	public Driver(int setDriverNumber, int randomNumber){
		driverNumber = setDriverNumber;
		currentCity = new City();
		currentCity.setCurrentLocation(randomNumber);//passing in a number 0-3
	}
	
	public int drive(int randomNumber){
		from = currentCity.currentLocation.getName();
		path = currentCity.moveLocation(randomNumber);//will return 1 if successful
		to = currentCity.currentLocation.getName();
		return 1;
	}
	
	public boolean checkOutside(){
		if(to == "Cleveland" || to == "Philadelphia"){
			return true;
		}else{
			return false;
		}
	}
	
	public void printRoute(){
		System.out.println("Driver "+ driverNumber +" heading from "+ from +" to "+ to +" via "+ path);
	}
	
	public void printOutside(){
		System.out.println("Driver "+ driverNumber +" heading from "+ from +" to Outside City via "+ path);
		System.out.println("Driver "+ driverNumber +" has gone to "+ to +"!");
	}
}
