/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
public class MonHoc {
    private int Id;
    private int maSinhVien;
    private String MaLop;
    private String MaMon;
    private float GK;
    private float CK;
    private float DK;
    private float TK;
   // private SinhVien sv;
   
    public MonHoc(){
        
    }
    public MonHoc(int id, int sv,String malop,String mamon, float gk,float ck,float dk,float tk){
        this.Id=id;
        this.maSinhVien=sv;
        this.MaMon=mamon;
        this.MaLop=malop;
        this.GK=gk;
        this.CK=ck;
        this.DK=dk;
        this.TK=tk;
        //this.sv=sv;
    }
   public int getId(){
       return this.Id;
   }
   public void setId(int i){
       this.Id=i;
   }
   public int getmaSinhVien(){
       return this.maSinhVien;
   }
   public void setMaSinhVien(int sv){
       this.maSinhVien=sv;
   }
   public String getMaMon(){
       return this.MaMon;
   }
   public void setMaMon(String s){
       this.MaMon=s;
   }
   public String getMaLop(){
       return this.MaLop;
   }
   public void setMaLop(String maLop){
       this.MaLop=maLop;
   }
   public float getGK()
    {
        return this.GK;
    }
    public void setGK(float gk){
        this.GK=gk;
    }
    public float getCK(){
        return this.CK;
    }
    public void setCK(float ck){
        this.CK=ck;
    }
    public float getDK(){
        return this.DK;
    }
    public void setDK(float dk){
        this.DK=dk;
    }
    public float getTK(){
        return this.TK;
    }
    public void setTK(float dt){
        this.TK=dt;
    }
    
}
