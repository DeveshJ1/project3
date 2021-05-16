package project3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Object;
/**
 * 
 * @author Devesh
 *First create the necessary fields and variables for the doubly linkedlist.
 *this includes the generic node class, the constructor for the node, and
 *the constructor  and member variables for the doubly linkedlist. 
 * 
 */
public class DoublyLinkedList<E> implements Iterable<E>
{
	private class Node<E>
	{
		public E data;
        public Node<E> next;
        public Node<E> prev;
   
        public Node (E data) 
        {
            if (data == null ) 
                throw new NullPointerException("list does not allow null elements");
            this.data = data;
            this.next = null; 
            this.prev=null;
        }
	}
	private Node<E> head;
    private Node<E> tail; 
    private int size; 
	public DoublyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
	/**
	 * 
	 * @author Devesh
	 * inner class implementing an iterator for this list
	 * creates two methods hasNext() and next() for operations
	 * useful to the iterator.
	 *
	 */
	private class Itr implements Iterator<E> 
	{
        private Node<E> current = head;
        public boolean hasNext() 
        {
            return current != null;
        }
        public E next()
        {
            E tmp = current.data;
            current = current.next;
            return tmp;
        }
    }
	/**
	 * @author Devesh
	 * getter for the node of the doubly linkedlist.
	 * This is useful so when needing to iterate over the linked list
	 * for ex: in remove in order to access the element before the one to remvove
	 * to get to that specific node position that is known
	 * we can just call this getter method instead of writing an iterator. 
	 * @param index
	 * @return the node in that index. 
	 */
	public Node<E> getNode(int index)
	{
        if(index<0 || index>=size)
        {
            throw new NoSuchElementException();
        }
        Node<E> current= head;
        for(int i=0;i<index;i++)
        {
            current=current.next;
        }
        return current;

    }
	/**
	 * @author Devesh
	 * Appends the specified element to the end of this list. 
	 * Returns true if this list changed as a result of the call. Returns false if the specified element is null.
	 * @param e= element to be appended to this list
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this list
	 */
	
	public boolean add(E e) throws ClassCastException
	{
		if(e==null)
			return false;
		
		Node<E> n=new Node<E>(e);
		if (head==null) 
		{
			head=n;
			tail=n;
			size++;
			return true;
		}
		else
		{
		Node<E> tailRef= tail;
		tailRef.next=n;
		n.prev=tailRef;
		tail=n;
		size++;
		return true;
		}	
	}
	/**
	 * @author Devesh
	 * Adds an element 'it' at position pos, shifts elements starting at pos by
	 * one position to the right (higher position values). 
	 * @return true, if the list has been modified as a result of this 
	 * operation, false, otherwise 
	 * @param e-element to be added to this list
	 * @throws ClassCastException if the class of the specified element prevents it from being added to this list
	 * @throws IndexOutOfBounds if pos < 0 or pos > size
	 * 
	 */
	public boolean add(E e, int pos) throws ClassCastException, IndexOutOfBoundsException 
	{
		if (pos < 0 || pos > size) 
		{
            throw new IndexOutOfBoundsException("invalid position given");
        }
		if(e==null) 
		{
			return false;
		}
		int counter = 0;
        Node<E> n = new Node<E>(e);
        if(size == 0)
        {
            head=n;
            tail=n;
            size++;
            return true; 
        }
        else if(pos==0)
        {
        	Node<E> headRef=head;
        	headRef.prev=n;
            n.next=head;
            head=n;
            size++;
            return true;
            
        }
        else if (pos==size) {
        	add(e);
        }
        else 
        {
        	 Node<E> current = head;
        	  while (counter < pos-1) 
        	  {  
        		  current=current.next;
        		  counter++;
        	  }
        	  n.next=current.next;
        	  current.next=n;
        	  n.prev=current;
        	  n.next.prev=n;
        	  size++;
        	  return true;
        }
        return true;
		
	}
	/**
	 * @author Devesh
	 * Removes all of the elements from this list. The list will be empty after this call returns.
	 */
	/**public void clear() {
		Node<E> current = head;
		while(current != null)
		{
		Node<E> node = current.next;
		current.next = current.prev = null;
		current = node;
		}
		size = 0;

		 
	}*/
	public void clear() 
	{
		head = null;
		tail=null;
        size = 0;

		 
	}
	/**
	 * @author Devesh
	 * 
	 * @param o-element whose presence in this list is to be tested
	 * @return true  if this list contains the specified element.
	 */
	public boolean contains(Object o)
	{
		if (this == o )  return true;
        if (o == null )  return false;
        Node<E> current= head;
        for(int i=0; i<size;i++) 
        {
        	if(current.data.equals(o)) 
        	{
        		return true;
        	}
        		current=current.next;
        }
        return false;
     
	}
	/**
	 * @author Devesh
	 * Compares the specified object with this list for equality.
	 * @param o- the object to be compared for equality with this list
	 * @returnReturns true if and only if the specified object is also an instance of a DoublyLinkedList , 
	 * both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
	 */
	public boolean equals​(Object o)
	{
		if (this == o )  return true;
	    if (o == null )  return false;
	    if (! ( o instanceof DoublyLinkedList<?> ) )  return false;
	   DoublyLinkedList<?> other = (DoublyLinkedList<?> ) o;
	    if (this.size != other.size )  return false;  
	    Iterator<E> thisItr = this.iterator(); 
	    Iterator<?> otherItr = other.iterator(); 
	    while (thisItr.hasNext() && otherItr.hasNext() )
	    {
	    	if ( !(thisItr.next().equals(otherItr.next() ) ) )
	    	{
	            return false; 
	            }
	        }

	        return true;  
	    }
	/**
	 * @author Devesh
	 * @param pos- index of the element to return
	 * @return- the element at the specified position in this list or null if such position does not exist.
	 */
	
	public E get(int pos)
	{
		if(pos<0 || pos>=size)
		{
			return null;
		}else {
			Node<E> current= head;
		    for(int i=0;i<pos;i++){
		       current=current.next;
		    }
		      return current.data;
		}
	}
	/**
	 * @author Devesh
	 * @return - true if this list contains no elements.
	 */
	public boolean isEmpty()
	{
		return head==null;
	}
	public int indexOf(Object o) 
	{
		if(o==null)
		{
			return -1;
		}
		else if(contains(o)== false)
		{
			return -1;
		}
		else
		{
			Node<E> current= head;
			for(int i=0; i<size; i++) 
			{
				if(current.data.equals(o))
				{
					return i;
				}
				else
				{
					current=current.next;
				}
			}
			return -1;
		}
		
	}
	/**
	 * @author Devesh
	 * @param o-element to be removed from this list, if present
	 * Removes the first occurrence of the specified element from this list, if it is present. 
	 * If this list does not contain the element, it is unchanged. 
	 * @return-true if this list contained the specified element and has been changed
	 * @throws ClassCastException-if the type of the specified element is incompatible with this list
	 * @throws NullPointerException-if the specified element is null
	 */
	public boolean remove(Object o) throws ClassCastException, NullPointerException
	{
		if(size==0)
		{
			return false;
		}
		if(o==null) 
		{
			throw new NullPointerException("Null objects not allowed.");
		}
		if(o.getClass().equals(this.getClass())) 
		{
			throw new ClassCastException("Object of incorrect class type.");
		}
		if(contains(o)==false)
		{
			return false;
		}else { 	
			if(head.data.equals(o) && size==1) 
			{
				head=head.next;
				tail=null;
				size--;
				return true;
			}
			else if(head.data.equals(o)) 
			{
				head=head.next;
				//head.next.prev=null;
				size--;
				return true;
			}
			else 
			{
				Node<E> current;
				for(int i=0;i<size;i++) 
				{
					if(get(i).equals(o)) 
					{
						current=getNode(i-1);
						current.next= current.next.next;
						if(i==size-1) {
							tail=current;
							size--;
							return true;
						}
						current.next.prev=current;
						size--;
						return true;
					}
					continue;
				}
				return false; 
			}
		}
	}
	/**
	 * @author Devesh
	 * Removes the element at the specified position pos in this list. Shifts any subsequent elements to the left 
	 * @param pos- the index of the element to be removed
	 * @return- Returns the element that was removed from the list.
	 * @throws IndexOutOfBoundsException- if pos is out of range (pos < 0 || pos >= size())
	 */
	
	public E remove(int pos) throws IndexOutOfBoundsException
	{
		if (pos < 0 || pos > size-1)
		{ 
            throw new IndexOutOfBoundsException("invalid position given");
        }
		Node<E> temp=getNode(pos);
		if(pos==0) 
		{
			head=head.next;
			if(size==1)
			{
				tail=null;
			}
			//head.next.prev=null;
			size--;
			return temp.data;
		}else 
		{
			 Node<E> current=getNode(pos-1);
			 current.next=current.next.next;
			 if (pos==size-1)
			 {
				 tail=current;
				 size--;
				 return temp.data;
			 }
			 current.next.prev=current;;
			 size--;
		}
		return temp.data;
	}
	/**
	 * @author Devesh
	 * @return the number of elements in this list.
	 */
	public int size()
	{
		return size;
		
       /** int counter =0;
        Node<E> temp= head;
        while(temp!=null){
             counter++;
             temp=temp.next;
         }
        return counter;*/
    }
	/**
	 * @author Devesh
	 * Returns a string representation of this list. 
	 */
	public String toString()
	{
		  if (head == null ) return ""; 
	        String toReturn = ""; 
	        Node<E> current = head; 
	        while (current != null ) 
	        {
	            toReturn += "[" + String.valueOf(current.data) + "], " + "\n"; 
	            current = current.next;
	        }
	        return toReturn;
	}
	/**
	 * @author Devesh
	 * Returns an iterator over the elements in this list. 
	 * This iterator should return elements in the same order in which they are stored in this list.
	 */
	public Iterator<E> iterator()
	{
		return new Itr();
	}
	

}
