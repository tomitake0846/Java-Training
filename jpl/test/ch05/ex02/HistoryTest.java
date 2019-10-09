package ch05.ex02;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import ch05.ex02.BankAccount.History;

class HistoryTest {

	@Test
	void historyTest() {
		BankAccount account = new BankAccount();

		account.addAction(getAcIns("draw"));
		account.addAction(getAcIns("deposit"));
		account.addAction(getAcIns("draw"));
		account.addAction(getAcIns("draw"));
		account.addAction(getAcIns("draw"));

		account.addAction(getAcIns("deposit"));
		account.addAction(getAcIns("deposit"));
		account.addAction(getAcIns("deposit"));
		account.addAction(getAcIns("draw"));
		account.addAction(getAcIns("deposit"));

		account.addAction(getAcIns("transfer")); //stored 11th action instance.

		History history = account.history();
		System.out.println();
		assertEquals("deposit" , history.next().getAction());


	}
	@Test
	void returnNullTest() {
		BankAccount account = new BankAccount();
		History history = account.history();
		assertNull(history.next());
	}

	@Test
	void immutableTest() {
		BankAccount account = new BankAccount();
		History history = account.history();

		account.addAction(getAcIns("draw")); // stored one action instance.

		history = account.history();
		assertEquals("draw",history.next().getAction());
		assertNull(history.next());


		account.addAction(getAcIns("draw"));// stored two action instance.

		history = account.history();
		assertEquals("draw",history.next().getAction());
		assertNotNull(history.next());
	}

	private Action getAcIns(String action) {
		Action ac = new Action();
		ac.setAction(action);
		return ac;
	}
}
