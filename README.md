# project3
You are going to write a program that uses our new data structures, stack and queue, to explore a maze and, hopefully, find a way out of it. There are many algorithms that use different data structures and different strategies to explore mazes. In this assignment you will try two such approaches. In both of these approaches you will start from some initial position within the maze and evaluate the neighboring spaces until either you find a way out, or you discover that there is no way out. The rough outline of both approaches is to examine spaces around the current position and decide which need to be examined further and which definitely do not lead to an exit (more details below in the algorithm description).


Main goal: the main goal of this programming project is to get out of a maze.

The other goal of this programming project is for you to master (or at least get practice on) the following tasks:

working with multi-file programs
writing classes
implementing existing interfaces
working with existing code
implementing your own doubly linked list
implementing your own stack and queue

PROGRAM USAGE

The program is started from the command line (or run within an IDE). It expects two command line arguments.

The first command line argument should be a name of an input file containing a maze to be used by the program. This project comes with two such files, see the appendix. You can (and should) create your own mazes for testing. The name of the file can be entered as an absolute or relative path.

The second command line argument should be one of the following keywords: stack or queue (or at least a keyword that starts with the letter 's' or the letter 'q').

If any other keyword is used, the program prints a message indicating that this option is not supported. (The meaning of the two keywords is described below.)

The user may start the program from the command line or run it within an IDE like Eclipse - from the point of view of your program this does not matter.

ALGORITHIM

You should be able to solve the above maze on paper easily. But how do you tell a computer to find a way out? The computer cannot just look at the whole maze and figure out where the nearest exit is. Think of yourself being stuck in a maze without having a ”global” view. You only have a local view of what is immediately next to you and before you take a step it might be wise to decide if there ever might be a reason to come back to your current location. The algorithm below describes this type of search for a way out of a maze.

The program should keep a set of spaces that need to be examined (places that we might need to get back to in order to test another alternative, for example when we have two choices and we can only follow one of them right away). The exact representation of this set does not matter from the point of view of the algorithm. At the very beginning the set consists of a single space that is the initial position. We explore the maze by repeating the following steps:

if the set is empty, there is no way out of the maze - algorithm ends;
otherwise we take the next element from the set
if the space that we just picked has been visited before, no need to look at it again, we skip the rest of this step
if the space is a way out, we found the solution - algorithm ends
otherwise, we examine all of the neighbors of that space (the order does not matter and for a more interesting simulation, the order of "examining the neighbors" should be randomized), for each space that is not a wall, we add it to the set of spaces we are maintaining and then mark the current space as visited
This algorithm is implemented for you. Your task is to provide two different implementations for the "set of spaces" that is used in the algorithm. For this purpose you need to implement a stack of spaces and a queue of spaces (details below).

DATA STORAGE

The project comes with several classes that provide a program that implements a maze simulation. Study the source code to understand what it is doing. You do not have to understand every detail (although there is no reason for you not to) to be able to implement the parts of the program that are missing.

The classes given to you are:

Labyrinth - the class that represents a 2D rectangular maze

LabyrinthSearchException - the class defines the exception thrown by the Labyrinth class during the search process

Simulation- the actual program that simulates an exploration of a maze

PossibleLocations - the interface that provides requirements for the two classes that you need to implement

Location - the class the represents a position/location of a single square in the maze

SquareType - the enumerated type describing different types of squares in the maze

Your task is to provide an implementation of a doubly linked list class and two different implementations of the PossibleLocations interface (that use your own 
doubly linked list class for their internal storage) included in the project.

You may implement additional classes if you wish. You are not allowed to modify any of the classes or interfaces provided to you as part of this project. We will compile your code with the original definitions of those classes. (The only exception to this is if some changes are announced to the entire class to provide any corrections that may be needed.)

DoublyLinkedList class

Your class should be called DoublyLinkedList<E>. It should be a generic class that does not permit null elements.

Your class should implement the following methods and interfaces:

boolean add​(E e)

Appends the specified element to the end of this list. Returns true if this list changed as a result of the call. Returns false if the specified element is null.

Parameters:

e - element to be appended to this list

Throws:

ClassCastException - if the class of the specified element prevents it from being added to this list

boolean add​(E e, int pos)

Inserts the specified element at the specified position pos in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices). Returns true if this list changed as a result of the call. Returns false if the specified element is null.

Parameters:

e - element to be added to this list

pos - position at which the element should be added; 0 <=pos <= size()

Throws:

ClassCastException - if the class of the specified element prevents it from being added to this list

IndexOutOfBoundsException - if pos is out of range (pos < 0 || pos > size())

void clear()

Removes all of the elements from this list. The list will be empty after this call returns.

boolean contains​(Object o)

Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that Objects.equals(o, e).

Parameters:

o - element whose presence in this list is to be tested

boolean equals​(Object o)

Compares the specified object with this list for equality. Returns true if and only if the specified object is also an instance of a DoublyLinkedList , both lists have the same size, and all corresponding pairs of elements in the two lists are equal. In other words, two lists are defined to be equal if they contain the same elements in the same order.

Parameters:

o - the object to be compared for equality with this list

E get(int pos)

Returns the element at the specified position in this list or null if such position does not exist.

Parameters:

pos - index of the element to return

boolean isEmpty()

Returns true if this list contains no elements.

int indexOf( Object o )

Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.

Parameters:

o - element to search for

boolean remove​(Object o)

Removes the first occurrence of the specified element from this list, if it is present. If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that Objects.equals(o, get(i)) (if such an element exists). Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).

Parameters:

o - element to be removed from this list, if present

Throws:

ClassCastException - if the type of the specified element is incompatible with this list

NullPointerException - if the specified element is null

E remove​(int pos)

Removes the element at the specified position pos in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.

Parameters:

pos - the index of the element to be removed

Throws:

IndexOutOfBoundsException - if pos is out of range (pos < 0 || pos >= size())

int size()

Returns the number of elements in this list.

String toString()

Returns a string representation of this list. The string representation consists of a list of the collection's elements in the order they are returned by its iterator, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space). Elements are converted to strings as by String.valueOf(Object).

Iterable<E> interface

Iterator<E> iterator() Returns an iterator over the elements in this list. This iterator should return elements in the same order in which they are stored in this list.
  
StackOfSpaces class

This class should implement the PossibleLocations interface. It should be a reference based stack that uses your own doubly linked list as the internal storage. Note that in order to implement the interface the typical push method needs to be called add and the typical pop method needs to be called remove.

You my implement additional methods if you wish.

QueueOfSpaces class

This class should implement the PossibleLocations interface. It should be a reference based stack that uses your own doubly linked list as the internal storage. Note that in order to implement the interface the typical enqueue method needs to be called add and the typical dequeue method needs to be called remove.

You my implement additional methods if you wish.
