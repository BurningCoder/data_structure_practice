# street_Mapping
Boyi Zhang
bzhang44@u.rochester.edu

In the main.java file, it first takes in the name of the data set with In.java. Then turn all the latitude and longitude of the node into node. And node class include an arraylist that contains all edges connected to the node. Then the dijkstra algorithm works to find the shortest way. The dijkstra algorithm is a kind of greedy algorithm
It always takes the shortest distance as the starting part. For the graphing part, the algorithm will traverse the whole hashtable that contains all node, and draw every edge connected to the node.

### Command line arguments
The sample command will be 
java main map.txt --show --directions start end
the output will be the node from the start point to the end point and the total distance.
## file
### Node.java
Node class is the basic node fo the whole map. It includes attributes, point's latitude, longitude, name and the list of edges connected to the point. A queue storing all the edges connected to the points allow later map drawing to traverse all the edges.
### Edge.java
Edge class is the edge for the whole map. It contains the name of two points and the distance of the path calculated by the Haversine formula.
The Haversine formula method is based on code on website: https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/.
### DijkstraNode.java
DijkstraNode class extends from the Node class. It has additional attributes parent and shortestD.
### Line.java
Line class is the line when exporting the graph of the map. It includes point's latitude and longitude.
### drawingCanvas.java
drawingCanvas class extends the JComponent class, it contains all the line from the map. 
### Mapping.java
Mapping extends from the JFrame class. It draws the map based on the input Map(a HashMap containing all the points). The default window size is 500*500.
Mapping also implements ComponentListener in order to attain the change of the window size.
Every time window size is change the Mapping will redraw the whole map to rescale the map to the window size.
### In.java
This class is written by Robert Sedgewick and Kevin Wayne. More detailed citation is included in the class. 
This class reads the txt file into string.
### main.java
this is the main method of the street_Mapping project, it takes in the file and exports the file as a map. 
In this file, dijkstra method calculate the shortest distance from starting point to other points in the map.
## runtime analysis
### map plotting
this algorithm will traverse each node and each edge. V represents number of node in the map. E represents number of edges in the map. So the plotting Map is expected to have runtime of O(V+E).
### dijkstra
Let E represents number of edges in the map. And V represents number of node in the map. This algorithm will traverse all the node in the map, and all the edges connected to the node.
The time for processing all the node require V operation.
And the maximum edge that conencted to the node is E. Since I did not use min heap data structure to store all nodes, time used for update distance is 1. But each time finding smallest distance node will require V.
Therefore, the time complexity is O(V(E+V)). However, the average performance will be better, since the program will stop as soon as the Target ID is in the Visited Map instead of traversing all nodes and edges.


