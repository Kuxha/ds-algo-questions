package graphs;

import java.util.*;



public class dfs {

    static class Edge{ 

        int src ;
        int dest;
        int weight;


        public Edge(int s,int d,int wt){
            src = s;
            dest = d;
            weight = wt;
        }
    }

    static void DFSutil(ArrayList<Edge>[] graph,int curr,boolean []vis){

        // First curr ko visit curro
        vis[curr] = true;
        System.out.print(curr + " ");

        // then go to the neighbours of curr - and simply dfsutil ek ek karke call karo

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                DFSutil(graph, e.dest, vis);
            }
            
        }


    }

    static void DFS(ArrayList<Edge>[] graph){

        System.out.print("\nTHE DFS Travesal is \n");

        // Number of vertices = graph length
        int vertices = graph.length;

        // First we initialize a queue
        // We add vertices to this queue , hence the type is integer
        Queue<Integer> q = new LinkedList<>();

        // Then we create a visited array
        boolean visited[] = new boolean[ vertices];
        DFSutil(graph, 0, visited);



    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList <Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        DFS(graph);
    }


    // What are we storing here
    // Basically graph is an array - where the index represents the vertices
    // Each vertices will have its own arraylist of edges
    static void createGraph(ArrayList <Edge> graph[]){
        //graph length is the number of vertices 
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            
        }

       /* 

                 1-------3
                /        |\
              /          | \
             0           |  5----6
              \          |  /
               \         | /
                2--------4
       
        */
        
        //node 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // node 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //node 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //node 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        //node 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4,5, 1));

        //node 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //node 6
        graph[6].add(new Edge(6, 5, 1));

        System.err.println("Graph Created");
        
    }

     
    
    
}
