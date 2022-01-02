//package assignment_C;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class CrewMembers extends Employee{

	transient Scanner sc = new Scanner(System.in);
	static List<CrewMembers> CM = new ArrayList<>();	
			
		String CrewType;	
	
		String Departing_port;
		String Arriving_port;
		List<String> Intermediate_ports = new ArrayList<>();	
		
		String start_time;
		String end_time;
		String break_time_st;
		String break_time_en;
	
	void addCrewmember()
	{
		CrewMembers c = new CrewMembers();
		c.addEmployee();
		
		System.out.println("Enter type of Crew");
		System.out.println("Enter 1 if type is pilot , 2 if type is air hostess and 3 if type is medical officer");
		int y = sc.nextInt();
		if(y==1)
			c.CrewType = "pilot";
		else if(y==2)
			c.CrewType = "air hostess";
		else
			c.CrewType = "medical officer";
		System.out.println("Enter Departing Port");
		c.Departing_port = sc.next();
		System.out.println("Enter Arriving Port");
		c.Arriving_port = sc.next();
		System.out.println("Enter 1 and type intermediate ports and enter -1 after sucessfully entering");
		int x = sc.nextInt();
		while(x!=-1)
		{	
			c.Intermediate_ports.add(sc.next());
			x = sc.nextInt();
		}
		
		System.out.println("Enter Start time of duty");
		c.start_time = sc.next();
		System.out.println("Enter end time of duty");
		c.end_time = sc.next();
		System.out.println("Enter starting of break hours ");
		c.break_time_st = sc.next();
		System.out.println("Enter end of break hours ");
		c.break_time_en = sc.next();
		try {
            FileInputStream fi = new FileInputStream("CrewMembers.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            List<CrewMembers> pr1 = (List<CrewMembers>) oi.readObject();
            
            CM = pr1;
            
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		CM.add(c);
		try {
            
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("CrewMembers.txt"));

            o.writeObject(CM);
            o.close();

  
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	void displayCrew()
	{
		 try {
	            FileInputStream fi = new FileInputStream("CrewMembers.txt");
	            ObjectInputStream oi = new ObjectInputStream(fi);

	            // Read objects
	            List<CrewMembers> pr1 = (List<CrewMembers>) oi.readObject();
	            
	            System.out.println("Our Crew members are ");
	            for(int i = 0;i<pr1.size();i++)
	            {
	            	System.out.println((i+1)+" -> Name : "+pr1.get(i).name+"    ID : "+pr1.get(i).ID);
	            }
	            
	            System.out.println("Enter the index of the member whose details is to be shown");
	            int in = sc.nextInt();
	            pr1.get(in-1).crewDetails();

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
	
	void crewDetails()
	{
		employeeDetails();
		
		System.out.println("                     *** Work Details *** \n");
		
		System.out.println("                 Mr/Mrs "+name+" works as a "+CrewType);
		System.out.println();
		
		System.out.println("                    *** Route Details ***\n");

		System.out.println("                The Departing Port is               ->"+Departing_port);
		System.out.println("                The Arriving Port is                -> "+Arriving_port);
		System.out.print("                All Inermediate Ports are           -> ");
		for(String i : Intermediate_ports)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n");
		
		System.out.println("                   *** Work Shedule ***\n");
		System.out.println("                Duty starts at "+start_time+" A.M.");
		System.out.println("                Break hours are from "+break_time_st+" P.M. to "+break_time_en+" P.M.");
		System.out.println("                Duty ends at "+end_time+" P.M");
	}
	
	void printCrewPaymentSlip(int b ,int final_s)
	{
		emoloyeePlaymentSlip();
		System.out.println("                                            Designation    : "+CrewType);
		System.out.println("============================================================================================\n");

		System.out.println("Base salary         : "+b+"/-");
		System.out.println("Loan Reapayment     : -"+(b*5/100)+"/-");
		System.out.println("National Insurance  : -"+(b*3/100)+"/-");
		System.out.println("Service Charge      : -"+(b*1/100)+"/-");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Total Earnings      :  "+final_s+"/-");
		System.out.println("============================================================================================\n");
	}
}