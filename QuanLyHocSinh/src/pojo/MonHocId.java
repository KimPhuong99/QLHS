/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class MonHocId implements Serializable {
    
    private String MaLop;
    private String MaMon;
    private SinhVien maSinhVien;
    public MonHocId(SinhVien sv, String mamon,String malop){
        this.maSinhVien=sv;
        this.MaLop=malop;
        this.MaMon=mamon;
    }
      public void setMaSinhVien(SinhVien mssv)
    {
        this.maSinhVien=mssv;
    }
      public SinhVien getMaSinhVien(){
          return this.maSinhVien;
      }
    public String getMaLop(){
        return this.MaLop;
    }
    public void setMaLop(String MaLop){
        this.MaLop=MaLop;
    }
    public String getMaMon(){
        return this.MaMon;
    }
    public void setMaMon(String mamon){
        this.MaMon=mamon;
    }
}
