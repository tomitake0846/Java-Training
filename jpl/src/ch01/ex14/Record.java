package ch01.ex14;

public class Record {
	private String title;
	private String playTime;
	private Object musicData;
	private boolean favolite;

	public Record(String title,String playTime,Object musicData) {
		this.title = title;
		this.playTime = playTime;
		this.musicData = musicData;
		this.favolite = false;
	}

	public boolean isFavolite() {
		return this.favolite;
	}
	public String getPlayTime() {
		return this.playTime;
	}
	public String getTiltle() {
		return this.title;
	}
	public Object getMusicData() {
		return this.musicData;
	}

	public void setFavolite(boolean favolite) {
		this.favolite = favolite;
	}
	@Override
	public String toString() {
		return "[title : "+ title + " , playTime : " + playTime +"]" ;
	}
}
