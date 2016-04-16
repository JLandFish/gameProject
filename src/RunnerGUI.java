
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class RunnerGUI extends JFrame implements ActionListener  {

    
    JPanel pnlButton = new JPanel();
    
    JButton clearboard = new JButton("Press to Clear Board");
    JButton start = new JButton("Press to Start!");
    JButton basicW1 = new JButton("Basic attack for Player 1");
    JButton basicW2 = new JButton("Basic attack for Player 2");
    JButton healW1 = new JButton("Heal 10HP for Player 1");
    JButton healW2 = new JButton("Heal 10HP for Player 2");
    JButton manaW1 = new JButton("Recover 5 MP for Player 1");
    JButton manaW2 = new JButton("Recover 5 MP for Player 2");
    JButton specW1 = new JButton("Special Attack for Player 1");
    JButton specW2 = new JButton("Special attack for Player 2");
    JLabel recentEvent = new JLabel();
    JLabel currentHP1 = new JLabel();
    JLabel currentHP2 = new JLabel();
    JLabel currentMP1 = new JLabel();
    JLabel currentMP2 = new JLabel();
    JLabel healCounter = new JLabel();
    JLabel mpCounter = new JLabel();
    Warrior Player1 = new Warrior(1000, 25, (int)(Math.random() * 20 + 1), "Pink Guy", "Normal");
    Warrior Player2 = new Warrior(1000, 25, (int)(Math.random() * 20 + 1), "Weeaboo", "Weeaboo"); 
    JButton[] P1 = {basicW1, healW1, manaW1, specW1};
    JButton[] P2 = {basicW2, healW2, manaW2, specW2};
    private int HP1_COUNTER;
	private int HP2_COUNTER;
	private int MP1_COUNTER;
	private int MP2_COUNTER;
    
   
    
    
    
    public RunnerGUI() {
    	pnlButton.setLayout(null);
    
        basicW1.setBounds(190, 70, 200, 30);
        healW1.setBounds(190, 100, 200, 30);		
        manaW1.setBounds(380, 100, 200, 30);
        specW1.setBounds(380, 70, 200, 30);
        
        basicW2.setBounds(190, 300, 200, 30);
        healW2.setBounds(190, 330, 200, 30);
        manaW2.setBounds(380, 330 , 200, 30);
        specW2.setBounds(380, 300, 200, 30);
        

        pnlButton.setBounds(800, 800, 200, 100);

       
        pnlButton.add(basicW1);
        pnlButton.add(basicW2);
        pnlButton.add(healW1);
        pnlButton.add(healW2);
        pnlButton.add(manaW1);
        pnlButton.add(manaW2);
        pnlButton.add(specW1);
        pnlButton.add(specW2);
        pnlButton.add(start);
        pnlButton.add(clearboard);
        basicW1.addActionListener(this);
        basicW2.addActionListener(this);
        healW1.addActionListener(this);
        healW2.addActionListener(this);
        manaW1.addActionListener(this);
        manaW2.addActionListener(this);
        specW1.addActionListener(this);
        specW2.addActionListener(this);
        
        
       
        
        add(pnlButton);
        currentHP1.setText(" Player 1 Health : "+ Player1.HP);
        pnlButton.add(currentHP1);
        currentHP1.setLocation(50, -10);
        currentHP1.setSize(200,200);
        currentHP2.setText(" Player 2 Health : " + Player2.HP);
        pnlButton.add(currentHP2);
        currentHP2.setLocation(50, 220);
        currentHP2.setSize(200,200);
        currentMP1.setText("Player 1 MP : " + Player1.MP);
        pnlButton.add(currentMP1);
        currentMP1.setLocation(50,20);
        currentMP1.setSize(200,200);
        currentMP2.setText("Player 2 MP : " + Player2.MP);
        pnlButton.add(currentMP2);
        currentMP2.setLocation(50,250);
        currentMP2.setSize(200,200);
        pnlButton.add(recentEvent);
        recentEvent.setLocation(300,300);
        recentEvent.setSize(300, 200);
       
        
        
        

     
        setSize(800, 600);
        setBackground(Color.BLACK);
        setTitle("Text Based Combat Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    
   
    
    	
    }
    private void startGame()
    {
    	for(int i = 0; i < P1.length; i++)
    	{
    		JButton hold = P1[i];
    		hold.setVisible(true);
    		JButton hold2 = P2[i];
    		hold2.setVisible(true);
    		start.setVisible(false);
    	   
    	}
   }
   
    private void switchToPlayer2()
    {
    	for(int i = 0;  i < P1.length; i++)
		{
			 JButton hold = P1[i];
			 hold.setVisible(false);
			 JButton hold2 = P2[i];
			 hold2.setVisible(true);
			 
			
		}
    }
    private void switchToPlayer1()
    {
    	for(int i = 0;  i < P2.length; i++)
		{
			 JButton hold = P2[i];
			 hold.setVisible(false);
			 JButton hold2 = P1[i];
			 hold2.setVisible(true);
			
		}
    }
  
    
    	   
 



	public void actionPerformed(ActionEvent button) {
	   
	 

		if(button.getSource() == basicW1)
		{
		Player1.Damage += 10; 
		int TOTAL_DMG1 = Player1.getDMG() + Player1.Damage + (int)(Math.random() * 5 + 1);
		Player2.HP -= TOTAL_DMG1;
		currentHP2.setText("Player 2 Health : " + Player2.HP);
		recentEvent.setText("Player 1 does a Basic Attack! Player 1 Deals:" + Player1.Damage);
	    switchToPlayer2();
		}
		else if(button.getSource() == healW1  && HP1_COUNTER < 3)
		{
			
			Player1.HP += 50;
			currentHP1.setText("Player 1 Health : " + Player1.HP);
			recentEvent.setText("Player 1 heals 50 HP");
			HP1_COUNTER++;
		    switchToPlayer2();
			
		
		}
		else if(button.getSource() == manaW1 && MP1_COUNTER < 3)
		{
			Player1.MP += 10;
			currentMP1.setText("Player 1 MP : " + Player1.MP);
			recentEvent.setText("Player 1 regenerates 10 MP");
			MP1_COUNTER++;
			switchToPlayer2();
		}
		else if(button.getSource() == specW1 && Player1.MP >= 10)
		{
			Player1.Damage += 30;
			int TOTAL_DMG1 = Player1.getDMG() + Player1.Damage + (int)(Math.random() * 5 + 1);
			Player1.MP -= 10;
			Player2.HP -= TOTAL_DMG1;
			currentHP2.setText(" Player 2 Health : " + Player2.HP);
			recentEvent.setText("Player 1 does a Special Attack and deals : " + TOTAL_DMG1);
			
			switchToPlayer2();
			
		}
		else if(button.getSource() == basicW2)
		{
			Player2.Damage +=10; 
			int TOTAL_DMG1 = Player2.getDMG() + Player2.Damage + (int)(Math.random() * 5 + 1);
			Player1.HP -= TOTAL_DMG1;
			currentHP1.setText("Player 1 Health : " + Player1.HP);
			recentEvent.setText("Player 2 does a Basic Attack! Player 2 Deals:" + Player2.Damage);
		    switchToPlayer1();
			
		}
		else if(button.getSource() == healW2 && HP2_COUNTER < 3)
		{
			Player2.HP += 50;
			currentHP2.setText("Player 2 Health : " + Player2.HP);
			recentEvent.setText("Player 2 Heals 50 HP");
			HP2_COUNTER++;
			switchToPlayer1();
			
			
		}
		else if(button.getSource() == manaW2 && MP2_COUNTER < 3 )
		{
			Player2.MP += 10;
			currentMP2.setText("Player 2 MP : " + Player2.MP);
			recentEvent.setText("Player 2 regenerates 10 MP" );
			MP2_COUNTER++;
			for(int i = 0;  i < P2.length; i++)
			switchToPlayer1();
			
			
		}
		else if(button.getSource() == specW2 && Player2.MP >= 10)
		{
			Player2.Damage += 30;
			int TOTAL_DMG1 = Player2.getDMG() + Player2.Damage + (int)(Math.random() * 5 + 1);
			Player2.MP -= 10;
			Player1.HP -= TOTAL_DMG1;
			currentHP1.setText(" Player 1 Health : " + Player1.HP);
			recentEvent.setText("Player 2 does a Special Attack and deals : " + TOTAL_DMG1);
			switchToPlayer1();
			
		}
			
	
		else if(button.getSource() == healW1 && HP1_COUNTER == 3)
		{
			recentEvent.setText(Color.RED + "Player 1 Cannot Heal anymore!");
			switchToPlayer1();
		
			
		}
		else if(button.getSource() == healW2 && HP2_COUNTER == 3)
		{
			recentEvent.setText("Player 2 Cannot Heal anymore!");
			switchToPlayer2();
			
		}
		else if(button.getSource() == manaW1 && MP1_COUNTER == 3)
		{
			recentEvent.setText("Player 1 Cannot Regenerate MP anymore!");
			switchToPlayer1();
		
		}
		else if(button.getSource() == manaW2 && MP2_COUNTER == 3)
		{
			recentEvent.setText("Player 2 Cannot Regenerate MP anymore!");
			switchToPlayer2();
		}
		else if(button.getSource() == specW1 && Player1.MP < 10)
		{
			recentEvent.setText("Player 1 mana is too low!");
			switchToPlayer1();
			
			
		}
		else if(button.getSource() == specW2 && Player2.MP < 10)
		{
			recentEvent.setText("Player 2's mana is too low!");
		    switchToPlayer2();
		
		}
		
		 if(Player1.HP <= 1 || Player2.HP <= 1)
		{
			System.exit(0);
		}
	}
	
	   public static void main(String[] args) {
	    	
	    	new RunnerGUI();
	    	
	     
	    }

}

 
	