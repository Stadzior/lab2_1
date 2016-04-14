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
    public void isExceptionThrown_WhenSequenceLengthEqualsZero(){
        SearchResult result = BinarySearch.search(5, new int[]{});
    }

	@Test
	public void isElementFound_WhenItExistsInSequence(){
		int key = 3;
		SearchResult result = BinarySearch.search(key, multipleElementSeq);
		assertThat(result.isFound() && multipleElementSeq[result.getPosition()] == key ,equalTo(true));
	}
	
	@Test
	public void isElementNotFound_WhenItsNotExistsInSequence(){
		int key = 15;
		SearchResult result = BinarySearch.search(key, multipleElementSeq);
		assertThat(!result.isFound() && result.getPosition() == -1 ,equalTo(true));
	}

    @Test
    public void isElementPositionFirst_WhenItsFirstInSequence(){
        int key = 1;
        SearchResult result = BinarySearch.search(key, multipleElementSeq);
        assertThat(result.isFound() && result.getPosition() == 0 ,equalTo(true));
    }

    @Test
    public void isElementPositionLast_WhenItsLastInSequence(){
        int key = 5;
        SearchResult result = BinarySearch.search(key, multipleElementSeq);
        assertThat(result.isFound() && result.getPosition() == multipleElementSeq.length-1 ,equalTo(true));
    }

    @Test
    public void foundElementIsInCenter(){
        int key = 3;
        SearchResult result = BinarySearch.search(key, multipleElementSeq);
        boolean isInCenter = (result.getPosition() == Math.floor((double) multipleElementSeq.length / 2));
        assertThat(result.isFound() && isInCenter ,equalTo(true));
    }

}
