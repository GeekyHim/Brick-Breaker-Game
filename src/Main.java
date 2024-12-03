import javax.swing.JFrame;
public class Main{
    public static void main(String[] args) {
        /*
         * JFrame is a built in class and package that is used to design the GUI window
         * We are using this to design the gui window of our game
         * the icons used to minimize and close the program etc. are going to be made using this
         * now after creating its object i am going to be setting all the neccesary values
         */
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay(); // game panel ke liye
        obj.setBounds(10,10,700,600);
        obj.setTitle("Breaking Out");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);

    }
}


