import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

	
	public class GamePanel extends JPanel 
	implements ActionListener, KeyListener{  
	
	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font smolFont = new Font("Arial", Font.PLAIN, 24);
    Timer frameDraw = new Timer(1000/60, this);
    Rocketship ship = new Rocketship(250, 700, 50, 50);
   
    public GamePanel(){
    	 frameDraw.start();
    }
    @Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		ship.move();
	}
	public void updateEndState() {
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 50, 100);
		g.setFont(smolFont);
		g.drawString("Press Enter to start", 150, 300);
		g.setFont(smolFont);
		g.drawString("Press Space for instructions", 100, 500);
		
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);
		ship.draw(g);
	}
	public void  drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("Game Over", 50, 100);
		g.setFont(smolFont);
		g.drawString("You killed enemies", 150, 300);
		g.drawString("Press Enter to restart", 100, 500);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		    System.out.println("action");
		    
		}	
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}  
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {		    
			ship.up=true;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    ship.down=true;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			ship.left=true;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		    ship.right=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {
		    ship.up=false;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    ship.down=false;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			ship.left=false;
		}
		if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		    ship.right=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
	
