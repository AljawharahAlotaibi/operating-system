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
	    private int remainingTime ;
	  

	    // Constructor
	    public PCB(String processID, int priority, int arrivalTime, int cpuBurstTime) {
	        this.processID = processID;
	        this.priority = priority;
	        this.arrivalTime = arrivalTime;
	        this.cpuBurstTime = cpuBurstTime;
	        remainingTime=cpuBurstTime;
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
		
		
	//setter
		public int getRemainingTime() {
			return remainingTime;
		}
		public void setRemainingTime(int remainingTimeQ1) {
			this.remainingTime = remainingTimeQ1;
		}
		public void setProcessID(String processID) {
			this.processID = processID;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public void setArrivalTime(int arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public void setCpuBurstTime(int cpuBurstTime) {
			this.cpuBurstTime = cpuBurstTime;
		}
		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}
		public void setTerminationTime(int terminationTime) {
			this.terminationTime = terminationTime;
		}
		public void setTurnaroundTime(int turnaroundTime) {
			this.turnaroundTime = turnaroundTime;
		}
		public void setWaitingTime(int waitingTime) {
			this.waitingTime = waitingTime;
		}
		public void setResponseTime(int responseTime) {
			this.responseTime = responseTime;
		}
		public void StatusDetail(){
		System.out.printf(" | The processID : %-4s" ,processID  );
		System.out.printf(" | The priority : %-4d" , priority);
		System.out.printf(" | The arrival Time : %-4d" , arrivalTime);
		System.out.printf(" | The cpu Burst Time :%-4d" , cpuBurstTime);
		System.out.printf(" | Starting time: %-4d" , startTime );
		System.out.printf(" | termination time %-4d" , terminationTime );
		System.out.printf(" | turnaround time  %-4d" , turnaroundTime);
		System.out.printf(" | waiting time  %-4d" , waitingTime );
		System.out.printf(" | response time %-4d" , responseTime);
	}
		@Override
		public String toString() {
			return "PCB [processID=" + processID ;
		}

} 
	
