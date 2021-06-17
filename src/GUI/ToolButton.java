package GUI;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Tool.Tool;

public class ToolButton extends JButton{
	Tool tool;
	public ToolButton(Tool tool,Icon icon) {
		this.tool=tool;
		this.setPreferredSize(new Dimension(25,25));
		this.setIcon(icon);
	}
}
