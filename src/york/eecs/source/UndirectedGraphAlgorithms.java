//Parth Barot , 216827107
package york.eecs.source;

import java.util.*;

public class UndirectedGraphAlgorithms<T extends Comparable<T>>
        implements GraphAlgorithms<T> {

    /**
     * Please implement BFS algorithm as described on the handout
     *
     * @param g:           a graph
     * @param initial:     the starting vertex of the path
     * @param destination: the destination vertex of the path
     * @return the path from initial to destination in the form of
     * an ArrayList of vertices, with initial as the first
     * element, and destination as the last element of the
     * ArrayList
     */
    public List<T> findBFSpath(Graph<T> g, T initial, T destination) {

        Queue<T> open = new LinkedList<>();
		open.add(initial);
        Map<T, T> mp = new HashMap<>();
        ArrayList<T> visited = new ArrayList<>();
        List<T> path = new ArrayList<>();
        T n,adjacentchild,adjacentparent;

		
		while (!open.isEmpty()) {
             n = open.remove();
          
            if (n == destination) {
                break;
            }
            

            for (T edgeVertex : g.getAdjacent(n)) {
                if (!visited.contains(edgeVertex)) {
                    open.add(edgeVertex);
                    mp.put(edgeVertex, n);
                    
                }
            }
        }
		
        path.add(destination);
		adjacentchild = destination;
		
		
		visited = new ArrayList<>();
	
		
		while(mp.containsKey(adjacentchild) && !visited.contains(adjacentchild))
		{
			 adjacentparent = mp.get(adjacentchild);
			visited.add(adjacentchild);
			adjacentchild = adjacentparent;
			if(!visited.contains(adjacentparent))
			{
				path.add(0,adjacentparent);
			}
		}
		
        return path;
    }

}