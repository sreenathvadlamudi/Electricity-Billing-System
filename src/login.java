

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;

    login()
    {
        super("Login Page");
        l1=new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        l2=new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        tf1=new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);
        pf2=new JPasswordField(15);
        pf2.setBounds(400, 60, 150, 20);
        add(pf2);

        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
        Image i1=ic1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        b1=new JButton("LOGIN",new ImageIcon(i1));
        b1.setBounds(320, 150, 100, 20);
        add(b1);

        ImageIcon ic2=new ImageIcon(ClassLoader.getSystemResource("images/cancel.png"));
        Image i2=ic2.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        b2=new JButton("CANCEL",new ImageIcon(i2));
        b2.setBounds(460, 150, 100, 20);
        add(b2);


        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("images/pop.png"));
        Image i3=ic3.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon icc3=new ImageIcon(i3);

        l3=new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        add(l3);

        setLayout(new BorderLayout());

        setSize(640,300);
        setLocation(450,200);
        setVisible(true);










    }


    public void actionPerformed(ActionEvent ae){

        try{
            //conn c1 = new conn();
            String a  = tf1.getText();
            String b  = pf2.getText();
            
            //String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";
            //ResultSet rs = c1.s.executeQuery(q);
            conn c = new conn ();
    		boolean status = c.getUser(a,b);
            if(status){
                new Project().setVisible(true);
                this.setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                //setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }
    }

    public static void main(String[] args){
        new login().setVisible(true);
    }

}
