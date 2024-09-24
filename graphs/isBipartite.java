package graphs;

import java.util.*;



public class isBipartite {

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

    static boolean isBipartitite (ArrayList<Edge>[] graph){
        int vertices = graph.length;
        int[] color = new int[ vertices];

        // Let 0 = no color
        // Let 1 = blue
        // Let 2 = red
        // By default all vertices are no color


        Queue<Integer> q = new LinkedList<>();

        // We go through each vertex in the graph - here i is the vertex
        for (int i = 0; i < graph.length; i++) {

            // First of all - we check color of our vertex - if no color - assign a color - else continue

            if(color[i] == 0){
                // Means this vertex has not been visited/colored yet

                // So first we color the vertex

                color[i] = 1; // we color it blue at first
                q.add(i); // after coloring add vertex to queue like bfs

                while(!q.isEmpty()){
                    int curr = q.remove();
                    // Now we look at each edge of the current vertex
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        int neighbour = e.dest;

                        // Now we check all cases of the neighbour

                        if(color[neighbour] == 0){
                            // If neighbour has not been visited yet
                            int neighborColor = color[curr] == 0 ? 1 :0;
                            color[neighbour ]= neighborColor;

                        }else if(color[neighbour] == color[curr]){
                            return false;
                        }                      
                    }
                }
            }       
        }
        return true;

    }


    public static void main(String[] args) {
        int V = 9;
        ArrayList[] graph;
        graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Graph is bipartite = "  + isBipartitite(graph));
    }


    // What are we storing here
    // Basically graph is an array - where the index represents the vertices
    // Each vertices will have its own arraylist of edges
    static void createGraph(ArrayList<Edge>[] graph){
        //graph length is the number of vertices 
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            
        }

       /* 

                 1-------3
                /        \
              /           \
             0             5
              \            /
               \          /
                2--------4
       
        */
        
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4,5, 1));
      
  
  
        System.err.println("Graph Created");
        
    }

     
    
    
}
