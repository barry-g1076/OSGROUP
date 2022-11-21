package domain;

public class ProcessList {
    Node head;

    public ProcessList() {
        head = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void InsertAtFront(Process pl) {
        Node newNode = new Node(pl);
        newNode.setdataProcess(pl);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.setNextNode(temp);
        }
    }

    public void retrieve(int N) {
        Node node = this.head;
        if (head != null && N >= 0) {
            for (int i = 0; i < N; i++) {
                node = node.getNextNode();
            }
            System.out.println("Node item at location " + N + " is " + node.dataProcess);
        }
    }

    public Process getProcessHead(){
        if(isEmpty()){
            System.out.println("there is no process to retrive");
        }
        return head.getdataProcess();
    }
    

    public void removeNode(int N) {
        if (N <= 0 || this.head != null) {
            Node currentNode = this.head;
            Node prevNode = null;
            for (int i = 0; i < N; i++) {
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }
            prevNode.nextNode = currentNode.nextNode;
        } else {
            System.out.println("No node exist at location: " + N);
        }
    }

    public void showList() {
        Node current = head;
        if (current != null) {
            sortListByArrivalTime();
            sortListByPriority();
            while (current != null) {
                System.out.println(current.getdataProcess());
                current = current.getNextNode();
            }
            System.out.println();
        } else {
            System.out.println("List is empty");
        }
    }

    public void DestroyList() {
        if (this.head != null) {
            while (this.head != null) {
                this.head = this.head.nextNode;
            }
        }
        System.out.println("List is distroyed");
    }

    public void sortListByPriority() // sort the list
    {
        if (head == null)
            System.out.println("List Empty");
        else {
            Node start = head;
            Node p = null;
            for (Node end = null; end != start.getNextNode(); end = p) {
                for (p = start; p.getNextNode() != end; p = p.getNextNode()) {
                    Node q = p.getNextNode();
                    if (p.getdataProcess().getArrivalTime() == q.getdataProcess().getArrivalTime()) {
                        if (p.getdataProcess().getPriority() > q.getdataProcess().getPriority()) {
                            Process temp = p.getdataProcess();
                            p.setdataProcess(q.getdataProcess());
                            q.setdataProcess(temp);
                        }
                    }
                }
            }
        }

    }

    public void sortListByArrivalTime() // sort the list
    {
        if (head == null)
            System.out.println("List Empty");
        else {
            Node start = head;
            Node p = null;
            for (Node end = null; end != start.getNextNode(); end = p) {
                for (p = start; p.getNextNode() != end; p = p.getNextNode()) {
                    Node q = p.getNextNode();
                    if (p.getdataProcess().getArrivalTime() > q.getdataProcess().getArrivalTime()) {
                        Process temp = p.getdataProcess();
                        p.setdataProcess(q.getdataProcess());
                        q.setdataProcess(temp);
                    }
                }
            }
        }

    }

   
}
