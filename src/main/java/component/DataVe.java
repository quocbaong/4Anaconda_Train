
package component;

public class DataVe {
    private String doiTuong;
    private String gaDen;
    private String gaDi;
    private int soLuong;
    private double tongTien;

    public DataVe(String doiTuong, String gaDen, String gaDi, int soLuong, double tongTien) {
        this.doiTuong = doiTuong;
        this.gaDen = gaDen;
        this.gaDi = gaDi;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public void setIntervolSL(){
        this.soLuong += 1;
    }
    
    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public String getGaDen() {
        return gaDen;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }

    public String getGaDi() {
        return gaDi;
    }

    public void setGaDi(String gaDi) {
        this.gaDi = gaDi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    

    
    
    
}
