package ex1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ex1.src.*;
class WGraph_AlgoTest {
	private WGraph_DS connectGraph() {
		WGraph_DS graph = new WGraph_DS();
		graph.addNode( 1);
		graph.addNode(2);
		graph.addNode(3);
		graph.connect(1, 3, 10);
		graph.connect(1, 2, 1);

		graph.connect(2, 3, 1);
		graph.connect(3, 1, 10);
		return graph;
	}

	private WGraph_DS notConnectGraph() {
		WGraph_DS graph = new WGraph_DS();
		graph.addNode( 1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.connect(1, 3, 1);
		graph.connect(1, 2, 1);


		return graph;
	}


	@Test
	void testInit() {
		 weighted_graph g0 = new WGraph_DS();
	        g0.addNode(0);
	        g0.addNode(1);
	        g0.addNode(1);
		weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(g0);
        assertEquals(g0, ag0.getGraph());
	}

	@Test
	void testGetGraph() {
		 weighted_graph g0 = new WGraph_DS();
	        g0.addNode(0);
	        g0.addNode(1);
	        g0.addNode(1);
		weighted_graph_algorithms ag0 = new WGraph_Algo();
     ag0.init(g0);
     assertEquals(g0, ag0.getGraph());
	}

	@Test
	void testCopy() {
		weighted_graph g0 = new WGraph_DS();
        g0.addNode(0);
        g0.addNode(1);
        g0.addNode(1);
	weighted_graph_algorithms ag0 = new WGraph_Algo();
 ag0.init(g0);
     
 assertEquals(g0, ag0.getGraph());
	}

	

	@Test
	void testIsConnected() {
		WGraph_DS conGraph = connectGraph();//
		WGraph_DS NConGraph = notConnectGraph();

		WGraph_Algo algo = new   WGraph_Algo();
		algo.init(conGraph);
		assertEquals(true, algo.isConnected());
		algo.init(NConGraph);
		assertEquals(false, algo.isConnected());
	}

	@Test
	void testShortestPathDist() {
		WGraph_DS graph = new WGraph_DS();
		graph.addNode(1);
		graph.addNode(2);
		graph.connect(1, 2, 3);
		WGraph_Algo algo = new   WGraph_Algo();
		algo.init(graph);
		double dist = algo.shortestPathDist(1, 2);
		assertEquals(3, dist);

		graph = connectGraph();
		algo.init(graph);
		dist = algo.shortestPathDist(1, 3);
		assertEquals(2, dist);
	}

	@Test
	void testShortestPath() {
		WGraph_DS graph = new WGraph_DS();
		graph.addNode(1);

		graph.addNode(3);
		graph.addNode(4);

		graph.connect(1, 3, 5);
		graph.connect(3, 4, 5);
		graph.connect(4, 1, 17);

		graph.addNode(2);
		graph.connect(1, 2, 70);
		graph.connect(2, 3, 10);
		WGraph_Algo algo = new   WGraph_Algo();
		algo.init(graph);
		List<node_info> l = algo.shortestPath(1, 3);
		ArrayList<Integer> m= new ArrayList<Integer>();
		m.add(1);
		m.add(3);
		
		System.out.println(l.get(0).getKey());
		assertEquals((int)m.get(0),l.get(0).getKey());
		assertEquals((int)m.get(1), l.get(1).getKey());
		
	}

	@Test
	void testSaveload() {
		WGraph_DS graph = new WGraph_DS();
		graph.addNode(1);

		graph.addNode(3);
		graph.addNode(4);

		graph.connect(1, 3, 5);
		graph.connect(3, 4, 5);
		graph.connect(4, 1, 3);

		graph.addNode(2);
		graph.connect(1, 2, 70);
		graph.connect(2, 3, 10);
        weighted_graph_algorithms ag0 = new WGraph_Algo();
        ag0.init(graph);
        String str = "g0.obj";
        ag0.save(str);
        WGraph_DS g1 = new WGraph_DS();
		g1.addNode(1);

		g1.addNode(3);
		g1.addNode(4);

		g1.connect(1, 3, 5);
		g1.connect(3, 4, 5);
		g1.connect(4, 1, 3);

		g1.addNode(2);
		g1.connect(1, 2, 70);
		g1.connect(2, 3, 10);
        ag0.load(str);
              assertEquals(graph, g1);
              
	}

	

}
