package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	BufferedImage image;
	Canvas (){
		image = new BufferedImage(50*14, 50*5*20, BufferedImage.TYPE_3BYTE_BGR);
		
		}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g.drawImage(image, 0,0,this);
		g.setColor(Color.black);
		for(int i=0;i<100;i++){
			if(i%5==0){
				g2.setColor(Color.RED);
				g2.setStroke(new BasicStroke(3));
				g2.drawString(""+(i/5), 0, i*50);
			}
			else {
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(1));
			}
			g2.drawLine(0, 50*i, 50*14, 50*i);
		}
		for(int i=0;i<14;i++){
			g.drawLine( 50*i,0, 50*i, 50*100);
		}
	}

	public Graphics getGraphics(int fake) {
		return image.createGraphics();
	}
}
