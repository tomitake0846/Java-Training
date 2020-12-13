package ch04.ex02;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class GodProperties{
	private int vi;
	private boolean vb;
	private double vd;
	private float vf;
	private long vl;

	private SimpleIntegerProperty sip;
	private SimpleBooleanProperty sbp;
	private SimpleDoubleProperty sdp;
	private SimpleFloatProperty sfp;
	private SimpleLongProperty slp;

	/*setter*/
	public void setInt(int i) {
		this.vi = i;
	}
	public void setBoolean(boolean b) {
		this.vb = b;
	}
	public void setDouble(double d) {
		this.vd = d;
	}
	public void setFloat(float f) {
		this.vf = f;
	}
	public void setLong(long l) {
		this.vl = l;
	}

	/*getter*/
	public SimpleIntegerProperty intProperty() {
		if(this.sip == null) {
			this.sip = new SimpleIntegerProperty(this.vi);
		}
		return this.sip;
	}
	public SimpleBooleanProperty booleanPropety() {
		if(this.sbp == null) {
			this.sbp = new SimpleBooleanProperty(this.vb);
		}
		return this.sbp;
	}
	public SimpleDoubleProperty doubleProperty() {
		if(this.sdp == null) {
			this.sdp = new SimpleDoubleProperty(this.vd);
		}
		return this.sdp;
	}
	public SimpleFloatProperty floatProperty() {
		if(this.sfp == null) {
			this.sfp = new SimpleFloatProperty(this.vf);
		}
		return this.sfp;
	}
	public SimpleLongProperty longProperty() {
		if(this.slp == null) {
			this.slp = new SimpleLongProperty(this.vl);
		}
		return this.slp;
	}
}
