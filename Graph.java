import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Graph {
    //Vertex inner class
    class Vertex{
        String label;
        Vertex(String label){
            this.label = label;
        }
    }
    //member variables
    private Map<Vertex, List<Vertex>> adjVertices;
    //addVertex
    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    //removeVertex
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }
    //addEdge
    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    //removeEdge
    //createGraph
    //getAdjVertices
    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
}