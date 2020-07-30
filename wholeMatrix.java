import java.io.*;
import java.util.*;

public class wholeMatrix {
    
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

    public static void initialVertices()
}