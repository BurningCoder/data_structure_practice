# Huffman_Coding
## hufNode
hufNode clas is the basic node class for the huffman compression tree. It includes attributes, cap, ascii code, huffCode, left and right child.
## nodeHolder
this is a hashMap storing huffmanNode. This HashMap allows other method to quickly access HuffmanNode based on their ascii code. 
## nodeArrayList
this is a ArrayList storing huffmanNode. This nodeArrayList can maintain the priority order during tree building.

## encode
this main method first read in all char in the inputFile into huffmanNode. Then huffmanNode will be constructed into tree based on their cap value. I assign that the left subtree of the node is 0, and right subtree of the node is 1.
Then the method traverse down from root to every leaf to assign huffmanCode to each ascii code. Then output the hashcode based on its corresponding ascii code in the input file and the frequency file. 

## decode
this main method first read through the frequency file to construct the huffmanCompression tree. Then based on the compression file, the method output the corresponding ascii code when traverse the tree.

## prob in BinaryIn, BinaryOut and Huffman Interface
according to the project requierment, I can only submit HuffmanSubmit.java and README file. However, the main code in the HuffmanSubmit require BinaryIn.java, BinaryOut.java and Huffman.java. So the submitted source code is unrunnable if BinaryIn.java, BinaryOut.java and Huffman.java is provided in the source code file. 
