# lab6
Boyi Zhang urid:bzhang44

## treeNode
this class is the node for the binary search tree. Each node contains keys and the value. 
Nodes contain the pointers of left and right children. 
## bst
bst class implements UR_BST. the whole tree is constructed with the rule that the left node is less than its parent node, and right node is greater than its parent node.
All the methods traverse follows the rule to find the element. deletemin method traverse to the "most left" node in the tree and replace it with its right node. 
Deletemax method traverse to the "most right" node in the trees, and replace it with it's left node. 
## bstIterator
This class is the Iterator class for the bst, this Iterator will traverse the whole tree with inorder.
There is stack in the Iterator class, it will first push all the left node in the stack. When the next() is called, the stack will pop the current left node and push its right node and all the left nodes if right node it is not null.

## LevelIterator
This class is the Iterator class for the bst. The Iteration order for this iterator will be like BFS. The Iterator will traverse one level down and keep going down to the next level.
This class contains Queue. When the next() is called, method will put in the left and right node of the current node. 

## extra note:
UR_BST assign root and UR_Node class to be private and did not provide method to access these attributes. Therefore, I write treeNode class and add head, size attributes into the class.
