package ch05.ex02;

public class Action {
	private String action;

	public Action() {};
	public Action(Action action) {
		_init(action);
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return this.action;
	}

	private void _init(Action action) {
		this.action = action.getAction();
	}
}
