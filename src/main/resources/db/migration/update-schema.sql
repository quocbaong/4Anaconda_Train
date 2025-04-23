CREATE TABLE ChiTietKhuyenMai
(
    MaHoaDon    varchar(255) NOT NULL,
    MaKhuyenMai varchar(255) NOT NULL,
    CONSTRAINT pk_chitietkhuyenmai PRIMARY KEY (MaHoaDon, MaKhuyenMai)
)
    GO

CREATE TABLE ChiTietTuyen
(
    ID      int          NOT NULL,
    MaTuyen varchar(255) NOT NULL,
    CONSTRAINT pk_chitiettuyen PRIMARY KEY (ID, MaTuyen)
)
    GO

CREATE TABLE ChiTietVe
(
    MaVe  varchar(255) NOT NULL,
    ID    int          NOT NULL,
    Chieu bit,
    CONSTRAINT pk_chitietve PRIMARY KEY (MaVe, ID)
)
    GO

CREATE TABLE ChoNgoi
(
    MaChoNgoi varchar(255) NOT NULL,
    MoTa      nvarchar(255),
    Gia       float(53),
    ViTri     int,
    MaTau     varchar(255),
    MaToa     varchar(255),
    CONSTRAINT pk_chongoi PRIMARY KEY (MaChoNgoi)
)
    GO

CREATE TABLE Chuyen
(
    MaChuyen     varchar(255) NOT NULL,
    TenChuyen    nvarchar(255),
    GioKhoiHanh  datetime,
    Chieu        bit,
    NgayKhoiHanh date,
    MaTau        varchar(255) NOT NULL,
    MaTuyen      varchar(255),
    CONSTRAINT pk_chuyen PRIMARY KEY (MaChuyen)
)
    GO

CREATE TABLE Ga
(
    ID     int NOT NULL,
    TenGa  nvarchar(255) NOT NULL,
    CuLy   float(53),
    DiaChi nvarchar(255),
    CONSTRAINT pk_ga PRIMARY KEY (ID)
)
    GO

CREATE TABLE HoaDon
(
    MaHoaDon   varchar(255) NOT NULL,
    GioTao     datetime,
    NgayTao    date,
    TrangThai  bit,
    MaNhanVien varchar(255),
    CCCD       varchar(255),
    CONSTRAINT pk_hoadon PRIMARY KEY (MaHoaDon)
)
    GO

CREATE TABLE KhachHang
(
    CCCD     varchar(255) NOT NULL,
    SDT      varchar(255),
    HoTen    nvarchar(255) NOT NULL,
    Email    varchar(255),
    DoiTuong nvarchar(255) NOT NULL,
    CONSTRAINT pk_khachhang PRIMARY KEY (CCCD)
)
    GO

CREATE TABLE KhuyenMai
(
    MaKhuyenMai     varchar(255) NOT NULL,
    TenKhuyenMai    nvarchar(255) NOT NULL,
    LoaiKhuyenMai   nvarchar(255) NOT NULL,
    ThoiGianBatDau  datetime     NOT NULL,
    ThoiGianKetThuc datetime     NOT NULL,
    SoLuongVe       int,
    TrangThai       bit,
    ChietKhau       float(53),
    CONSTRAINT pk_khuyenmai PRIMARY KEY (MaKhuyenMai)
)
    GO

CREATE TABLE NhanVien
(
    MaNhanVien varchar(255) NOT NULL,
    HoTen      nvarchar(255) NOT NULL,
    CCCD       varchar(255) NOT NULL,
    SDT        varchar(255),
    Email      varchar(255),
    GioiTinh   bit,
    DiaChi     nvarchar(255),
    LoaiNV     varchar(255),
    TrangThai  bit,
    NgaySinh   date, [
    NgayVaoLam]
    date,
    CONSTRAINT pk_nhanvien PRIMARY KEY (MaNhanVien)
)
    GO

CREATE TABLE TaiKhoan
(
    TenTaiKhoan varchar(255) NOT NULL,
    MatKhau     varchar(255),
    MaNhanVien  varchar(255) NOT NULL,
    CONSTRAINT pk_taikhoan PRIMARY KEY (TenTaiKhoan)
)
    GO

CREATE TABLE Tau
(
    MaTau   varchar(255) NOT NULL,
    LoaiTau varchar(255),
    TenTau  varchar(255),
    TocDo   float(53),
    CONSTRAINT pk_tau PRIMARY KEY (MaTau)
)
    GO

CREATE TABLE Toa
(
    MaToa   varchar(255) NOT NULL,
    LoaiToa varchar(255),
    ViTri   int,
    CONSTRAINT pk_toa PRIMARY KEY (MaToa)
)
    GO

CREATE TABLE Tuyen
(
    MaTuyen           varchar(255) NOT NULL,
    TenTuyen          nvarchar(255),
    DiemDi            nvarchar(255),
    DiemDen           nvarchar(255),
    ThoiGianKhoiHanh  varchar(255),
    ThoiGianDenDuKien varchar(255),
    GiaVeCoBan        float(53),
    TrangThai         bit,
    CONSTRAINT pk_tuyen PRIMARY KEY (MaTuyen)
)
    GO

CREATE TABLE Ve
(
    MaVe           varchar(255) NOT NULL,
    ThoiGianLenTau datetime,
    TrangThai      bit,
    MaChuyen       varchar(255),
    MaChoNgoi      varchar(255),
    MaKhuyenMai    varchar(255),
    CCCD           varchar(255),
    MaHoaDon       varchar(255),
    CONSTRAINT pk_ve PRIMARY KEY (MaVe)
)
    GO

ALTER TABLE TaiKhoan
    ADD CONSTRAINT uc_taikhoan_manhanvien UNIQUE (MaNhanVien)
    GO

ALTER TABLE ChiTietVe
    ADD CONSTRAINT FK_CHITIETVE_ON_ID FOREIGN KEY (ID) REFERENCES Ga (ID)
    GO

ALTER TABLE ChiTietVe
    ADD CONSTRAINT FK_CHITIETVE_ON_MAVE FOREIGN KEY (MaVe) REFERENCES Ve (MaVe)
    GO

ALTER TABLE ChoNgoi
    ADD CONSTRAINT FK_CHONGOI_ON_MATAU FOREIGN KEY (MaTau) REFERENCES Tau (MaTau)
    GO

ALTER TABLE ChoNgoi
    ADD CONSTRAINT FK_CHONGOI_ON_MATOA FOREIGN KEY (MaToa) REFERENCES Toa (MaToa)
    GO

ALTER TABLE Chuyen
    ADD CONSTRAINT FK_CHUYEN_ON_MATAU FOREIGN KEY (MaTau) REFERENCES Tau (MaTau)
    GO

ALTER TABLE Chuyen
    ADD CONSTRAINT FK_CHUYEN_ON_MATUYEN FOREIGN KEY (MaTuyen) REFERENCES Tuyen (MaTuyen)
    GO

ALTER TABLE HoaDon
    ADD CONSTRAINT FK_HOADON_ON_CCCD FOREIGN KEY (CCCD) REFERENCES KhachHang (CCCD)
    GO

ALTER TABLE HoaDon
    ADD CONSTRAINT FK_HOADON_ON_MANHANVIEN FOREIGN KEY (MaNhanVien) REFERENCES NhanVien (MaNhanVien)
    GO

ALTER TABLE TaiKhoan
    ADD CONSTRAINT FK_TAIKHOAN_ON_MANHANVIEN FOREIGN KEY (MaNhanVien) REFERENCES NhanVien (MaNhanVien)
    GO

ALTER TABLE ChiTietTuyen
    ADD CONSTRAINT fk_chi_on_ga FOREIGN KEY (ID) REFERENCES Ga (ID)
    GO

ALTER TABLE ChiTietKhuyenMai
    ADD CONSTRAINT fk_chi_on_hoa_don FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon)
    GO

ALTER TABLE ChiTietKhuyenMai
    ADD CONSTRAINT fk_chi_on_khuyen_mai FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai (MaKhuyenMai)
    GO

ALTER TABLE ChiTietTuyen
    ADD CONSTRAINT fk_chi_on_tuyen FOREIGN KEY (MaTuyen) REFERENCES Tuyen (MaTuyen)
    GO