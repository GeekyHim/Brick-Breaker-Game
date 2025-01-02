import javax.swing.JPanel;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
    //panel where we run our game
public class Gameplay extends JPanel implements KeyListener,ActionListener  {
    // basic properties
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21; //defines the no of bricks and hence the map

    private Timer timer; // ball ko time and speed dene ke liye
    private int delay = 10;

    //player and ball positions
    private int playerX = 310;
    
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    // constructor 
    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){
        //ye graphic object receive karega jiski help se hum bricks, slider etc sab banayege
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        //border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint(); // recall paint method, and draw everything again tabhi show hoga
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(playerX>=600) playerX =600; //agar border pe hai toh vahi rakho
            else moveRight();
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(playerX<=10) playerX = 10; //agar border pe hai toh vahi rakho
            else moveLeft();
        }
    }

    public void moveRight(){
        play = true; // upar play false pe set tha
        playerX+=20; // 20 to right
    }

    public void moveLeft(){
        play = true; // upar play false pe set tha
        playerX-=20; 
    }
    //No need for these but need to define nevertheless coz interface ka part and is compulsory
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

        
    
}
