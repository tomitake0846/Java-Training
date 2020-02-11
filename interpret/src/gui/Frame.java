package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import processing.InterpretException;

public class Frame extends JFrame implements ActionListener{
	private InterpretPanel interpretPanel;
	private JTextField text;
	public Frame() {
		initVisual();
		initTextBox();
		setVisible(true);
	}

	private void initVisual() {
		setTitle("interpret");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initTextBox() {
		JPanel textPanel = new JPanel();
		//prepare
		text = new JTextField();
		text.setPreferredSize(new Dimension(250,30));
		JButton button = new JButton("submit");
		button.addActionListener(this);

		//set component
		textPanel.add(text);
		textPanel.add(button);
		Container contentPane = getContentPane();
		contentPane.add(textPanel,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Container contentPane = getContentPane();
		try {
			//create new InterpretPanel
			//When input illegal class name [value of text.getText()] , thrown InterpretException.
			InterpretPanel ip = new InterpretPanel(this.text.getText());
			if(interpretPanel != null) {
				//remove old interpretPanel.
				contentPane.remove(interpretPanel);
			}
			//add new interpretPanel
			contentPane.add(ip,BorderLayout.CENTER);
			interpretPanel = ip;
			setVisible(true);

		} catch (InterpretException exception) {
			//display dialog with error message.
			JOptionPane.showMessageDialog(this,exception.getMessage());
		}
	}
}
