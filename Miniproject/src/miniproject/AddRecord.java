/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddRecord extends JFrame implements ActionListener {
    
    private JLabel id;
    private JTextField tid;
    private JLabel name;
    private JTextField tname;
    private JLabel marks;
     private JTextField tmarks;
    private JButton save;
    private Container c;
    AddRecord()
    {
            setTitle("Add Record");
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
            
            save=new JButton("Save");
            save.setSize(100,30);
            save.setLocation(100,250);
            save.addActionListener(this);
            c.add(save);
            
            
            setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==save)
        {
            //insert into database
                    try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con=DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            System.out.println("Database connected");   
            
            //PreparedStatement
            PreparedStatement stmt=con.prepareStatement("insert into student values(?,?,?)");
                    
            stmt.setString(1,tid.getText());
            stmt.setString(2,tname.getText());
            stmt.setString(3,tmarks.getText());
            int i=stmt.executeUpdate();  
            System.out.println(i+" records updated");  
            con.close();
            
             }
        catch(Exception e)
        {
               System.out.println(e);
                    
         }
        }
    }
    public static void main(String args[])
    {
        AddRecord obj=new AddRecord();
    }
}
