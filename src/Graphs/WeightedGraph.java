package Graphs;

import java.util.LinkedList;

public class WeightedGraph {
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
					 System.out.println("vertex-" + i + " is connected to " +
					 list.get(j).destination + " with cost " + list.get(j).cost 
					 + " with distance " + list.get(j).distance + " with duration " + list.get(j).duration);
				 }
			 }
		 }
	 }
	 public static void main(String[] args) {
		 int vertices = 6;
		 Graph graph = new Graph(vertices);
		 graph.addEgde(0, 1, 4, 0, 1);
		 graph.addEgde(0, 2, 3, 0, 1);
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
