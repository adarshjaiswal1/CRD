import java.io.Serializable;
public class Friend implements Serializable
{
   private String name;
   private int age;
   private Hobby[] hobbies;
   
   public Friend(String name, int age, Hobby[] hobbies)
   {
	   this.name = name;
	   this.age = age;
	   this.hobbies = hobbies;
   }
   
   public String getName()
   {
	   return name;
   }
   public int getAge()
   {
	   return age;
   }
   public Hobby[] getHobbies()
   {
	   return hobbies;
   }
}
