/*
 * @author Kevin Madison
 * CS 1632 Quality Assurance
 * Deliverable 2
 * Instructor: Bill Laboon
*/

public class Path
{
	Location to;
	String pathName;

	public Path(String setPathName, Location setTo)
	{
		pathName = setPathName;
		to = setTo;

	}
	public String getPathName()
	{
		return pathName;
	}
	
	//return the next location
	public Location getTo(){
		return to;
	}
}