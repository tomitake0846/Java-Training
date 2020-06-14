package dc2_4.dialog;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;

import dc2_4.ButtonFactory;
import dc2_4.ButtonType;
import dc2_4.DigitalClock;
import dc2_4.PropertyInfo;;

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
		JPanel p = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.RIGHT);
		p.setLayout(layout);
		p.add(this.updateButton);

		getContentPane().add(updateButton,BorderLayout.PAGE_END);
//		add(updateButton);

	}

	public void paint(Graphics g) {
//		int rightDown = DIALOG_WINDOW_SIZE - PROPERTY_FONT_SIZE * 2;
//		this.updateButton.setBounds(rightDown,rightDown,PROPERTY_FONT_SIZE+12,PROPERTY_FONT_SIZE+5);
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
		JPanel p = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);

		// FONT FAMILY pulldown list setting
		GridBagConstraints gbc = new GridBagConstraints();

		//set label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel label = new JLabel(FONT_FAMILY);
		label.setBackground(Color.orange);
		layout.setConstraints(label, gbc);
		p.add(label);

		//set pulldown list
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		JComboBox<String> box = pulldownItemMap.get(FONT_FAMILY);
		box.setSelectedItem(this.propertyInfo.getFontFamily());
		layout.setConstraints(box,gbc);
		p.add(box);

		//FONT SIZE pulldown list setting

		//set label
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		label = new JLabel(FONT_SIZE);
		layout.setConstraints(label, gbc);
		p.add(label);

		//set pulldown list
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(FONT_SIZE);
		box.setSelectedItem(this.propertyInfo.getFontSize());
		layout.setConstraints(box,gbc);
		p.add(box);

		//CHAR_COLOR pulldown list setting

		//set label
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		label = new JLabel(CHAR_COLOR);
		layout.setConstraints(label, gbc);
		p.add(label);

		//set pulldown list
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(CHAR_COLOR);
		box.setSelectedItem(this.propertyInfo.getCharColor());
		layout.setConstraints(box,gbc);
		p.add(box);

		//BG_COLOR pulldown list setting

		//set label
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		label = new JLabel(BG_COLOR);
		layout.setConstraints(label, gbc);
		p.add(label);

		//set pulldown list
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		box = pulldownItemMap.get(BG_COLOR);
		box.setSelectedItem(this.propertyInfo.getBGColor());
		layout.setConstraints(box,gbc);
		p.add(box);

		getContentPane().add(p,BorderLayout.CENTER);
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
