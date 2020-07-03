/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Admin
 */
public class DangNhap {
    private int MSSV;
    private String Pass;
    public DangNhap(){
        
    }
    public DangNhap(int MSSV,String pass){
        this.MSSV=MSSV;
        this.Pass=pass;
    }
    public  int getMSSV(){
        return this.MSSV;
    }
    public void setMSSV(int MSSV){
        this.MSSV=MSSV;
    }
    public String getPass(){
        return this.Pass;
    }
    public void setPass(String pass){
        this.Pass=pass;
    }
}
