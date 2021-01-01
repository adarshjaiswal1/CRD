import java.util.*;
import java.io.*;
public class Main 
{
	
	ArrayList<Hobby> hobbies = new ArrayList<Hobby>();
	ArrayList<Friend> friends = new ArrayList<Friend>();
	
	Scanner sc = new Scanner(System.in);
	
	String myName = "Adarsh";	
	int myAge = 26;
	Hobby[] myHobbies = new Hobby[2];
	Friend[] myFriends = new Friend[2];
	
	
	public void createData()
	{
		inputHobbies();
		inputFriends();
		myHobbies[0] =  hobbies.get(1);
		myHobbies[1] =  hobbies.get(2);
		myFriends[0] = friends.get(0);
		myFriends[1] = friends.get(1);
	}
	
	private void inputHobbies()
	{
		hobbies.add(new Hobby("Coding", "Debugging"));
		hobbies.add(new Hobby("App Develoment", "Programming"));
		hobbies.add(new Hobby("Game Designing","Front-End Development"));
		hobbies.add(new Hobby("Problem Solving","Competetive Coding"));
		
		
	}
	
	private void inputFriends()
	{
		Hobby[] ashHobbies =  {hobbies.get(2)};
		friends.add(new Friend("Ash",20, ashHobbies));
		Hobby[] ajHobbies = {hobbies.get(0), hobbies.get(3)};
		friends.add(new Friend("A J", 20, ajHobbies));
		
	}
	
	public void saveData()
	{
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(myName);
		data.add(myAge);
		data.add(myHobbies);
		data.add(myFriends);
		
		try
		{
		   FileOutputStream fileout = new FileOutputStream("data.ser");
		   ObjectOutputStream out = new ObjectOutputStream(fileout);
		   out.writeObject(data);
		   out.close();
		   fileout.close();
		   System.out.print("Serialized data is save into data.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadData()
	{
		ArrayList<Object> deserialized = new ArrayList<Object>();
		
		try
		{
			FileInputStream filein = new FileInputStream("data.ser");
			ObjectInputStream in = new ObjectInputStream(filein);
		//	ArrayList<Object> readObject = (ArrayList<Object>)in.readObject(); 
		//	deserialized = readObject;
			deserialized = (ArrayList<Object>)in.readObject();
			in.close();
			filein.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return;
		}
		catch(ClassNotFoundException c)
		{
			c.printStackTrace();
			return;
		}
		
		String retrieveName = (String)deserialized.get(0);
		int retrieveAge = (int)deserialized.get(1);
		Hobby[] retrieveHobbies = (Hobby[])deserialized.get(2);
		Friend[] retrieveFriend = (Friend[])deserialized.get(3);
		
		
		System.out.print("My Name : " +retrieveName);
		System.out.print("Age : " +retrieveAge);
		
		for(int i=0;i<retrieveHobbies.length;i++)
		{
			System.out.print("Hobby " +retrieveHobbies[i].getName() + " at " +retrieveHobbies[i].getLocation());
		}
		for(int i=0;i<retrieveFriend.length;i++)
		{
			System.out.print("Friend :" +retrieveFriend[i].getName() + "aged" + retrieveFriend[i].getAge());
			for(int j=0;j<retrieveFriend[i].getHobbies().length;j++)
			{
				System.out.print("Friend's Hobby" + j + retrieveFriend[i].getHobbies()[j].getName() + " a t" +retrieveFriend[i].getHobbies()[j].getLocation());
			}
		}
		
	}
	

}
