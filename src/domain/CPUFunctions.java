package domain;

public class CPUFunctions {
    ProcessList pList;
    CPU cQueue;
    Resource resource;

    public void addProcessToCpu(ProcessList processList, ResourceList resourceList) {
        CPU cpu2 = new CPU();
        CPU cpu1 = new CPU();
        CPU temp = new CPU();
        Node currentNode = processList.head;
        int systemTime = 0;
        int bTime1 = 1;
        int bTime2 = 1;
       
        while (systemTime < 30) {
            if (cpu1.isEmpty() || cpu2.isEmpty()) {
                while (cpu1.isEmpty() && currentNode != null) {
                    if (systemTime == currentNode.getdataProcess().getArrivalTime()) {
                        cpu1.enqueue(currentNode.getdataProcess());
                        if (currentNode.getNextNode()!=null){
                            currentNode.getNextNode().getdataProcess().setBlockedTime(currentNode.getdataProcess().getBurstTime());
                        }
                        currentNode = currentNode.getNextNode();
                        break;
                    }
                    if (!cpu2.isEmpty() && bTime2 != cpu2.front.getdataProcess().getBurstTime()) {
                        bTime2++;
                    }
                    systemTime++;
                }
                while (!cpu1.isEmpty() && cpu2.isEmpty() && currentNode != null) {
                    if (bTime1 != cpu1.front.getdataProcess().getBurstTime()) {
                        bTime1++;
                    }
                    if (systemTime == currentNode.getdataProcess().getArrivalTime()) {
                        cpu2.enqueue(currentNode.getdataProcess());
                       
                        if (currentNode.getNextNode()!=null){
                            currentNode.getNextNode().getdataProcess().setBlockedTime(currentNode.getdataProcess().getBurstTime());
                        }
                        currentNode = currentNode.getNextNode();
                        break;
                    }
                    systemTime++;
                }

                if (!cpu1.isEmpty()) {
                    bTime1 = LockRes(cpu1, bTime1, cpu1.getFrontProcess().getTask(),
                            resourceList);
                }
                if (!cpu2.isEmpty()) {
                    bTime2 = LockRes(cpu2, bTime2, cpu2.getFrontProcess().getTask(),
                            resourceList);
                }

            } // end is empty check
            if (cpu1.isEmpty() && currentNode == null) {
                systemTime++;
            } else if (bTime1 == cpu1.front.getdataProcess().getBurstTime()) {
                temp.enqueue(cpu1.dequeue().getdataProcess());
                bTime1 = 0;
            } else {
                bTime1++;
            }
            if (cpu2.isEmpty() && currentNode == null) {
                systemTime++;
            } else if (bTime2 == cpu2.front.getdataProcess().getBurstTime()) {
                temp.enqueue(cpu2.dequeue().getdataProcess());
                bTime2 = 0;
            } else {
                bTime2++;
            }
        }
        temp.display();
        resourceList.showList();
    }

    public int LockRes(CPU a, int BT, int RT, ResourceList resourceList) {
        Resource res;
        res = resourceList.retrieve(generateRan());

        if (RT == 3 || RT == 4) {
            if (RT == 3) {
                System.out.println("Retrieved: Resource ID:"+res.getiD()+" Data:"+res.getData());
                if (BT != a.front.getdataProcess().getBurstTime())
                    BT++;
            } else {
                resourceList.sumList();
                if (BT != a.front.getdataProcess().getBurstTime())
                    BT++;
            }
            return BT;
        }
        if (RT == 1 || RT == 2) {

            while (BT <= a.front.getdataProcess().getBurstTime()) {

                System.out.println("Resource is now locked");
                BT++;
            }
            if (RT == 1) {
                System.out.println("Resource is now unlocked");
                res.setData(generateRan1());
                System.out.println("Update resource ID: "+res.getiD()+" Data to: " + res.getData());
            } else {
                System.out.println("Resource is now unlocked");
                res.setData(0);
                System.out.println("Data was removed ID: " +res.getiD()+" Data: "+ res.getData());
            }
           
                BT=a.front.getdataProcess().getBurstTime();

        }
        return BT;
    }

    public int generateRan() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 5);
    }

    public int generateRan1() {
        final var rand = java.util.concurrent.ThreadLocalRandom.current();
        return rand.nextInt((int) 1, (int) 100);
    }

}
