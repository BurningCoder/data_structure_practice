

## hashNode
this class is the node for the has table. Each node contains its keys and nodes.

## hashTable
it exnteds from the UR_HashTable class. It contains methods that build up a hash table.
The hashFunction for the table is key%capcity of the hashTable. When collision occurs in the hashtable, the put function will put hte element in the next null index. 
delete and contains both traverse the whole mainArray to find the element. 
Resize function will be called to enlarge the hashTable when collision is over 1/3 of the capacity, or loadfactor is larger than 0.6.
The resize function will increase the capacity into two times of its size.

## keyIterator
provide a key Iterator to traverse the whole hashtable. 
## test class
For the test class, I first initialize the hashtable with array size of only 1. So I can check the resize method when I add elements to the hashtable.
Then I use keys() method to attain the iterator and print all the elements' values in hashtable. Then get,delete,contains methods are called to check. 

# extra note:
Due to a lot of attributes in UR_HashTable are private, and lab did not provide methods to access these private attributes, I write private mainArray maxCollision, size and minCap in the hashTable class. 