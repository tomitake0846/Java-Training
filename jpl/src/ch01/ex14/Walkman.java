package ch01.ex14;

import java.util.ArrayList;
import java.util.List;

public class Walkman {

	private List<Record> recordList;
	private Object terminal;

	public Walkman() {
		this.recordList = new ArrayList<Record>();
	}
	public void displayMusicList() {
		for(Record rec : this.recordList) {
			System.out.println(rec);
		}
	}
	public void play() {
		/*play code...*/
	}
	public void setRecord(Record rec) {
		this.recordList.add(rec);
	}
	public List<Record> getRecordList() {
		return this.recordList;
	}
	public void Terminalconnetion(Object terminal) {
		this.terminal = terminal;
		//some code
	}
}
