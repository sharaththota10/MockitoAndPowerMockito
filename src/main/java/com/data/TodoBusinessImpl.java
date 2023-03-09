package com.data;

import java.util.ArrayList;
import java.util.List;


//here SUT is TodoBusinessImpl
//where as TodoService is dependency because  TodoBusinessImpl dependency on TodoService
//also we dont have implementation for interface as it may be developed by other teams
public class TodoBusinessImpl {

	private TodoService todoservice;

	public TodoBusinessImpl(TodoService todoservice) {
		this.todoservice = todoservice;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoservice.retrieveTodos(user);
		for(String todo:todos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoservice.retrieveTodos(user);
		for(String todo:todos) {
			if(!todo.contains("Spring")) {
				todoservice.deleteTodo(todo);
			}
		}
	}
}
