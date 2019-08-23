package ch01.ex14;

public class Walkman {

	private Object terminal;
	private Record record;

	public Walkman() {

	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public void play() {
		/*play code...*/
	}

	public void stop() {
		/*stop code*/
	}

	public void Terminalconnetion(Object terminal) {
		this.terminal = terminal;
		//some code
	}
}
