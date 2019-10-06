package dc1_1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockCanvas extends Canvas{

	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

	public ClockCanvas(int width,int height) {
		setSize(width,height);
		setBackground(Color.black);

	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		Font font = new Font("Serif",Font.ITALIC,32);
		String drawString = LocalDateTime.now().format(f);
		FontMetrics metrics = g.getFontMetrics(font);

		g.setFont(font);
		g.drawString(drawString, metrics.stringWidth(drawString) , getHeight() / 2);
	}
}
