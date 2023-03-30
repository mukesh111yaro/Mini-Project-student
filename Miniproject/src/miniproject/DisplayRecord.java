/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayRecord extends JFrame implements ActionListener {
    
    private JLabel id;
    private JTextField tid;
    private JLabel name;
    private JTextField tname;
    private JLabel marks;
     private JTextField tmarks;
    private JButton next;
    private Container c;
    ResultSet res;
    DisplayRecord()
    {
            setTitle("Display Record");
            setBounds(500,500,500,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            c=getContentPane();
            c.setLayout(null);
            
            
            //id field
            id=new JLabel("ID:");
            id.setSize(100,30);
            id.setLocation(100,100);
            c.add(id);
            tid=new JTextField();
            tid.setSize(100,30);
            tid.setLocation(120,100);
            c.add(tid);
            
            //name field
            name=new JLabel("Name:");
            name.setSize(100,30);
            name.setLocation(100,150);
            c.add(name);
            tname=new JTextField();
            tname.setSize(100,30);
            tname.setLocation(137,150);
            c.add(tname);
            
            //marks field
            marks=new JLabel("Marks:");
            marks.setSize(100,30);
            marks.setLocation(100,200);
            c.add(marks);
            tmarks=new JTextField();
            tmarks.setSize(100,30);
            tmarks.setLocation(140,200);
            c.add(tmarks);
            
            next=new JButton("next");
            next.setSize(100,30);
            next.setLocation(100,250);
            next.addActionListener(this);
            c.add(next);
            
            
            setVisible(true);
        
            connect();
    }
    public void connect()
    {
        try
        {
            
             Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            System.out.println("Database connected");   

            Statement stmt=con.createStatement();  
             res=stmt.executeQuery("select * from student"); 
            
     }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            
        
        try{
 
            
           res.next();
            String sid=res.getString(1);
            String sname=res.getString(2);
            String smarks=res.getString(3);
            tid.setText(sid);
            tname.setText(sname);
            tmarks.setText(smarks);
            
                    
                    
             }
        catch(Exception e)
        {
               System.out.println(e);
                    
         }
        }
    }
    public static void main(String args[])
    {
        DisplayRecord obj=new DisplayRecord();
    }
}
