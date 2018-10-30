import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane, internalPane;
	private JTextField input, output;
	private JScrollPane scrollPane;
	private JComboBox<String> mode;
	
	private boolean extendedMode=false;
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
		setBounds(100, 100, 450, 400);
		//main pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.setResizable(false);
		
		//output textfield
		output = new JTextField("output");
		
		output.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				output.selectAll();
			}
		});
		
		output.setEditable(false);
		output.setBounds(5, 338, 424, 23);
		contentPane.add(output);
		
		//input textfield
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//internalPane.removeAll();
				updatePane(input.getText());
			}
		});
		input.setBounds(5, 42, 424, 20);
		contentPane.add(input);
		input.setColumns(10);
		

		//pane that contains char lists
		internalPane = new JPanel();
		internalPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		internalPane.setLayout(new GridLayout());
		
		//scrollpane to contain internalPane
		scrollPane = new JScrollPane(internalPane);

		scrollPane.setBounds(5, 73, 424, 254);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		contentPane.add(scrollPane);
        contentPane.setPreferredSize(new Dimension(300, 400));
        
        mode = new JComboBox<String>();
        mode.addItem("Normal");
        mode.addItem("Extended");
        mode.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		extendedMode=mode.getSelectedItem().equals("Extended");
        		updatePane(input.getText());
        	}
        });
        mode.setBounds(10, 11, 125, 20);
        contentPane.add(mode);
		
	}
	
	public void updatePane(String text){
		//output.setText(text);
		int[] selIndexes = new int[text.length()];
		for(int i=0; i<text.length(); i++){
			selIndexes[i]=internalPane.getComponentCount()-1<i?0:((CharList)internalPane.getComponents()[i]).getSelectedIndex();
		}
		internalPane.removeAll();
		
		for(int i=0; i<text.length(); i++){
			addCharList(String.valueOf(text.charAt(i)), selIndexes[i]);
		}
		
		String outp="";
		for(Component c : internalPane.getComponents()){
			if(c instanceof CharList){
				outp+=((CharList)c).getSelectedChar();
				((CharList)c).getJList().addListSelectionListener(new ListSelectionListener(){
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						String outp="";
						for(Component c : internalPane.getComponents()){
							if(c instanceof CharList)
								outp+=((CharList)c).getSelectedChar();
						}
						output.setText(outp);
					}
				});
				
			}
		}
		output.setText(outp);
		
		this.setVisible(true);
		
	}
	
	public void addCharList(String c, int selectedValue){
		internalPane.add(new CharList(c, internalPane.getComponentCount(), selectedValue, extendedMode));
	}
}
