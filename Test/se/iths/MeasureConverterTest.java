package se.iths;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MeasureConverterTest {
	MeasureConverter testMeasureConverter;

	@Before
	public void createTestMeasureConverter(){
		testMeasureConverter = new MeasureConverter();
	}
	
	@Test
	public void convertWeightTrue(){
		int result = testMeasureConverter.convertWeight(10, true);
		
		assertEquals(result, 3);
	}
	
	@Test
	public void convertWeightFalse(){
		int result = testMeasureConverter.convertWeight(5, false);
		
		assertEquals(result, 13);
	}
	
	@Test
	public void convertToFeetEvenDivision(){
		int result = testMeasureConverter.convertToFeet(90);
		
		assertEquals(result, 3);
	}
	
	@Test
	public void convertToFeetUnevenDivision(){
		int result = testMeasureConverter.convertToFeet(130);
		
		assertEquals(result, 4);
	}

}
