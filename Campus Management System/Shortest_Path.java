package final_;
// Feature 3
class Edge {
	int source, destination, wieght;
	
	public Edge(int src, int dest, int w) {
		this.source = src;
		this.destination = dest;
		this.wieght = w;
	}
}

public class Shortest_Path {
	int vertex, edge;
	int[][] graph; // Dijkstra
	Edge[] edges;  // Bellman
	
	public Shortest_Path(int V, int E){
		this.vertex = V;
		this.edge = E;
		this.edges = new Edge[E];
		this.graph = new int[V][V];
	}
	
	public void addEdge(int index, int u, int v, int w) { // O(1)
		edges[index] = new Edge(u, v, w);
		graph[u][u] = w;
		graph[u][v] = w;
	}
	
	public boolean negative_edges() { // O(# of edges)
		for(Edge edge : edges) {
			if(edge.wieght < 0) {
				return true;
			}
		}
		return false;
	}
	
	// Dijkstra
	public void dijkstra(int start) { // O(|V|²)
		int[] distance = new int[vertex];
		boolean[] visited = new boolean[vertex];
		
		for(int i = 0 ; i < vertex ; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		distance[start] = 0;
		
		for(int count = 0 ; count < vertex - 1 ; count++) {
			int u = min_distance(distance, visited);
			visited[u] = true;
			for(int v = 0 ; v < vertex ; v++) {
				if(!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
			System.out.println("Shortest path:");
			displayDistance(distance, start);
		}
	}
	
	private int min_distance(int[] distance, boolean[] visited) { // O(|V|)
		int min = Integer.MAX_VALUE, index = -1;
		for(int i = 0 ; i < vertex ; i++) {
			if(!visited[i] && distance[i] <= min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	// Bellman Algorithm
	public void bellman_ford(int start) {
		int[] distance = new int[vertex];
		for(int i = 0 ; i < vertex ; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		for(int i = 1 ; i < vertex ; i++) {
			for(int j = 0 ; j < edge ; j++) {
				int u = edges[j].source, v = edges[j].destination, w = edges[j].wieght;
				if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
					distance[v] = distance[u] + w;
				}
			}
		}
		
		for(int j = 0 ; j < edge ; j++) {
			int u = edges[j].source, v = edges[j].destination, w = edges[j].wieght;
			if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
				System.out.println("There is negative weight cycle!!!");
				return;
			}
		}
		
		System.out.println("Shortest path:");
		displayDistance(distance, start);
	}
	
	private void displayDistance(int[] distance, int start) { // O(|V|)
		System.out.println("Distance from " + start + ": ");
		for(int i = 0 ; i < distance.length ; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("To " + i + " => infinite");
			} else {
				System.out.println("To " + i +" => " + distance[i]);
			}
		}
	}
	
	public void autoSelect_Algorithm(int source) {
		if(negative_edges()) {
			bellman_ford(source);
		} else {
			dijkstra(source);
		}
	}
	
}
