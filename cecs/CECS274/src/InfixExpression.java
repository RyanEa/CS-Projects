
public class InfixExpression extends StringStack {
	
	public static boolean compare(String a, String b){
		//You also want to fix the comparisons between ( and any operator to return true
		if((a == "+" || a == "-") && (b == "*" || b == "/"))
			return true;
		else if(a == "(") {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		String[] infix = {"(","3","+","5",")","*","5", "+", "5" };
		String[] postfix = convertToPostfix(infix);
		for(int i = 0; i < postfix.length; i++){
			System.out.print(postfix[i]);
		}
	}
	
	public static String[] convertToPostfix(String[] infix){
		int j = 0;
		String[] Postfix = new String[infix.length];
		StringStack stack = new StringStack(infix.length);
		
		for( int i = 0; i < infix.length; i++){
			if(infix[i].matches("[(+-/*)]")){
				if (stack.length() == 0 ){
					stack.push(infix[i]);
				}
				else {
					if( compare(stack.peek(), infix[i])){
						stack.push(infix[i]);
					}
					else if(infix[i].matches("[)]")){
						while(!stack.peek().matches("[(]")){
							if(!stack.peek().matches("[(]")){
								System.out.println(Postfix[j]+"I'M NOT ("+j);
								Postfix[j] = stack.pop();
								j++;
							}
						}
						stack.pop();
					}
					else {
						while(!compare(stack.peek(), infix[i])){ //While comparing is false keep popping
							System.out.println("I WASN'T ) i think. SIZE OF STACK->"+ stack.length());
							System.out.println("I AM 'Set array to top of stack and remove top of stack'"+stack.peek());
							Postfix[j] = stack.peek(); //Set array to top of stack and remove top of stack
							System.out.println("POOP POP");
							stack.pop();
							j++;								
							if(stack.length() == -1){//If the stack is empty, make the infix top and then break
								stack.push(infix[i]);
								break;			
						}
						}
					}	
				}
			}
			else {
				System.out.println("TOO GOOD TO BE AN OPERATOR HERE--->"+ infix[i]);
				Postfix[j] = infix[i];
				j++;
			}
		}
		while(stack.length() != 0){
			System.out.println("POPPERS");
			Postfix[j] = stack.pop();
			j++;
		}
		return Postfix;
	}	
}
