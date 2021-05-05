package dc3_4.controller.RESTLogic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class RESTLogicTest {

	@Test
	void loginSuccess() {
		RESTLogic.login("admin", "admin",
				errMsg -> fail(),
				str -> assertEquals("admin",str));
	}

	@Test
	void loginFailedUserIdEmpty() {
		RESTLogic.login("", "admin",
				errMsg -> assertEquals("user id is empty.",errMsg),
				str -> fail());
	}
	@Test
	void loginFailedMissedUserId() {
		RESTLogic.login("adminn", "admin",
				errMsg -> assertEquals("invalid user_id or password.",errMsg),
				str -> fail());
	}

	@Test
	void loginFailedpasswordEmpty() {
		RESTLogic.login("admin", "",
				errMsg -> assertEquals("password is empty.",errMsg),
				str -> fail());
	}
	@Test
	void loginFailedMissedpassword() {
		RESTLogic.login("admin", "adminn",
				errMsg -> assertEquals("invalid user_id or password.",errMsg),
				str -> fail());
	}



	/*register test*/
	@Test
	void registSuccess() {
		RESTLogic.regist(LocalDateTime.now().toString(), "admine","admine",
				errMsg -> fail(),
				str -> assertEquals("{\"Font Family\":\"Serif\",\"Font Size\":\"40.0\",\"X coordinate\":\"200.0\",\"BackGround Color\":\"black\",\"Character Color\":\"white\",\"Y coordinate\":\"200.0\",\"Font Name\":\"ITALIC\"}",str));
	}

	@Test
	void registFailedUserIdEmpty() {
		RESTLogic.regist("", "admin","admin",
				errMsg -> assertEquals("user id is empty.",errMsg),
				str -> fail());
	}

	@Test
	void registFailedUserIdAlreadyExists() {
		RESTLogic.regist("admin", "admin","admin",
				errMsg -> assertEquals("id:admin has already existed.",errMsg),
				str -> fail());
	}

	@Test
	void registFailedPasswordEmpty() {
		RESTLogic.regist("admin", "","admin",
				errMsg -> assertEquals("password is empty.",errMsg),
				str -> fail());
	}

	@Test
	void registFailedNotMatchedPassword() {
		RESTLogic.regist("admin", "admin","adminn",
				errMsg -> assertEquals("not matched password and confirm password.",errMsg),
				str -> fail());
	}

	@Test
	void registFailedNotMatchedPasswordWithConfirmPasswordIsEmpty() {
		RESTLogic.regist("admin", "admin","",
				errMsg -> assertEquals("not matched password and confirm password.",errMsg),
				str -> fail());
	}

}
