package domain;

public class Process {
    private int PID=0;
    private int task;
    private int priority;
    private int arrivalTime;
    private int blockedTime;
    private int burstTime;

    public Process() {
        PID = 0;
        // task = 1;
        task = generateTask();
        priority = generatePriority();
        arrivalTime = generateArrivalTime();
        blockedTime = 0;
        burstTime = generatePriority();
    }

    // Generates task
    public int generateTask() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 5);
    }

    // Generates Priority
    public int generatePriority() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 6);
    }

    // Generates ArrivalTime
    public int generateArrivalTime() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 10);
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int pID) {
        PID = pID;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(int blockedTime) {
        this.blockedTime = blockedTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public String toString() {
        return "PID: " + this.PID + ",Task: " + this.task + ",Priority: " + this.priority + ",Arrival Time: "
                + this.arrivalTime + ",Blocked Time: " + this.blockedTime + ",Burst Time: " + this.burstTime;
    }

}
