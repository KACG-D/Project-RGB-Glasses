package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Manager.Manager;

public class IOPanel extends JPanel implements ActionListener{
	JButton output,input;
	Manager m;
	JSpinner spin;
	JComboBox<String> combo;
	public IOPanel(Manager m) {
		JPanel p1=new JPanel(),p2=new JPanel(),p3=new JPanel();
		p1.setBounds(0,0,300,70);
		p2.setBounds(0,70,100,70);
		p3.setBounds(100, 70, 200, 70);
		p1.setBorder(new TitledBorder(new EtchedBorder(), "input/output"));
		p2.setBorder(new TitledBorder(new EtchedBorder(), "No"));
		p3.setBorder(new TitledBorder(new EtchedBorder(), "Mode"));
		output = new JButton("Save");
		input = new JButton("Load");
		spin = new JSpinner(new SpinnerNumberModel(1,1, 10, 1));
		output.addActionListener(this);
		input.addActionListener(this);
		combo = new JComboBox<>();
		combo.addItem("stop");
		combo.addItem("moveª");
		combo.addItem("move«");
		combo.addItem("move©");
		combo.addItem("move¨");
		combo.addItem("stop+");
		combo.addItem("moveª+");
		combo.addItem("move«+");
		combo.addItem("move©+");
		combo.addItem("move¨+");
		p1.add(output);
		p1.add(input);
		p2.add(spin);
		p3.add(combo);
		setLayout(null);
		add(p1);add(p2);add(p3);
		this.m=m;
		m.setIopanel(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object b = e.getSource();
		if(b == output){
			m.output();
		}
	}

	public int getFilenum(){
		return (Integer)spin.getValue();
	}
	public int getMode(){
		return combo.getSelectedIndex();
	}
}
