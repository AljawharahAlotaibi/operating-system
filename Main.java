import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

static PCB[] Q1 ;
static PCB[] Q2 ;
static int currentTime; 
public static void main(String[] args)  throws IOException {
    Scanner scanner = new Scanner(System.in);

    int numProcesses =0 ;
    do {
        System.out.print("Enter the number of processes (P): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            scanner.next(); // Consume the invalid input
        }
        numProcesses = scanner.nextInt();
        if (numProcesses <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        }
    } while (numProcesses <= 0);

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
           
                for (int i = 0; i < numProcesses; i++) {
                    String pid = "P" + (i + 1);
                    System.out.print("Enter priority for process " + pid + " (1 or 2): ");
                    int priority = scanner.nextInt();
                    System.out.print("Enter arrival time for process " + pid + ": ");
                    int arrivalTime = scanner.nextInt();
                    System.out.print("Enter CPU burst for process " + pid + ": ");
                    int cpuBurst = scanner.nextInt();
                    PCB process = new PCB(pid, priority, arrivalTime, cpuBurst);
                    addProcess(process);
                }
            break;
        case 2:
                for (int i = 0; i < numProcesses; i++) {
            System.out.print( i+1 );
            
                Q1[i].StatusDetail();
            Q2[i].StatusDetail();
            
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
    /*			for (int i = 0; i < Q2.length; i++) {
                outputfile.write(" | The processID " +Q2[i].getProcessID()  );
                outputfile.write(" | The priority : " +Q2[i].getPriority());
                outputfile.write(" | The arrivalTime : " + Q2[i].getArrivalTime());
                outputfile.write(" | The cpuBurstTime :" + Q2[i].getCpuBurstTime());
                outputfile.write(" | Starting time: " + Q2[i].getStartTime() );
                outputfile.write(" | termination time  " + Q2[i].getTerminationTime() );
                outputfile.write(" | turnaround time  " + Q2[i].getTurnaroundTime());
                outputfile.write(" | waiting time  " + Q2[i].getWaitingTime() );
                outputfile.write(" | response time  " + Q2[i].getResponseTime() );
                outputfile.write(" ");
            }*/
            //outputfile.flush();
            outputfile.close();
        }

    
public static void addProcess(PCB process) {
    int priority = process.getPriority();
    String processID = process.getProcessID();

            if (priority == 1) {
        // Find the first null element in Q1 and add the process there
        for (int i = 0; i < Q1.length; i++) {
            if (Q1[i] == null) {
                Q1[i] = process;
                System.out.println("Added " + processID + " to Q1.");
                return;
            }
        }
    } else if (priority == 2) {
        // Find the first null element in Q2 and add the process there
        for (int i = 0; i < Q2.length; i++) {
            if (Q2[i] == null) {
                Q2[i] = process;
                System.out.println("Added " + processID + " to Q2.");
                return;
            }
        }
        } else {
            System.out.println("Invalid priority. Process not added.");
        }
    }


    public static void excuteQ2() {

        // Sort Q2 based on CPU burst time SJF
        Arrays.sort(Q2, Comparator.comparingInt(PCB::getCpuBurstTime));

        

        // Repeatedly iterate through Q2 until all processes are executed
        while (true) {
            boolean processExecuted = false; // Track if any process is executed in this iteration
            for (int i = 0; i < Q2.length; i++) {
                PCB process = Q2[i];
                if (process != null && process.getArrivalTime() <= currentTime) {
                    processExecuted = true; // A process is executed in this iteration
                    excuteProcess(process); // Execute the process for its CPU burst time
                    remove(Q2, i); 
                    break;
                }else {
                    if(processArriveAtQ1()){ //check q1 if there is arrival excute it and don't twice increment time
                        processExecuted = true; // A process is executed in this iteration
                    }
                }
            }
            if (empty(Q2) && empty(Q1)) {
                // All processes executed, exit the loop
                break;
            }
            if (!processExecuted) {
                // No process executed, increment currentTime
                currentTime++;
            }
        }
        
    }
    public static void excuteProcess(PCB process){

        int cpuBurst = process.getCpuBurstTime();
        
        //for each ms of the time 
        for(int i=0;i<cpuBurst;i++){ 
        System.out.println("Running process " + process.getProcessID() + "  with priority 2");
        currentTime++;    
        process.setCpuBurstTime( process.getCpuBurstTime()-1 ); //could not be necessary !!
        processArriveAtQ1(); //check q1 if there is arrival, excute it                
        }
    }

    public static boolean empty(PCB[] array) {
        boolean empty = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                empty = false;
        }
        return empty;
    }
    
    public static boolean processArriveAtQ1(){
        for (int i = 0; i < Q1.length; i++){
            if (Q1[i] != null && Q1[i].getArrivalTime() <= currentTime){
                //call schedulling q1 
                return true;
            }
        }
        return false;
    }    
}//MAIN