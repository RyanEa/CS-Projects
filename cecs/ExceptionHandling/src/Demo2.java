// Exercise 11.17 Solution: Demo2.java
// Catching Exception exception.
import java.io.IOException;
 
public class Demo2
{
   // execute application
   public static void main(String[] args)
   {
      try
      {
         // throw Exception A
       
      }
      catch (Exception exception)
      {
         // print stack trace      
      }
 
      try
      {
         // throw Exception B
      }
      catch (Exception exception)
      {
         // print stack trace
      }
 
      try
      {
         // throw null pointer exception
      }
      catch (Exception exception)
      {
         //print stack trace      }
 
      try
      {
         // throw IO Exception      
      }
      catch (Exception exception)
      {
         // print stack trace
      }
   }
} // end class Demo2
}

//subclass of Exception
class ExceptionA extends Exception
{
	System.out.println("ERRRORA");
}

//subclass of ExceptionA
class ExceptionB extends ExceptionA
{
// empty class body
}
class ExceptionC extends ExceptionB{
	
}


   