   public class keyNotFound extends Exception
   {
     public keyNotFound(String one)
     {
       super("Key not found:"+ one);
     }
   }