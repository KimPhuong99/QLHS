/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class SinhVien implements java.io.Serializable{
    private int STT;
    private int maSinhVien_id;
    private String CMND;
    private String HoTen;
    private int GioiTinh;
    private String MaLop;
    public SinhVien(){
    
    }
    public SinhVien(int stt,int mssv, String cmnd, String hoten, String malop, int gioitinh){
        STT=stt;
        maSinhVien_id=mssv;
        CMND=cmnd;
        HoTen=hoten;
        MaLop=malop;
        GioiTinh=gioitinh;
    }
    public int getSTT(){
        return this.STT;
    }
    public void setSTT(int stt){
        this.STT=stt;
    }
   public int getMaSinhVien_id(){
       return this.maSinhVien_id;
   }
   public void setMaSinhVien_id(int mssv){
       this.maSinhVien_id=mssv;
   }
   public String getCMND(){
       return this.CMND;
   }
   public void setCMND(String cmnd){
       this.CMND=cmnd;
   }
   public String getHoTen(){
       return this.HoTen;
   }
   public void setHoTen(String hoten){
       this.HoTen=hoten;
   }
   public int getGioiTinh(){
       return this.GioiTinh;
   }
   public void setGioiTinh(int gt){
       this.GioiTinh=gt;
   }
   public String getMaLop(){
       return this.MaLop;
   }
   public void setMaLop(String ml){
       this.MaLop=ml;
   }
}
