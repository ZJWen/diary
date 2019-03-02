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
    //自定义IndexGUI继承JFrame类
    private JPanel contentPane;  //声明面板
    //创建JFrame的类对象声明
    private static IndexGUI frame;

    public static void main(String[] args) {
        IndexGUI indexGUI=new IndexGUI();
    }
   
    public IndexGUI() {
        setTitle("KnowYou");  //设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置默认关闭方式，点击窗体关闭按钮可关闭窗体
        /*x - the new x-coordinate of this component
          y - the new y-coordinate of this component
         width - the new width of this component
         height - the new height of this component  */
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel(); //实例化面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //设置面板大小，位置
        setContentPane(contentPane); //frame添加面板
        contentPane.setLayout(null);  //面板设置布局为null,不可省略。否则页面布局将会杂乱。

        JLabel lblNewLabel = new JLabel("Welcome to use KnowYou"); //标题
        lblNewLabel.setBounds(132, 74, 386, 35);
        lblNewLabel.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel);

        JButton login = new JButton("Login"); //登陆按钮
//        //登陆按钮鼠标事件，当鼠标被点击时调用
//        login.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                event_Login(); //登陆事件方法
//            }
//        });
//
//
//        //增加键盘事件
//        login.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_ENTER)
//                {
//                    event_Login();//登陆事件方法
//                }
//            }
//        });
        login.setBounds(65, 263, 124, 45);
        
        contentPane.add(login);

        JButton register = new JButton("Sign Up"); //注册按钮

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
