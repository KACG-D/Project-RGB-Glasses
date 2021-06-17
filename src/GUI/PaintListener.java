package GUI;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import Manager.Manager;

public class PaintListener implements MouseInputListener{
	Manager m;
	public PaintListener(Manager m) {
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e){
		m.getGraphics().fillRect((e.getX()/50)*50, (e.getY()/50)*50, 50, 50);
		m.draw(e.getX()/50, e.getY()/50);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		m.getGraphics().fillRect((e.getX()/50)*50, (e.getY()/50)*50, 50, 50);
		m.draw(e.getX()/50, e.getY()/50);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
