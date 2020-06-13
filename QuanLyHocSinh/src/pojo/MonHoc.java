/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
public class MonHoc {
    private int maSinhVien;
    private String MaLop;
    private String MaMon;
    private float GK;
    private float CK;
    private float DK;
    private float TK;
    public MonHoc(){
        
    }
    public MonHoc(int mssv, String malop,String mamon, float gk,float ck,float dk,float tk){
        this.maSinhVien=mssv;
        this.MaLop=malop;
        this.MaMon=mamon;
        this.GK=gk;
        this.CK=ck;
        this.DK=dk;
        this.TK=tk;
    }
    public int getmssv(){
        return this.maSinhVien;
    }
    public void setmssv(int mssv)
    {
        this.maSinhVien=mssv;
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
    public float getDT(){
        return this.TK;
    }
    public void setDT(float dt){
        this.TK=dt;
    }
    
}
