package GUI;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Panel extends JPanel{
	Canvas canvas;
	Pallet pallet;
	IOPanel iopanel;
	ToolPanel toolpanel;
	Panel(Canvas canvas,Pallet pallet,IOPanel iopanel,ToolPanel toolpanel){
		setLayout(null);
		this.iopanel = iopanel;
		this.canvas = canvas;
		this.pallet = pallet;
		this.toolpanel = toolpanel;
		iopanel.setBounds(50*14+50,0,300,150);
		canvas.setBounds(0,0,50*14,50*5*20);
		canvas.setPreferredSize(new Dimension(50*14, 50*100));
		pallet.setBounds(50*14+50,230,300,800);
		toolpanel.setBounds(50*14+50,150,300,70);
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(canvas);
		sp.setBounds(0, 0, 50*14+30, 750);
		sp.getVerticalScrollBar().setUnitIncrement(25);
		add(sp);
		add(pallet);
		add(iopanel);
		add(toolpanel);
	}
}
