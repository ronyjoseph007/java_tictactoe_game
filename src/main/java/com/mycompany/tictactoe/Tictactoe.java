/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class Tictactoe implements ActionListener {

   Random random = new Random();
   JFrame frame = new JFrame();
    JPanel title_panel= new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    
    JLabel next_player= new JLabel();
    JButton[]buttons= new JButton[9] ;
    boolean player1_turn = true;
    
  
    public Tictactoe(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(255, 102, 179));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(102, 0, 102));
        textfield.setForeground(new Color(235, 156, 247));
        textfield.setFont(new Font("Ink Free",Font.BOLD,70));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
//        next_player.setBackground(new Color(255,255,255));
//        next_player.setForeground(new Color(255,255,255));
//        next_player.setFont(new Font("Ink Free",Font.BOLD,50));
//        next_player.setHorizontalAlignment(JLabel.LEFT);
//        next_player.setText("jiiii");
//        next_player.setOpaque(true);
        
        
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
       
//        title_panel.add(next_player);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(153, 0, 153));
       
        for(int i=0;i<9;i++){
            buttons[i]= new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Century Gothic",Font.BOLD,120));
            buttons[i].setBackground(new Color(115, 38, 115));
            buttons[i].setFocusable(false);
             
            buttons[i].addActionListener((ActionListener) this);
            
        }
        
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);   
        title_panel.add(textfield);
        
        firstTurn();
    } 
    
    @Override
    public void  actionPerformed(ActionEvent e){
        
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equals("")){
                        
                        buttons[i].setForeground(new Color(10, 245, 245));
                        
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("o turn"); 
                        check();
                        
                    }
                    
                    
                    
                }else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(227, 250, 152));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("x turn");
                        check();
                    }
                }
            }
        }
        
    }
    
    public void firstTurn(){
        
//        Thread.sleep(2000);
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("x turn");
        }else{
            player1_turn=false;
            textfield.setText("o turn");
        }
    }
    
    public void check(){
        
        if(buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){
            winner(0,1,2);
            
        }
        
         if(buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){
            winner(3,4,5);
            
        }
         
         if(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[7].getText().equals("X")){
            winner(6,7,8);
            
        }
         
          if(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){
            winner(0,3,6);
            
        }
          
           if(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){
            winner(1,4,7);
            
        }
           
         if(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){
            winner(2,5,8);
            
        }  
         
//         o win condition
         
         if(buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")){
            winner(0,1,2);
            
        }
        
         if(buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){
            winner(3,4,5);
            
        }
         
         if(buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[7].getText().equals("O")){
            winner(6,7,8);
            
        }
         
          if(buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")){
            winner(0,3,6);
            
        }
          
           if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){
            winner(1,4,7);
            
        }
           
         if(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){
            winner(2,5,8);
            
        }   
         
        
        
    }
    
    public void winner(int a, int b, int c){
        buttons[a].setBackground(new Color(76, 230, 86));
        buttons[b].setBackground(new Color(76, 230, 86));
        buttons[c].setBackground(new Color(76, 230, 86));
            
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
        if(textfield.getText().equals("x turn")){
            
            
            
            textfield.setText(" Player O wins");
            
            
        }else{
            textfield.setText(" Player X  wins");
            
            
            
        }
        
    }
   
}
