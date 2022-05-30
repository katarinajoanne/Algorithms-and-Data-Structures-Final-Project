public class Graph {
    private int numVertex;
    private int [][] adjacencyMatrix;

    public Graph(int numVertex) {
        this.numVertex = numVertex;
        adjacencyMatrix = new int[numVertex][numVertex];
    }

    public void addEdge(int from, int to, int len) {
        adjacencyMatrix[from][to] = len;
        adjacencyMatrix[to][from] = len;
    }

    public void displayGraph() {
        // To make graph more readable
        System.out.print(" ");
        for (int i = 0; i < numVertex; i++) {
            System.out.printf("%5d", i);
        }

        System.out.println(" ");

        for (int i = 0; i < numVertex; i++) {
            System.out.print(i);
            for (int j = 0; j < numVertex; j++) {
                System.out.printf("%5d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void dijkstra(int src, int dst, String location1, String location2){
        int distance[] = new int[numVertex];
        boolean[] fixed = new boolean[numVertex];
        int[] parent = new int[numVertex];
        int i,j;
        for(i = 0; i < numVertex; i++){
            distance[i] = Integer.MAX_VALUE;
            fixed[i] = false;
        }
        distance[src] = 0;
        parent[src] = -1;
        while(true){
            int marked = minIndex(distance, fixed);
            if(marked < 0) break;
            if(distance[marked] ==  Integer.MAX_VALUE) break;
            fixed[marked] = true;
            for(j = 0; j < numVertex; j++){
                if(adjacencyMatrix[marked][j] > 0 && !fixed[j]){
                    int newDistance = distance[marked] + adjacencyMatrix[marked][j];
                    if(newDistance < distance[j]){
                        distance[j] = newDistance;
                        parent[j] = marked;
                    }
                }
            }
        }
        if(distance[dst] == Integer.MAX_VALUE){
            System.out.println("no route");
        }
        else{
            System.out.println("Shortest path from " + location1 + " to " + location2 + " with dijkstra is " + distance[dst] + " km");
        }
    }

    public int minIndex(int[] distance, boolean[] fixed) {
        int idx = 0;
        for (; idx < fixed.length; idx++)
            if (!fixed[idx]) 
                break;

        if (idx  == fixed.length) 
            return - 1;

        for (int i = idx + 1; i < fixed.length; i++)
            if (!fixed[i] && distance[i] < distance[idx]) 
                idx = i;
        return idx;
    }
}
