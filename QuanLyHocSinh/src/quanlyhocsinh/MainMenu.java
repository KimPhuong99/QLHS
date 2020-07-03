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
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import static oracle.jrockit.jfr.events.Bits.longValue;
import pojo.MonHoc;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;

public class MainMenu {

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
       

        //khung cưa số
        jframe = new JFrame();
        jframe.setSize(600, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().setLayout(null);
        jframe.getContentPane().add(jpanelDangNhap);
        
       
        // jpanel chính
        jpanel = new JPanel();
        jpanel.setBackground(java.awt.Color.lightGray);
        jpanel.setBounds(0, 0, 600, 500);
          buttonpn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String t1=text1pn.getText().toString();
                String t2=text2pn.getText().toString();
                if(t1.length()!=0&&t2.length()!=0){
                    if(t1.equals("giaovu")&&t2.equals("giaovu")){
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
                            System.out.println(sv.getMaSinhVien_id() + " " + sv.getMaLop() + " id=" + id);
                            SinhVienDAO.ThemSinhVien(sv);

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
                                if (i == 5) {
                                    //System.out.println(dssv.get(i).getMaLop()+" "+dssv.get(i).getMaSinhVien_id()+" "+i+"lllll"); 
                                    //System.out.println(dssv.get(i).getMaLop()+"va"+" "+malop);
                                    int id = MonHocDAO.LayDSMonHoc().size();
                                    MonHoc mh = new MonHoc(id + 1, dssv.get(i).getMaSinhVien_id(), malop, employee[1], 0, 0, 0, 0);
                                    MonHocDAO.ThemSinhVienMonHoc(mh);
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
                            for (int i = 0; i < dsn.size(); i++) {
                                System.out.println(dsn.get(i).getmaSinhVien() + " " + dsn.get(i).getMaMon() + " " + dsn.get(i).getMaLop());
                            }
                            System.out.println(employee[3] + " " + employee[4] + " " + employee[5] + " " + employee[6] + " " + mamon + " " + dsn.get(0).getMaMon());
                            int d = 0;
                            for (int i = 0; i < dsn.size(); i++) {
                                if (mamon.equals(dsn.get(i).getMaMon())) {
                                    dsn.get(i).setGK(Float.parseFloat(employee[3]));
                                    dsn.get(i).setCK(Float.parseFloat(employee[4]));
                                    dsn.get(i).setDK(Float.parseFloat(employee[5]));
                                    dsn.get(i).setTK(Float.parseFloat(employee[6]));
                                    System.out.println("nè ne" + dsn.get(i).getGK() + " " + dsn.get(i).getCK() + " " + dsn.get(i).getDK() + " " + dsn.get(i).getTK() + " " + mamon + " " + dsn.get(0).getMaMon());
                                    MonHocDAO.ThemDiem(dsn.get(i));
                                    d++;
                                }
                            }
                            System.out.println(d);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("ok");
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
    }
}
