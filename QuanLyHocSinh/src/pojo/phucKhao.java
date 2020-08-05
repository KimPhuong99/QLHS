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
public class phucKhao {
   private int STT;
   private int MSSV;
   private String mon;
   private String cotDiem;
   private float Diem;
   private String LyDo;
   int tt;
   public phucKhao(){
       
   }
   public phucKhao(int STT,int mssv, String mon, String cotdiem,float diem,String lydo,int tt){
       this.STT=STT;
       MSSV=mssv;
       this.mon=mon;
       cotDiem=cotdiem;
       Diem=diem;
       LyDo=lydo;
       this.tt=tt;
   }
   public int getSTT(){
       return STT;
   }
   public void setSTT(int stt){
       STT=stt;
   }
   public int getMSSV(){
       return MSSV;
   }
   public void setMSSV(int mssv){
       MSSV=mssv;
   }
   public String getMon(){
       return mon;
   }
   public void setMon(String Mon){
       mon=Mon;
   }
   public String getCotDiem(){
       return cotDiem;
   }
   public void setCotDiem(String cd){
       cotDiem=cd;
   }
   public float getDiem(){
       return Diem;
   }
   public void setDiem(float diem){
       Diem=diem;
   }
   public String getLyDo(){
       return LyDo;
   }
   public void setLyDo(String ld){
       LyDo=ld;
   }
   public int gettt(){
       return tt;
   }
   public void settt(int tt){
       this.tt=tt;
   }
}
