## Heap
Heap implements Heap. Heap is a minimum heap in order to become a priority queue. The heap class has three attributes, mainArray, size, capacity.
Two main method to main the heap is the minimum heap is bubble up and bubble down. Bubble up help to add new elements to the heap. Every time insert is called, new element is added to the end of the array.
Then bubble up method is called to traverse up the tree to find the correct position for the node. 
bubble down help to turn new a random array into priority queue, or maintain minimum heap when the top of the heap is popped. The method will let the top of the heap traverse down the tree, swapping heap and its biggest children.
