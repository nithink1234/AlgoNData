/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1: Input: "()"  Output: true  

Example 2: Input: "()[]{}" Output: true

Example 3: Input: "(]"  Output: false

Example 4: Input: "([)]"  Output: false

Example 5: Input: "{[]}"  Output: true
 */

import java.util.*;
public class CA_validParatheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValid("([)]"));
	}
	
	// Loop thru the String  and take a stack
	// Push when stack is empty 
	// if not check if its valid closing bracket .. pop only when it is 
	// if its neither then push it 
	
	//i.e u pop only when it valid .. else u keep pushing
	// in the end if stack is empty its all valid else its not. 
	static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray())
		{
			if(stack.isEmpty())
			{
				stack.push(c);
			}
			else
			{
				char peek = stack.peek();
				if(c == ')' && peek == '(')
				{
					stack.pop();
				}
				else if(c == ']' && peek == '[')
				{
					stack.pop();
				}
				else if(c == '}' && peek == '{')
				{
					stack.pop();
				}
				else
				{
					stack.push(c);
				}
			}
		}
		
		return stack.isEmpty();
	}
}
