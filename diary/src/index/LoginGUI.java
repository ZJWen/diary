package index;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
   import java.awt.event.KeyAdapter;
   import java.awt.event.KeyEvent;
   import java.awt.event.MouseAdapter;
   import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
   import javax.swing.JFrame;
   import javax.swing.JLabel;
   import javax.swing.JOptionPane;
   import javax.swing.JPanel;
   import javax.swing.JPasswordField;
   import javax.swing.JTextField;
   import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import JDBC.JDBCUtils;


   public class LoginGUI extends JFrame {
       private static final long serialVersionUID = 4994949944841194839L;
       private JPanel contentPane;  //���
       private JTextField IDtxt; //ID�����
       private JLabel Passwdlabel;//�����ǩ
       private JPasswordField passwordField;//���������
       private JButton login;//��½��ť
       private JButton back;//���ذ�ť
       Connection conn=null;
  	   Statement stmt=null;
  	   ResultSet rs=null;
  	  JLabel tips=new JLabel();
       /**
        * Launch the application.
        * @return 
        */
       
       public  void loginGUI() {
           EventQueue.invokeLater(new Runnable() {
               public void run() {
                   try {
                       LoginGUI frame = new LoginGUI();
                       frame.setVisible(true);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           });
       }
      

       /**
        * Create the frame.
        */
       public LoginGUI() {
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setBounds(100, 100, 650, 400);
           contentPane = new JPanel();
           contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
           setContentPane(contentPane);
           contentPane.setLayout(null);

           JLabel IDlabel = new JLabel("Please input ID");//ID��ǩ
           IDlabel.setBounds(130, 170, 91, 39);
           contentPane.add(IDlabel);

           IDtxt = new JTextField();
           IDtxt.setBounds(265, 179, 126, 21);
           contentPane.add(IDtxt);
           IDtxt.setColumns(10);

           Passwdlabel = new JLabel("Please input password");
           Passwdlabel.setBounds(130, 219, 150, 50);
           contentPane.add(Passwdlabel);

           passwordField = new JPasswordField();
           passwordField.setBounds(265, 234, 126, 21);
           contentPane.add(passwordField);

           login = new JButton("login");

           login.setBounds(150, 310, 93, 23);
           contentPane.add(login);

           //���ذ�ť
           back = new JButton("BACK");
           back.setBounds(320, 310, 93, 23);
           contentPane.add(back);
           //����
           JLabel label = new JLabel("Welcome to use KnowYou");
           label.setFont(new Font("����", Font.BOLD | Font.ITALIC, 30));
           label.setBounds(142, 54, 386, 35);
           contentPane.add(label);
           
           tips.setBounds(250, 320, 93, 50);
           contentPane.add(tips);
           login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				 String id=IDtxt.getText().toString().trim();
		         String passwd=passwordField.getText().toString().trim();
				 //System.out.println(id+passwd);
		         connection(id, passwd);
		         
			
			}
		});
        
           back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IndexGUI indexGUI=new IndexGUI();
				
				
			}
		});
       }
       
     public void connection(String id,String passwd){
    	 boolean flag=false;
    	 try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql="select * from diary";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(id.equalsIgnoreCase(rs.getString("name"))
				&&passwd.equalsIgnoreCase(rs.getString("password"))){
					System.out.println("��¼�ɹ�");
					tips.setText("��¼�ɹ�");
					
					setVisible(false);
					UsersGUI usersGUI=new UsersGUI();
					flag=true;
					break;
				}
				
			}
			if(flag==false){
				tips.setText("��¼ʧ�ܣ�");
				IDtxt.setText("");
				passwordField.setText("");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
       }
      
   }

