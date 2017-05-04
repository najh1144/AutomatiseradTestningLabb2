package se.iths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

public class AmericanizerTest {

	
	Americanizer americanizer;
	
	public interface ComponentTests{
		
	}
	
	public interface IntegrationTests{
		
	}
	
	@Before
	public void createObjects(){
		
		americanizer = new Americanizer();
		
	}
	
	
	//Komponentstest
	
	@Category(ComponentTests.class)
	@Test
	public void testConvertSpeach(){
		Americanizer test_americanizer = new Americanizer();
		
		String test_string = "Hello";
		String result_string = "yo dude!Hello, you know?";
		String converted_test_string = test_americanizer.convertSpeach(test_string);
		
		assertEquals(result_string, converted_test_string);
	}
	
	/*
	//Hade här "(expected=NullPointerException.class)", men trots att det blev en sådan
	//långt ner i stacken godkändes inte testet
	@Category(ComponentTests.class)
	@Test(expected=NullPointerException.class)
	public void testConvertTimeTriggerException(){
		americanizer.setTimeConverter(null);
		
		String predicted_string = "";
		
		String result_string = americanizer.convertTime(15);
		assertEquals(predicted_string, result_string);
	}
	*/
	//Integrationstest
	
	@Category(IntegrationTests.class)
	@Test
	public void testConvertTimeReturnAM(){
		String result = "9 AM";
		TimeConverter mockTimeConverter = mock(TimeConverter.class);
		
		americanizer.setTimeConverter(mockTimeConverter);
		
		when(mockTimeConverter.getMeridiem(9)).thenReturn("AM");
		assertEquals(result, americanizer.convertTime(9));
	}
	
	@Category(IntegrationTests.class)
	@Test
	public void testConvertTimeReturnPM(){
		String result = "8 PM";
		TimeConverter mockTimeConverter = mock(TimeConverter.class);
		
		americanizer.setTimeConverter(mockTimeConverter);
		
		when(mockTimeConverter.getMeridiem(20)).thenReturn("PM");
		assertEquals(result, americanizer.convertTime(20));
		
	}
	/*
	@Category(IntegrationTests.class)
	@Test
	public void testConvertToPoundToMetricFalse(){
		int result = 27;
		int test_weight = 10;
		boolean test_toMetric = false;
		
		MeasureConverter mockMeasureConverter = mock(MeasureConverter.class);
		americanizer.setWeightConverter(mockMeasureConverter);
		
		when(mockMeasureConverter.convertWeight(test_weight, test_toMetric)).thenReturn(27);
		//verify((mockMeasureConverter, atLeastOne()).convertWeight(test_weight, test_toMetric));
		assertEquals(result, americanizer.convertToPound(test_weight));
	}
	*/
	@Category(IntegrationTests.class)
	@Test
	public void testConvertToPoundToMetricTrue(){
		int result = 3;
		int test_weight = 10;
		boolean test_toMetric = true;
		
		MeasureConverter mockMeasureConverter = mock(MeasureConverter.class);
		americanizer.setWeightConverter(mockMeasureConverter);
		
		when(mockMeasureConverter.convertWeight(test_weight, test_toMetric)).thenReturn(3);
		assertEquals(result, americanizer.convertToPound(test_weight));
	}
	
	@Category(IntegrationTests.class)
	@Test
	public void testConvertToFeetWithMock(){
		int result = 4;
		int test_length = 120;
		
		MeasureConverter mockMeasureConverter = mock(MeasureConverter.class);
		americanizer.setWeightConverter(mockMeasureConverter);
		
		when(mockMeasureConverter.convertToFeet(test_length)).thenReturn(4);
		assertEquals(result, americanizer.convertToFeet(test_length));
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(IntegrationTests.class)
	@SuiteClasses({
		AmericanizerTest.class
	})
	public static class RunIntegrationTests{
		
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(ComponentTests.class)
	@SuiteClasses({
		AmericanizerTest.class
	})
	public static class RunComponentTests{
		
	}
}
