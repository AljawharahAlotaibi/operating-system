import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

static PCB[] Q1 ;
static PCB[] Q2 ;
    
    public static void main(String[] args)  throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of processes (P)
        System.out.print("Enter the number of processes (P): ");
        int numProcesses = scanner.nextInt();

        // Create arrays to represent Q1 and Q2
         Q1 = new PCB[numProcesses];
         Q2 = new PCB[numProcesses];

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
                 for (int i = 0; i < numProcesses; i++) {
					System.out.printf("%-3d", i + 1);
					Q1[i].StatusDetail();
				}
 				WriteReport();
 				break;
 			case 3:
 				System.out.println("Exiting.. ");
 				break;

 			default:
 				System.out.println("Invalid input, try again");
 			}
 		} while (answer != 3);
 	}
public static void WriteReport() throws IOException {
 
			BufferedWriter outputfile = new BufferedWriter(new FileWriter("Report.txt"));
			for (int i = 0; i < Q1.length; i++) {
				outputfile.write(" | The processID " +Q1[i].getProcessID()  );
				outputfile.write(" | The priority : " +Q1[i].getPriority());
				outputfile.write(" | The arrivalTime : " + Q1[i].getArrivalTime());
				outputfile.write(" | The cpuBurstTime :" + Q1[i].getCpuBurstTime());
				outputfile.write(" | Starting time: " + Q1[i].getStartTime() );
				outputfile.write(" | termination time  " + Q1[i].getTerminationTime() );
				outputfile.write(" | turnaround time  " + Q1[i].getTurnaroundTime());
				outputfile.write(" | waiting time  " + Q1[i].getWaitingTime() );
				outputfile.write(" | response time  " + Q1[i].getResponseTime() );
				
				outputfile.write(" ");
			}
			//outputfile.flush();
			outputfile.close();
		}
}
