package Graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class WeightedGraph {
	 // Creating a Hash-Map
	 static HashMap<Integer, String> map = new HashMap<>();
	 
	 static class Edge {
		 int source;
		 int destination;
		 int cost;
		 int distance;
		 int duration;
		
		 public Edge(int source, int destination, int cost, int distance, int duration) {
			 this.source = source;
			 this.destination = destination;
			 this.cost = cost;
			 this.distance = distance;
			 this.duration = duration;
		 }
	 }

	 static class Graph {
		 int vertices;
		 LinkedList<Edge> [] adjacencylist;
		
		 Graph(int vertices) {
			 this.vertices = vertices;
			 adjacencylist = new LinkedList[vertices];
			 //initialize adjacency lists for all the vertices
			 for (int i = 0; i <vertices ; i++) {
				 adjacencylist[i] = new LinkedList<>();
			 }
		 }
		
		 public void addEgde(int source, int destination, int cost, int distance, int duration) {
			 Edge edge = new Edge(source, destination, cost, distance, duration);
			 adjacencylist[source].addFirst(edge); //for directed graph
		 }
		
		 public void printGraph(){
			 for (int i = 0; i <vertices ; i++) {
				 LinkedList<Edge> list = adjacencylist[i];
				 for (int j = 0; j <list.size() ; j++) {
					 System.out.println("vertex-" + map.get(list.get(j).source) + " is connected to " +
					 map.get(list.get(j).destination) + " with cost " + list.get(j).cost 
					 + " with distance " + list.get(j).distance + " with duration " + list.get(j).duration);
				 }
			 }
		 }
	 }
	 public static void main(String[] args) {
		 
		 // To initialize Graph
		 int vertices = 20;
		 Graph graph = new Graph(vertices);
		 
		 map.put(1, "DEL");
		 map.put(2, "BOM");
		 map.put(3, "BLR");
		 map.put(4, "HYD");
		 map.put(5, "CCU");
		 map.put(6, "MAA");
		 map.put(7, "AMD");
		 map.put(8, "GOI");
		 map.put(9, "PAT");
		 map.put(10, "COK");
		 map.put(11, "LKO");
		 map.put(12, "GAU");
		 map.put(13, "PNQ");
		 map.put(14, "JAI");
		 map.put(15, "SXR");
		 map.put(16, "BBI");
		 map.put(17, "IXB");
		 map.put(18, "VNS");
		 map.put(19, "IXC");
		 map.put(20, "IXR");
		 
		 graph.addEgde(5, 1, 4, 0, 1);
		 graph.addEgde(7, 2, 3, 0, 1);
		 graph.addEgde(1, 3, 2, 0, 1);
		 graph.addEgde(1, 2, 5, 0, 1);
		 graph.addEgde(2, 3, 7, 0, 1);
		 graph.addEgde(3, 4, 2, 0, 1);
		 graph.addEgde(4, 0, 4, 0, 1);
		 graph.addEgde(4, 1, 4, 0, 1);
		 graph.addEgde(4, 5, 6, 0, 1);
		 graph.printGraph();
	 }
}