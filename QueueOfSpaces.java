package project3;

public class QueueOfSpaces implements PossibleLocations 
{

	private DoublyLinkedList<Location> QueueT;
	public QueueOfSpaces()
	{
		QueueT= new DoublyLinkedList();
	}
	/**
	    * Add a Location object to this collection.
	    * @param s object to be added
	    * @throws NullPointerException if the given location is null
	    */
	@Override
	public void add(Location s) throws NullPointerException 
	{
		// TODO Auto-generated method stub
	
		QueueT.add(s);
		
	}
	/**
     * Remove the next object from this collection. The specific
     * item returned is determined by the underlying structure
     * by which this collection is represented.
     * @return the next object, or null if set is empty
     */
	@Override
	public Location remove() 
	{
		// TODO Auto-generated method stub
		return QueueT.remove(0);
	}
	/**
     * Determines if this collection is empty or not.
     * @return  true, if set is empty, false, otherwise.
     */
	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return QueueT.isEmpty();
	}
	/**
     * Returs a string representation of this collection.
     * The string representation consists of a list of the collection's
     * elements in the order they would be removed and returned by future
     * calls to remove(). The elements should be enclosed in square brackets (`"[]"`).
     * Adjacent elements are separated by the characters `", "` (comma and space).
     * Elements are converted to strings as by `String.valueOf(Object)`.
     * @return string representation of this colleciton
     */
	public String toString() 
	{
		return QueueT.toString();
		
	}
}
