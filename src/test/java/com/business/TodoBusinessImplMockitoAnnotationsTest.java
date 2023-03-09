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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.verification.VerificationMode;

import com.data.TodoBusinessImpl;
import com.data.TodoService;


//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoAnnotationsTest {
	
	
	//without using @@RunWith(MockitoJUnitRunner.class) ,we can use @Rule
	//and also we can have multiple rules whereas runwith can have only one
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	//above statement eleminates below instantiation
	//TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock() {
		
	
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
		assertEquals(2,filteredTodos.size());
		
	}
	
	//using BDD style

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		//When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
		
		//then
		// assertEquals(2,filteredTodos.size());
		assertThat(filteredTodos.size(),is(2));
		
	}
	
	@Test
	public void testDeleteTodosRelatedToSpring_usingBDD() {
		
		
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		
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
		
		
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java","Learn Something");
		
		given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);
		
		
		//When
		todoBusinessImpl.deleteTodosRelatedToSpring("DummyUser");
		
		//then
		//verify(todoServiceMock,times(1)).deleteTodo("Learn Java");
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		//assertThat(stringArgumentCaptor.getValue(),is("Learn Java"));
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
		
	}

}
