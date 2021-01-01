import java.io.Serializable;

public class Hobby implements Serializable
{
 
     private String name;
     private String location;
     
     public Hobby(String name, String location)
     {
    	 this.name = name;
    	 this.location = location;
     }
     
     public String getName()
     {
    	 return name;
     }
     
     public String getLocation()
     {
    	 return location;
     }
	
}
