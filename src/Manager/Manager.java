package Manager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import GUI.Canvas;
import GUI.Frame;
import GUI.IOPanel;
import Tool.Tool;

public class Manager {
	Graphics g;
	Frame frame;
	Canvas canvas;
	Tool tool;
	IOPanel iopanel;
	BufferedImage buttons_image;	
	
	int selectedColor;
	int color[][] = new int[100][14];
	IO io;
	public Manager() {
		io = new IO(this);
		
		//ƒAƒCƒRƒ““Ç‚Ýž‚Ý
		try {
		  buttons_image= ImageIO.read(new File(".\\Button.png"));
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	public void setIopanel(IOPanel iopanel) {
		this.iopanel = iopanel;
	}
	public IOPanel getIopanel() {
		return iopanel;
	}
	public Graphics getGraphics() {
		return g;
	}
	public void setGraphics(Graphics g) {
		this.g = g;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public Tool getTool() {
		return tool;
	}
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	public Color toColor(int c) {
		int r,g,b;
		r= (c%6);
		g=((c/6)%6);
		b= (c/36);
		r*=(255/5);
		g*=(255/5);
		b*=(255/5);
		selectedColor=c;
		return new Color((int)r,(int)g, (int)b);
	}

	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public void draw(int x,int y){
		if(0>x||x>=14||y<0||y>=100)return;
		this.color[y][x]=selectedColor;
		canvas.repaint();
	}
	public void output(){
		io.write(color);
	}
	public BufferedImage getButtons_image() {
		return buttons_image;
	}
}
