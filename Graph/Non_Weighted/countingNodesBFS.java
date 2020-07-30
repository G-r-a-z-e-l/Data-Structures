
import java.util.*;
import java.io.*;
/*Count the number of nodes at given level in a tree using BFS.
Given a tree represented as undirected graph. Count the number of nodes at given level l. It may be assumed that vertex 0 is root of the tree. 

Input :   7 - vtx
          6 - edges
          0 1
          0 2
          1 3
          1 4 
          1 5
          2 6
          2
Output :  4

Input : 6
        5
        0 1
        0 2
        1 3
        2 4
        2 5
        2
Output : 3

*/


public class countingNodesBFS {
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
           
            graph[v1].add(v2);
            graph[v2].add(v1);        
        }
        int level = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtx];
        System.out.println(countBFS(graph,0,visited,level));

    }


    public static int countBFS(ArrayList<Integer>[] graph,int src,boolean[] visited,int level){
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);
        if(level==0){
            return q.removeFirst();
        }
        while(level!=1){
            int rv = q.removeLast();
            visited[rv] = true;
            for(int neigh : graph[src]){
                if(visited[neigh]!=true)
                q.addLast(neigh);
            }
            level--;
        }

        int count =0;
        
        while(!q.isEmpty()){
            int rm = q.removeFirst();
            for(int neigh : graph[rm]){
                if(visited[neigh]==false){
                    count++;
                }
            }
        }
        return count;
    }

}