package waage;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

	@Test

	public void TestStueckZahl() {
		
		Assert.assertEquals("200.0", new Messung().stueckZahlKalkulation(40.0, 0.2));
		
	}
	
	@Test

	public void TestError() {
		
		Assert.assertEquals("Error", new Messung().stueckZahlKalkulation(60.0, 0.2));
		
	}
	
	@Test

	public void TestNull() {
		
		Assert.assertEquals(null, new Messung().stueckZahlKalkulation(40.0, 0.0));
		
	}

}




