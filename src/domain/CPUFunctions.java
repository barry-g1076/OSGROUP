package domain;


public class CPUFunctions {
    ProcessList pList;
    CPU cQueue;
    Resource resource;

    public CPU addProcessToQueue(ProcessList processList) {
        CPU processQueue = new CPU();
        pList = processList;
        Node currenProcessList = pList.head;
        while (currenProcessList != null) {
            processQueue.enqueue(currenProcessList.getdataProcess());
            currenProcessList = currenProcessList.nextNode;
        }
        // processQueue.display();
        return processQueue;
    }

    public void addProcessToCpu(ProcessList processList, ResourceList resourceList) {
        // CPU cpu2 = new CPU();
        CPU processQueue= addProcessToQueue(processList);
        Node currentNode=processQueue.front;
        // Node curNode=null;
        // Node prev= null;
        int systemTime=0;
        int bTime1=0;
        while(systemTime!=30){
            if (systemTime!= currentNode.getdataProcess().getArrivalTime()) {
                System.out.println("Cpus are Idle");
            }else if (systemTime== currentNode.getdataProcess().getArrivalTime()) {
                addProcessToCpu1( currentNode,  resourceList);
            }
             if(bTime1== currentNode.getdataProcess().getBurstTime()){
                currentNode.getNextNode();
                addProcessToCpu1( currentNode,  resourceList);
            }
             if (bTime1!= currentNode.getdataProcess().getBurstTime()) {
                System.out.println("Cpu1 is busy");
                bTime1++;
            }
            systemTime++;
            System.out.println("System Time: "+systemTime+" Burst Time: "+bTime1);
        }
    }
    public int generateRan() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 5);
    }
    public void addProcessToCpu1(Node process, ResourceList resourceList){
        CPU cpu1 = new CPU();
        cpu1.enqueue(process.dataProcess);
        Node nextQNode = process;
        Node prev= null;
       
            resource= resourceList.retrieve(generateRan());
            if (nextQNode.getdataProcess().getTask() == 1) {
                resource.setData(generateRan());
                System.out.println("Task 1 complete");
                // resourceList.showList();
            }else if(nextQNode.getdataProcess().getTask() == 2){
                resource.setData(0);
                System.out.println("Task 2 complete");
                // resourceList.showList();
            }else  if(nextQNode.getdataProcess().getTask() == 3){
                System.out.println("Task 3 complete");
                System.out.println(resourceList.retrieve(resource.getiD()));
            }else  if(nextQNode.getdataProcess().getTask() == 4){
                System.out.println("Task 4 complete");
                // resourceList.sumList();
            }
            if (prev != null){
                nextQNode.dataProcess.setBlockedTime(prev.dataProcess.getBurstTime());
            }
            prev=nextQNode;
            cpu1.display();
    }
}
