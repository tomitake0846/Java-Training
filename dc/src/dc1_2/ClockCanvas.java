package dc1_2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockCanvas extends Canvas{

	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
	private PropertyInfo propertyInfo;

	public ClockCanvas(int width,int height) {
		setSize(width,height);
		setBackground(Color.black);
		this.propertyInfo = PropertyInfo.instance;
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		Font font = new Font(this.propertyInfo.getFontFamily(),
							 this.propertyInfo.getFontName(),
							 this.propertyInfo.getFontSize());
		String drawString = LocalDateTime.now().format(f);
		FontMetrics metrics = g.getFontMetrics(font);
		int x = (getWidth() - metrics.stringWidth(drawString)) / 2 ;
		int y = getHeight() / 2;
		g.setFont(font);
		g.drawString(drawString,x , y);
	}
}
