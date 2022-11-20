package domain;

public class CPU {
     Node front;
     Node rear;
 
    /* Constructor */
    public CPU()
    {
        front = null;
        rear = null;
    }    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        if(front == null)
        	return true;
        
        return false;
    }    
    /*  Function to insert an element to the queue */
    public void enqueue(Process
     data)
    {
        Node node = new Node(data);
        if (rear == null)
        {
            front = node;
            rear = node;
        }
        else
        {
            rear.setNextNode(node);
            rear = rear.getNextNode();
        }
    }    

    public Process getFrontProcess(){
        if(isEmpty()){
        	 System.out.println("There is currently no process running on the cpu1");
        }
        return front.getdataProcess();
    }
    
    // public Node getProcessNext(Process currentProcess){
    //     if(isEmpty()){
    //         System.out.println("there is no process to retrive");
    //     }
    //     return ((Node) currentProcess).getNextNode();
    // }
    /*  Function to remove front element from the queue */
    public Node dequeue()
    {
        if (isEmpty() )
        	 System.out.println("There is currently no process running on the cpu");
        Node node = front;
        Node temp =node;
        front = node.getNextNode();        
        if (front == null)
            rear = null;
        
        return temp;
    }    
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.println("Queue = ");
        if (isEmpty() == true)
        {
            System.out.println("Empty\n");
            return ;
        }
        Node node = front;
        while (node != null )
        {
            System.out.println(node.getdataProcess()+" \n");
            node = node.getNextNode();
        }
        System.out.println();        
    }
    /*Destroy*/
    public void Destroy(){
    	Node node = front;
        while (node != null)
        {
            node.setdataProcess(null);
            node = node.getNextNode();
        }
        System.out.println("All processes in CPU 1 is terminated ");  
    }
    
    public int countQueueItems(CPU queue) {
    	int count=0;
    	if (isEmpty() == true)
        {
            System.out.println("Empty\n");
            return -1;
        }
    	Node node = queue.front;
        while (node != null )
        {
            count++;
            node = node.getNextNode();
        }
        return count;
    }
}
