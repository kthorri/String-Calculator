package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
  	org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(5, Calculator.add("5"));
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
	@Test
  public void testMultipleNumbers(){
   	assertEquals(6, Calculator.add("1,2,3"));
  }
  @Test
  public void testMultipleNumbers2() {
  	assertEquals(256, Calculator.add("1,2,3,4,5,6,7,201,8,9,10"));
  }
  @Test
  public void testNewlineSplitter() {
  	assertEquals(6, Calculator.add("1\n2\n3"));
  }
  @Test
  public void testBothSplitters1() {
  	assertEquals(6, Calculator.add("1\n2,3"));
 	}
  @Test
  public void testBothSplitters2() {
  	assertEquals(6, Calculator.add("1,2\n3"));
 	} 	
  @Test
  public void testDifferentDelimiters1() {
  	assertEquals(3, Calculator.add("//;\n1;2"));
  }
  @Test
  public void testDifferentDelimiters2() {
  	assertEquals(6, Calculator.add("//%\n4%2"));
  }
  @Test
  public void testCombinedDelimiters1() {
  	assertEquals(16, Calculator.add("//%\n4%2,5\n5"));
  }
  @Test
  public void testCombinedDelimiters2() {
  	assertEquals(80, Calculator.add("//;\n4;1\n30,45"));
  }
  @Test
  public void testMinusNumbers1() {
    try {
      Calculator.add("-3,-4");
    }
    catch (RuntimeException e) {
      assertEquals("Negatives not allowed: -3, -4", e.getMessage());
    }
  }
  @Test
  public void testBiggerthan1000() {
    assertEquals(2, Calculator.add("1001,2"));
  } 
  @Test
  public void testLongerDelimiters(){
    assertEquals(6, Calculator.add("//[***]\n1***2***3"));
  }
  @Test
  public void testDifferentDelimitersOfLength1(){
    assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
  }
  @Test
  public void testDifferentDelimitersOfAnyLength1(){
    assertEquals(10, Calculator.add("//[**][%%%%][///]\n1**2%%%%3///4"));
  }
  @Test
  public void testDifferentDelimitersOfAnyLength2(){
    assertEquals(10, Calculator.add("//[**********][?????????][!!!!!!!!]\n1**********2?????????3!!!!!!!!4"));
  }

}