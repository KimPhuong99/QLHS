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
public class TaoPhucKhao {
    private int STT;
    private String Dau;
    private String Cuoi;
    public TaoPhucKhao(){
        
    }
    public TaoPhucKhao(int STT,String dau,String cuoi){
        this.STT=STT;
        Dau=dau;
        Cuoi=cuoi;
    }
    public int getSTT(){
        return STT;
    }
    public void setSTT(int stt){
        STT=stt;
    }
    public String getDau(){
        return Dau;
    }
    public void setDau(String dau){
        Dau=dau;
    }
    public String getCuoi(){
        return Cuoi;
    }
    public void setCuoi(String cuoi){
        Cuoi=cuoi;
    }
}
