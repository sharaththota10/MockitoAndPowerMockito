package com.data.api;

import java.util.Arrays;
import java.util.List;

import com.data.TodoService;

public class TodoServiceStub implements TodoService{

	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn Java");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
