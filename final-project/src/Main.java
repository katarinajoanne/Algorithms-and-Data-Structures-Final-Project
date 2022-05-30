import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter location 1: ");
            String location1 = sc.nextLine();

            System.out.print("Enter location 2: ");
            String location2 = sc.nextLine();

            System.out.print("How many stops would you like to have? ");
            int numVertex = sc.nextInt();

            boolean condition = true;
            int edge1;
            int edge2;
            int stops = 1;

            Graph map = new Graph(numVertex);
   
            while (condition == true) {
                try {
                    System.out.print("Enter distance and stops (stop " +  stops + ", stop " + (stops+1) + ", distance), (n if no more stops)");
                    edge1 = (sc.nextInt()-1);
                    edge2 = (sc.nextInt()-1);
                    int distance = sc.nextInt();
                
                    map.addEdge(edge1, edge2, distance);
                    stops++;
                    
                } catch (Exception e) {
                    condition = false;
                }
            }

            // System.out.print("Enter distance from location " + location + " to location " + (location + 1) + ": ");
            // int distance =  sc.nextInt();
            // System.out.println(distance);

            map.displayGraph();

            map.dijkstra(0, numVertex-1, location1, location2);
        }
    }
}

