import domain.CPUFunctions;
import domain.Process;
import domain.ProcessList;
import domain.Resource;
import domain.ResourceList;

public class App {
    public static void main(String[] args) throws Exception {
        ProcessList processList= new ProcessList();
        ResourceList resourceList= new ResourceList(); 
        processList=list(processList);
        resourceList=list(resourceList);
        System.out.println("Process List \n");
        processList.showList();
        resourceList.showList();
           System.out.println( resourceList.retrieve(1));
        CPUFunctions functions= new CPUFunctions();
        functions.addProcessToCpu(processList, resourceList);
    }

    public static ProcessList list(ProcessList plList){
        Process pd = new Process();
        for (int i = 0; i < 20; i++) {
            pd.setPID(i+1);
            plList.InsertAtFront(pd);
            pd = new Process();
        }

        return plList;
    }

    public static ResourceList list(ResourceList rlist){
        Resource rd = new Resource();
        for (int i = 0; i < 20; i++) {
            rd.setiD(i+1);
            rlist.InsertAtFront(rd);
            rd =  new Resource();
        }

        return rlist;
    }
}
