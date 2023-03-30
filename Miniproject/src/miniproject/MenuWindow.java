/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;





public class MenuWindow implements ActionListener  {
    
    
      Frame f;
      MenuBar mb;
      Menu menu;
      MenuItem m1;
      MenuItem m2;
      MenuItem m3;
        MenuWindow()
        {
             f=new Frame("application");
             mb =new MenuBar();
            menu=new Menu("Application");
            m1=new MenuItem("Add Student");
            m1.addActionListener(this);
            m2=new MenuItem("Display Student");
            m2.addActionListener(this);
            m3=new MenuItem("Exit");
            m3.addActionListener(this);
            menu.add(m1);
            menu.add(m2);
            menu.add(m3);
            mb.add(menu);
            f.setMenuBar(mb);  
            f.setSize(400,400);  
            f.setLayout(null);  
            f.setVisible(true); 
            
            f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    f.dispose();
                }
            });       
        }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==m1)
            {
                AddRecord obj=new AddRecord();
            }
            else if(ae.getSource()==m2)
            {
                DisplayRecord obj=new DisplayRecord();
            }
            else if(ae.getSource()==m3)
            {
                System.exit(0);
            }
        }
                
        public static void main(String args[])
        {
            MenuWindow obj=new MenuWindow();
        }
        
    
    
}
