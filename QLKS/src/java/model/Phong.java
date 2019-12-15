package model;

public class Phong {

    int Id;
    String Ten;
    int DienTich;
    int GiaThue;
    String TienNghi;
    String MoTa;
    int LoaiGiuong;
    int IdKhachSan;
    String TenKhachSan;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getDienTich() {
        return DienTich;
    }

    public void setDienTich(int DienTich) {
        this.DienTich = DienTich;
    }

    public int getGiaThue() {
        return GiaThue;
    }

    public void setGiaThue(int GiaThue) {
        this.GiaThue = GiaThue;
    }

    public String getTienNghi() {
        return TienNghi;
    }

    public void setTienNghi(String TienNghi) {
        this.TienNghi = TienNghi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getLoaiGiuong() {
        return LoaiGiuong;
    }

    public void setLoaiGiuong(int LoaiGiuong) {
        this.LoaiGiuong = LoaiGiuong;
    }

    public int getIdKhachSan() {
        return IdKhachSan;
    }

    public void setIdKhachSan(int IdKhachSan) {
        this.IdKhachSan = IdKhachSan;
    }

    public String getTenKhachSan() {
        return TenKhachSan;
    }

    public void setTenKhachSan(String TenKhachSan) {
        this.TenKhachSan = TenKhachSan;
    }

    public Phong() {
    }

    public Phong(int Id, String Ten, int DienTich, int GiaThue, String TienNghi, String MoTa, int LoaiGiuong, int IdKhachSan, String TenKhachSan) {
        this.Id = Id;
        this.Ten = Ten;
        this.DienTich = DienTich;
        this.GiaThue = GiaThue;
        this.TienNghi = TienNghi;
        this.MoTa = MoTa;
        this.LoaiGiuong = LoaiGiuong;
        this.IdKhachSan = IdKhachSan;
        this.TenKhachSan = TenKhachSan;
    }
    
}