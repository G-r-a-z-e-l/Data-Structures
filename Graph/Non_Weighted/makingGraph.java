import java.io.*;
import java.util.*;
// I am gonna construct a non weighted Graph using an Array of ArrayList.
public class makingGraph {
    
//taking input----------------------    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtx = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[vtx];

        for(int i=0;i<vtx;i++){
            graph[i] = new ArrayList<>();
        }
        int edges  = Integer.parseInt(br.readLine());
        for(int i=0;i<edges;i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int w1 = Integer.parseInt(parts[2]);
            graph[v1].add(v2);
            graph[v2].add(v1);        
        }

        int src  =Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean visited[] = new boolean[vtx];
        System.out.println(hasPath(graph, src, dest, visited));     
        
        //System.out.println(connectedComponents(graph));
        printPath(graph, src, dest, "" ,new boolean[vtx]);

    }    

    public static boolean hasPath(ArrayList<Integer>[] graph,int src,int dest,boolean[] visited){
        if(src==dest){
            return true;
        }

        if(visited[src]==true){
            return false;
        }
        visited[src] = true;

        for(int neigh : graph[src]){
            boolean path = hasPath(graph, neigh, dest, visited);

            if(path==true){
                return true;
            }
        }

        visited[src] = false;

        return false;
    }

    public static void printPath(ArrayList<Integer>[] graph,int src,int dest,String psf,boolean[] visited){
        
        if(src==dest){
            System.out.println(psf+dest);
            return;
        }
        if(visited[src] == true){
            return;
        }

        visited[src] = true;

        for(int neigh : graph[src]){
            printPath(graph,neigh,dest,psf+src+" ",visited);
        }
        visited[src] = false;
        
    }




// gives the compnents of the graph in which all the vertices have a edge between them
/* A test case
7
7
0 1 10
1 2 10
2 3 10
0 3 10
4 5 10
5 6 10
4 6 10
*/
    public static ArrayList<ArrayList<Integer>> connectedComponents(ArrayList<Integer>[] graph){
        boolean visited[]  = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(visited[i] == true){
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            connected(graph, i, list, visited);
            comp.add(list);
        }

        return comp;
    }

    public static void connected(ArrayList<Integer>[] graph,int src,ArrayList<Integer> edges,boolean[] visited){
        if(visited[src]==true){
            return;
        }   
        
        visited[src] = true;
        edges.add(src);
        
        for(int neigh: graph[src]){
            connected(graph,neigh,edges,visited);
        }
        
       }
}

//Breadth First Search
public static class pair{
    int vtx;
    String psf;
    
   public pair(int vtx,String psf){
        this.vtx = vtx;
        this.psf = psf;
    }
}

public static void bfs(ArrayList<Integer>[] graph,int src){
    
    LinkedList<pair> q = new LinkedList<>();
    boolean[] visited = new boolean[graph.length];
    q.add(new pair(src,src+""));
    
    while(!q.isEmpty()){
        pair removed = q.removeFirst();
         
         if(visited[removed.vtx] == true){
             continue;
         }   
         visited[removed.vtx] = true;
         System.out.println(removed.vtx +"@"+removed.psf);
         for(int neigh : graph[removed.vtx]){
             if(visited[neigh]==false){
                 q.add(new pair(neigh,removed.psf+neigh+""));
             }
         }
    }
    
}