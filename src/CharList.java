import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CharList extends JScrollPane{
	private JList<?> list;
	private Characters charClass;
	
	public CharList(String c, int index, int selectedIndex, boolean extendedMode){
		charClass = new Characters(extendedMode);

		DefaultListModel<Object> listModel = new DefaultListModel<Object>();
		
		
		ArrayList<String> chars = charClass.getCharsForLetter(c);
		
		for (int i = 0; i < chars.size(); i++) {
			listModel.addElement(chars.get(i));
		}

		list = new JList<Object>(listModel);
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectedIndex(selectedIndex>list.getComponentCount()-1?selectedIndex:0);
		
		this.setBounds((65*index), 0, 65, 192);
		this.setPreferredSize(new Dimension(40, 0));
		this.setViewportView(list);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		
	}
	
	public String getSelectedChar(){
		return (String) list.getSelectedValue();
	}
	
	public int getSelectedIndex(){
		return list.getSelectedIndex();
	}
	
	public JList<?> getJList(){
		return list;
	}

}
