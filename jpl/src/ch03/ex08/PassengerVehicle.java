package ch03.ex08;

public class PassengerVehicle extends Vehicle{
	private int sheetNum;
	private int passengers;

	public PassengerVehicle(int sheetNum) {
		if(sheetNum <= 0) {
			throw new IllegalArgumentException();
		}
		this.sheetNum = sheetNum;
		this.passengers = 0;
	}
	public boolean ride() {
		//If there are extra sheets.
		if(this.sheetNum > passengers) {
			passengers ++;
			System.out.println("been ridden!");
			return true;
		} else {
			//If there is no extra sheet.
			System.out.println("can't be ride...");
			return false;
		}
	}
	public int getSheetNum() {
		return this.sheetNum;
	}
	public int getPassengers() {
		return this.passengers;
	}

	public static void main(String[] args) {
		p(new PassengerVehicle(2));
		p(new PassengerVehicle(4));
		p(new PassengerVehicle(7));
	}

	public static void p(PassengerVehicle v) {
		System.out.println("sheet Num :"+v.getSheetNum());
		System.out.println("passenger :"+v.getPassengers());
		v.ride();
		System.out.println("passenger :"+v.getPassengers()+"\n");
	}

}
