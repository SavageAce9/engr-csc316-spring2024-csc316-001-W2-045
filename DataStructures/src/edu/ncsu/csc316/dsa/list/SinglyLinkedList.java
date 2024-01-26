package edu.ncsu.csc316.dsa.list;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E>{

    /** A reference to the dummy/sentinel node at the front of the list **/
    private LinkedListNode<E> front;
    
    /** A reference to the last/final node in the list **/
    private LinkedListNode<E> tail;
    
    /** The number of elements stored in the list **/
    private int size;
        
    /**
     * Constructs an empty singly-linked list
     */     
    public SinglyLinkedList() {
        front = new LinkedListNode<E>(null);
        tail = null;
        size = 0;
    }
    
    public void add(int index, E value) {
    	if(index < 0 || index > size) {
    		throw new IndexOutOfBoundsException("Index out of bounds.");
    	}
    	
    	if(index == size) {
    		addLast(value);
    	}
    	else {
    		LinkedListNode<E> curr = front;
    		for(int i = 0; i < index; i++) {
    			curr = curr.getNext();
    		}
    		curr.setNext(new LinkedListNode<>(value, curr.getNext()));
    		size++;
    	}
    	
    }
    
    public void addLast(E element) {
    	LinkedListNode<E> newNode = new LinkedListNode<>(element);
    	if(size == 0) {
    		front.setNext(newNode);
    		tail = newNode;
    	}
    	else {
    		tail.setNext(newNode);
    		tail = newNode;
    	}
    	size++;
    	
    }
    public E get(int index) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Index out of bounds exception.");
    	}
    	LinkedListNode<E> curr = front.getNext();
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	return curr.getElement();
    	
    }
    public Iterator<E> iterator(){
    	
    	
    }
    public E last() {
    	if(size == 0) {
    		return null;
    	}
    	return tail.getElement();
    	
    }
    public E remove(int index) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Index out of bounds exception.");
    	}
    	LinkedListNode<E> curr = front;
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	E removeEle = curr.getNext().getElement();
    	curr.setNext(curr.getNext().getNext());
    	size--;
    	if(index == size) {
    		tail = curr;
    	}
    	return removeEle;
    	
    }
    public E set(int index, E value) {
    	if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Index out of bounds exception.");
    	}
    	LinkedListNode<E> curr = front.getNext();
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	E oldVal = curr.getElement();
    	curr.setElement(value);
    	return oldVal;
    }
    public int size() {
    	return size;
    }
    
    
    
    
    private static class LinkedListNode<E> {
        
        private E element;
        private LinkedListNode<E> next;
        
        public LinkedListNode(E ele) {
        	element = ele;
        	
        }
        public LinkedListNode(E ele, LinkedListNode<E> next) {
        	element = ele;
        	this.next = next;
        	
        }
        public E getElement() {
        	return element;
        }
        public void setElement(E element) {
        	this.element = element;
        }
        public LinkedListNode<E> getNext(){
        	return next;
        }
        
        public void setNext(LinkedListNode<E> next) {
        	this.next = next;
        }
        	
    }
    
    private class ElementIterator implements Iterator<E> {
        /**
         * Keep track of the next node that will be processed
         */
        private LinkedListNode<E> current;
        
        
        /**
         * Construct a new element iterator where the cursor is initialized 
         * to the beginning of the list.
         */
        public ElementIterator() {
            // TODO Your code here
        }

        @Override
        public boolean hasNext() {
            // TODO Your code here
        }

        @Override
        public E next() {
            // TODO Your code here
        }
         
        @Override    
        public void remove() {
    	    // DO NOT CHANGE THIS METHOD
            throw new UnsupportedOperationException(
                "This SinglyLinkedList implementation does not currently support removal of elements when using the iterator.");
        }
    }
    
}