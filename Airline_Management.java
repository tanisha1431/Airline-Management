//package assignment_C;

import java.util.Scanner;


 
public class Airline_Management {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Payment p = new Payment();
		CrewMembers c = new CrewMembers();	
		Supporting_Staf  s = new Supporting_Staf();
		
		while(true)
		{
			System.out.println("Enter :");
			System.out.println("1 -> For Details of our Crew Members");
			System.out.println("2 -> For Details of our Supporting Staf(Ground Staff)");
			System.out.println("3 -> For adding new Crew Member");
			System.out.println("4 -> For adding new Supporting Staff member");
			System.out.println("5 -> For Making payments");
			System.out.println("6 -> To Exit");
			int x = sc.nextInt();
			
			if(x==1)
			{
				c.displayCrew();;
			}
			else if(x==2)
			{
				s.displaySupportingStaf();
			}
			else if(x==3)
			{
				c.addCrewmember();
			}
			else if(x==4)
			{
				s.addSupportingStaf();
			}
			else if(x==5)
			{
				p.paySalary();
			}
			else if(x==6)
			{
				System.out.println("Thank You");
				break;
			}
			else
			{
				System.out.println("!!!! Enter valid integer !!!!");
			}
		}

	}

}
