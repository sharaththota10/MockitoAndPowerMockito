package com.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.data.TodoBusinessImpl;
import com.data.TodoService;
import com.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUSer");
		assertEquals(2,filteredTodos.size());
		
	}

}
