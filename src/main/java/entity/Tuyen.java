
package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Tuyen implements Serializable {

    @Id
    @Column(name = "MaTuyen", nullable = false)
    private String maTuyen;

    @Column(name = "TenTuyen", columnDefinition = "nvarchar(255)")
    private String tenTuyen;

    @Column(name = "DiemDi", columnDefinition = "nvarchar(255)")
    private String diemDi; // Điểm xuất phát

    @Column(name = "DiemDen", columnDefinition = "nvarchar(255)")
    private String diemDen; // Điểm đến

    @Column(name = "ThoiGianKhoiHanh")
    private String thoiGianKhoiHanh; // Thời gian khởi hành (định dạng: hh:mm hoặc yyyy-MM-dd HH:mm)

    @Column(name = "ThoiGianDenDuKien")
    private String thoiGianDenDuKien; // Thời gian dự kiến đến (định dạng tương tự)

    @Column(name = "GiaVeCoBan")
    private double giaVeCoBan; // Giá vé cơ bản (VNĐ)

    @Column(name = "TrangThai")
    private boolean trangThai; // Trạng thái của tuyến: true = Đang hoạt động, false = Tạm ngưng

    @OneToMany(mappedBy = "tuyen")
    private List<Chuyen> listChuyens;


    @ManyToMany
    @JoinTable(name = "ChiTietTuyen", joinColumns = {
            @JoinColumn(name = "MaTuyen") }, inverseJoinColumns = {
            @JoinColumn(name = "ID") })
    private Set<Ga> listGas;

    public Tuyen() {
    }

    public Tuyen(String maTuyen, String tenTuyen) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;

    }

    public Tuyen(String maTuyen, String tenTuyen, String diemDi, String diemDen, String thoiGianKhoiHanh,
                 String thoiGianDenDuKien, double giaVeCoBan, boolean trangThai) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.thoiGianDenDuKien = thoiGianDenDuKien;
        this.giaVeCoBan = giaVeCoBan;
        this.trangThai = trangThai;
    }


    // Getters và Setters
    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public void setThoiGianKhoiHanh(String thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public String getThoiGianDenDuKien() {
        return thoiGianDenDuKien;
    }

    public void setThoiGianDenDuKien(String thoiGianDenDuKien) {
        this.thoiGianDenDuKien = thoiGianDenDuKien;
    }

    public double getGiaVeCoBan() {
        return giaVeCoBan;
    }

    public void setGiaVeCoBan(double giaVeCoBan) {
        this.giaVeCoBan = giaVeCoBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public List<Chuyen> getListChuyens() {
        return listChuyens;
    }

    public void setListChuyens(List<Chuyen> listChuyens) {
        this.listChuyens = listChuyens;
    }

    public Set<Ga> getListGas() {
        return listGas;
    }

    public void setListGas(Set<Ga> listGas) {
        this.listGas = listGas;
    }


    @Override
    public String toString() {
        return "Tuyen{" + "maTuyen=" + maTuyen + ", tenTuyen=" + tenTuyen + '}';
    }
}