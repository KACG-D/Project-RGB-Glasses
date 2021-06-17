package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Manager.Manager;
import Tool.*;

public class ToolPanel extends JPanel implements ActionListener{
	ToolButton pen,syringe,baketsu;
	Manager m;
	public ToolPanel(Manager m) {
		this.m=m;
		setBorder(new TitledBorder(new EtchedBorder(), "Tools"));
		pen = new ToolButton(new Pen(),new ImageIcon(m.getButtons_image().getSubimage(0, 0, 20, 20)));
		syringe = new ToolButton(new Pen(),new ImageIcon(m.getButtons_image().getSubimage(0, 20, 20, 20)));
		baketsu = new ToolButton(new Pen(),new ImageIcon(m.getButtons_image().getSubimage(0, 40, 20, 20)));
		pen.addActionListener(this);
		pen.addActionListener(this);
		pen.addActionListener(this);
		add(pen);add(syringe);add(baketsu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ToolButton tb = (ToolButton)e.getSource();
		m.setTool(tb.tool);
	}
}
