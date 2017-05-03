import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class CharList extends JScrollPane{
	
	public CharList(String c, int index){

		DefaultListModel<Object> listModel = new DefaultListModel<Object>();
		
		for (int i = 0; i < 15; i++) {
			String s = c+String.valueOf(i);
			listModel.addElement(s);
		}

		JList<?> list = new JList<Object>(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectedIndex(0);
		this.setBounds((65*index), 0, 65, 192);
		this.setViewportView(list);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		
	}

}
