//package assignment_C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Supporting_Staf extends Employee{

	transient Scanner sc = new Scanner(System.in);
	static List<Supporting_Staf> SS = new ArrayList<>();
	
	String worktype;
	
	String Shift_Type;
	String WorkPlace;
	int Working_hours;
	int break_st;
	int break_en;
	
	String position;
	
	void addSupportingStaf()
	{
		Supporting_Staf s = new Supporting_Staf();
		
		s.addEmployee();
		
		System.out.println("Enter worktype of Supporting staff");
		System.out.println("Enter 1 if the staff is a technecian , 2 if the staff is a security officer , 3 if the staff is a customer service agent , 4 if the staff is a flight dispatcher and 5 if staff is a cleanser ");
		int x = sc.nextInt();
		if(x==1)
			s.worktype = "technicians";
		else if(x==2)
			s.worktype = "security officer";
		else if(x==3)
			s.worktype = "customer service agent";
		else if(x==4)
			s.worktype = "flight dispachers";
		else
			s.worktype = "cleaners";
		
		System.out.println("Enter the type of Shift whether day or night");
		s.Shift_Type = sc.next();
		System.out.println("Enter the place where the person works");
		s.WorkPlace = sc.next();
		System.out.println("Enter the Shift hours");
		s.Working_hours = sc.nextInt();
		System.out.println("Enter starting time of break");
		s.break_st = sc.nextInt();
		System.out.println("Enter ending time of break");
		s.break_en = sc.nextInt();
		
		System.out.println("Enter the Designation of staff member");
		s.position = sc.next();
		
		try {
            FileInputStream fi = new FileInputStream("SupMembers.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            List<Supporting_Staf> pr1 = (List<Supporting_Staf>) oi.readObject();
            
            SS = pr1;

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		SS.add(s);
		
		try {
            
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("SupMembers.txt"));

            o.writeObject(SS);
            o.close();

  
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	void displaySupportingStaf()
	{
		 try {
	            FileInputStream fi = new FileInputStream("SupMembers.txt");
	            ObjectInputStream oi = new ObjectInputStream(fi);

	            // Read objects
	            List<Supporting_Staf> pr1 = (List<Supporting_Staf>) oi.readObject();
	            
	            System.out.println("Our Supporting staff is ");
	            for(int i = 0;i<pr1.size();i++)
	            {
	            	System.out.println((i+1)+" -> Name : "+pr1.get(i).name+"    ID : "+pr1.get(i).ID);
	            }
	            
	            System.out.println("Enter the index of the member whose details is to be shown");
	            int in = sc.nextInt();
	            pr1.get(in-1).supportingDetails();

	            oi.close();
	            fi.close();

	        } catch (FileNotFoundException e) {
	            System.out.println("File not found");
	        } catch (IOException e) {
	            System.out.println("Error initializing stream");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	void supportingDetails()
	{
		employeeDetails();
		System.out.println("                     *** Work Details *** \n");
		
		System.out.println("                  Mr/Mrs "+name+" works as a "+worktype);
		System.out.println("                  The Emplooyee is "+position+" among "+worktype);
		System.out.println();
		System.out.println("                   *** Work Shedule ***\n");
		System.out.println("                 The Type of Shift is "+Shift_Type+"-Shift");
		System.out.println("                 The Employee works at "+WorkPlace);
		System.out.println("                 The Employee works for "+Working_hours+" hours");
		System.out.println("                 The break starts at "+break_st+" and ends at "+break_en);
	}
	
	void printSupportingPaySlip(int b ,int final_s)
	{
		emoloyeePlaymentSlip();
		System.out.println("                                   Designation of Employee    : "+position);
		System.out.println("                                   Worked for                 : "+Working_hours+" hours");
		System.out.println("                                   Type of shift              : "+Shift_Type+" (10 % Bonus if Night shift)");

		System.out.println("============================================================================================\n");
		
		System.out.println("Base Salary         : "+b*Working_hours+" /-");
		System.out.println("National Insurance  : -"+(b*Working_hours*1/100)+"/-");
		System.out.println("Service Charge      : -"+(b*Working_hours*1/100)+"/-");
		System.out.println("--------------------------------------------------------------------------------------------");

		System.out.println("Total Earnings      :  "+(final_s)+"/-");
		System.out.println("============================================================================================\n");
	}
	
}