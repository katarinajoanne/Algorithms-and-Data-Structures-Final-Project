public class Main {
    public static void main(String[] args) {
        int numVertex = 8;
        Graph map = new Graph(numVertex);

        map.addEdge(0, 1, 28);

        map.addEdge(1, 2, 60);
        map.addEdge(1, 3, 150);

        map.addEdge(2, 3, 126);

        map.addEdge(3, 4, 130);

        map.addEdge(4, 5, 229);
        map.addEdge(4, 6, 313);

        map.addEdge(5, 6, 133);
        map.addEdge(5, 7, 352);

        map.addEdge(6, 7,328);

        map.displayGraph();

        map.dijkstra(0, 7);
    }
}
