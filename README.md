This project is an initial part of a project in the style of the "waze" application or maybe pokemon game?.
With the help of this project you will be able to represent unweighted graphs with the help of nodes and weights more efficiently.
You can also initialize graphs you have built from a file and initialize them from an existing file. Object type.
And you can also get algorithmic information about your graph even if it is very large such as Is it a link?, What is the shortest distance between two points? And through these nodes passes this route.
Among other things, you can find an implementation in java of the Dykstra algorithm
In stage 1 , we characterize 3 interfaces that represent a node-info, a weghted graph with weighted edges  weghited  graph algorithems  
 and a graph of algorithms, and two classes that implement the specified interfaces, respectively  the class WGraphDS its for two interfaces(node it inner class that interfare node-info) 	
  *Details of the information in each class and in each function can be seen in the documentation attached to the code*

.

We implemented the WDsGraph class using a 2 hasmap that the first contains integer keys that represent the number of node in  graph and values ??of an node-info type
and the second contains integer keys that represent the number of node and the    values they inner hashmap with keys of id negibhors and th value its dooble ssay  the edge whgiet.    
And with the help of search efficiency and other functions in this data structure. We implemented the various functions in the class more efficiently

The WGrapAlgo class , which allows you to initialize a graph and check various things in it, such as a short distance between two points and their tracks each to other, checking the tying of the graph, etc. 
We implemented this with the help of a "dikstra" function which is a well-known algorithm that helped us check connecting and find a short distance and trajectory between two nodes
in weighted gerph.
distance - Keeps each node its distance from the node being tested.


