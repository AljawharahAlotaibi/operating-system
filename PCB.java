public class PCB {
    private String processID;
    private int priority;
    private int arrivalTime;
    private int cpuBurstTime;
    private int startTime;
    private int terminationTime;
    private int turnaroundTime;
    private int waitingTime;
    private int responseTime;

    // Constructor
    public PCB(String processID, int priority, int arrivalTime, int cpuBurstTime) {
        this.processID = processID;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.cpuBurstTime = cpuBurstTime;
        this.startTime = -1; // Initialize to -1 (not started)
        this.terminationTime = -1; // Initialize to -1 (not terminated)
        this.turnaroundTime = 0;
        this.waitingTime = 0;
        this.responseTime = -1; // Initialize to -1 (not responded)
    }
    // getter
    public String getProcessID() {
		return processID;
	}


	public int getPriority() {
		return priority;
	}



	public int getArrivalTime() {
		return arrivalTime;
	}


	public int getCpuBurstTime() {
		return cpuBurstTime;
	}

	
	public int getStartTime() {
		return startTime;
	}

	

	public int getTerminationTime() {
		return terminationTime;
	}


	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	
	public int getWaitingTime() {
		return waitingTime;
	}


	public int getResponseTime() {
		return responseTime;
	}
}
