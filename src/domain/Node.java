package domain;

public class Node {
    Process dataProcess;
    Resource dataResource;
    Node nextNode;

    public Node() {
        dataProcess = null;
        nextNode = null;
    }

    public Node(Process pd) {
        dataProcess = pd;
        nextNode = null;
    }
    public Node(Resource rd) {
        dataResource = rd;
        nextNode = null;
    }

    public Node(Node node) {
        dataProcess = node.dataProcess;
        nextNode = node.nextNode;
    }

    public Process getdataProcess() {
        return dataProcess;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Resource getDataResource() {
        return dataResource;
    }

    public void setDataResource(Resource dataResource) {
        this.dataResource = dataResource;
    }

    public void setdataProcess(Process pd) {
        dataProcess = pd;
    }

    public void setNextNode(Node ne) {
        nextNode = ne;
    }

}
