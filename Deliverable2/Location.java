
public class Location
{
	String location;
	Path street, avenue;
	int num;

	public Location(String setName, int setNumber){
		location = setName;
		num = setNumber;
	}
	
	public int addStreetPath(Path setPath){
		street = setPath;
		return 1;
	}
	
	public int addAvenuePath(Path setPath){
		avenue = setPath;
		return 1;
	}
	
	public String getName(){
		return location;
	}
	

	public int getLocNum(){
		return num;
	}
	
	public void setLoc(String setLocation){
		location = setLocation;
	}
}