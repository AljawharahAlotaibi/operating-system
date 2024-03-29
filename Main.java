import java.util.Scanner;

public class Main {

    //	static PCB[] Q1 ;
//	static PCB[] Q2 ;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of processes (P)
        System.out.print("Enter the number of processes (P): ");
        int numProcesses = scanner.nextInt();

        // Create arrays to represent Q1 and Q2
        PCB[] Q1 = new PCB[numProcesses];
        PCB[] Q2 = new PCB[numProcesses];

         int answer = 0;
         do {
 			System.out.println("Chosse form the following menu:");
 			System.out.println("1) Enter process’ information. ");
 			System.out.println("2) Report detailed information about each process and different scheduling criteria. ");
 			System.out.println("3) Exit the program.");
 
 			answer = scanner.nextInt();

 			switch (answer) {
 		
 			case 1:
 				
 				break;
 			case 2:
 				break;
 			case 3:
 				System.out.println("Exiting.. ");
 				break;

 			default:
 				System.out.println("Invalid input, try again");
 			}
 		} while (answer != 3);
 	}

}
