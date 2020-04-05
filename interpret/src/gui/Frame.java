package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.panels.ConstructorPanel;
import gui.panels.FieldPanel;
import gui.panels.MemberPanel;
import gui.panels.MethodPanel;
import processing.InterpreterFacade;
import processing.interpret.InterpretException;

public class Frame extends JFrame implements ActionListener{
	public static final String CONSTRUCTOR = "Constructor";
	public static final String FIELD = "Field";
	public static final String METHOD = "Method";
	public static final Frame FRAME = new Frame();
	private boolean hasAlreadySubmited = false;
	public InterpreterFacade interpreter;

	private MemberPanel displayPanel;
	private JTextField text;

	private Map<String,MemberPanel> panelMap;

	public Frame() {
		panelMap = new HashMap<String,MemberPanel>();
		initVisual();
		initTextBox();
		setVisible(true);
	}

	private void initVisual() {
		setTitle("interpret");
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initTextBox() {
		JPanel textPanel = new JPanel();
		//prepare
		text = new JTextField();
		text.setPreferredSize(new Dimension(250,30));

		//set component
		textPanel.add(text);
		textPanel.add(getButton("submit"));

		Container contentPane = getContentPane();
		setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		contentPane.add(textPanel,BorderLayout.NORTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Container contentPane = getContentPane();
		try {
			String command = e.getActionCommand();
			if("submit".equals(command)) {
				//setting Button
				setPanelButton(contentPane);

				String className = this.text.getText();
				this.interpreter = InterpreterFacade.INTERPRETER;
				this.interpreter.Construct(className);
				//create new ConstructorPanel , FieldPanel , and MethodPanel.
				//When input illegal class name [value of text.getText()] , thrown InterpretException.
				panelMap.put(CONSTRUCTOR,new ConstructorPanel(interpreter));
				panelMap.put(FIELD,new FieldPanel(interpreter));
				panelMap.put(METHOD,new MethodPanel(interpreter));
				command = CONSTRUCTOR;
			}

			//remove old Panel.
			if(displayPanel != null) {
				contentPane.remove(displayPanel);
				displayPanel.setVisible(false);
			}

			//add new Panel
			MemberPanel panel = panelMap.get(command);
			contentPane.add(panel);
			displayPanel = panel;
			displayPanel.setVisible(true);
			setVisible(true);

		} catch (InterpretException exception) {
			//display dialog with error message.
			JOptionPane.showMessageDialog(this,exception.getMessage());
		}
	}

	private void setPanelButton(Container content) {
		if(hasAlreadySubmited) {
			return;
		}
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(getButton(CONSTRUCTOR));
		buttonPanel.add(getButton(FIELD));
		buttonPanel.add(getButton(METHOD));
		content.add(buttonPanel,BorderLayout.NORTH);
		setVisible(true);
		hasAlreadySubmited = true;
	}
	private JButton getButton(String name) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		return button;
	}

}
