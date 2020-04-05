package gui.panels;
import java.awt.GridLayout;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import processing.interpret.InterpretException;

public abstract class MemberPanel extends JPanel{

	private JPanel titlePanel;
	public abstract void update(ItemPanel itemPanel) throws InterpretException;

	public MemberPanel(String...strings) {
		this.titlePanel = initTitlePanel(strings);
	}

	public JPanel getTitlePanel() {
		return this.titlePanel;
	}

	protected List<String> getMemberList(Member[] mems) {
		List<String> list = new ArrayList<String>(mems.length);
		for(Member m : mems) {

			if(m.getDeclaringClass() == Object.class) {
				continue;
			}
			String decl = m.toString();
			list.add(decl.replace("java.lang.",""));
		}
		return list;
	}
	protected String modifierString(int v) {
	    if (Modifier.isPrivate(v))  return "private";
	    if (Modifier.isPublic(v))  return "public";
	    if (Modifier.isProtected(v)) return "protected";
	    return "";
	}
//	protected Object convert(String paramName,String type) {
//
//	}

	private JPanel initTitlePanel(String...strings) {
		JPanel title = new JPanel();
		title.setLayout(new GridLayout(1,strings.length));
		for(String str : strings) {
			title.add(new JLabel(str));
		}
		return title;
	}

}
