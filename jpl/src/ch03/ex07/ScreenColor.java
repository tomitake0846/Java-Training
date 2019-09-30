package ch03.ex07;

public class ScreenColor {
	private Object value;
	public ScreenColor() {
		this.value = null;
	}

	public ScreenColor(Object value) {
		this.value = value;
	}
	public Object getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(! (obj instanceof ScreenColor)) return false;
		if(obj == this) return true;
		ScreenColor attr = (ScreenColor)obj;
		return getValue().equals(attr.getValue());
	}
}
