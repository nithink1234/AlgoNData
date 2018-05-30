/*
 * Explation of How to use a Custom Comparator to sort custom objects  
 */

import java.util.*;
class Student {
	String firstName;
	String lastName;
	int rollNo;
	
	public Student(String firstName, String lastName, int rollNo ){
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNo = rollNo;
	}
}

class rollSort implements Comparator<Student> {
	
	// Needs to be implemented because it is defined in Comparator interface 
	
	// if the Comparator is defined with raw type.. i.e its not declared of type student in our case
	// the abstract compare menthod will have type Object i.e public int compare(Object o1, Object o2)
	public int compare(Student std1, Student std2) {
		
		// Converting objects to our type so that we can do custom comparisions in case when comparator is implemented undefined. 
		/*Student std1 = (Student) o1;
		Student std2 = (Student) o2;
		*/
		
		// Has to return 1 if its greater , -1 if its lesser, 0 if its same. 
		if(std2.rollNo > std1.rollNo)
			return 1;
		else if(std2.rollNo < std1.rollNo)
			return -1;
		
		return 0;
	}
}

class firstNameSort implements Comparator<Student>{
	
	public int compare(Student std1, Student std2) {
		
		// CompareTo is a String method .. it compares Strings Lexicographically
		// Returns -1 if Std1 comes before Std2  vice versa .. 0 if its same
		return std1.firstName.compareTo(std2.firstName);
	}
}


public class AA_comparator {
	
	public static void main (String[] args) {
		
		// Creating a array containing Student objects
		Student[] classofstudents = new Student[5];
		
		// Creating a student with values and filling for each array. 
		classofstudents[0] = new Student("Nithin" , "Kumar" , 6);
		classofstudents[1] = new Student("Manoj" , "Kumar" , 3);
		classofstudents[2] = new Student("Nithin" , "Reddy" , 8);
		classofstudents[3] = new Student("Sridhar" , "Sd" , 5);
		classofstudents[4] = new Student("Manoj" , "Williams" , 5);
		
		
		rollSort sortingbyroll = new rollSort();
		
		firstNameSort sortingbyfirstname = new firstNameSort();
		
		Arrays.sort(classofstudents, sortingbyfirstname);
		
		
		for(int i=0; i<classofstudents.length; i++) {
			System.out.println(classofstudents[i].firstName + " " + classofstudents[i].lastName + " : " + classofstudents[i].rollNo);
		}
	}
}

