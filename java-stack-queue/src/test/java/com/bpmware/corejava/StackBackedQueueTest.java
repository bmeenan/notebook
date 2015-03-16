package com.bpmware.corejava;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class built to exercise the behavior of the StackBackedQueue class
 * 
 * @author bmeenan
 *
 */

@Test
public class StackBackedQueueTest {

	private StackBackedQueue queue;
	Stack<Object> stack;
	
	/**
	 * Setup method that's called before each test is run
	 */
	@BeforeMethod
	public void setup() {
		queue = new StackBackedQueue();		
	}

	/**
	 * Verify an item can be added to the back/bottom of the queue
	 */	
	@Test
	public void testInsert() {
	
		//add 4 items to the stack
		queue.addBack(new String("1"));
		queue.addBack(new String("2"));
		queue.addBack(new String("3"));
		queue.addBack(new String("4"));
		
		stack = queue.getStack();

		//general assertions
		Assert.assertNotNull(queue);
		Assert.assertNotNull(stack);
		Assert.assertEquals(stack.size(), 4);
		
		//verify the items are ordered as expected, the last item inserted is the first item in the collection, etc.
		Assert.assertEquals((String) stack.get(0), "4");
		Assert.assertEquals((String) stack.get(1), "3");
		Assert.assertEquals((String) stack.get(2), "2");
		Assert.assertEquals((String) stack.get(3), "1");
		
	}
	
	/**
	 * Verifies the item on the top of the stack is removed
	 */
	@Test
	public void testRemove() {

		//add 4 items to the stack
		queue.addBack(new String("1"));
		queue.addBack(new String("2"));
		queue.addBack(new String("3"));
		queue.addBack(new String("4"));
		
		//general assertions
		Assert.assertNotNull(queue);
		Assert.assertNotNull(stack);
		Assert.assertEquals(stack.size(), 4);
		
		stack = queue.getStack();
		Object objectToRemove  = stack.peek();
		
		//call removeFrom which should remove the item on the top of the list
		queue.removeFront();

		//retrieve the updated stack
		stack = queue.getStack();
		Assert.assertNotNull(stack);
		Assert.assertEquals(stack.size(), 3);
		
		for (Object obj : stack) {
			Assert.assertNotEquals(obj, objectToRemove);
		}
		
		
	}
	
	
}
