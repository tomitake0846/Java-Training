package controller;

import gui.SingleInstanceFrame;

public class ArrayItem {

	private String objectType;
	private int index;
	private SingleInstanceFrame frame;

	public ArrayItem(String objectType,int index) {
		this.objectType = objectType;
		this.index = index;
	}

	public String toString() {
		String str="object not created.";
		if(this.frame != null) {
			str = frame.toString();
		}
		return str;
	}
	public int getIndex() {
		return this.index;
	}

	public void run() {
		if(this.frame == null) {
			this.frame = new SingleInstanceFrame();
		}
		frame.setText(this.objectType);
		frame.setVisible(true);
	}
}
