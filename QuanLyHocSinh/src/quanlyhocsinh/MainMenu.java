/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;


import dao.MonHocDAO;
import dao.SinhVienDAO;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;
import javax.swing.border.EtchedBorder;
import static oracle.jrockit.jfr.events.Bits.longValue;
import pojo.MonHoc;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;
public class MainMenu {
    private JFrame jframe;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    public MainMenu(){
        initiablitia();
    }

    private void initiablitia() {
        //khung cưa số
        jframe=new JFrame();
        jframe.setSize(600, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().setLayout(null);
        // jpanel chính
        JPanel jpanel = new JPanel();
        jpanel.setBackground(java.awt.Color.lightGray);
        jpanel.setBounds(0, 0, 600, 500);
        jframe.getContentPane().add(jpanel);
        jpanel.setLayout(null);
        
        //jpanel chứa jlabel UQAN LY THU VIEN
        JPanel panel1 =new JPanel();
        panel1.setLayout(null);
        jpanel.add(panel1);
        panel1.setBounds(0,0,600,100);
        panel1.setBackground(java.awt.Color.ORANGE);
        JLabel label=new JLabel("QUAN LY THU VIEN");
        panel1.add(label);
        label.setBounds(230,35,500,30);
        JFileChooser jf=new JFileChooser();//JFilerChooser để chọn file
        //Jbanel chứa 1 đống Button
        JPanel panel2=new JPanel();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        jpanel.add(panel2);
        panel2.setBounds(0,100,600,500);
        panel2.setBackground(java.awt.Color.red);
        
        JButton button1 = new JButton("import dữ liệu");
        panel2.add(button1);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal=jf.showOpenDialog(null);
               
                if(returnVal==jf.APPROVE_OPTION)
                {
                   String path=jf.getSelectedFile().getAbsolutePath();
                   String filename=jf.getSelectedFile().getName();
                   
                   String line = "";
                   String splitBy = ",";  
                   BufferedReader br = null;  
                     try {
                        br = new BufferedReader(new FileReader(path));
                        
                     } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     try {
                       int dem=0;
                         String malop="";
                        while ((line = br.readLine()) != null)   //returns a Boolean value
                        {  
                            String[] employee = line.split(splitBy);    // use comma as separator
                            if(dem==0)
                            {
                                dem=1;
                                malop=employee[0];
                                continue;
                            }
                            if(dem==1){
                                dem=2;
                                continue;
                            }
                            int id=0;
                                    if(SinhVienDAO.LayDSSinhVien().size()!=0){
                                        id=SinhVienDAO.LayDSSinhVien().size();
                                    }
                            SinhVien sv;
                            sv = new SinhVien(id+1,Integer.parseInt(employee[1]),employee[2],employee[3],employee[4],malop);
                            System.out.println(sv.getMaSinhVien_id()+" "+sv.getMaLop()+" id="+id);
                            SinhVienDAO.ThemSinhVien(sv);
                            
                        }
                     } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     System.out.print("ok"); 
            }
            }});
        JButton button2 = new JButton("Thêm một sinh viên mới.");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button2);
        button2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ListDialog.showDialog(jframe);
            }

        
        });
        JButton button3=new JButton("Import thoi khoa bieu.");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button3);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  int returnVal=jf.showOpenDialog(null);
                if(returnVal==jf.APPROVE_OPTION)
                {
                   String path=jf.getSelectedFile().getAbsolutePath();
                   String filename=jf.getSelectedFile().getName();
                   
                   String line = "";
                   String splitBy = ",";  
                   BufferedReader br = null;  
                     try {
                        br = new BufferedReader(new FileReader(path));
                        
                     } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     try {
                          int dem=0;
                         String malop="";
                         List<SinhVien> dssv=SinhVienDAO.LayDSSinhVien();
                         int stt=1;
                        while ((line = br.readLine()) != null)   //returns a Boolean value
                        {
                            String[] employee = line.split(splitBy);    // use comma as separator
                            if(dem==0)
                            {
                                dem=1;
                                malop=employee[0];
                                continue;
                            }
                            if(dem==1){
                                dem=2;
                                continue;
                            }
                            int idw=0;
                                    if(SinhVienDAO.LayDSTKB().size()!=0){
                                        idw=SinhVienDAO.LayDSTKB().size();
                                    }
                            ThoiKhoaBieu tkb;
                            tkb = new ThoiKhoaBieu(idw+1,employee[1],malop,employee[2],employee[3]);
                            SinhVienDAO.ThemTKB(tkb);
                            
                            for(int i=0;i<dssv.size();i++){
                                if(i==5){
                                 //System.out.println(dssv.get(i).getMaLop()+" "+dssv.get(i).getMaSinhVien_id()+" "+i+"lllll"); 
                                 //System.out.println(dssv.get(i).getMaLop()+"va"+" "+malop);
                                 int id= MonHocDAO.LayDSMonHoc().size();
                                 MonHoc mh=new MonHoc(id+1,dssv.get(i).getMaSinhVien_id(),malop,employee[1],0,0,0,0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
                                }
                                if(dssv.get(i).getMaLop().equals(malop)){
                                    int id=0;
                                    if(MonHocDAO.LayDSMonHoc().size()!=0){
                                        id=MonHocDAO.LayDSMonHoc().size();
                                    }
                                    MonHoc mh=new MonHoc(id+1,dssv.get(i).getMaSinhVien_id(),malop,employee[1],0,0,0,0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
                                }
                            }
                            
                        }
                     } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            } }  
        });
        JButton button4 = new JButton("Xoa sinh vien khoi mon hoc");
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button4);
        button4.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogXoaSinhVien.showDialog(jframe);
                }
            
        });
    }
}
