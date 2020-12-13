package ch06.ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WebUtilsTest {

//	@Test
//	void containsLinkTest() {
//
//		fail("まだ実装されていません");
//
//	}
//
//	@Test
//	void notContainsLinkTest() {
//		fail("まだ実装されていません");
//
//	}


	/*
	 * isHTTP test
	 * */

	@Test
	void isHTTPNormal1() {
		assertTrue(WebUtils.isHTTP("http://test.com"));
		assertTrue(WebUtils.isHTTP("https://test.com"));
	}

	@Test
	void isHTTPNormal2() {
		assertTrue(WebUtils.isHTTP("<a href='http://test.com'> test </a>"));
		assertTrue(WebUtils.isHTTP("<a href='https://test.com'> test </a>"));
	}

	@Test
	void isHTTPAbnormal1() {
		assertFalse(WebUtils.isHTTP("http:// is bad protocol"));
		assertFalse(WebUtils.isHTTP("https:// is very nice protocol"));
	}

	/*
	 * parseHTTP test
	 * */

	@Test
	void parseHTTPNormal1() {
		assertEquals("http://test.com",WebUtils.parseHTTP("http://test.com")[0]);
		assertEquals("https://test.com",WebUtils.parseHTTP("https://test.com")[0]);
	}

	@Test
	void parseHTTPNormal2() {
		assertEquals("http://test.com",WebUtils.parseHTTP("<a href='http://test.com'> test </a>")[0]);
		assertEquals("https://test.com",WebUtils.parseHTTP("<a href='https://test.com'> test </a>")[0]);
	}

	@Test
	void parseHTTPNormal3() {
		String[] http = WebUtils.parseHTTP("<a href='http://test.evil.com'> http://test.com </a>");
		String[] https = WebUtils.parseHTTP("<a href='https://test.evil.com'> https://test.com </a>");
		assertEquals(2,http.length);
		assertEquals(2,https.length);

		assertEquals("http://test.evil.com",http[0]);
		assertEquals("http://test.com",http[1]);

		assertEquals("https://test.evil.com",https[0]);
		assertEquals("https://test.com",https[1]);
	}

	@Test
	void parseHTTPAbnormal1() {
		assertEquals(0,WebUtils.parseHTTP("http:// is bad protocol").length);
		assertEquals(0,WebUtils.parseHTTP("https:// is very nice protocol").length);
	}
}
