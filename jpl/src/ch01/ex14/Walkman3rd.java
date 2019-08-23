package ch01.ex14;

public class Walkman3rd extends Walkman2nd{
	public void communication(String to) {
		if(connectionEstablish(to)) {
			//talk start
		}
	}
	private boolean connectionEstablish(String to) {
		//code connection establish
		return true;
	}
}
