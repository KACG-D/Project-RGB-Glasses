package GUI;
import javax.swing.JFrame;

import Manager.Manager;

public class Frame extends JFrame{
	Panel panel;
	Manager m;
	public Frame(Manager m){
		super("RGB glasses");
		this.m = m;
		Canvas canvas = new Canvas();
		PaintListener pl = new PaintListener(m);
		Pallet pallet = new Pallet(m);
		ToolPanel toolpanel = new ToolPanel(m);
		panel = new Panel(canvas,pallet,new IOPanel(m),toolpanel);
		panel.setBounds(100, 0, 1100, 800);

		canvas.addMouseListener(pl);
		canvas.addMouseMotionListener(pl);
		canvas.setFocusable(true);

		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1100, 800);
		this.setVisible(true);
		m.setCanvas(canvas);
		m.setGraphics(canvas.getGraphics(1));
	}
}
