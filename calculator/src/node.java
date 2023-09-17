public class node<E> {
    private E element; // Value for this node
    private node<E> n; // Reference to next node in list
    private node<E> p;
    // Constructors
    node(E it, node<E> inn, node<E> pre) {
        element = it;
        n = inn;
        p = pre;
    }
    node( node<E> inn, node<E> pre) {
        n = inn;
        p = pre;
    }
    // Get and set methods for the data members
    public E element() {
        return element;
    } // Return the value
    public E setElement(E it) {
        return element = it;
    } // Set element value
    public node<E> next() {
        return n;
    } // Return next link
    public node<E> setNext(node<E> nextval) {
        return n = nextval;
    } // Set next link
    public node<E> prev(){
        return p;
    }
    public node<E> setPrev(node<E> preval){
        return p = preval;
    }

}
