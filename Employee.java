//package assignment_C;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;



public class Employee implements Serializable{

	transient Scanner sc = new Scanner(System.in);
	
	Employee()
	{

	}
	
		String name;
		String DOB;
		int age;
		String gender;
		String ID;
		 
	
		String DOJ ;
	
	
		String acc_no;
		String CIF_no;
		
		
	
	
		String contact_no;
		String email;
		int experience;
		List<String> prev_work = new ArrayList<>();
		String qualification;	
		String skill;
		List<String> languages_known = new ArrayList<>();
		
		
		
	List<Integer> salary_record = new ArrayList<>();
	
	void addEmployee()
	{
		System.out.println("Enter name of Employee");
		this.name = sc.nextLine();
		System.out.println("Enter DOB in dd/mm/yy");
		this.DOB = sc.next();
		System.out.println("Enter age");
		this.age = sc.nextInt();
		System.out.println("Enter gender");
		this.gender = sc.next();
		System.out.println("Enter ID");
		this.ID = sc.next();
		
		System.out.println("Date of Joining in dd/mm/yy");
		this.DOJ = sc.next();
		
		System.out.println("Enter Account Number");
		this.acc_no = sc.next();
		System.out.println("Enter CIF Number");
		this.CIF_no = sc.next();
		
		
		System.out.println("Enter Contact number");
		contact_no = sc.next();
		System.out.println("Enter email address");
		email = sc.next();
		System.out.println("Enter 1 and type places where have worked previously and enter -1 after entering sucessfully");
		int x = sc.nextInt();
		while(x!=-1)
		{	
			this.prev_work.add(sc.next());
			x = sc.nextInt();
		}
		System.out.println("Enter Qualification");
		this.qualification = sc.next();
		System.out.println("Enter years of experience");
		this.experience = sc.nextInt();
		System.out.println("Enter Skills");
		this.skill = sc.nextLine();
		System.out.println("Enter 1 and type languages known and enter -1 after entering sucessfully");
		x = sc.nextInt();
		while(x!=-1)
		{	
			this.languages_known.add(sc.next());
			x = sc.nextInt();
		}
		System.out.println("Last 3 salaries");
		for(int i = 0;i<3;i++)
			this.salary_record.add(sc.nextInt());
		
	}
	
	void employeeDetails()
	{
		System.out.println("                     *** Personal Details *** \n");
		System.out.println("                 Name                               ->" + name);
		System.out.println("                 Date Of Birth                      -> "+DOB);
		System.out.println("                 Age is                             -> "+age);
		System.out.println("                 Gender is                          -> "+gender);
		System.out.println("                 Identity Number                    -> "+ ID);
		System.out.println();
		
		
		System.out.println("                 Date of Joining -> "+DOJ);
		System.out.println();
		
		System.out.println("                      *** Account Details ***\n");
		System.out.println("                 Account Number                     -> "+acc_no);
		System.out.println("                 CIF Number of Bank                 -> "+CIF_no);
		System.out.println();
		System.out.println("                         *** Resume ***\n");
		System.out.println("                Contact Number                      -> "+contact_no);
		System.out.println("                Email Address                       -> "+email);
		System.out.print("                Places where have worked previously -> ");
		for(String i : prev_work)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("                Qualificantions                     -> "+qualification);
		System.out.println("                Other Skills                        -> "+skill);
		System.out.print("                Languages Known are                 -> ");
		for(String i : languages_known)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	void emoloyeePlaymentSlip()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	   
		
		System.out.println("============================================================================================");
		System.out.println("                                                        Contact No : 1800674930");
		System.out.println("                                                        Email      : airindia.gmail.com");
		System.out.println("                                                        Website    : www.airindia.com");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("                                        AIR INDIA                                          ");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("============================================================================================\n");
		 System.out.println("                                                       Date       : "+formatter.format(date));  
		System.out.println("============================================================================================");
		System.out.println("                                       PAYMENT SLIP                                         ");
		System.out.println("============================================================================================");
		
		System.out.println("Employee ID    : "+ID);
		System.out.println("Name           : "+name);
		System.out.println("Email          : "+email);
		System.out.println("Account no.    : "+acc_no);
		System.out.println("CIF no.        : "+CIF_no);
		
		System.out.println("                                               Salary of Last 3 months    ");
		System.out.print("                                            "+salary_record.get(salary_record.size()-3)+"/-   ||  "+salary_record.get(salary_record.size()-2)+"/-    ||   "+salary_record.get(salary_record.size()-1)+" /- ");
		
		System.out.println("\n\n");
	}
}
