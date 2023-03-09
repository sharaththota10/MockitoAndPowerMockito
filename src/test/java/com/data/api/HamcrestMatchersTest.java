package com.data.api;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	  
	public void test() {
		List<Integer> scores = Arrays.asList(99,200,101,9);
		
		//scores has 4 itmes
		assertThat(scores,hasSize(4));
		assertThat(scores,hasItems(101,9));
		
		//every item> 90
		assertThat(scores,everyItem(greaterThan(8)));
		
		//String related
		assertThat("",isEmptyString());
		assertThat(null,isEmptyOrNullString());
		
		//arrays related
		Integer[] marks = {1,2,3};
		
		assertThat(marks,arrayWithSize(3));
		
		assertThat(marks,arrayContaining(1,2,3));
		assertThat(marks,arrayContainingInAnyOrder(2,1,3));
		
		
		
		
	}

}
