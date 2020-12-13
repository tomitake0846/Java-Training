package ch04.ex03;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class DefaultProperties {
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
		this.sip = new SimpleIntegerProperty(this.vi);
	}
	public void setBoolean(boolean b) {
		this.vb = b;
		this.sbp = new SimpleBooleanProperty(this.vb);
	}
	public void setDouble(double d) {
		this.vd = d;
		this.sdp = new SimpleDoubleProperty(this.vd);
	}
	public void setFloat(float f) {
		this.vf = f;
		this.sfp = new SimpleFloatProperty(this.vf);
	}
	public void setLong(long l) {
		this.vl = l;
		this.slp = new SimpleLongProperty(this.vl);
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
