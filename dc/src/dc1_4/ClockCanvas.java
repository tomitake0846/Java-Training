package dc1_4;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
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
		Image buff = createImage(getWidth(),getHeight());
		setBackground(PropertyInfo.toColor(this.propertyInfo.getBGColor()));

		Graphics buffGra = buff.getGraphics();
		buffGra.setColor(PropertyInfo.toColor(this.propertyInfo.getCharColor()));
		Font font = new Font(this.propertyInfo.getFontFamily(),
							 this.propertyInfo.getFontName(),
							 this.propertyInfo.getFontSize());
		String drawString = LocalDateTime.now().format(f);
		FontMetrics metrics = buffGra.getFontMetrics(font);
		int x = (getWidth() - metrics.stringWidth(drawString)) / 2 ;
		int y = getHeight() / 2;
		buffGra.setFont(font);
		buffGra.drawString(drawString,x,y);

		g.drawImage(buff, 0, 0, this);
	}
}
