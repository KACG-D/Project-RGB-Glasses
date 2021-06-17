package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Manager.Manager;

public class Pallet extends JPanel implements ActionListener{
	Manager m;
	JPanel p1,p2;
	Pallet(Manager m){
		this.m=m;
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setBorder(new TitledBorder(new EtchedBorder()));
		p1.setBackground(Color.BLACK);
		p1.setBounds(0, 0, 30, 30);
		
		p2.setPreferredSize(new Dimension(250, 380));
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(p2);
		sp.setBounds(0,50,300,300);
		sp.setBorder(new TitledBorder(new EtchedBorder(), "pallet"));
		setLayout(null);
		for(int i=0;i<216;i++){
			JButton button = new JButton(i+"");
			button.setBackground(m.toColor(i));
			button.addActionListener(this);
			button.setPreferredSize(new Dimension(16,16));
			p2.add(button);
		}
		add(p1);add(sp);
	}
	void setColor(int c){
		m.getGraphics().setColor(m.toColor(c));
		p1.setBackground(m.toColor(c));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		setColor(Integer.valueOf(button.getText()));
	}
}
