import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WeightedGraph {

    class WeightedNode {
        int mIndex;
        private List<WeightedEdge> mNeighbors = new ArrayList<WeightedEdge>();

        WeightedNode(int index) {
            mIndex = index;
        }
    }

    private class WeightedEdge implements Comparable {

        private WeightedNode mFirst, mSecond;
        private double mWeight;

        WeightedEdge(WeightedNode first, WeightedNode second, double weight) {
            mFirst = first;
            mSecond = second;
            mWeight = weight;
        }

        @Override
        public int compareTo(Object o) {
            WeightedEdge e = (WeightedEdge) o;
            return Double.compare(mWeight, e.mWeight);
        }
    }

    private List<WeightedNode> mVertices = new ArrayList<WeightedNode>();

    public WeightedGraph(int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++) {
            mVertices.add(new WeightedNode(i));
        }
    }

    public void addEdge(int firstVertex, int secondVertex, double weight) {
        WeightedNode first = mVertices.get(firstVertex);
        WeightedNode second = mVertices.get(secondVertex);

        WeightedEdge edge = new WeightedEdge(first, second, weight);
        first.mNeighbors.add(edge);
        second.mNeighbors.add(edge);
    }

    /**
     * Prints the graph to the console. Each vertex is printed on its own line,
     * starting with the vertex's number (its index in the mVertices list), then
     * a colon, then a sequence of pairs for each edge incident to the vertex.
     * For each edge, print the number of the vertex at the opposite end of the
     * edge, as well as the edge's weight.
     *
     * Example: in a graph with three vertices (0, 1, and 2), with edges from 0
     * to 1 of weight 10, and from 0 to 2 of weight 20, printGraph() should print
     *
     * Vertex 0: (1, 10), (2, 20) Vertex 1: (0, 10) Vertex 2: (0, 20)
     */
    public void printGraph() {
        for(int i=0; i< mVertices.size();i++){
            WeightedNode n= mVertices.get(i);
            System.out.print("Vertex " + i + ": ");
            for(int j=0; j<n.mNeighbors.size(); j++) {
                WeightedEdge e = n.mNeighbors.get(j);
                //System.out.print("(" + e.mFirst.mIndex + "," + e.mSecond.mIndex + ","+ e.mWeight +")");
                if(e.mSecond.mIndex == i) {
                    System.out.print("(" + e.mFirst.mIndex + "," + e.mWeight + ")");
                }
                else
                    System.out.print("(" + e.mSecond.mIndex + "," + e.mWeight + ")");
            }
            System.out.println("");
        }
    }

    /**
     * Applies Prim's algorithm to build and return a minimum spanning tree for
     * the graph. Start by constructing a new WeightedGraph with the same number
     * of vertices as this graph. Then apply Prim's algorithm. Each time an edge
     * is selected by Prim's, add an equivalent edge to the other graph. When
     * complete, return the new graph, which is the minimum spanning tree.
     *
     * @return an UnweightedGraph representing this graph's minimum spanning
     * tree.
     */
    public WeightedGraph getMinimumSpanningTree() {
        // TODO: build and return the MST.
        WeightedGraph prim= new WeightedGraph(this.mVertices.size());
        HashSet<WeightedNode> markedVertices= new HashSet<WeightedNode>();
        markedVertices.add(this.mVertices.get(0));
        PriorityQueue<WeightedEdge> queue= new PriorityQueue<>(this.mVertices.get(0).mNeighbors);
        while(markedVertices.size() < prim.mVertices.size()){//Loops until size of marked vertices = # of vertices
            WeightedEdge min = queue.poll();
            while (markedVertices.contains(min.mFirst) && markedVertices.contains(min.mSecond)){//Checks for new unmarked vertices
                min= queue.poll();
            }
            WeightedNode addVertex= null;
            WeightedNode oldVertex= null;
            if(markedVertices.contains(min.mFirst))//Determines vertex to add to marked list
                addVertex = min.mSecond;
            else
                addVertex = min.mFirst;
            if(markedVertices.contains(min.mFirst))//Determines vertex to add for first in edge.
                oldVertex = min.mFirst;
            else
                oldVertex = min.mSecond;
            markedVertices.add(addVertex);
            prim.addEdge(oldVertex.mIndex , addVertex.mIndex , min.mWeight);
            queue.addAll(addVertex.mNeighbors);
        }

        return prim;
    }

    /**
     * Applies Dijkstra's algorithm to compute the shortest paths from a source
     * vertex to all other vertices in the graph. Returns an array of path
     * lengths; each value in the array gives the length of the shortest path
     * from the source vertex to the corresponding vertex in the array.
     */
    public double[] getShortestPathsFrom(int source) {
        // TODO: apply Dijkstra's algorithm and return the distances array.

        // This queue is used to select the vertex with the smallest "d" value
        // so far.
        // Each time a "d" value is changed by the algorithm, the corresponding
        // DijkstraDistance object needs to be removed and then re-added to
        // the queue so its position updates.
        PriorityQueue<DijkstraDistance> vertexQueue =
                new PriorityQueue<DijkstraDistance>();

        // Initialization: set the distance of the source node to 0, and all
        // others to infinity. Add all distances to the vertex queue.
        DijkstraDistance[] distances = new DijkstraDistance[mVertices.size()];
        distances[source] = new DijkstraDistance(source, 0);
        for (int i = 0; i < distances.length; i++) {
            if (i != source)
                distances[i] = new DijkstraDistance(i, Integer.MAX_VALUE);

            vertexQueue.add(distances[i]);
        }

        while (vertexQueue.size() > 0) {
            // Finish the algorithm.
        DijkstraDistance d = vertexQueue.poll();
            int x;
                WeightedNode n= mVertices.get(d.mVertex);
                for(int j=0; j< n.mNeighbors.size(); j++){
                    WeightedEdge e = n.mNeighbors.get(j);
                    Double len= d.mCurrentDistance + e.mWeight;
                    if(d.mVertex == e.mFirst.mIndex){//Gets correct index to replace
                        x= e.mSecond.mIndex;
                    }
                    else
                        x=e.mFirst.mIndex;
                    if(len < distances[x].mCurrentDistance){
                        distances[x].mCurrentDistance = len;
                    }
                }
        }
        double[] shortestPath = new double[distances.length];
        for (int i = 0; i < distances.length; i++)
            shortestPath[i] =  distances[i].mCurrentDistance;
        return shortestPath;
    }

    class DijkstraDistance implements Comparable {

        int mVertex;
        double mCurrentDistance;

        DijkstraDistance(int vertex, double distance) {
            mVertex = vertex;
            mCurrentDistance = distance;
        }

        @Override
        public int compareTo(Object other) {
            DijkstraDistance d = (DijkstraDistance) other;
            return Double.compare(mCurrentDistance, d.mCurrentDistance);
        }
    }

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("simpleGraph.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = scan.nextLine();
        int size= Integer.parseInt(line);
        int vertex= 0;
        WeightedGraph r = new WeightedGraph(size);
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            String set[]= line.split(" ");
            if(set.length >= 2) {
                for (int i = 0; i < set.length; i = i + 2) {
                    r.addEdge(vertex, Integer.parseInt(set[i]), Integer.parseInt(set[i+1]));
                }
            }
            vertex++;
        }
        Scanner cin = new Scanner(System.in);
        while(true){
            int input;
            Menu();
            input=cin.nextInt();
            switch(input){
                case 1:
                    r.printGraph();
                    break;
                case 2:
                    WeightedGraph mst1 = r.getMinimumSpanningTree();
                    mst1.printGraph();
                    break;
                case 3:
                    System.out.println("Enter a source vector from 0 to " + (size-1));
                    int src=cin.nextInt();
                    double[] distances = r.getShortestPathsFrom(src);
                    for (int i = 0; i < distances.length; i++) {
                        System.out.println("Distance from" + src + " to " + i + ": " +
                                distances[i]);
                    }
                    break;
                case 4: return;
                default:
                    ;
            }
        }
//        // Use this main to test your code by hand before implementing the program.
//        WeightedGraph g = new WeightedGraph(6);
//        g.addEdge(0, 1, 1);
//        g.addEdge(0, 2, 3);
//        g.addEdge(1, 2, 1);
//        g.addEdge(1, 3, 1);
//        g.addEdge(1, 4, 4);
//        g.addEdge(2, 3, 1);
//        g.addEdge(2, 5, 2);
//        g.addEdge(3, 4, 1);
//        g.addEdge(3, 5, 3);
//        g.addEdge(4, 5, 2);
//        g.printGraph();
//
//
//        double[] distances = g.getShortestPathsFrom(0);
//        for (int i = 0; i < distances.length; i++) {
//            System.out.println("Distance from 0 to " + i + ": " +
//                    distances[i]);
//
//        }
//
//        WeightedGraph mst = g.getMinimumSpanningTree();
//        System.out.println("Minimum spanning tree:");
//        mst.printGraph();

    }
    public static void Menu(){
        System.out.println("\tMenu \n1.Print Graph\n2.Print minimum spanning tree\n3.Print shortest paths");
    }
}
