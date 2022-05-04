package Graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class WeightedGraph {
	 // Creating a Hash-Map
	 static HashMap<Integer, String> map = new HashMap<>();
	 
	 // To initialize Graph
	 static int vertices = 20;
	 static Graph graph = new Graph(vertices);
	 
	 static LinkedList<Edge> [] adjacencylist;
	 
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
	 
	 public class Dijkastra {
		 int Min_Distance(int dist[], Boolean sptSet[]) {
			 
			 // We first initialize min values
			 int min = Integer.MAX_VALUE, min_index = -1;
			 
			 for(int v=0; v<vertices; v++) {
				 if(sptSet[v] == false && dist[v] <= min) {
					 min = dist[v];
					 min_index = v;
				 }
			 }
			 
			 return min_index;
		 }
		 
		 void Dijkstra(int source) {
			 
			 // Array to hold shortest distance from source to ith node
			 int dist[] = new int[vertices];
			 
			 //sptSet[i] will be true when a node is included in shortest path tree 
			 //or if shortest distance from source to ith index is finalized
			 Boolean sptSet[] = new Boolean[vertices];
			 
			 // Initially we will initialize all distances as INFINITE
			 // and sptSet[] array as false
			 for(int i=0; i<vertices; i++) {
				 dist[i] = Integer.MAX_VALUE;
				 sptSet[i] = false;
			 }
			 
			 // Setting distance from source to itself as ZERO
			 dist[source] = 0;
			 
			 // Now finding shortest path for all vertices
			 for(int i=0; i<vertices; i++) {
				 // Now we pick up minimum distance vertex from the set of vertices
				 int u = Min_Distance(dist, sptSet);
				 
				 // Now we mark the picked vertex as true as it is used
				 sptSet[u] = true;
				 
				 LinkedList<Edge> list = adjacencylist[i];
				 for (int j = 0; j <list.size() ; j++) {
					// Update dist[v] only if is not in sptSet, there is an
                	// edge from u to v, and total weight of path from src to
	                // v through u is smaller than current value of dist[v]
	                
				 }
				 
			 }
			 
			 
		 }
		 
		 void LeastDistance(int source, int destination) {
			 
		 }
		 
		 void LeastCost(int source, int destination) {
			 
		 }
		 
		 void LeastDuration(int source, int destination) {
			 
		 }
	 }
	 
	 public static void main(String[] args) {
		 
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