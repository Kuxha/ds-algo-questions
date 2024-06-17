package graphs;

import java.util.*;



public class bfs {

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

    static void BFS (ArrayList<Edge>[] graph){
        int vertices = graph.length;
        boolean visited[] = new boolean[ vertices];


        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){

                System.err.println("New Component starts with " + i + "\n");
                BFSutil(graph, visited,i);
            }
  

        }
    



    }
    static void BFSutil(ArrayList<Edge>[] graph,   boolean visited[],int start){

        // Number of vertices = graph length
   

        // First we initialize a queue
        // We add vertices to this queue , hence the type is integer
        Queue<Integer> q = new LinkedList<>();

        // Then we create a visited array


        // Finally we add the first node to our queue

        q.add(start);

        while(!q.isEmpty()){
            // First remove the first element of the queue

            int curr = q.remove();

            if(!visited[curr]){
                    // If the node is not visited  - perform three things
                    // step 1 - mark the node as visited
                    visited[curr] = true;
                    // step 2 - print the node
                    System.out.print(curr + " ");
                    // step 3 - add all children to the queue

              
                    for (int i = 0; i < graph[curr].size(); i++) {
                        // Basically we first go the the current node in graph
                        // From there we get an array list of edges
                        // Iterate through each edge -- and keep adding the destination
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }

            }

        }
    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList <Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        BFS(graph);
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
             0           |  5----6   7----8
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


        graph[7].add(new Edge(7, 8, 1));
        System.err.println("Graph Created");
        
    }

     
    
    
}
