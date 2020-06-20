/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
public class ThoiKhoaBieu {
    private int Id;
    private String MaMon;
    private String MaLop;
    private String TenMonHoc;
    private String PhongHoc;
    public ThoiKhoaBieu(){
        
    }
    public ThoiKhoaBieu(int id,String mamon,String malop,String ten,String phong){
        this.MaLop=malop;
        this.MaMon=mamon;
        this.TenMonHoc=ten;
        this.Id=id;
        this.PhongHoc=phong;
    }
    public int getId(){
        return this.Id;
    }
    public void setId(int id){
        this.Id=id;
    }
    public String getMaMon(){
        return this.MaMon;
    }
    public void setMaMon(String mamon){
        this.MaMon=mamon;
    }
    public String getMaLop(){
        return this.MaLop;
    }
    public void setMaLop(String malop){
        this.MaLop=malop;
    }
    public String getTenMonHoc(){
        return this.TenMonHoc;
    }
    public void setTenMonHoc(String ten){
        this.TenMonHoc=ten;
    }
    public String getPhongHoc(){
        return this.PhongHoc;
    }
    public void setPhongHoc(String phong){
        this.PhongHoc=phong;
    }
}

