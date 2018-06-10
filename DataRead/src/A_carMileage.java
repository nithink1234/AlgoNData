/*
 *  A group of friends are tracking the miles per gallon for each of their cars. 
 *  
 *  Each time one of them fills up their gas tank, they record the following in a file:
		His or her name
		The type of car they drove
		How many miles driven since they last filled up
		How many gallons purchased at this fill up
		Date of the fill
	
	Their data is formatted as a (csv) file with the following format for each row
		(#person,carName,milesDriven,gallonsFilled,fillupDate)
	Miles are recorded as floating-point numbers and gallons as integers.

	Please create a program that allows members of this group to determine the miles per gallon (MPG) of each of their cars during a specific time range. 
		Note: person may have more than one so a time range query might need to output data for one or more cars. 
			  MPG is calculated as (total miles traveled during time period)/ (total gallons filled during time period.
			  The dates you receive in the query should be treated inclusively. 
		A skeleton class will be provided; your job will be to complete the program.
	
	The principal function for querying MPG is of the form (the exact name, data types, etc., can be learned by inspecting the "solution" class in the skeleton code):
		GetRangeMPG(PersonName, StartDate, EndDate)
		Returns list of objects containing (CarName, MPG)
		
 */

import java.util.*;
import java.io.*;
import java.text.*;

class Car{
	//public String PersonName ;
	//public String CarName;
	public double MilesDriven;
	public int Fuel;
	public Date Date;
}

class MPG {
	
	public String CarName;
	public Double MPG;
}

public class A_carMileage {

	
	
	public static void main(String[] args) {
		
		ArrayList<MPG> result = GetRangeMPG("nithin" , "5/15/2012" , "1/1/2017");
		
		for(int i=0; i<result.size(); i++) {
			
			System.out.println(result.get(i).CarName + " : " + result.get(i).MPG);
		}
	}
	
	public static ArrayList<MPG> GetRangeMPG(String PersonName, String StartDate, String EndDate) {
		
		HashMap<String, ArrayList<Car>> carmap = new HashMap<String,ArrayList<Car>>();
		ArrayList<MPG> result = new ArrayList<MPG>();
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		
		try {
			String path = "C:/Users/Nithin/eclipse-workspace/DataRead/src/Book1.csv";
			Scanner scan = new Scanner(new File(path));
			
			// for column names 
			scan.nextLine();
			
			while(scan.hasNextLine()) {
				
				// Split the lines by comma 
				String[] values = scan.nextLine().trim().split(",");
				
				
				if(values.length == 5) {
					
					Date startdate = sdf.parse(StartDate);
					Date enddate = sdf.parse(EndDate);
					Date recordDate = sdf.parse(values[4].trim());
					
					// Select the records only if it matches the given name and the record is valid. 
					if(values[0].trim().equalsIgnoreCase(PersonName) && recordDate.after(startdate) && recordDate.before(enddate)) {
						
						// Use the cartype as the key and store the records as an object 
						String cartype = values[1].trim().toLowerCase();
						
						
						Car newrecord = new Car();
						newrecord.MilesDriven = Double.parseDouble(values[2].trim());
						newrecord.Fuel = Integer.parseInt(values[3].trim());
						newrecord.Date = recordDate;
						
						System.out.println(cartype + " " + newrecord.Date);
						
						// If this cartype is already there , then just add it to the record list
						if(carmap.containsKey(cartype)) {
							carmap.get(cartype).add(newrecord);
						}
						
						// Create a new entry
						else {
							ArrayList<Car> recordList = new ArrayList<Car>();
							recordList.add(newrecord);
							carmap.put(cartype, recordList);
						}
						
					}
					
				}
				
			}
			
			scan.close();
			
			for(String key : carmap.keySet()) {
				
				ArrayList<Car> cartype = carmap.get(key);
				MPG newcartype = new MPG();
				double prevmiles  = cartype.get(0).MilesDriven;
				double totalmiles = 0;
				int totalfuel = 0;
				
				if(cartype.size() >= 2) {
					
					for(int i=1; i<cartype.size(); i++) {
						
						totalmiles = totalmiles + (cartype.get(i).MilesDriven - prevmiles);
						totalfuel += cartype.get(i-1).Fuel;
					
					}
				}
				
				
				newcartype.CarName = key;
				newcartype.MPG =  totalmiles/totalfuel;
				result.add(newcartype);
			}
			
		}
		
		catch (Exception e){
			
			System.out.println(e.getMessage());
		}

		return result;
	}
	

}
