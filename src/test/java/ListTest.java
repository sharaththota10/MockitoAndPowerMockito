import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2,listMock.size());
		
	}
	@Test
	public void testListSiz_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size()); //it fails because actual output getting is 3
		
	}
	
	@Test
	public void testListGetMethod() {
		List listMock = mock(List.class);
	//	when(listMock.get(0)).thenReturn("sample");
		when(listMock.get(anyInt())).thenReturn("sample");
		assertEquals("sample",listMock.get(0));
		assertEquals("sample",listMock.get(1));
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		listMock.get(0);
		
	}
	
	
	//using BDD Mockito
	@Test
	public void testListGetMethod_usingBDD() {
		//Given
		List listMock = mock(List.class);
	//	when(listMock.get(0)).thenReturn("sample");
		given(listMock.get(anyInt())).willReturn("sample");
		
		
		String firstElement = (String) listMock.get(0);
		assertThat(firstElement,is("sample"));
		
	//	assertEquals("sample",listMock.get(1));
		
	}


}
