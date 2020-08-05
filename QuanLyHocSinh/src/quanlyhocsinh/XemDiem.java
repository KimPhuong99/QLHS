/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;

import dao.MonHocDAO;
import dao.SinhVienDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import pojo.MonHoc;
import pojo.SinhVien;
import pojo.ThoiKhoaBieu;

/**
 *
 * @author Admin
 */
public class XemDiem extends JDialog
        implements ActionListener {

    private static XemDiem dialog;
    private int id;

    public static void showDialog(Component frameComp
    ) {
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new XemDiem(frame);
        dialog.setSize(500, 500);
        dialog.setVisible(true);

    }

    private XemDiem(Frame frame) {
        super(frame, "them sinh vien", true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(0, 0, 500, 50);
        panel.add(panel1);
        JLabel label = new JLabel("Nhập mã lớp");
        panel1.add(label);
        label.setBounds(20, 5, 100, 30);
        JTextField text1 = new JTextField();
        panel1.add(text1);
        text1.setBounds(230, 5, 170, 30);

        final JLabel label5 = new JLabel("");
        label5.setForeground(Color.YELLOW);
        label5.setBounds(260, 35, 170, 50);
        panel.add(label5);
        JPanel panel6 = new JPanel();
        panel6.setBounds(0, 370, 500, 50);
        panel6.setBackground(Color.LIGHT_GRAY);
        panel6.setLayout(null);
        panel.add(panel6);
        JButton button12 = new JButton("OK");
        button12.setBackground(Color.GREEN);
        panel6.add(button12);
        button12.setBounds(80, 0, 100, 40);
        JButton button2 = new JButton("EXIT");
        button2.setBackground(Color.red);
        panel6.add(button2);
        button2.setBounds(260, 0, 100, 40);
        label.setBounds(20, 5, 100, 30);
        JLabel label2 = new JLabel("Nhập mã môn học");
        panel.add(label2);
        label2.setBounds(20, 90, 170, 30);
        JTextField text2 = new JTextField();
        panel.add(text2);
        text2.setBounds(230, 90, 170, 30);
        //List<MonHoc> ds=null;
        id = 0;
                     
        button12.addActionListener(new ActionListener() {

            @Override
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e) {
                String t1 = text1.getText().toString();
                String t2 = text2.getText().toString();
                if (t1.length() != 0 && t2.length() != 0) {
                    List<MonHoc> dsmh = MonHocDAO.layThongTinTheoMaMonHon(t2);
                    String column[] = {"STT", "MSSV", "Họ tên", "Mã Môn", "Giữa kỳ", "Cuối kỳ", "Điểm khác", "Điểm tổng","Đậu/Rớt"};
                    String data[][] = new String[dsmh.size()][9];
                    int i = 0;
                    int dau=0;
                    int rot=0;
                    System.out.println(dsmh.size()+"hhhhhh");
                    
                    for (MonHoc w : dsmh) {
                        SinhVien sv = SinhVienDAO.layThongTinhSinhVien(w.getmaSinhVien());
                        System.out.println(w.getmaSinhVien()+sv.getHoTen());
                        data[i][0] = String.valueOf(i + 1);;
                        data[i][1] = String.valueOf(sv.getMaSinhVien_id());
                        data[i][2] = sv.getHoTen();
                        data[i][3] = w.getMaMon();
                        data[i][4] = String.valueOf(w.getGK());
                        data[i][5] = String.valueOf(w.getCK());
                        data[i][6] = String.valueOf(w.getDK());
                        data[i][7] = String.valueOf(w.getTK());
                        System.out.println(w.getmaSinhVien()+" "+w.getCK()+" va data: "+data[i][1]+" "+data[i][5]);
                        if(w.getCK()==0){
                            continue;
                        }
                        if(w.getTK()<5.0){
                            data[i][8]=" ";
                            rot++;
                        }else{
                            data[i][8]="Đậu";
                            dau++;
                        }
                       
                        i++;
                    }
                     System.out.println(data[1][2]);
                    JTable table = new JTable(data, column);
                    JScrollPane spTable = new JScrollPane(table);
                    spTable.setBounds(5, 150, 470, 130);
                     JLabel labeldau =new JLabel("Đậu: "+String.valueOf(dau));
                     JLabel labelrot=new JLabel("Rớt :"+String.valueOf(rot));
                     panel.add(labeldau);
                     panel.add(labelrot);
                     labeldau.setBounds(10,300,100,40);
                     labelrot.setBounds(150,300,100,40);
                    panel.add(spTable);
                    
                }

            }

        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XemDiem.dialog.setVisible(false);
            }

        });

        Container contentPane = getContentPane();
        contentPane.add(panel);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
