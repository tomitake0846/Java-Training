package dc2_4;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockCanvas extends Canvas{

	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
	private PropertyInfo propertyInfo;

	public ClockCanvas(PropertyInfo propertyInfo) {
		this.propertyInfo = propertyInfo;
		setSize(this.propertyInfo.getClockWidth(),this.propertyInfo.getClockHeight());
		setBackground(PropertyInfo.toColor(this.propertyInfo.getBGColor()));
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(PropertyInfo.toColor(this.propertyInfo.getCharColor()));
		setBackground(PropertyInfo.toColor(this.propertyInfo.getBGColor()));
		Font font = new Font(this.propertyInfo.getFontFamily(),
							 this.propertyInfo.getFontName(),
							 this.propertyInfo.getFontSize());
		String drawString = LocalDateTime.now().format(f);
		FontMetrics metrics = g.getFontMetrics(font);
		int x = (getWidth() - metrics.stringWidth(drawString)) / 2 ;
		int y = getHeight() / 2;
		g.setFont(font);
		g.drawString(drawString,x,y);
	}
}
