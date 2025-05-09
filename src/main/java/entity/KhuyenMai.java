package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
        @NamedQuery(name = "KhuyenMai.findAllKMKH", query = "SELECT km FROM KhuyenMai km WHERE km.loaiKhuyenMai != :loai"),
        @NamedQuery(name = "KhuyenMai.findAllKMHD", query = "SELECT km FROM KhuyenMai km WHERE km.loaiKhuyenMai = :loai"),
        @NamedQuery(name = "KhuyenMai.findAll", query = "SELECT km FROM KhuyenMai km"),
        @NamedQuery(name = "KhuyenMai.findAllKMNB", query = "SELECT km FROM KhuyenMai km WHERE km.maKhuyenMai LIKE :ma"),
        @NamedQuery(name = "KhuyenMai.findAllTimeRange", query = "SELECT km FROM KhuyenMai km WHERE km.thoiGianBatDau >= :startTime AND km.thoiGianKetThuc <= :endTime")
})
public class KhuyenMai implements Serializable {

    @Id
    @Column(name = "MaKhuyenMai", unique = true, nullable = false)
    private String maKhuyenMai;

    @Column(name = "TenKhuyenMai", nullable = false, columnDefinition = "nvarchar(255)")
    private String tenKhuyenMai;

    @Column(name = "LoaiKhuyenMai", nullable = false, columnDefinition = "nvarchar(255)")
    private String loaiKhuyenMai;

    @Column(name = "ThoiGianBatDau", nullable = false, columnDefinition = "datetime")
    private Date thoiGianBatDau;

    @Column(name = "ThoiGianKetThuc", nullable = false, columnDefinition = "datetime")
    private Date thoiGianKetThuc;

    @Column(name = "SoLuongVe")
    private int soLuongVe;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @Column(name = "ChietKhau")
    private double chietKhau;

    @OneToMany(mappedBy = "khuyenMai")
    private List<Ve> listVes;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, Date thoiGianBatDau,
                     Date thoiGianKetThuc, int soLuongVe, boolean trangThai, double chietKhau) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.soLuongVe = soLuongVe;
        this.trangThai = trangThai;
        this.chietKhau = chietKhau;
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, Date thoiGianBatDau,
                     Date thoiGianKetThuc, boolean trangThai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.trangThai = trangThai;
    }

    // === Getter & Setter ===

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(double chietKhau) {
        this.chietKhau = chietKhau;
    }

    public List<Ve> getListVes() {
        return listVes;
    }

    public void setListVes(List<Ve> listVes) {
        this.listVes = listVes;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", loaiKhuyenMai='" + loaiKhuyenMai + '\'' +
                ", thoiGianBatDau=" + thoiGianBatDau +
                ", thoiGianKetThuc=" + thoiGianKetThuc +
                ", chietKhau=" + chietKhau +
                ", soLuongVe=" + soLuongVe +
                ", trangThai=" + trangThai +
                '}';
    }
}
