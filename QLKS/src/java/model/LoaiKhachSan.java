package model;

public class LoaiKhachSan {

    int Id;
    String Ten;
    String MoTa;
    String UrlHinhAnh;

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

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getUrlHinhAnh() {
        return UrlHinhAnh;
    }

    public void setUrlHinhAnh(String UrlHinhAnh) {
        this.UrlHinhAnh = UrlHinhAnh;
    }

    public LoaiKhachSan() {

    }

    public LoaiKhachSan(int Id, String Ten, String MoTa, String UrlHinhAnh) {
        this.Id = Id;
        this.Ten = Ten;
        this.MoTa = MoTa;
        this.UrlHinhAnh = UrlHinhAnh;
    }

    public LoaiKhachSan(LoaiKhachSan tp) {
        this.Id = tp.Id;
        this.Ten = tp.Ten;
        this.MoTa = tp.MoTa;
        this.UrlHinhAnh = tp.UrlHinhAnh;
    }

    public void reload(int Id, String Ten, String MoTa, String UrlHinhAnh) {
        this.Id = Id;
        this.Ten = Ten;
        this.MoTa = MoTa;
        this.UrlHinhAnh = UrlHinhAnh;
    }
}