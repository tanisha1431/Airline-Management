//package assignment_C;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Payment implements Serializable{

	public static Map<String,Integer> salary = new HashMap<>();
	transient Scanner sc = new Scanner(System.in);
	CrewMembers c = new CrewMembers();
	Payment()
	{
		addSalary();
	}
	void addSalary()
	{
		salary.put("pilot",365000);
		salary.put("air hostess",43000);
		salary.put("medical officer",65000);
		salary.put("technicians",500);
		salary.put("security officer",400);
		salary.put("customer service agent",500);
		salary.put("flight dispachers",400);
		salary.put("cleaners",300);	
	}
	
	int calcDeductions()
	{ 
		int sum = 0;
		System.out.println("Enter points from (0 - 10) for the given employee which will help in calculating the Performance");
		System.out.println("For Regularity \t");
		sum+=sc.nextInt();
		System.out.println("For Honesty \t");
		sum+=sc.nextInt();
		System.out.println("For Behaviour \t");
		sum+=sc.nextInt();
		System.out.println("For Feedback from customers \t");
		sum+=sc.nextInt();
		
		
		
		if(sum>30)
			return 0;
		else if(sum >25)
			return 1;
		else if(sum > 20)
			return 2;
		else
			return 5;
	}
	
	
	void paySalary()
	{
		int salary_given;
		System.out.println("Enter type of Employee you want to pay");
		System.out.println("Enter 1 if Employee is a crew member else enter any other number if Employee is Supporting Staff");
		
		int x = sc.nextInt();
		if(x==1)
		{
			 try {
		            FileInputStream fi = new FileInputStream("CrewMembers.txt");
		            ObjectInputStream oi = new ObjectInputStream(fi);

		          
		            List<CrewMembers> pr1 = (List<CrewMembers>) oi.readObject();
		            
		            System.out.println("Our Crew members are ");
		            for(int i = 0;i<pr1.size();i++)
		            {
		            	System.out.println((i+1)+" -> Name : "+pr1.get(i).name+"        ID : "+pr1.get(i).ID);
		            }
		          
					System.out.println("Enter the index of Crew member you want to pay ");
					int in = sc.nextInt();
					salary_given = salary.get(pr1.get(in-1).CrewType);
					
					int dedu = calcDeductions();
					
					int final_salary;					
					
					final_salary = salary_given - (salary_given*(dedu)/100) - (salary_given*(5)/100) - (salary_given*(3)/100) - (salary_given*(1)/100);
					
					pr1.get(in-1).salary_record.add(final_salary);
					
					pr1.get(in-1).printCrewPaymentSlip(salary.get(pr1.get(in-1).CrewType), final_salary);
					
					oi.close();
		            fi.close();
		            
		            FileOutputStream f = new FileOutputStream("CrewMembers.txt");
		            ObjectOutputStream o = new ObjectOutputStream(f);

		       
		            o.writeObject(pr1);
		           

		            o.close();
		            f.close();

		            

		        } catch (FileNotFoundException e) {
		            System.out.println("File not found");
		        } catch (IOException e) {
		            System.out.println("Error initializing stream");
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
			
		}
		else
		{
			try
			{
				FileInputStream fi = new FileInputStream("SupMembers.txt");
	            ObjectInputStream oi = new ObjectInputStream(fi);

	            // Read objects
	            List<Supporting_Staf> pr1 = (List<Supporting_Staf>) oi.readObject();
	            
	            System.out.println("Our Supporting staf is ");
	            for(int i = 0;i<pr1.size();i++)
	            {
	            	System.out.println((i+1)+" -> Name : "+pr1.get(i).name+"        ID : "+pr1.get(i).ID);
	            }
	          
				System.out.println("Enter the index of Supporting staff member you want to pay ");
				int in = sc.nextInt();
				
				salary_given = salary.get(pr1.get(in-1).worktype)*pr1.get(in-1).Working_hours;
				
				int dedu = calcDeductions();
				int final_salary;
				
				try
				{
					final_salary = salary_given - (salary_given*(dedu)/100) - 2*(salary_given*(1)/100);
				}
				catch(ArithmeticException e)
				{
					final_salary = salary_given - 2*(salary_given*(1)/100);
				}
				if(pr1.get(in-1).Shift_Type.equals("night"))
				{
					final_salary += (final_salary*10/100);
				}
				pr1.get(in-1).salary_record.add(final_salary);
				
				pr1.get(in-1).printSupportingPaySlip(salary.get(pr1.get(in-1).worktype),final_salary);
				
				oi.close();
	            fi.close();
	            
	            FileOutputStream f = new FileOutputStream("SupMembers.txt");
	            ObjectOutputStream o = new ObjectOutputStream(f);

	            // Write objects to file
	            o.writeObject(pr1);
	           

	            o.close();
	            f.close();
				
			}
			catch (FileNotFoundException e) {
	            System.out.println("File not found");
	        } catch (IOException e) {
	            System.out.println("Error initializing stream");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		}
	}
	
}