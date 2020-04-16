package gui.panels;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MemberPanel extends JPanel{

	private JPanel titlePanel;

	private JScrollPane scrollPane;

	public MemberPanel(int itemNum,String...strings) {
		this.titlePanel = initTitlePanel(strings);

		this.scrollPane = new JScrollPane(this);
		this.setPreferredSize(new Dimension(1100,(41 * itemNum)));
		this.setLayout(null);
		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	}

	public JPanel getTitlePanel() {
		return this.titlePanel;
	}

	public JScrollPane getMainPane() {
		return this.scrollPane;
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
	public String modifierString(int v) {
	    if (Modifier.isPrivate(v))  return "private";
	    if (Modifier.isPublic(v))  return "public";
	    if (Modifier.isProtected(v)) return "protected";
	    return "";
	}

	private JPanel initTitlePanel(String...strings) {
		JPanel title = new JPanel();
		title.setLayout(new GridLayout(1,strings.length));
		for(String str : strings) {
			JLabel label = new JLabel(str);
			label.setFont(new Font("Century",Font.BOLD,20));
			title.add(label);
		}
		return title;
	}

}
