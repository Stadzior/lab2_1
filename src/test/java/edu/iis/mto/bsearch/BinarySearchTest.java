package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    int[] singleElementSeq;
    int[] multipleElementSeq;

    @Before public void initialize(){
        singleElementSeq = new int[]{0};
        multipleElementSeq = new int[]{1,2,3,4,5};
    }
	@Test(expected = IllegalArgumentException.class)
    public void isExceptionThrown_WhenSequenceLenghtEqualsZero(){
        SearchResult result = BinarySearch.search(5, singleElementSeq);
    }

	@Test
	public void elementFound(){
		int key = 3;
		SearchResult result = BinarySearch.search(key, multipleElementSeq);
		assertThat(result.isFound() && multipleElementSeq[result.getPosition()] == key ,equalTo(true));
	}
	
	@Test
	public void elementNotFound(){
		int key = 5;
		SearchResult result = BinarySearch.search(key, multipleElementSeq);
		assertThat(!result.isFound() && result.getPosition() == -1 ,equalTo(true));
	}

    @Test
    public void foundElementIsFirst(){
        int key = 1;
        SearchResult result = BinarySearch.search(key, multipleElementSeq);
        assertThat(result.isFound() && result.getPosition() == 0 ,equalTo(true));
    }

    @Test
    public void foundElementIsLast(){
        int key = 5;
        SearchResult result = BinarySearch.search(key, multipleElementSeq);
        assertThat(result.isFound() && result.getPosition() == multipleElementSeq.length-1 ,equalTo(true));
    }

}
