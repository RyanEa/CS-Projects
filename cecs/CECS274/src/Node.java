public class Node
{
private String element; // list deals with String
private Node next; // self-referential
public Node(String element, Node next) {
this.element = element;
this.next = next;
}
public String getElement() {
return element;
}
public Node getNext() {
return next;
}
public void setElement(String newElement) {
element = newElement;
}
public void setNext(Node newNext) {
next = newNext;
}
public void add(Node add)
{
	Node temp=next;//creates a temporary node to cycle through
	while(temp.getNext()!=null)
	{
		temp.setNext(temp.getNext());//sets to next node
	}
	temp.setNext(add);
}
}