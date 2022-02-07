//Parth Barot , 216827107
package york.eecs.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import york.eecs.source.Graph;
import york.eecs.source.UndirectedGraph;
import york.eecs.source.UndirectedGraphAlgorithms;
import york.eecs.source.VertexExistsException;

public class StudentTest   {

	 /**
	  * TODO: Please write at least 5 test cases for testing @UndirectedGraph.
	  * TODO: Please write at least 5 test cases for testing @UndirectedGraphAlgorithms.
	  */
	
	UndirectedGraph udg;
	UndirectedGraphAlgorithms udga;
    		
    		@Before
    		public void setUp() throws Exception {
    		
    			 udg = new UndirectedGraph();
        		 udga = new UndirectedGraphAlgorithms();
        		
    		}

    		@After
    		public void tearDown() throws Exception {
    		}
    		
    		
    		@Test
        	public  void checkisEmpty() throws VertexExistsException //checks initial size of the graph 
        	{
    			
    			udg.getSize();
    			assertTrue(udg.getSize() == 0);    			
    			
        	}
    		
    		
    		@Test
        	public  void checkisEmpty2() throws VertexExistsException //checks initial size of the graph 
        	{
    			
    			udg.addVertex("A");
    			udg.getSize();
    			assertTrue(udg.getSize() == 1); 
    			assertFalse(udg.getSize() != 1);
        	}
    		
    		
    		@Test
    		public void checksize() throws VertexExistsException //checks if the getSize function is working correclty
    		{
    			
    			int a=udg.getSize();
    			udg.addVertex("A");
    			udg.addVertex("B");
    			int b=udg.getSize();
    			assertTrue(b == 2);
    		}
    		
    		
    		@Test
    		public void check1size() throws VertexExistsException //checks if the getSize function is working correclty
    		{
    			
    			int a=udg.getSize();
    			int b=udg.getSize();
    			assertTrue(b == 0);
    		}

    		@Test
    		public void check2size() throws VertexExistsException //checks if the getSize function is working correclty
    		{
    			udg.addVertex("A");
    			udg.addVertex("C");
    			int b=udg.getSize();
    			assertFalse(b == 0);
    			assertTrue(udg.isEmpty() == false );
    		}

    		
    		@Test
    		public void checkaddVertex() throws VertexExistsException
    		{
    			
    			int a=udg.getSize();
    			List<String> list = new LinkedList<>();
    			list.add("A");
    			list.add("B");
    			udg.addVertex("A");
    			udg.addVertex("B");
    			
    			assertEquals(list.toArray(),udg.getVertices().toArray() );
    			
    		}
    		
    		@Test
    		public void checkaddVertex2() throws VertexExistsException
    		{
    			
    			int a=udg.getSize();
    			List<String> list = new LinkedList<>();
    			list.add("A");
    			list.add("B");
    			list.add("C");
    			udg.addVertex("A");
    			udg.addVertex("B");
    			udg.addVertex("C");
    			
    			assertEquals(list.toArray(),udg.getVertices().toArray() );
    			
    		}
    		
    		@Test
    		public void checkaddVertex3() throws VertexExistsException
    		{
    			
    			int a=udg.getSize();
    			List<String> list = new LinkedList<>();
 
    			assertTrue(udg.isEmpty());
    			
    		}
    		
    		
    		
    		@Test
    		public void testBFS() throws VertexExistsException{ //BFS Tester
    			UndirectedGraph<String> ug = udg;
    			
    				ug.addVertex("A");
    				ug.addVertex("B");
    				ug.addVertex("C");
    				ug.addVertex("D");;
    				ug.addEdge("A", "B");
    				ug.addEdge("A", "C");
    				ug.addEdge("C", "D");
    			
    			List<String> result = (ArrayList<String>) udga.findBFSpath(ug, "A", "D");
    			List<String> expected = new ArrayList<>();
    			expected.add("A");
    			expected.add("C");
    			expected.add("D");
    			assertEquals(result, expected);
    		}
    		
    		@Test  
    		public void testBFS2() throws VertexExistsException{ //BFS Tester 2
    			UndirectedGraph<String> ug = udg;
    			
    				ug.addVertex("A");
    				ug.addVertex("B");
    				ug.addVertex("C");
    				ug.addEdge("A", "B");
    				ug.addEdge("A", "C");
    				ug.addEdge("C", "B");
    			
    			List<String> result = (ArrayList<String>) udga.findBFSpath(ug, "A", "C");
    			List<String> expected = new ArrayList<>();
    			expected.add("A");
    			expected.add("B");
    			expected.add("C");
    			assertEquals(result, expected);
    		}
}
