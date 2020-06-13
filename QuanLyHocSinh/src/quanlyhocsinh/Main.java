/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhocsinh;


import dao.SinhVienDAO;
import java.util.List;
import pojo.SinhVien;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args){
        
        List<SinhVien> ds =SinhVienDAO.LayDSSinhVien();
        System.out.println("ok");
        for(int i=0;i<ds.size();i++)
        {
            System.out.println("MSSV: "+ds.get(i).getMaSinhVien_id());
        }
    }
}
