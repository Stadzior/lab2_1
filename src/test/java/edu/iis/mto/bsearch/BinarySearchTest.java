package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

public class BinarySearchTest {

	@Test(expected = IllegalArgumentException.class)	
	public void isExceptionThrownWhenSequenceLenghtEqualsZero(){
		int[] seq = new int[0];
		SearchResult result = BinarySearch.search(5, seq);
	}
	
	@Test
	public void elementFound(){
		int[] seq = new int[5];
		seq[0] = 5;
		int key = 5;
		SearchResult result = BinarySearch.search(key, seq);	
		assertThat(result.isFound() && seq[result.getPosition()] == key ,equalTo(true));
	}
	
	@Test
	public void elementNotFound(){
		int[] seq = new int[5];
		SearchResult result = BinarySearch.search(5, seq);
		assertThat(!result.isFound() && result.getPosition() == -1 ,equalTo(true));
	}
}
