package index;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.Marshaller.Listener;

public class IndexGUI extends JFrame {
    //�Զ���IndexGUI�̳�JFrame��
    private JPanel contentPane;  //�������
    //����JFrame�����������
    private static IndexGUI frame;

    public static void main(String[] args) {
        IndexGUI indexGUI=new IndexGUI();
    }
   
    public IndexGUI() {
        setTitle("KnowYou");  //���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرշ�ʽ���������رհ�ť�ɹرմ���
        /*x - the new x-coordinate of this component
          y - the new y-coordinate of this component
         width - the new width of this component
         height - the new height of this component  */
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel(); //ʵ�������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //��������С��λ��
        setContentPane(contentPane); //frame������
        contentPane.setLayout(null);  //������ò���Ϊnull,����ʡ�ԡ�����ҳ�沼�ֽ������ҡ�

        JLabel lblNewLabel = new JLabel("Welcome to use KnowYou"); //����
        lblNewLabel.setBounds(132, 74, 386, 35);
        lblNewLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel);

        JButton login = new JButton("Login"); //��½��ť
//        //��½��ť����¼�������걻���ʱ����
//        login.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                event_Login(); //��½�¼�����
//            }
//        });
//
//
//        //���Ӽ����¼�
//        login.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_ENTER)
//                {
//                    event_Login();//��½�¼�����
//                }
//            }
//        });
        login.setBounds(65, 263, 124, 45);
        
        contentPane.add(login);

        JButton register = new JButton("Sign Up"); //ע�ᰴť

        register.setBounds(489, 263, 109, 45);
        contentPane.add(register);
        setVisible(true);
        login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginGUI loginGUI=new LoginGUI();
				loginGUI.loginGUI();
			}
		});
        
        register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegisterGUI registerGUI=new RegisterGUI();
				registerGUI.registerGUI();
				
			}
		});
        
    }
   

}
