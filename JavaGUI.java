
 
//Christopher Santiago
//Working with GUI in Java. Utilizing the Swing and AWT Libraries
//02/15/18

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class GUIActionListener implements ActionListener, ListSelectionListener {
	MyFrame fr;
	public GUIActionListener(MyFrame frame) {
		fr = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(fr.jcb.getSelectedIndex() == 0) {
			fr.jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} else {
			fr.jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
	}

	
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == fr.jlst) {
			JList lst = (JList) e.getSource();
			String destinations = "";
			int[] selected = lst.getSelectedIndices();
			for(int i = 0; i < selected.length; i++) {
				destinations += lst.getModel().getElementAt(selected[i]) + ", ";
			}
			fr.jlbl.setText("Selected items:" + destinations);
			
		}
	}
	
}

class MyFrame extends JFrame {
	public JLabel jlbl;
	public JList jlst;
	public JComboBox jcb;
	public MyFrame() {
		super();
		init();
	}
	
	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setLocation(800, 400);
		JComponent panel = new JPanel();
		String[] countries = {"England", "Czech Republic", "Hungary", "Austria", "Scotland", "Puerto Rico", "United States"};
		jlst = new JList(countries);
		jlst.addListSelectionListener(new GUIActionListener(this));
		String[] selections = {"Single", "Multiple"};
		jcb = new JComboBox(selections);
		jcb.addActionListener(new GUIActionListener(this));
		jlbl = new JLabel("Selected items will appear here");
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("Choose Selection Mode:"));
		panel.add(jcb);
		this.add(panel, BorderLayout.NORTH);
		this.add(jlst, BorderLayout.WEST);
		this.add(jlbl, BorderLayout.SOUTH);
		this.pack();
	}
	
}
	

public class JavaGUI {

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(
			 "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception e) { }
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
	}

}
