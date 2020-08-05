/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;
import dao.MonHocDAO;
import dao.SinhVienDAO;
import java.awt.BorderLayout;
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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import static oracle.jrockit.jfr.events.Bits.longValue;
import pojo.DangNhap;
import pojo.MonHoc;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;
import pojo.phucKhao;

public class MainMenu {
    int MSSV;
    private JFrame jframe;
    private JPanel jpanel;
    private JPanel jpanelDangNhap;
    public static void main(String[] args) {
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

    public MainMenu() {
       // ShowDia();
        initiablitia();
    }
    private void ShowDia(){
        //DangNhap.showDialog(jframe);
    }
    
    private void initiablitia() {
        //jpanel dăng nhập
        jpanelDangNhap=new JPanel();
        jpanelDangNhap.setBackground(java.awt.Color.LIGHT_GRAY);
        jpanelDangNhap.setLayout(null);
        jpanelDangNhap.setBounds(0, 0, 600, 500);
        JPanel panel11 = new JPanel();
        panel11.setLayout(null);
        panel11.setBackground(java.awt.Color.LIGHT_GRAY);
        panel11.setBounds(0, 0, 500, 50);
        jpanelDangNhap.add(panel11);
        JLabel labelpn = new JLabel("UserName");
        panel11.add(labelpn);
        labelpn.setBounds(20, 5, 100, 30);
         JTextField text1pn = new JTextField();
        panel11.add(text1pn);
        text1pn.setBounds(230, 5, 170, 30);
        JLabel label2pn = new JLabel("Password");
        jpanelDangNhap.add(label2pn);
        label2pn.setBounds(20, 90, 170, 30);
        JTextField text2pn = new JTextField();
        jpanelDangNhap.add(text2pn);
        text2pn.setBounds(230, 90, 170, 30);
        JLabel labelcb = new JLabel("Nhập username và password");
        jpanelDangNhap.add(labelcb);
        labelcb.setForeground(java.awt.Color.YELLOW);
        labelcb.setBounds(230,120,170,30);
        JButton buttonpn =new JButton("OK");
        jpanelDangNhap.add(buttonpn);
        buttonpn.setBounds(270,170,90,30);
       //jpanel cho hoc sinh
        JPanel panelhs=new JPanel();
       panelhs.setLayout(new BoxLayout(panelhs,BoxLayout.Y_AXIS));
       panelhs.setSize(600,500);
       
       JLabel labelhs = new JLabel("MOODLE KHTN");
       
       panelhs.add(labelhs);
       
       labelhs.setAlignmentX(Component.CENTER_ALIGNMENT);
       JButton btXemDiem=new JButton("Xem điểm");
       panelhs.add(btXemDiem);
       btXemDiem.setAlignmentX(Component.CENTER_ALIGNMENT);
       JButton btSuaMatKhau=new JButton("Sửa mật khẩu");
       panelhs.add(btSuaMatKhau);
       JButton btTaoPK=new JButton("Làm phúc khảo");
       panelhs.add(btTaoPK);
       btTaoPK.setAlignmentX(Component.CENTER_ALIGNMENT);
       btSuaMatKhau.setAlignmentX(Component.CENTER_ALIGNMENT);
       btXemDiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JPanel panelXemDiem=new JPanel();
                panelXemDiem.setLayout(new BoxLayout(panelXemDiem,BoxLayout.Y_AXIS));
                jframe.setContentPane(panelXemDiem);
                panelXemDiem.setSize(600,500);
                //panelXemDiem.setBackground(java.awt.Color.red);
                
                JLabel lbDiemThi=new JLabel("Điểm Tổng");
                lbDiemThi.setForeground(java.awt.Color.BLACK);
                lbDiemThi.setBounds(10,0,150,30);
                panelXemDiem.add(lbDiemThi);
                String column[] = { "STT","Môn", "Giữa kỳ", "Cuối kỳ","Điểm khác","Điểm tổng"};
                List<MonHoc> dsmh=MonHocDAO.layThongTinMonHoc(MSSV);
                String data[][]=new String[dsmh.size()][6];
                int i=0;
                 for (MonHoc w : dsmh) {
                        data[i][0] = String.valueOf(i + 1);;
                        data[i][1] = SinhVienDAO.LayTenMonHoc(w.getMaMon());
                        data[i][2] = String.valueOf(w.getGK());
                        data[i][3] = String.valueOf(w.getCK());
                        data[i][4] = String.valueOf(w.getDK());
                        data[i][5] = String.valueOf(w.getTK());
                        i++;
                        
                    }
                    JTable table = new JTable(data, column);
                    JScrollPane spTable = new JScrollPane(table);
                    spTable.setBounds(50,50, 450,100);
                    panelXemDiem.add(spTable);
                    JButton btExit = new JButton("Exit");
                    panelXemDiem.add(btExit);
                    btExit.setBounds(170,200,190,30);
                    btExit.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     jframe.setContentPane(panelhs);
                    }
                        
                    });
                    }
           
       });
       btSuaMatKhau.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelSuaMK=new JPanel();
                panelSuaMK.setLayout(null);
                 jframe.setContentPane(panelSuaMK);
                panelSuaMK.setSize(600,500);
                JLabel lbDiemThi=new JLabel("Nhập mật khẩu mới");
                lbDiemThi.setForeground(java.awt.Color.BLACK);
                lbDiemThi.setBounds(10,30,150,30);
                panelSuaMK.add(lbDiemThi);
               JTextField text = new JTextField();
               panelSuaMK.add(text);
               text.setBounds(200,30,150,30);
               JButton btOK=new JButton("OK");
               panelSuaMK.add(btOK);
               btOK.setBounds(200,90,150,30);
               btOK.addActionListener((ActionEvent e1) -> {
                   String t=text.getText();
                   if(t.length()!=0){
                       SinhVienDAO.SuaMatKhau(MSSV, t);
                       if(MSSV!=1)
                       jframe.setContentPane(panelhs);
                       if(MSSV==1)
                       jframe.setContentPane(jpanel);
                   }
                });
            
            }
           
       });
       btTaoPK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(java.awt.Color.LIGHT_GRAY);
       panel.setSize(600,500);
       JPanel panel1= new JPanel();
       panel1.setLayout(null);
       panel1.setBackground(java.awt.Color.LIGHT_GRAY);
       panel1.setBounds(0,0,500,50);
       panel.add(panel1);
       JTextField text1=new JTextField();
       text1.setBounds(170,10,300,30);
       panel1.add(text1);
       text1.setColumns(10);
       JLabel label1 = new JLabel("MSSV");
       label1.setBounds(20,10,50,30);
       panel1.add(label1);
       
       JPanel panel2= new JPanel();
       panel2.setLayout(null);
       panel2.setBackground(java.awt.Color.LIGHT_GRAY);
       panel2.setBounds(0,50,500,50);
       panel.add(panel2);
       JTextField text2=new JTextField();
       text2.setBounds(170,5,300,30);
       panel2.add(text2);
       text2.setColumns(10);
       JLabel label2 = new JLabel("Môn");
       label2.setBounds(20,5,70,30);
       panel2.add(label2);
       
       
       JPanel panel3= new JPanel();
       panel3.setLayout(null);
       panel3.setBackground(java.awt.Color.LIGHT_GRAY);
       panel3.setBounds(0,100,500,50);
       panel.add(panel3);
       JTextField text3=new JTextField();
       text3.setBounds(170,5,300,30);
       panel3.add(text3);
       text3.setColumns(10);
       JLabel label3 = new JLabel("Cột điểm");
       label3.setBounds(20,5,70,30);
       panel3.add(label3);
       
       JPanel panel4= new JPanel();
       panel4.setLayout(null);
       panel4.setBackground(java.awt.Color.LIGHT_GRAY);
       panel4.setBounds(0,150,500,50);
       panel.add(panel4);
       JTextField text4=new JTextField();
       text4.setBounds(170,5,300,30);
       panel4.add(text4);
       text4.setColumns(10);
       JLabel label4 = new JLabel("Điểm mong muốn");
       label4.setBounds(20,5,120,30);
       panel4.add(label4);
       
        JPanel panel5= new JPanel();
       panel5.setLayout(null);
       panel5.setBackground(java.awt.Color.LIGHT_GRAY);
       panel5.setBounds(0,200,500,50);
       panel.add(panel5);
       JTextField text5=new JTextField();
       text5.setBounds(170,5,300,30);
       panel5.add(text5);
       
       JLabel label55 = new JLabel("Lý do");
       label55.setBounds(20,5,120,30);
       panel5.add(label55);
       
       final JLabel label5 = new JLabel("Nhập đúng thứ tự");
       label5.setForeground(java.awt.Color.YELLOW);
       label5.setBounds(350,200,340,50);
       panel.add(label5);
      
       JPanel panel6 = new JPanel();
       panel6.setBounds(0,300,500,50);
       panel6.setBackground(java.awt.Color.LIGHT_GRAY);
       panel6.setLayout(null);
       panel.add(panel6);
       JButton button1 = new JButton("OK");
       button1.setBackground(java.awt.Color.GREEN);
       panel6.add(button1);
       button1.setBounds(80,0,100,40);
       JButton button2 = new JButton("EXIT");
       button2.setBackground(java.awt.Color.red);
       panel6.add(button2);
       button2.setBounds(260,0,100,40);
       jframe.setContentPane(panel);
          button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               String t1=text1.getText().toString();
               String t2=text2.getText().toString();
               String t3=text3.getText().toString();
               String t4=text4.getText().toString();
               String t5=text5.getText().toString();
             
               if(t1.length()!=0&&t2.length()!=0&&t3.length()!=0&&t4.length()!=0){
                
                List<phucKhao> dspk=SinhVienDAO.LayDSPK();
                phucKhao pk=new phucKhao(dspk.size()+1,Integer.parseInt(t1),t2,t3,Float.parseFloat(t4),t5,0);
                SinhVienDAO.themPhucKhao(pk);
               
            }else{
                   label5.setForeground(java.awt.Color.red);
                   label5.setText("Nhập thiếu thông tin!");
               }
            }

       });
           button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setContentPane(panelhs);
                
                }
           
       });
            }
           
       });
        //khung cưa số
        jframe = new JFrame();
        jframe.setSize(600, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(jpanelDangNhap);
        
       
        // jpanel chính của admin
        jpanel = new JPanel();
        jpanel.setBackground(java.awt.Color.lightGray);
        jpanel.setBounds(0, 0, 600, 500);
        buttonpn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String t1=text1pn.getText().toString();
                String t2=text2pn.getText().toString();
                if(t1.length()!=0&&t2.length()!=0){
                    List<DangNhap> dsdn=SinhVienDAO.LayDSMK();
                    String gv="";
                    String Pass="";
                    for(DangNhap w: dsdn){
                        if(w.getMSSV()==1){
                            gv=w.getPass();
                            
                        }
                        if(t1.equals("giaovu")){
                            MSSV=1;
                            break;
                        }
                           
                        if(Integer.parseInt(t1)==w.getMSSV())
                        {
                            MSSV=Integer.parseInt(t1);
                            Pass=w.getPass();
                            
                            break;
                        }
                    }
                   // System.out.println(t2.compareTo(Pass));
                    if(t2.compareTo(Pass)==0){
                        jframe.setContentPane(panelhs);
                        
                    }
                    if(t2.equals(gv)){
                       
                        jframe.setContentPane(jpanel);
                    }
                    
                }
                text1pn.setText("");
                text2pn.setText("");
                labelcb.setText("Username hoặc pass sai!");
                labelcb.setForeground(java.awt.Color.red);
                
                  }
            
        });
        jpanel.setLayout(null);
        
        
        //jpanel chứa jlabel UQAN LY THU VIEN
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        jpanel.add(panel1);
        panel1.setBounds(0, 0, 600, 100);
        panel1.setBackground(java.awt.Color.ORANGE);
        JLabel label = new JLabel("QUAN LY THU VIEN");
        panel1.add(label);
        label.setBounds(230, 35, 500, 30);
        JFileChooser jf = new JFileChooser();//JFilerChooser để chọn file
        //Jbanel chứa 1 đống Button
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        jpanel.add(panel2);
        panel2.setBounds(0, 100, 600, 500);
        panel2.setBackground(java.awt.Color.red);

        JButton button1 = new JButton("import dữ liệu");
        panel2.add(button1);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = jf.showOpenDialog(null);
                if (returnVal == jf.APPROVE_OPTION) {
                    String path = jf.getSelectedFile().getAbsolutePath();
                    String filename = jf.getSelectedFile().getName();
                    String line = "";
                    String splitBy = ",";
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(path));

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        int dem = 0;
                        String malop = "";
                        while ((line = br.readLine()) != null) //returns a Boolean value
                        {
                            String[] employee = line.split(splitBy);    // use comma as separator
                            if (dem == 0) {
                                dem = 1;
                                malop = employee[0];

                                continue;
                            }
                            if (dem == 1) {
                                dem = 2;
                                continue;
                            }
                            int id = 0;
                            if (SinhVienDAO.LayDSSinhVien().size() != 0) {
                                id = SinhVienDAO.LayDSSinhVien().size();
                            }
                            SinhVien sv;
                            sv = new SinhVien(id + 1, Integer.parseInt(employee[1]), employee[2], employee[3], employee[4], malop);
                           
                            SinhVienDAO.ThemSinhVien(sv);
                            DangNhap dn=new DangNhap(Integer.parseInt(employee[1]),employee[1]);
                            System.out.println();
                            SinhVienDAO.themMatKhau(dn);

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("ok");
                }
            }
        });
        JButton button2 = new JButton("Thêm một sinh viên mới.");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ListDialog.showDialog(jframe);
            }

        });
        JButton button3 = new JButton("Import thoi khoa bieu.");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = jf.showOpenDialog(null);
                if (returnVal == jf.APPROVE_OPTION) {
                    String path = jf.getSelectedFile().getAbsolutePath();
                    String filename = jf.getSelectedFile().getName();

                    String line = "";
                    String splitBy = ",";
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(path));

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        int dem = 0;
                        String malop = "";
                        List<SinhVien> dssv = SinhVienDAO.LayDSSinhVien();
                        int stt = 1;
                        while ((line = br.readLine()) != null) //returns a Boolean value
                        {
                            String[] employee = line.split(splitBy);    // use comma as separator
                            if (dem == 0) {
                                dem = 1;
                                malop = employee[0];
                                continue;
                            }
                            if (dem == 1) {
                                dem = 2;
                                continue;
                            }
                            int idw = 0;
                            if (SinhVienDAO.LayDSTKB().size() != 0) {
                                idw = SinhVienDAO.LayDSTKB().size();
                            }
                            ThoiKhoaBieu tkb;
                            tkb = new ThoiKhoaBieu(idw + 1, employee[1], malop, employee[2], employee[3]);
                            SinhVienDAO.ThemTKB(tkb);
                            
                            for (int i = 0; i < dssv.size(); i++) {
                               
                                if(dssv.get(i).getMaLop().equals("17HCB")){
                                     int id = 0;
                                    if (MonHocDAO.LayDSMonHoc().size() != 0) {
                                        id = MonHocDAO.LayDSMonHoc().size();
                                    }
                                    MonHoc mh = new MonHoc(id + 1, dssv.get(i).getMaSinhVien_id(), malop, employee[1], 0, 0, 0, 0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
                                }
                                 if(dssv.get(i).getMaLop().equals("18HCB")){
                                     int id = 0;
                                    if (MonHocDAO.LayDSMonHoc().size() != 0) {
                                        id = MonHocDAO.LayDSMonHoc().size();
                                    }
                                    MonHoc mh = new MonHoc(id + 1, dssv.get(i).getMaSinhVien_id(), malop, employee[1], 0, 0, 0, 0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
                                }
                                if(i==5){
                                    System.out.print(dssv.get(5).getMaLop().compareTo(malop));
                                }
                               
                                if (dssv.get(i).getMaLop().equals(malop)) {
                                    int id = 0;
                                    if (MonHocDAO.LayDSMonHoc().size() != 0) {
                                        id = MonHocDAO.LayDSMonHoc().size();
                                    }
                                    MonHoc mh = new MonHoc(id + 1, dssv.get(i).getMaSinhVien_id(), malop, employee[1], 0, 0, 0, 0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
                                }
                            }

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        JButton button4 = new JButton("Xoa sinh vien khoi mon hoc");
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogXoaSinhVien.showDialog(jframe);
            }
        });
        JButton button5 = new JButton("Thêm Sinh viên môn học");
        button5.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogThemSinhVienMonHoc.showDialog(jframe);
            }
        });
        JButton button6 = new JButton("Xem thời khóa biểu");
        button6.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XemThoiKhoaBieu.showDialog(jframe);
            }
        });
        JButton button7 = new JButton("import bảng điểm");
        button7.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = jf.showOpenDialog(null);

                if (returnVal == jf.APPROVE_OPTION) {
                    String path = jf.getSelectedFile().getAbsolutePath();
                    String filename = jf.getSelectedFile().getName();

                    String line = "";
                    String splitBy = ",";
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(path));

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        int dem = 0;
                        String mamon = "";

                        while ((line = br.readLine()) != null) //returns a Boolean value
                        {
                            String[] employee = line.split(splitBy);    // use comma as separator
                            if (dem == 0) {
                                dem = 1;
                                mamon = employee[0];
                                String[] words = mamon.split("-");
                                mamon = words[1];
                                continue;
                            }
                            if (dem == 1) {
                                dem = 2;
                                continue;
                            }
                            List<MonHoc> dsn = MonHocDAO.layThongTinMonHoc(Integer.parseInt(employee[1]));
                            //for (int i = 0; i < dsn.size(); i++) {
                               // System.out.println(dsn.get(i).getmaSinhVien() + " " + dsn.get(i).getMaMon() + " " + dsn.get(i).getMaLop());
                           // }
                            //System.out.println(employee[3] + " " + employee[4] + " " + employee[5] + " " + employee[6] + " " + mamon + " " + dsn.get(0).getMaMon());
                            int d = 0;
                            for (int i = 0; i < dsn.size(); i++) {
                                if (mamon.equals(dsn.get(i).getMaMon())) {
                                    dsn.get(i).setGK(Float.parseFloat(employee[3]));
                                    dsn.get(i).setCK(Float.parseFloat(employee[4]));
                                    dsn.get(i).setDK(Float.parseFloat(employee[5]));
                                    dsn.get(i).setTK(Float.parseFloat(employee[6]));
                                    //System.out.println("nè ne" + dsn.get(i).getGK() + " " + dsn.get(i).getCK() + " " + dsn.get(i).getDK() + " " + dsn.get(i).getTK() + " " + mamon + " " + dsn.get(0).getMaMon());
                                    MonHocDAO.ThemDiem(dsn.get(i));
                                    d++;
                                }
                            }
                           
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
        JButton button8 = new JButton("Xem điểm");
        button8.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button8);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XemDiem.showDialog(jframe);
            }
        });
         JButton button9 = new JButton("Sua điểm");
        button9.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(button9);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaDiem.showDialog(jframe);
            }
        });
        panel2.add(btSuaMatKhau);
        JButton bttpk = new JButton("Tạo thời gian cho phúc khảo.");
        bttpk.setAlignmentX(Component.CENTER_ALIGNMENT);
        //panel2.add(bttpk);
        bttpk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            
        });
    }
}
