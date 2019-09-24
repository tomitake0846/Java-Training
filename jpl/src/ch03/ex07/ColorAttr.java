package ch03.ex07;

import java.util.Objects;

public class ColorAttr extends Attr{
	private ScreenColor myColor;//変換された色

	public ColorAttr(String name, Object value) {
		super(name,value);
		decodeColor();
	}
	public ColorAttr(String name) {
		this(name,"transparent");
	}

	public ColorAttr(String name,ScreenColor value) {
		super(name,value.toString());
		this.myColor = value;
	}

	public Object setCalue(Object newValue) {
		// super クラスのsetValueを最初に使う
		Object retval  = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	/*t 値を記述ではなくScreenColorに設定する*/
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = this.myColor;
		this.myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor() {
		return this.myColor;
	}

	protected void decodeColor() {
		if(getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}
	@Override
	public boolean equals (Object obj) {
		if(obj == null) return false;
		if(! (obj instanceof ColorAttr)) return false;
		if(obj == this) return true;
		ColorAttr attr = (ColorAttr)obj;

		return this.myColor.equals(attr.getColor());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}
}
