package se.iths;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeConverterTest {
	
	TimeConverter testTimeConverter;
	
	@Before
	public void createTimeConverter(){
		testTimeConverter = new TimeConverter();
	}

	@Test
	public void checkGetMeridiemPM(){
		String result = testTimeConverter.getMeridiem(17);
		
		assertEquals(result, "PM");
	}
	
	@Test
	public void checkGetMeridiemAM(){
		String result = testTimeConverter.getMeridiem(8);
		
		assertEquals(result, "AM");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkGetMeridiemExceptionPlus(){
		String result = testTimeConverter.getMeridiem(25);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkGetMeridiemExceptionNegative(){
		String result = testTimeConverter.getMeridiem(-3);
		
	}

}
