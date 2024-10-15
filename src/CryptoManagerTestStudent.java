import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testIsStringInBounds()
	{
		assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
		assertFalse(CryptoManager.isStringInBounds("hELLO WORLD"));
		assertTrue(CryptoManager.isStringInBounds(" !&*()"));
		assertFalse(CryptoManager.isStringInBounds("abc123"));
	}
	
	@Test
	public void testCaesarEncryption()
	{
		assertEquals("W^&/\\$RW",CryptoManager.caesarEncryption("HOW MUCH", 15));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hOW MUCH", 3));

	}
	@Test
	public void testCaesarDecryption()
	{
		assertEquals("HOW MUCH", CryptoManager.caesarDecryption("W^&/\\$RW", 15));
	}
	@Test
	public void testBellasoEncryption()
	{
		assertEquals("PT#,\\]HT",CryptoManager.bellasoEncryption("HOW MUCH", "HELLO"));
	}
	@Test
	public void testBellasoDecryption()
	{
		assertEquals("HOW MUCH", CryptoManager.bellasoDecryption("PT#,\\]HT", "HELLO"));
	}
	

}
