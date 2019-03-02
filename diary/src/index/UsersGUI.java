package index;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.NonWritableChannelException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.sound.midi.VoiceStatus;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UsersGUI extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JFileChooser chooser;
	private static String pathname;
	private JTextArea createTxt;
	public static void init(String path){
		pathname=path;
	}
	
	public UsersGUI(){
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 600, 400);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);

         JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
         tabbedPane.setToolTipText("KonwYou");
         tabbedPane.setBounds(0, 0, 574, 67);
         contentPane.add(tabbedPane);

         final JPanel panel = new JPanel();
         tabbedPane.addTab("Management Journal", null, panel, null);

 

        JButton readButton = new JButton("Read the diary");
        panel.add(readButton);
        

        JButton addButton = new JButton("Create a diary");
        panel.add(addButton);
        
        JButton delButton = new JButton("Delete");
        panel.add(delButton);


        JButton back = new JButton("BACK");
        panel.add(back);
        
        
        setVisible(true);
        
        chooser=new JFileChooser(".\\"+pathname);
        FileNameExtensionFilter filter=new FileNameExtensionFilter(".txt", "txt");
        chooser.setFileFilter(filter);
        
        readButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int value=chooser.showOpenDialog(panel);//判断用户是否选择了文件
				JInternalFrame internalFrame_Read=new JInternalFrame("Read the diary", false, true, false,false);
				 internalFrame_Read.setBounds(0, 77, 584, 275);
				    contentPane.add(internalFrame_Read);
				       internalFrame_Read.getContentPane().setLayout(null);
				       JTextArea txtDiary = new JTextArea();
				      // txtDiary.setLineWrap(true);
				       txtDiary.setBounds(0, 0, 568, 246);
				       internalFrame_Read.getContentPane().add(txtDiary);
				       //JTextField 
				       javax.swing.text.Document doc=txtDiary.getDocument();
				       txtDiary.setBackground(Color.white);//背景颜色为绿色
				       txtDiary.setEditable(false);//设置为不可编辑
				 
				       //当value的值和JFileChooser.APPROVE_OPTION相等时，证明用户选择了文件
				        if (value == JFileChooser.APPROVE_OPTION) {
				 
				        //得到用户选择的文件
				        	File file = chooser.getSelectedFile();
				        	String rr  =file.getPath();
				            if(file.exists())    //如果文件存在
				                {
				               
				                    String read; 
				              try {
				            	  
				            	   txtDiary.setText("");
				            	 FileReader fr=new FileReader(rr);
				            	 BufferedReader br = new BufferedReader(fr);
				            	  while((read = br.readLine())!= null){
									 txtDiary.append(read+"\n"); 
									 
									 System.out.println(read);
								  }
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				                internalFrame_Read.setVisible(true);
				                    }
				        }
				
			}
		});
        
        addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createTxt=new JTextArea("hfdkgghdk",20,43);
				createTxt.setBounds(0,80, 568, 400);
				//createTxt.setText("fkghgkhgk");
				Button submitButton=new Button("submit");
				submitButton.setBounds(520, 300, 50, 20);
				createTxt.setLineWrap(true);
				//createTxt.setWrapStyleWord(true);
				createTxt.setVisible(true);
				contentPane.add(submitButton);
				contentPane.add(createTxt);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String content=createTxt.getText().toString();
						
						
						Date day=new Date();
						SimpleDateFormat adf=new SimpleDateFormat("yyyy-MM-dd");
						
						//System.out.println(adf.format(day));
						File file=new File("D:\\diray.txt");
						try {
							FileWriter out=new FileWriter(file,true);
							out.write(" \r\n");
							out.write(content);
							out.write(" \r\n");
							out.write("\t\t\t\t\t\t\t"+adf.format(day));
							out.close();
							submitButton.setVisible(false);
							createTxt.setVisible(false);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		});
        
        delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createTxt.setText("");
				
			}
		});
        
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginGUI loginGUI=new LoginGUI();
				loginGUI.loginGUI();
				setVisible(false);
			}
		});
	}
	public static void main(String []args){
		UsersGUI usersGUI=new UsersGUI();
	}
}
