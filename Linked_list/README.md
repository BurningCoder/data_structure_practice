
## linkedList
The class inlucdes serveral methods and three attributes.

Three attributes inlucdes URNode head, tail and int size.
Head is pointer to the first Node in the list, and tail is the pointer to the last elements in the list. 
Size indicated teh number of elements in the list.

public boolean add(Object o ) addes elements to the end of the list. It returns true when the element is added to the list successfully.
If list is empty, both head and tail pointer will point to the new elements. 
On the other way, the tail pointer will point to the new elements.

public void add(int index, Object element) addes element to specific position. When the size is less than index, the element will be added to the end of the list. 
If the list is empty, the elements will be added to the head node. 

public void bollean addAll(Collection c) add the list of elements to the end of the list. It return true when elements are successfully added to the list. 
The method will repeatedly call the boolean add(Object o) functions for every elements in collection c.

public boolean addAll(int index, Collection c) add the list of elements to the list, and the first element of the will be added at spefic position, index.
The method return true when elements are successfully added. 
The method repeatedly call the void add(int index, Object element) methods to add elements in specific elements.

public void clear() clear the list. 
It sets both head and tail pointer to null.

public boolean contains(Object o) check if o is in the list. 
It returns true when o is in the list. 
The function traverses the whole list with while loop until it find the o elements or it reaches the tail.

public E get(int index) return the value of specific position in the list.
It will return null when the index is larger than the list size.

public int indexOf(Object o) return the position first appearance of the elements.
If the elements does not find the elements, it will return -1

public boolean isEmpty return ture when the size is 0 and false otherwise.

public Iterator iterator() return a LinkedlistIterator

public boolean remove(Object o) return true when it successfully removes element o in the list.
The mehtods traverses the list from head and stop when the elements is found

public boolean remove(Collection c) it will return true when it succesfully removes all the elements from c in list.
It repeatedly calls the method remove(Object o)

public boolean containsAll(Collection c) it will return ture when all elements from c are in list.
it will return false otherwise. It traverses the list from the head pointer to the tail pointer. 

public void addFirst(E e) add the elements at the beginning fo the list.

public void addLast(E e) add the elements at the end fo the list

## URArrayList
The URArrayList class contains several methods and three attributes. The mainArray is a array contains elements, and length represents the length of the array.
And allocationSize represent the total capacity of the mainArray.

All method that add elements in the array will check the if array has capacity to hold additional elements. 
If the arary are full, reSize method will be called to enlarge the capacity.

contains, indexOf methods all iterate the mainArray to check if mainArray contain the element. 
Contains method return true if element is in the array or return false otherwise. 
IndexOf method return the position of the first position in the array, or return -1 if the array does not contain the element. 

for remove method, the method will find the position of the elements. And for each element after the target element will be moved down by 1.

### linkedListIterator and arrayLisIterator
These two classes are the iterators for URLinkedList and URArrayList.
### test.java
This is the testing class to the function of URLinkedList and URArrayList.



