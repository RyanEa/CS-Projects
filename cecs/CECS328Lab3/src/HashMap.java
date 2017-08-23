import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashMap<KeyType, ValueType> {
   private class Node {
      public KeyType mKey;
      public ValueType mValue;
      public Node mNext;
      public void nodeSet(KeyType sKey,ValueType sValue){
    	  mKey=sKey;
    	  mValue=sValue;
      }
   }
   
   private Node[] mTable;
   private int mCount;
   
   public HashMap(int tableSize) {
      mTable = (Node[])Array.newInstance(Node.class, tableSize); 
   }

   public void insert(KeyType key, ValueType value) {
	   int hk= key.hashCode()%mTable.length;
	   hk=Math.abs(hk);
	   Node temp= new Node();
	   temp.nodeSet(key, value);
	   Node traverse;

	   if(mTable[hk] == null){
		   mTable[hk] = temp; 
		   mCount++;
		   return;
	   }
	   else{
		   traverse=mTable[hk];
		   while(traverse.mNext!= null || traverse.mKey.equals(key)){
		   if(traverse.mKey.equals(key)){
			   traverse.mValue=value;
			   return;
		   }
		   traverse=traverse.mNext;
	   }
		   if(temp.mKey.equals("Albert Pujols")){
			   System.out.println("HERE");
		   }
		   traverse.mNext=temp;
		   mCount++;
	   }
   }

   public ValueType find(KeyType key) throws keyNotFound {
	   int hk= key.hashCode()%mTable.length;
	   hk=Math.abs(hk);
	   
	   if(mTable[hk]==null){
		   throw new keyNotFound(key.toString());
	   }
	   Node iter=mTable[hk];
	   while(iter.mNext!=null || iter.mKey.equals(key)){
	   if(iter.mKey.equals(key)){
		   return iter.mValue;
	   }
	   	iter=iter.mNext;
	   	}
      throw new keyNotFound(key.toString());
   }
   
   public void remove(KeyType key) {
	   int hk= key.hashCode() % mTable.length;
	   hk=Math.abs(hk);
	   if(mTable[hk] == null)
		   return;
	   if(mTable[hk].mKey.equals(key)){
		   mTable[hk]=mTable[hk].mNext;
		   mCount--;
		   return;
	   }
	   Node prev=mTable[hk];
	   Node iter=mTable[hk];
	   while(iter.mNext!=null || iter.mKey.equals(key)){
		   if(iter.mKey.equals(key)){
			   iter=iter.mNext;
			   prev.mNext=iter;
			   mCount--;
			   return;
		   }
		   prev=iter;
		   iter=iter.mNext;
	   }
   }
   public boolean containsKey(KeyType key){
	   try{
		   if(find(key)!=null)
			   return true;
	   }
	   catch (keyNotFound e){
	   }
	   return false;
   }
   public ArrayList<KeyType> keySet(){
	   ArrayList<KeyType> keysets=new ArrayList<KeyType>();
	   for(int i=0; i<mTable.length; i++){
		   Node iter=mTable[i];
		   while(iter != null){
			   keysets.add(iter.mKey);
			   iter=iter.mNext;
		   }
	   }
	   return keysets;
   }
   public int count(){
	   return mCount;
   }
}