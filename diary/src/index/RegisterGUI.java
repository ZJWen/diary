package index;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;


import JDBC.JDBCUtils;

public class RegisterGUI extends JFrame{
  //  private static final long serialVensionUID = 3250371445038102261L;
    private JPanel contentPane;
    private JTextField nametext;//name�����
    private JTextField emailtext;//ID�����
    private JTextField passwdtext;//���������
    JLabel tips=new JLabel();
    Connection conn=null;
    public  void registerGUI(){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
            RegisterGUI frame = new RegisterGUI();
            frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
                );
    }

    public RegisterGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,650,400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel6 = new JLabel("Welcome to use KnowYou"); //����
        lblNewLabel6.setBounds(132, 35, 386, 35);
        lblNewLabel6.setFont(new Font("����", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel6);
        
        JLabel namelabel = new JLabel("Please input user name");//������ʾ���������ǩ
        namelabel.setBounds(102,91,151,23);
        contentPane.add(namelabel);

        JLabel IDlabel = new JLabel("please input Email");
        IDlabel.setBounds(102,224,163,23);
        contentPane.add(IDlabel);
        JLabel passwdlaber = new JLabel("please input user password");
        passwdlaber.setBounds(102,160,151,23);
        contentPane.add(passwdlaber);

        nametext = new JTextField();//��ͨ�ı������
        nametext.setBounds(271, 92, 92, 21);//����λ�ü���С
        contentPane.add(nametext);
        

      
        emailtext = new JTextField();
        emailtext.setBounds(271, 225, 92, 21);
        contentPane.add(emailtext);
       

        
        passwdtext = new JTextField();
        passwdtext.setBounds(271,161 , 92, 21);
        contentPane.add(passwdtext);

      //ע�ᰴť
        JButton register = new JButton("Sign Up"); 

        register.setBounds(150, 305, 93, 23);
        contentPane.add(register);

        JButton back = new JButton("BACK"); //���ذ�ť
        back.setBounds(300, 305, 93, 23);
        contentPane.add(back);
         
          JLabel lblNewLabel = new JLabel("(There are at laste 6 numbers)");
          lblNewLabel.setBounds(373, 164, 163, 15);
          contentPane.add(lblNewLabel);

          JLabel lblNewLabel_1 = new JLabel("(end of @qq.com)");
          lblNewLabel_1.setBounds(373, 228, 163, 15);
          contentPane.add(lblNewLabel_1);
          tips.setBounds(250, 320, 93, 50);
          contentPane.add(tips);
          back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IndexGUI indexGUI=new IndexGUI();
				
				
			}
		});
          
          register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name=nametext.getText().toString().trim();
				String passwd=passwdtext.getText().toString().trim();
				String email=emailtext.getText().toString().trim();
				try {
					conn=JDBCUtils.getConnection();
					String sql="insert into diary values(?,?,?)";
					if(!name.isEmpty()&&!passwd.isEmpty()&&!email.isEmpty()){
						PreparedStatement pst=conn.prepareStatement(sql);
						pst.setString(1, name);
						pst.setString(2, passwd);
						pst.setString(3, email);
						pst.executeUpdate();
						System.out.println("ע��ɹ���");
						tips.setText("ע��ɹ���");
						setVisible(false);
						IndexGUI indexGUI=new IndexGUI();
						
					}
					else{
						tips.setText("ע��ʧ�ܣ�");
						System.out.println("ע��ʧ�ܣ�");
						nametext.setText("");
						passwdtext.setText("");
						emailtext.setText("");
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
    }
}
