import java.util.*;

public class fourth {

    static int V;

    static int minDist(int[] dist, boolean[] boolSet){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < V ; i++){
            if (!boolSet[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void print(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    static void dijkstra (int[][] graph,  int src){
        int[]dist = new int[V];
        boolean[] boolset =new boolean [V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            boolset[i] = false;
        }

        dist[src] = 0;

        for(int i = 0; i < V; i++){
            
            int u = minDist(dist, boolset);
            boolset[u] = true;

            for(int v = 0; v < V; v++){
                if (!boolset[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }


        }

        print(dist);


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no if vertices: ");
        V = sc.nextInt();

        int [] [] graph = new int [V][V];

        System.out.println("Enter the adjencency matrix: ");
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        int src = 0;

        dijkstra(graph, src);
        sc.close();
    }
}
