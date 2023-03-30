/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class first extends JFrame implements ActionListener{
    
   private Container first;
   private JButton start;
   private JButton close;

    first(){
         setTitle("First Window");
        setBounds(300,300,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        first=getContentPane();
        first.setLayout(null);
        setVisible(true);
        
        //start button
        start=new JButton("start");
        start.setSize(100,20);
        start.setLocation(100, 100);
        start.addActionListener(this);
        first.add(start);
        
        //close button
        close=new JButton("close");
        close.setSize(100,20);
        close.setLocation(100, 150);
        close.addActionListener(this);
        first.add(close);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            Login obj=new Login();
        }
        else if(ae.getSource()==close)
        {
            System.exit(0);
        }
    }
public static void main(String args[])
{
    first f = new first();
}
}