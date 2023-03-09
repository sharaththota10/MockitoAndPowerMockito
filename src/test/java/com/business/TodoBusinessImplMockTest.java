package com.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.verification.VerificationMode;

import com.data.TodoBusinessImpl;
import com.data.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock() {
		
		
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
		assertEquals(2,filteredTodos.size());
		
	}
	
	//using BDD style

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
		
		//then
		// assertEquals(2,filteredTodos.size());
		assertThat(filteredTodos.size(),is(2));
		
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosRelatedToSpring("DummyUser");
		
		//then
		//verify(todoServiceMock,times(1)).deleteTodo("Learn Java");
		then(todoServiceMock).should().deleteTodo("Learn Java");
		
		//verify(todoServiceMock,never()).deleteTodo("Learn Spring");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
		
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD_argumentCapture() {
		
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//define Argument captor on specific method call
		
		//capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java","Learn Something");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosRelatedToSpring("DummyUser");
		
		//then
		//verify(todoServiceMock,times(1)).deleteTodo("Learn Java");
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		//assertThat(stringArgumentCaptor.getValue(),is("Learn Java"));
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
		
	}

}
