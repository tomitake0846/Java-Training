package ch10.ex03;

public class WorkingDay {
	public boolean isWorkingDay1(WeekDay day) {
		if(day == WeekDay.SUNDAY || day == WeekDay.SUTARDAY) {
			return false;
		} else {
			return true;
		}
	}
	//一目瞭然なのはswitch文だと思われる。
	public boolean isWorkingDay2(WeekDay day) {
		switch(day) {
			case MONDAY :
			case THUESDAY :
			case WEDNESDAY :
			case THURSDAY :
			case FRIDAY : return true;
			case SUNDAY :
			case SUTARDAY : return false;
			default : return false;
		}
	}
}
