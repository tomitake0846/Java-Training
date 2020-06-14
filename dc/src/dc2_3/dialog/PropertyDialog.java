package dc2_3.dialog;

import java.awt.Button;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import dc2_3.ButtonFactory;
import dc2_3.ButtonType;
import dc2_3.DigitalClock;
import dc2_3.PropertyInfo;

public class PropertyDialog extends abstractDialog implements ActionListener{

	public static final int PROPERTY_FONT_SIZE = 20;
	public static final int DIALOG_WINDOW_SIZE = 600;

	private final String FONT_FAMILY = "Font Family";
	private final String FONT_SIZE = "Font Size";
	private final String CHAR_COLOR = "Character Color";
	private final String BG_COLOR = "BackGround Color";
	private final int MAX_PROPERTY_WIDTH;

	private PropertyInfo propertyInfo;
	private Font propertyFont;

	private Button updateButton;

	private Map<String,JComboBox<String>> pulldownItemMap;

	public PropertyDialog(){
		setSize(DIALOG_WINDOW_SIZE,DIALOG_WINDOW_SIZE);
		setResizable(false);

		this.propertyInfo = PropertyInfo.instance;

		this.propertyFont = new Font("Serif",0,PROPERTY_FONT_SIZE);
		setFont(this.propertyFont);

		//shoud refactoring
		this.MAX_PROPERTY_WIDTH = getMaxPropertyWidth(propertyFont,
				FONT_FAMILY,FONT_SIZE,CHAR_COLOR,BG_COLOR);

		int listWidth = MAX_PROPERTY_WIDTH+40;

		String[] fontFamilyList = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		String[] fontSizeList = {"20","26","32","40","48","56"};
		String[] colorList = {"white","lightGray","gray","darkGray","black","red",
				"pink","orange","yellow","green","magenta","cyan","blue"};

		this.pulldownItemMap = new HashMap<String,JComboBox<String>>();
		this.pulldownItemMap.put(FONT_FAMILY,new JComboBox<String>(fontFamilyList));
		this.pulldownItemMap.put(FONT_SIZE,new JComboBox<String>(fontSizeList));
		this.pulldownItemMap.put(CHAR_COLOR,new JComboBox<String>(colorList));
		this.pulldownItemMap.put(BG_COLOR,new JComboBox<String>(colorList));

		initPulldownList();

		//update Button initialization
		this.updateButton = ButtonFactory.getButton(ButtonType.PROPERTY_UPDATE,this);
		add(updateButton);

	}

	public void paint(Graphics g) {
//		g.drawString(FONT_FAMILY,20,100);
//		g.drawString(FONT_SIZE, 20, 150);
//		g.drawString(CHAR_COLOR,20,200);
//		g.drawString(BG_COLOR, 20, 250);


		int rightDown = DIALOG_WINDOW_SIZE - PROPERTY_FONT_SIZE * 2;
		this.updateButton.setBounds(rightDown,rightDown,PROPERTY_FONT_SIZE+12,PROPERTY_FONT_SIZE+5);
	}

	@Override
	//update PropertyInfo
	public void actionPerformed(ActionEvent e) {

		String currentFontFamily = (String) pulldownItemMap.get(FONT_FAMILY).getSelectedItem();
		String currentFontSize = (String) pulldownItemMap.get(FONT_SIZE).getSelectedItem();
		String currentCharColor = (String) pulldownItemMap.get(CHAR_COLOR).getSelectedItem();
		String currentBGColor = (String) pulldownItemMap.get(BG_COLOR).getSelectedItem();

		propertyInfo.setFontFamily(currentFontFamily);
		propertyInfo.setFontSize(currentFontSize);
		propertyInfo.setCharColor(currentCharColor);
		propertyInfo.setBGColor(currentBGColor);

		DigitalClock.frame.setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		DigitalClock.canvas.repaint();

		close();
	}



	private void initPulldownList() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		// FONT FAMILY pulldown list setting
		GridBagConstraints gbc = new GridBagConstraints();

		//set label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(new JLabel(FONT_FAMILY), gbc);

		//set pulldown list
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JComboBox<String> box = pulldownItemMap.get(FONT_FAMILY);
		box.setSelectedItem(this.propertyInfo.getFontFamily());
		layout.setConstraints(box,gbc);

		//FONT SIZE pulldown list setting

		//set label
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(new JLabel(FONT_FAMILY), gbc);

		//set pulldown list
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(FONT_SIZE);
		box.setSelectedItem(this.propertyInfo.getFontSize());
		layout.setConstraints(box,gbc);

		//CHAR_COLOR pulldown list setting

		//set label
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(new JLabel(CHAR_COLOR), gbc);

		//set pulldown list
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(CHAR_COLOR);
		box.setSelectedItem(this.propertyInfo.getCharColor());
		layout.setConstraints(box,gbc);

		//BG_COLOR pulldown list setting

		//set label
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(new JLabel(BG_COLOR), gbc);

		//set pulldown list
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(BG_COLOR);
		box.setSelectedItem(this.propertyInfo.getBGColor());
		layout.setConstraints(box,gbc);
	}

	private int getMaxPropertyWidth(Font font,String...targets) {
		int maxPropertyWidth = 0;
		int width = 0;
		Graphics graphics = createImage(DIALOG_WINDOW_SIZE, DIALOG_WINDOW_SIZE).getGraphics();
		FontMetrics fontMetrics = graphics.getFontMetrics(font);

		for(String target : targets) {
			width = fontMetrics.stringWidth(target);
			if(maxPropertyWidth < width) {
				maxPropertyWidth = width;
			}
		}

		graphics = null;
		fontMetrics = null;

		return maxPropertyWidth;
	}

}
