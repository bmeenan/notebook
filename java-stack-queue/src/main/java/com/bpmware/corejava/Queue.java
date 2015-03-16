package com.bpmware.corejava;

/**
 * This interface defines the required methods of queue implementation.
 */
public interface Queue {
	/**
     * Add object o to the tail of the queue.
     */
    void addBack(Object o);
 
    /**
     * Removes and removes the object that is the head of the queue.
     */
    Object removeFront();
    
}
