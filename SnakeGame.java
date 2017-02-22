import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class SnakeGame extends JPanel implements KeyListener, ActionListener {
	int x = (int) (Math.random()*200);
	int y = (int) (Math.random()*200);
	int xApple = (int) (Math.random()*200);
	int yApple = (int) (Math.random()*200);
	int xVel = 0;
	int yVel= 0;
	Timer t = new Timer (5, this);
	
	public SnakeGame(){
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graph = (Graphics2D) g;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRect(x, y, 15, 15);
		g.setColor(Color.red);
		g.fillOval(xApple, yApple, 15,15);		
	}
	

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_LEFT){
			xVel = -1;
			yVel = 0;
			System.out.println("left");
			
		}
		if(key== KeyEvent.VK_RIGHT){
			xVel = 1;
			yVel = 0;
			System.out.println("right");
		}
		if(key== KeyEvent.VK_UP){
			yVel = -1;
			xVel = 0;
			System.out.println("up");
		}
		if(key == KeyEvent.VK_DOWN){
			yVel = 1;
			xVel = 0;
			System.out.println("down");
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
//		x += xVel;
//		y += yVel;
//		repaint();
		
	}
	private void moveSnake(){
		x += xVel;
		y += yVel;
	}
	public static void main(String[] args){
		JFrame frame = new JFrame("Snake");
		frame.setSize(300, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SnakeGame game = new SnakeGame();
		frame.add(game);
		while(true){
			frame.setVisible(true);
			game.repaint();
			game.moveSnake();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


}
