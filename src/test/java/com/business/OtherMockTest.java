package com.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.data.TodoBusinessImpl;
import com.data.TodoService;

public class OtherMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock() {
		
		
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUSer");
		assertEquals(2,filteredTodos.size());
		
	}
}
