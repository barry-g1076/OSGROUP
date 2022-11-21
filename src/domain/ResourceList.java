package domain;

public class ResourceList {
    Node head;

    public ResourceList() {
        head = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void InsertAtFront(Resource rl) {
        Node newNode = new Node(rl);
        newNode.setDataResource(rl);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.setNextNode(temp);
        }
    }

    public Resource retrieve(int n) {
        Node current = this.head;
        if (isEmpty()) {
            System.out.println("Resource List is empty ");
            return null;
        } else {
            while (current.getDataResource().getiD() != n) {
                current = current.getNextNode();
            }
        }
        return current.getDataResource();
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
        if (!isEmpty()) {
            System.out.println("Shared Resource List: ");
            sortList();
            while (current != null) {
                System.out.println(current.getDataResource());
                current = current.getNextNode();
            }
            System.out.println();
        } else {
            System.out.println("List is empty");
        }
    }

    public void sumList() {
        Node current = head;
        int sum = 0;
        if (!isEmpty()) {
            System.out.println("Shared Resource List Total: ");
            while (current != null) {
                sum = +current.getDataResource().getData();
                current = current.getNextNode();
            }
            System.out.println("Sum: " + sum);
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

    public void sortList() // sort the list
    {
        if (head == null)
            System.out.println("List Empty");
        else {
            Node start = head;
            Node p = null;
            for (Node end = null; end != start.getNextNode(); end = p) {
                for (p = start; p.getNextNode() != end; p = p.getNextNode()) {
                    Node q = p.getNextNode();
                    if (p.getDataResource().getiD() > q.getDataResource().getiD()) {
                        Resource temp = p.getDataResource();
                        p.setDataResource(q.getDataResource());
                        q.setDataResource(temp);
                    }
                }
            }
        }

    }

}
