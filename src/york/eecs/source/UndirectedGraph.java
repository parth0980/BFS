//Parth Barot , 216827107
package york.eecs.source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedGraph<T extends Comparable<T>> extends Graph<T> {

	private Map<T, Set<T>> graph;
	
	
	/**
	 *  This is the constructor.
	 *  Please do not change it.
	 */
	public UndirectedGraph() {
		this.graph = new HashMap<>();
	}
	
	
	/**
	 * @return true if graph is nonempty, false otherwise.
	 */
	public boolean isEmpty() {
		// TODO: Complete this method
		if(graph.size() == 0) 
			return true;
		// Hint: An empty graph contains zero vertices
		else
		return false; // this line needs to be rewritten 
	}

	
	
	/**
	 * @return the size (i.e. number of vertices) of this graph
	 */
	public int getSize() {
		// TODO: compute the size
		int a = graph.size();
		return a; // this line needs to be rewritten
	}
	
	
	
	/**
	 * Add a new vertex to the graph. A new vertex points
	 * to an empty set of adjacent vertices.
	 * 
	 * @param vertex: an object that is a new vertex in the graph
	 */
	public void addVertex(T vertex) throws VertexExistsException {
		// TODO: Complete this method  
		// Hints: If the vertex already exists, throw and exception
		//        Else, add a new pair to the graph hashmap:
		//        the vertex is the key, the value is an empty
		//        set of vertices.
		
		if(graph.containsKey(vertex))
		{
            throw new VertexExistsException("Already exist in the graph");

		}
		else
		{
			graph.put(vertex,new HashSet<T>());
		}
	}
	
	
	
	public List<T> getAdjacent(T vertex) {
		return new ArrayList<>(graph.get(vertex));
	}
	
	
	@Override
	public List<T> getVertices() {
		return graph.keySet().stream()
                .collect(Collectors.toList());
	}

	/**
	 * @param fromVertex one of vertices of this edge
	 * @param toVertex the other vertex of this egde
	 */
	public void addEdge(T fromVertex, T toVertex) {
		// TODO: Complete this method
		// Hint: Recall, both vertices already exist. Also,
		//       our graphs are not oriented, hence both edges
		//       need to be added.
		Set<T> initial = graph.get(fromVertex);
		Set<T>	finald = graph.get(toVertex);
		
		//assigning absent element  to the set
		initial.add(toVertex);
		finald.add(fromVertex);
		
		//adding values of set
		graph.put(fromVertex, initial);
		graph.put(toVertex, finald);
			
	}

	@Override
	 public String toString() {
        String answer = "Graph:\n";
        //Overriding the function 
        for (T vertex : graph.keySet()) {
            answer += "Vertex: " + vertex + " & Adjacent Vertices: " + graph.get(vertex) + "\n";
        }

        return answer;
    }
}
