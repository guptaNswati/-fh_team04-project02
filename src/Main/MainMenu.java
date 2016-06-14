import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

public class MainMenu implements ActionListener {
   private JFrame menuFrame;
   private JPanel menuPanel;   
   private JButton startButton;
   private JButton exitButton;
   private JPanel helpPanel;
   private JButton helpButton;
   private JTextArea instructionTextBox;
   private JButton closeHelp;
   private JPanel settingsPanel;
   private JButton settingsButton;
   private JButton colorBlind;
   private JButton singlePlayer;
   private JButton twoPlayer;
   private JButton closeSettings;     
   private KamisadoBoard board;  
   private ColorBlindBoard symbolsBoard;

   MainMenu() {
      menuFrame = new JFrame("Main Menu");
      menuFrame.setBounds(0, 0, 450, 450);
      menuFrame.setLocationRelativeTo(null);
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      java.awt.Container contentPane = menuFrame.getContentPane();
      SpringLayout layout = new SpringLayout();
      contentPane.setLayout(layout);

      JLabel label = new JLabel("Kamisado");
      label.setFont(new Font("Sans Serif",Font.ITALIC, 28));
      label.setForeground(Color.RED);
      contentPane.add(label);

      menuPanel = new JPanel();
      menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      contentPane.add(menuPanel);

      layout.putConstraint(SpringLayout.NORTH, label, 40, SpringLayout.NORTH,
            contentPane);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0,
            SpringLayout.HORIZONTAL_CENTER, contentPane);

      layout.putConstraint(SpringLayout.NORTH, menuPanel, 90,
            SpringLayout.NORTH, contentPane);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, menuPanel, 0,
            SpringLayout.HORIZONTAL_CENTER, contentPane);

      startButton = new JButton("Start");
      startButton.addActionListener(this);
      menuPanel.add(startButton);

      helpButton = new JButton("Help");
      helpButton.addActionListener(this);
      menuPanel.add(helpButton);
      
      settingsButton = new JButton("Settings");
      settingsButton.addActionListener(this);
      menuPanel.add(settingsButton);

      exitButton = new JButton("Exit");
      exitButton.addActionListener(this);
      menuPanel.add(exitButton);
      
      
      
      settingsPanel = new JPanel();
      settingsPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
      settingsPanel.setBackground(Color.ORANGE);
//      settingsPanel.setPreferredSize(new Dimension(250, 180));
      contentPane.add(settingsPanel);     
      settingsPanel.setLayout(new BorderLayout());
      layout.putConstraint(SpringLayout.NORTH, settingsPanel, 150,
            SpringLayout.NORTH, contentPane);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, settingsPanel, 0,
            SpringLayout.HORIZONTAL_CENTER, contentPane); 
            
      Box box = Box.createVerticalBox();
      singlePlayer = new JButton("Single Player");
      singlePlayer.addActionListener(this);
      box.add(singlePlayer);
      
      box.add(Box.createVerticalStrut(10));
      twoPlayer = new JButton("Two Player");
      twoPlayer.addActionListener(this);
      box.add(twoPlayer);
      
      box.add(Box.createVerticalStrut(10));
      colorBlind = new JButton("Color Blind");
      colorBlind.addActionListener(this);
      box.add(colorBlind);
      box.add(Box.createVerticalStrut(10));
      
      closeSettings = new JButton("Close");
      closeSettings.addActionListener(this);
      box.add(closeSettings);
      
      settingsPanel.add(box);
      settingsPanel.setVisible(false);

      helpPanel = new JPanel();
      helpPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      helpPanel.setBackground(Color.BLACK);
      helpPanel.setPreferredSize(new Dimension(250, 180));
      contentPane.add(helpPanel);
      helpPanel.setLayout(new BorderLayout());
      layout.putConstraint(SpringLayout.NORTH, helpPanel, 150,
            SpringLayout.NORTH, contentPane);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, helpPanel, 0,
            SpringLayout.HORIZONTAL_CENTER, contentPane);
      instructionTextBox = new JTextArea();
      instructionTextBox
            .setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      instructionTextBox.setBackground(Color.BLACK);
      instructionTextBox.setForeground(Color.green);
      instructionTextBox
            .setText("Instructions: \n \n Move piece forward: straight/diagonal "
                  + "\n \n Outline shows possible moves \n \n Move: Mouse click on square \n");
      instructionTextBox.setEditable(false);
      instructionTextBox.setVisible(false);
      helpPanel.add(instructionTextBox);
      closeHelp = new JButton("Close");
      closeHelp.addActionListener(this);
      helpPanel.add(closeHelp, "South");
      helpPanel.setVisible(false);

      menuFrame.setResizable(true);
      menuFrame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.startButton) {
    	  board = new KamisadoBoard();
         menuFrame.setVisible(false);
      }

      if (e.getSource() == this.exitButton) {
         menuFrame.dispose();
      }

      if (e.getSource() == this.helpButton) {
         instructionTextBox.setVisible(true);
         helpPanel.setVisible(true);
      }
      
      if (e.getSource() == closeHelp) {
          instructionTextBox.setVisible(false);
          helpPanel.setVisible(false);
       }
      
      if (e.getSource() == this.settingsButton) {
    	  settingsPanel.setVisible(true);
       }
      
      if (e.getSource() == colorBlind) {
    	  symbolsBoard = new ColorBlindBoard();
    	  menuFrame.setVisible(false);
       }
      
      if (e.getSource() == closeSettings) {
    	  settingsPanel.setVisible(false);
       }      
      
   }

   public static void main(String[] args) {
      MainMenu menu = new MainMenu();
   }
}
