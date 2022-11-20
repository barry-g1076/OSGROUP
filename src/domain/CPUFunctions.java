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
        CPU cpu2 = new CPU();
        CPU cpu1 = new CPU();
        CPU temp = new CPU();
        Node currentNode = processList.head;
        int systemTime = 0;
        int bTime1 = 1;
        int bTime2 = 1;
        int tempT = 5;
        while (systemTime < 30  ) {
            // while (bTime2 < tempT) {
            if (cpu1.isEmpty() || cpu2.isEmpty()) {
                while (cpu1.isEmpty()&& currentNode!= null) {
                    if (systemTime == currentNode.getdataProcess().getArrivalTime()) {
                        cpu1.enqueue(currentNode.getdataProcess());
                        System.out.println("Cpu 1 is busy");
                        currentNode = currentNode.getNextNode();
                            break;
                     }
                    if (!cpu2.isEmpty() && bTime2 != cpu2.front.getdataProcess().getBurstTime()) {
                        bTime2++;
                        System.out.println("CPU 2 is busy burst check adding from cpu 1");

                    }
                    systemTime++;
                    System.out.println("CPU 1 is idle");
                }
                while (!cpu1.isEmpty() && cpu2.isEmpty()&& currentNode!= null) {
                    if (bTime1 != cpu1.front.getdataProcess().getBurstTime()) {
                        bTime1++;
                        System.out.println("CPU 1 is busy burst check adding from cpu 2");
                    }
                    if (systemTime == currentNode.getdataProcess().getArrivalTime()) {
                        cpu2.enqueue(currentNode.getdataProcess());
                        System.out.println("Cpu 2 is busy");
                        tempT = currentNode.getdataProcess().getBurstTime();
                        System.out.println("temp time" + tempT);
                       
                            currentNode = currentNode.getNextNode();
                            break;
                          
                    }
                    
                    systemTime++;
                    System.out.println("CPU 2 is idle");
                }
                
                bTime1=LockRes(cpu1,cpu1.getFrontProcess().getBurstTime(),cpu1.getFrontProcess().getTask(),resourceList);
                bTime2=LockRes(cpu2,cpu2.getFrontProcess().getBurstTime(),cpu2.getFrontProcess().getTask(),resourceList);
                
            } // end is empty check
            if (cpu1.isEmpty()&& currentNode == null) {
                System.out.println("CPU 1 is empty no more processes to run");
                systemTime++;
            } else if (bTime1 == cpu1.front.getdataProcess().getBurstTime()) {
                temp.enqueue(cpu1.dequeue().getdataProcess());
                System.out.println("CPU 1 is now empty");
                bTime1 = 0;
            } else {
                System.out.println("CPU 1 is busy burst check");
                bTime1++;
            }
            if (cpu2.isEmpty() && currentNode == null) {
                System.out.println("CPU 2 is empty no more processes to run");
                systemTime++;
            } else if (bTime2 == cpu2.front.getdataProcess().getBurstTime()) {
                temp.enqueue(cpu2.dequeue().getdataProcess());
                System.out.println("CPU 2 is idle  now empty");
                bTime2 = 0;
            } else {
                System.out.println("CPU 2 is busy burst check");
                bTime2++;
            }
            // } // end While
            System.out.println("System Time: " + systemTime + " Burst Time 1: " + bTime1 + " Burst Time 2:" + bTime2);
        }
        temp.display();
    }
    public int LockRes(CPU a, int BT, int RT , ResourceList resourceList) {
    	 Resource res;		
    	 res= resourceList.retrieve(generateRan());     
            
    	 if (RT==3||RT==4 ) {
    		 if(RT==3) {
           System.out.println(res.getData());
           if(BT!=a.front.getdataProcess().getBurstTime())
    		   BT++;
           }else{
        	   resourceList.sumList();
        	   if(BT!=a.front.getdataProcess().getBurstTime())
        		   BT++;
           }
            	return BT ;
            }else {
            	
            	for(;BT<= a.front.getdataProcess().getBurstTime();BT++) {
            		
            		System.out.println("Resource is now locked");
            		
            		
            	}
            	if(RT==1) {
            		res.setData(generateRan1());
                    System.out.println("Data Update to: "+res.getData());
                    System.out.println("Resourse is now Unlocked");
                    }else{
                 	   res.setData(0);
                 	  System.out.println("Data was removed to: "+res.getData());
                 	  System.out.println("Resourse is now Unlocked");
                 	  }
            	
            	
            	return BT;
            }
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
