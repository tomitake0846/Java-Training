package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.arrayPanel.ArrayPanel;
import gui.arrayPanel.PanelForUserInput;
import processing.interpret.InterpretException;

public class ArrayFrame extends JFrame{

	private PanelForUserInput userPanel;

	private JPanel mainPanel;

	public ArrayFrame() {
		setTitle("Interpret with Array");

		//width : 1200
		//height : 800
		setSize(1200,800);
		userPanel = new PanelForUserInput(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = userPanel.getTypeField();
				String size = userPanel.getSizeField();
				System.out.println("type :"+type);
				System.out.println("size :"+size);
				try {
					updateArrayPanel(type,size);
				} catch (InterpretException exception) {
					String message = "exception occurred.\n"+
							exception.getMessage() +"\n" +
							exception.getException().toString();
					JOptionPane.showMessageDialog(null,message);
					dispose();
				}
			}
		});
		initArrayPanel();
	}

	private void initArrayPanel() {
		Container contentPane = getContentPane();

		// crear conponents.
		if(mainPanel != null) {
			contentPane.remove(this.mainPanel);
		}

		ArrayPanel arrayPanel = new ArrayPanel();

		mainPanel = new JPanel();
		mainPanel.setSize(1200, 700);
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(this.userPanel);
		mainPanel.add(arrayPanel.getScrollPane());
		mainPanel.setVisible(true);
		contentPane.add(mainPanel);
	}
	private void updateArrayPanel(String type,String size) throws InterpretException {
		Container contentPane = getContentPane();

		// crear conponents.
		if(mainPanel != null) {
			this.mainPanel.setVisible(false);
			contentPane.remove(this.mainPanel);
		}

		ArrayPanel arrayPanel = new ArrayPanel();
		arrayPanel.initArrayItemList(type, size);

		mainPanel = new JPanel();
		mainPanel.setSize(1200, 700);
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(this.userPanel);
		mainPanel.add(arrayPanel.getScrollPane());
		contentPane.add(mainPanel);
		mainPanel.setVisible(true);

	}

}
