package ch09.ex11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RegexTest {

	/*isCreditCardFormat method test*/

	@Test
	void normalTest() {
		assertTrue(Regex.isCreditCardFormat("0000-0000-0000-0000"));
		assertTrue(Regex.isCreditCardFormat("0000-0000-0000-0000t"));
		assertTrue(Regex.isCreditCardFormat("t0000-0000-0000-0000t"));
	}

	@Test
	void nullTest() {
		assertFalse(Regex.isCreditCardFormat(null));
	}

	@Test
	void abnormalTest() {
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-00"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-0"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-00"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-"));
		assertFalse(Regex.isCreditCardFormat("0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-000"));
		assertFalse(Regex.isCreditCardFormat("0000-00"));
		assertFalse(Regex.isCreditCardFormat("0000-0"));
		assertFalse(Regex.isCreditCardFormat("0000-"));
		assertFalse(Regex.isCreditCardFormat("000"));
		assertFalse(Regex.isCreditCardFormat("00"));
		assertFalse(Regex.isCreditCardFormat("0"));
		assertFalse(Regex.isCreditCardFormat(""));

		assertFalse(Regex.isCreditCardFormat("000-0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("00-0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0-0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("-0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("00-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000"));
		assertFalse(Regex.isCreditCardFormat("000-0000"));
		assertFalse(Regex.isCreditCardFormat("00-0000"));
		assertFalse(Regex.isCreditCardFormat("0-0000"));
		assertFalse(Regex.isCreditCardFormat("-0000"));

		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-00a0"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-00a0-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-00a0-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("00a0-0000-0000-0000"));

		assertFalse(Regex.isCreditCardFormat("0000-0000-0000-000"));
		assertFalse(Regex.isCreditCardFormat("0000-0000-000-0000"));
		assertFalse(Regex.isCreditCardFormat("0000-000-0000-0000"));
		assertFalse(Regex.isCreditCardFormat("000-0000-0000-0000"));
	}

	/*extractCreditCardNumber method test*/
	@Test
	void extractCreditCardNumberNomalTest() {
		List<String> cardList = Regex.extractCreditCardNumbers("");

		assertEquals(0, cardList.size());

		cardList = Regex.extractCreditCardNumbers("card number 0000-0000-0000-0000 accepted");
		assertEquals(1,cardList.size());
		for(String str : cardList) {
			assertTrue(str.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"));
		}

		cardList = Regex.extractCreditCardNumbers("0000-0000-0000-0000,0000-0000-0000-0000,0000-0000-0000-0000");
		assertEquals(3,cardList.size());
		for(String str : cardList) {
			assertTrue(str.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"));
		}
	}

}
