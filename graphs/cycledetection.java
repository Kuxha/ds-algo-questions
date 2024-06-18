package graphs;

import java.util.*;



public class cycledetection {

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

    static boolean CycleDetectionUtil(ArrayList<Edge>[] graph,boolean []vis,int start,int parent){


        // First curr ko visit curro
        vis[start] = true;
        System.out.print(start + " ");

        // then go to the neighbours of curr - and simply dfsutil ek ek karke call karo

        for (int i = 0; i < graph[start].size(); i++) {

            Edge e = graph[start].get(i);
            int neighbour = e.dest;
            // Three Case

            // Case 3 - If not visited - visit it
            if(!vis[neighbour]){
                if(CycleDetectionUtil(graph, vis, neighbour, start)){
                    // If cycle is detected in any neighbour - then return true
                                return true;
                            }
            }else if(vis[neighbour] && neighbour!=parent){
                  // Case 1 -  Visited the node before - and it is not a parent
                return true;
            }

             // Case 2 -  Visited the node before - and it is a parent

            if(vis[neighbour] && neighbour==parent){
               // do nothing and continue
            }



             
            
            
        }


        return false;


    }

    static boolean CycleDetection(ArrayList<Edge>[] graph){

        System.out.print("\nDetecting Cycle \n");

        // Number of vertices = graph length
        int vertices = graph.length;
        // First create a visited array
        boolean visited[] = new boolean[ vertices];

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(CycleDetectionUtil(graph, visited,i,-1)){
                    return true;
                }
            }

           
        }


        return false;
    }



    public static void main(String[] args) {
        int V = 9;
        ArrayList <Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("cycle is there  = " + CycleDetection(graph));

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
                /         \
              /            \
             0               5----6        7-----8
              \             
               \           
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
        // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4,5, 1));

        //node 5
        graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //node 6
        graph[6].add(new Edge(6, 5, 1));

        graph[7].add(new Edge(7, 8, 1));
        System.err.println("Graph Created");
        
    }

     
    
    
}
