package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import gui.panels.MemberPanel;
import processing.interpret.InterpretException;

public class SingleInstanceFrame extends JFrame implements ActionListener{

//	public static final SingleInstanceFrame FRAME = new SingleInstanceFrame();
	protected Controller controller;

	private MemberPanel displayPanel;
	private JTextField text;

	private JButton FieldButton;
	private JButton MethodButton;

	public SingleInstanceFrame() {
		initVisual();
		initTextBox();
	}

	private void initVisual() {
		setTitle("interpret");
		setSize(1200,800);
		controller = new Controller(this);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initTextBox() {
		JPanel textPanel = new JPanel();
		//prepare
		text = new JTextField();
		text.setPreferredSize(new Dimension(250,30));

		FieldButton = getButton(Controller.FIELD);
		MethodButton = getButton(Controller.METHOD);
		FieldButton.setVisible(false);
		MethodButton.setVisible(false);

		//set component
		textPanel.add(text);
		textPanel.add(getButton(Controller.CONSTRUCTOR));
		textPanel.add(FieldButton);
		textPanel.add(MethodButton);

		Container contentPane = getContentPane();
		setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		contentPane.add(textPanel,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if(Controller.CONSTRUCTOR.equals(command)) {
			String className = this.text.getText();

			removePanel();
			this.controller = new Controller(this);

			try {
				displayPanel = controller.getDisplayPanel(command,className);
			} catch (InterpretException e1) {
				//display dialog with error message.
				JOptionPane.showMessageDialog(this,e1.getMessage());
			}
		}
		panelDisplay(command);
		repaint();
	}

	@Override
	public void repaint() {
		if(displayPanel != null) {
			displayPanel.setVisible(true);
			String panelType = displayPanel.getPanelType();
			panelDisplay(panelType);
		}
		if(controller.hasInstance()) {
			this.FieldButton.setVisible(true);
			this.MethodButton.setVisible(true);
		} else {
			this.FieldButton.setVisible(false);
			this.MethodButton.setVisible(false);
		}

		setVisible(true);
	}

	public void setText(String text) {
		this.text.setText(text);
	}
	public String toString() {
		return "To do : test";
	}

	public Object getInstance() {
		return this.controller.getInstance();
	}

	private void panelDisplay(String panelType) {
		Container contentPane = getContentPane();
		try {
			//remove old Panel.
			if(displayPanel != null) {
				contentPane.remove(displayPanel.getMainPane());
				displayPanel.setVisible(false);
			}

			//add new Panel
			MemberPanel panel = controller.getDisplayPanel(panelType);
			contentPane.add(panel.getMainPane());
			displayPanel = panel;

			displayPanel.setVisible(true);

		} catch (InterpretException exception) {
			//display dialog with error message.
			JOptionPane.showMessageDialog(this,exception.getMessage());
		}
	}

	private JButton getButton(String name) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		return button;
	}

	private void removePanel() {
		Container contentPane = getContentPane();
		if(displayPanel !=null) {
			contentPane.remove(displayPanel.getMainPane());
		}
	}
}
