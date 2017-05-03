import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private JPanel contentPane, internalPane;
	private JTextField input;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("L33T Writer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextField output = new JTextField("output");
		output.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				output.selectAll();
			}
		});
		
		output.setEditable(false);
		output.setBounds(5, 228, 424, 23);
		contentPane.add(output);
		
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				output.setText(input.getText());
				internalPane.removeAll();
				for(int i=0; i<input.getText().length(); i++){
					addCharList(String.valueOf(input.getText().charAt(i)));
				}
				for(Component c : internalPane.getComponents()){
					c.repaint();
				}
				internalPane.repaint();
				scrollPane.repaint();
			}
		});
		input.setBounds(5, 5, 424, 20);
		contentPane.add(input);
		input.setColumns(10);
		

		/*
		DefaultListModel<Object> listModel = new DefaultListModel<Object>();
		
		for (int i = 0; i < 15; i++) {
			String s = "value "+String.valueOf(i);
			listModel.addElement(s);
		}
		
		JList<?> charListColl = new JList<Object>(listModel);
		charListColl.setBounds(5, 36, 51, 181);
		charListColl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		charListColl.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		charListColl.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				output.setText(String.valueOf(charListColl.getSelectedIndex()));
			}
		});
		*/

		internalPane = new JPanel();
		internalPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		internalPane.setLayout(new GridLayout());
		
		//add children(plavceholder)
		addCharList("a");
		addCharList("b");
		addCharList("c");
		addCharList("d");
		addCharList("e");
		addCharList("f");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		addCharList("g");
		
		scrollPane = new JScrollPane(internalPane);

		scrollPane.setBounds(5, 36, 424, 192);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		contentPane.add(scrollPane);
        contentPane.setPreferredSize(new Dimension(300, 400));
		

		
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 25, 419, 192);
		contentPane.add(scrollPane);
		*/
		
		//scrollPane.setViewportView(internalPanel);
		
		
		/*
		JScrollPane mainScroll = new JScrollPane();
		mainScroll.setBounds(5, 25, 424, 192);
		*/
	}
	
	public void addCharList(String c){
		internalPane.add(new CharList(c, internalPane.getComponentCount()));
	}
}
