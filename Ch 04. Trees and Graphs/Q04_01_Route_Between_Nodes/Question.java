package Q04_01_Route_Between_Nodes;

import java.util.HashSet;
import java.util.LinkedList;

public class Question {

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static void main(String a[]) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[0];
        Node end = n[7];
        System.out.println(searchDFS(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        int n = 8;
        Node[] temp = new Node[n];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);
        temp[6] = new Node("g", 1);
        temp[7] = new Node("h", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        temp[6].addAdjacent(temp[7]);
        for (int i = 0; i < n; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean searchBFS(Graph graph, Node start, Node end) {
        // BFS
        LinkedList<Node> list = new LinkedList<Node>();
        for (Node node : graph.getNodes()) {
            node.state = State.Unvisited;
        }
        start.state = State.Visiting;
        list.add(start);
        Node node;
        while (!list.isEmpty()) {
            node = list.removeFirst();
            if (node != null) {
                for (Node subnode : node.getAdjacent()) {
                    if (subnode == end) {
                        return true;
                    } else {
                        subnode.state = State.Unvisited;
                        list.add(subnode);
                    }
                }
                node.state = State.Visited;
            }
        }
        return false;
    }
    
    public static boolean hasPathDFS(Graph graph, Node start, Node end, HashSet<Node> visited) {
        if (visited.contains(start)) {
            return false;
        }
        visited.add(start);
        if (start == end) {
            return true;
        }
        for (Node child : start.getAdjacent()) {
            if (hasPathDFS(graph,child,end,visited) == true) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean searchDFS(Graph graph, Node start, Node end) {
        // DFS
        HashSet<Node> visited = new HashSet<Node>();
        return hasPathDFS(graph,start,end,visited);
    }    
    
}
