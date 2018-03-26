package test.fillingHills;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public AppTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testApp() {
		int actual = App2.waterCounter(null);
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{0});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{5,5,5,5,5,5,5});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{0,0,0,5,0,0,0});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{1,2,3,4,3,2,1});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{0,2,3,4,3,2,0});
		assertEquals(0, actual );
		
		actual = App2.waterCounter(new int[]{1,0,1,0,1,0,1});
		assertEquals(3, actual );
		
		
	}
}
