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

public class Login extends JFrame implements ActionListener {
    
    private JButton login;
    private JLabel username;
    private JTextField tusername;
    private JLabel pwd;
    private JPasswordField tpwd;
    private Container c;
    
        Login()
        {
            setTitle("Login");
            setBounds(500,500,500,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
 
            c = getContentPane();
            c.setLayout(null);
            
            
            
            //username
            username=new JLabel("UserName");
            username.setSize(100,20);
            username.setLocation(100,100);
            c.add(username);
            tusername=new JTextField();
            tusername.setSize(100,20);
            tusername.setLocation(200,100);
            c.add(tusername);
            
            
            //password
            pwd=new JLabel("password");
            pwd.setSize(100,20);
            pwd.setLocation(100,200);
            c.add(pwd);
            tpwd=new JPasswordField();
            tpwd.setSize(100,20);
            tpwd.setLocation(200,200);
            tpwd.setEchoChar('*');
            c.add(tpwd);
            
            
           login=new JButton("Login");
           login.setLocation(200,250);
           login.setSize(100,20);
           login.addActionListener(this);
           c.add(login);
           
            
           
            
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==login)
            {
                System.out.println("Login successful");
                MenuWindow obj=new MenuWindow();
            }
        }
    public static void main(String args[])
    {
        Login obj=new Login();
    
}
}
