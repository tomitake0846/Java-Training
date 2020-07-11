package dc2_4.dialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dc2_4.ButtonFactory;
import dc2_4.ButtonType;
import dc2_4.DigitalClock;
import dc2_4.PropertyInfo;;

public class PropertyDialog extends abstractDialog implements ActionListener{

	public static final int PROPERTY_FONT_SIZE = 20;
	public static final int DIALOG_WINDOW_SIZE = 600;

	private PropertyInfo propertyInfo;

	private PropertyPanel propertyPanel;

	public PropertyDialog(){
		setSize(DIALOG_WINDOW_SIZE,DIALOG_WINDOW_SIZE);
//		setResizable(false);

		this.propertyInfo = PropertyInfo.instance;

		setFont(new Font("Serif",0,PROPERTY_FONT_SIZE));

		//property panel init
		this.propertyPanel = new PropertyPanel();

		//Button initialization
		JButton updateButton = ButtonFactory.getButton(ButtonType.PROPERTY_UPDATE,this);
		JButton cancelButton = ButtonFactory.getButton(ButtonType.PROPERTY_CANCEL,this);
		JButton resetButton = ButtonFactory.getButton(ButtonType.PROPERTY_RESET,this);

		//create main panel
		JPanel mainPanel = new JPanel();

		mainPanel.add(this.propertyPanel);
		mainPanel.add(updateButton,BorderLayout.PAGE_END);
		mainPanel.add(cancelButton,BorderLayout.PAGE_END);
		mainPanel.add(resetButton,BorderLayout.PAGE_END);


		getContentPane().add(mainPanel);

//		FlowLayout layout = new FlowLayout();
//		layout.setAlignment(FlowLayout.RIGHT);
//		p.setLayout(layout);
//		p.add(this.updateButton);

//		getContentPane().add(p,BorderLayout.PAGE_END);

	}

	@Override
	//update PropertyInfo
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK")) {

			String currentFontFamily = propertyPanel.getSelectedFontFamily();
			String currentFontSize = propertyPanel.getSelectedFontSize();
			String currentCharColor = propertyPanel.getSelectedCharColor();
			String currentBGColor = propertyPanel.getSelectedBGColor();

			propertyInfo.setFontFamily(currentFontFamily);
			propertyInfo.setFontSize(currentFontSize);
			propertyInfo.setCharColor(currentCharColor);
			propertyInfo.setBGColor(currentBGColor);

			DigitalClock.prefs.propertyUpdate();

		} else if (e.getActionCommand().equals("reset")) {
			DigitalClock.prefs.propertyReflesh();
			DigitalClock.prefs.positionReflesh();
		}

		DigitalClock.frame.setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		DigitalClock.canvas.repaint();

		close();
	}

}
