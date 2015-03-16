package com.bpmware.corejava;

import java.util.Stack;

/**
 * This Queue implementation uses Java's Stack object to store items.
 * Because it is not known what type of objects will be added to the
 * queue, this implementation provides the ability to add any object 
 * type.
 * 
 * @see java.util.Stack
 * @author bmeenan
 *
 */
public class StackBackedQueue implements Queue {
	
	/*
	 * Java Stack storage mechanism. Because it is unknown what object types will be stored 
	 * on the queue, it is currently provides the ability add any object type to the queue.
	 */
	private Stack<Object> stack = new Stack<Object>();
	
	/*
	 * (non-Javadoc)
	 * @see com.bpmware.corejava.Queue#addBack(java.lang.Object)
	 */
	public void addBack(Object o) {
		if (o!=null) {
			//create a temporary stack instance and insert the item. It is now at the back of the list
			Stack<Object> updatedStack = new Stack<Object>();
			updatedStack.push(o);
			//take all other items from the original stack and add it to the temp stack
			updatedStack.addAll(stack);
			this.stack = updatedStack;				
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.bpmware.corejava.Queue#removeFront()
	 */
	public Object removeFront() {
		Object itemRemoved = null;
		if (!stack.isEmpty()) {
			Object itemToRemove = stack.peek();
			Stack<Object> updatedStack = new Stack<Object>();
			for (Object obj : stack) {
				if (obj != itemToRemove) {
					updatedStack.push(obj);
				}
			}
			this.stack = updatedStack;
		}
		return itemRemoved;
	}

	/**
	 * Defaulting to protected scope, this method is made available
	 * to unit tests to inspect the stack while testing
	 * @return the current stack instance held by this class
	 */
	Stack<Object> getStack() {
		return stack;
	}
	
}
