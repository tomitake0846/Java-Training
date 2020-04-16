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

public class Frame extends JFrame implements ActionListener{

	public static final Frame FRAME = new Frame();
	public static Controller controller = new Controller();

	private MemberPanel displayPanel;
	private JTextField text;

	private JButton FieldButton;
	private JButton MethodButton;

	public Frame() {
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
		Container contentPane = getContentPane();
		try {
			String command = e.getActionCommand();

			//remove old Panel.
			if(displayPanel != null) {
				contentPane.remove(displayPanel.getMainPane());
				displayPanel.setVisible(false);
			}
			if(Controller.CONSTRUCTOR.equals(command)) {
				String className = this.text.getText();
				Frame.controller = new Controller();
				displayPanel = controller.getDisplayPanel(command,className);
			}

			//add new Panel
			MemberPanel panel = controller.getDisplayPanel(command);
			contentPane.add(panel.getMainPane());
			displayPanel = panel;
			repaint();

		} catch (InterpretException exception) {
			//display dialog with error message.
			JOptionPane.showMessageDialog(this,exception.getMessage());
		}
	}

	@Override
	public void repaint() {
		if(displayPanel != null) {
			displayPanel.setVisible(true);
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

	private JButton getButton(String name) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		return button;
	}

}
