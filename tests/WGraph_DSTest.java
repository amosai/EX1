package ex1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


import ex1.src.*;


class WGraph_DSTest {
	
	@Test
	void testWGraph_DS() {
		
		//fail("Not yet implemented");
	}

	@Test
	void testGetNode() {
		 weighted_graph g = new WGraph_DS();
		g.addNode(0);
		 try {
			 	 node_info i= g.getNode(0);
			 
			 	assertEquals(0, i.getKey());
			} catch (Exception e) {
				
			}
	
		
	}

//	@Test
//	void testEqualsObject() {
//		//fail("Not yet implemented");
//	}

	@Test
	void testHasEdge() {
		
		WGraph_DS a=new WGraph_DS();
		a.addNode(1);
		a.addNode(2);
		a.addNode(3);
		a.connect(1, 2, 12);
		
		assertFalse(!a.hasEdge(1, 2));
		assertFalse(!a.hasEdge(2, 1));
		assertFalse(a.hasEdge(3, 1));
		assertFalse(a.hasEdge(1, 3));//
		assertFalse(a.hasEdge(1, 4));//4 not in graph
		
	}

	@Test
	void testGetEdge() {
		WGraph_DS a=new WGraph_DS();
		a.addNode(1);
		a.addNode(2);
		a.addNode(3);
		a.connect(1, 2, 12.7);
		assertEquals(12.70, a.getEdge(1,2));
		assertEquals(12.7, a.getEdge(2,1));
		assertEquals(-1, a.getEdge(1,3));///not have edge between but the nodes in graph
		assertEquals(-1, a.getEdge(1,4));/// the 4 node not in graph
	}

	@Test
	void testAddNode() {
		WGraph_DS a=new WGraph_DS();
		a.addNode(1);
		a.addNode(2);
		a.addNode(1);
		assertEquals(2, a.nodeSize());
		a.removeNode(1);
		assertEquals(1, a.nodeSize());
		//a.nodeSize();
	}

	@Test
	void testConnect() {
		WGraph_DS a=new WGraph_DS();
		a.addNode(1);
		a.addNode(2);
		a.connect(1, 2, 12.7);
		a.connect(1, 2, 12.7);
		assertEquals(2, a.nodeSize());
		
		a.connect(1, 2, 12.7);
		assertEquals(2, a.nodeSize());
		a.removeNode(1);
		assertEquals(1, a.nodeSize());
	}

	@Test
	void testGetV() {
		  weighted_graph g = new WGraph_DS();
	        g.addNode(0);
	        g.addNode(1);
	        g.addNode(2);
	        g.addNode(3);
	        g.connect(0,1,1);
	        g.connect(0,2,2);
	        g.connect(0,3,3);
	        g.connect(0,1,1);
	        Collection<node_info> v = g.getV();
	        Iterator<node_info> iter = v.iterator();
	        while (iter.hasNext()) {
	            node_info n = iter.next();
	            assertNotNull(n);
	        }
	}

	@Test
	void testGetVInt() {
		weighted_graph g = new WGraph_DS();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.connect(0,1,1);
        g.connect(0,2,2);
        g.connect(0,3,3);
        g.connect(0,1,1);
        Collection<node_info> v = g.getV(0);
        Iterator<node_info> iter = v.iterator();
        while (iter.hasNext()) {
            node_info n = iter.next();
            assertNotNull(n);
        }
	}

	@Test
	void testRemoveNode() {
		 weighted_graph g = new WGraph_DS();
	        g.addNode(0);
	        g.addNode(1);
	        g.addNode(2);
	        g.addNode(3);
	        g.connect(0,1,1);
	        g.connect(0,2,2);
	        g.connect(0,3,3);
	    
	        g.removeNode(4);
	       
	      
	        g.removeNode(0);
	        
	        assertFalse(g.hasEdge(1,0));
	        int e = g.edgeSize();
	        
	        assertEquals(0,e);
	       
	        assertEquals(3,g.nodeSize());
	        
	}

	@Test
	void testRemoveEdge() {
		 weighted_graph g = new WGraph_DS();
	        g.addNode(0);
	        g.addNode(1);
	        g.addNode(2);
	        g.addNode(3);
	        g.connect(0,1,1);
	        g.connect(0,2,2);
	        g.connect(0,3,3);
	        g.removeEdge(0,3);
	        double w = g.getEdge(0,3);
	        assertEquals(w,-1);
	}

	@Test
	void testNodeSize() {
		 weighted_graph g = new WGraph_DS();
		g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(0);
        g.connect(0,1,1);
        assertEquals(3, g.nodeSize());
	}

	@Test
	void testEdgeSize() {
		 weighted_graph g = new WGraph_DS();
		g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(0);
        g.connect(0,1,1);
        assertEquals(1, g.edgeSize());
	 g.connect(0,1,5);
    g.connect(0,2,2);
    g.connect(0,3,3);
    g.removeEdge(0,3);
    assertEquals(2, g.edgeSize());
	}

	@Test
	void testGetMC() {
		weighted_graph g = new WGraph_DS();
		   g.addNode(0);
	        g.addNode(1);
	        g.addNode(2);
	        g.addNode(3);
	        g.connect(0,1,1);
	        g.connect(0,2,2);
	        g.connect(0,3,3);
	        g.removeEdge(0,3);
	        assertEquals(8, g.getMC());
	        
	}

}
