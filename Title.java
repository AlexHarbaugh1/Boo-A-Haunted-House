
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author hyattkamel
 */
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;


public class Title {
    
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel,attackbuttonPanel,exitButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 45);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton,attackbutton,exitbutton;
    JTextArea mainTextArea = new JTextArea();

    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    
   
    
    public void UpdateTextArea(String text) {
    SwingUtilities.invokeLater(() -> {
        
        mainTextArea.setText(text);        
        mainTextArea.setCaretPosition(mainTextArea.getDocument().getLength()); // Auto-scroll to bottom
        
    });
}
    
    public Title() {
    
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setVisible(true);
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Boo! A Haunted House");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
       
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        window.setVisible(true);
    }
   
    
    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 150);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        mainTextArea.setText("You have entered the haunted house... \n Beware of Monsters!");
        mainTextArea.setBounds(100, 100, 500, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // ATTACK BUTTON
        attackbuttonPanel = new JPanel();
        attackbuttonPanel.setBounds(200, 400, 200, 100);
        attackbuttonPanel.setBackground(Color.black);
        
        attackbutton = new JButton("ATTACK");
        attackbutton.setBackground(Color.white);
        attackbutton.setForeground(Color.black);
        attackbutton.setFont(normalFont);
        attackbutton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Set choice[0] to 1 when the attack button is clicked
            System.out.print("Attack button clicked");
        }
    });
        attackbutton.setFocusPainted(false);
 
        attackbuttonPanel.add(attackbutton);
        // END ATTACK BUTTON
        
        //EXIT BUTTON
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(400, 400, 200, 100);
        exitButtonPanel.setBackground(Color.black);
        
        exitbutton = new JButton("EXIT");
        exitbutton.setBackground(Color.white);
        exitbutton.setForeground(Color.black);
        exitbutton.setFont(normalFont);
        exitbutton.addActionListener(e -> System.exit(0));
        exitbutton.setFocusPainted(false);
        exitButtonPanel.add(exitbutton);
        // END EXIT BUTTON
        
        con.add(titleNamePanel);
        con.add(attackbuttonPanel);
        con.add(exitButtonPanel);
        window.setVisible(true);
    }
    

    
    public class TitleScreenHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            try {
                    File soundFile = new File("src/Dungeon-master/boo.wav");
                    if (!soundFile.exists()) 
                    {
                        System.err.println("File not found: " + soundFile.getAbsolutePath());
                        return;
                    
                    }                   
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    createGameScreen();
                    } catch (Exception f) {
                    return;
                    }
            
        }
    }
}


package Screen;
import java.awt.*;
import javax.swing.JFrame;


public class Screen {
    
    private GraphicsDevice vc;
    
    public Screen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();
    }
    
    public void setFullscreen(DisplayMode dm, JFrame window) {
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);
        
        if(dm != null && vc.isDisplayChangeSupported()) {
            try{
                vc.setDisplayMode(dm);
            }catch(Exception ex) {}
        }
             
    }
    
    public Window getFullScreenWindow() {
        return vc.getFullScreenWindow();
    }
    
    public void restoreScreen() {
        Window w = vc.getFullScreenWindow();
        if(w != null){
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }
}

