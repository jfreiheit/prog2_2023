package themen.zwei;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MemoryPanel extends JPanel {
	
	enum State { SHOW, HIDE, CLICKED }
	
	private Color color;
	private State state;
	
	public MemoryPanel(Color color) {
		super();
		this.color = color;
		this.setBackground(color);
		this.state = State.CLICKED;
		this.addToMouseListener();
	}
	
	private void addToMouseListener() {
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(MemoryPanel.this.isHidden()) {
					MemoryPanel.this.show();
					MemoryPanel.this.state = State.CLICKED;
				}
			}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			
		});
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void refreshPanel(Color color) {
		this.color = color;
		this.setBackground(color);
		this.state = State.CLICKED;
	}
	
	public void show() {
		this.setBackground(this.color);
		this.setStateToShow();
	}
	
	public void hide() {
		this.setBackground(Color.GRAY);
		this.setStateToHide();
	}
	
	public boolean isClicked() {
		return this.state == State.CLICKED;
	}
	
	public boolean isHidden() {
		return this.state == State.HIDE;
	}
	
	public boolean isShown() {
		return this.state == State.SHOW;
	}
	
	public void setStateToShow() {
		this.state = State.SHOW;
	}
	
	public void setStateToHide() {
		this.state = State.HIDE;
	}
}
