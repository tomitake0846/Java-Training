package ch01.ex14;

public class Walkman2nd extends Walkman{

	private Object secondTerminal;

	public void displayOnlyFavolite() {
		for(Record rec : getRecordList()) {
			if(rec.isFavolite()) {
				System.out.println(rec);
			}
		}
	}
	public void changeFavolite(Record rec) {
		rec.setFavolite(!rec.isFavolite());
	}
	public void Terminalconnetion(Object terminal) {
		this.secondTerminal = terminal;
		//some code
	}
}
