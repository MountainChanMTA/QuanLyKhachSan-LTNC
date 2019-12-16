package bean;

import static bean.BeanThanhPho.hashThanhPho;
import java.io.Serializable;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanKhachSan", eager = true)
@ApplicationScoped
public class BeanKhachSan implements Serializable {

    private static final long serialVersionUID = 1786783L;
    
    KhachSan khachSan;
    ArrayList<KhachSan> listKhachSan;
    ArrayList<KhachSan> listKhachSanNoiBat;
    ArrayList<BuaAn> listBuaAn;
    Connection con;

    public KhachSan getKhachSan() {
        return khachSan;
    }

    public void setKhachSan(KhachSan khachSan) {
        this.khachSan = khachSan;
    }

    public ArrayList<KhachSan> getListKhachSan() {
        return listKhachSan;
    }

    public ArrayList<BuaAn> getListBuaAn() {
        return listBuaAn;
    }

    public ArrayList<KhachSan> getListKhachSanNoiBat() {
        return listKhachSanNoiBat;
    }

    public BeanKhachSan() {
        listBuaAn = new ArrayList();
        listBuaAn.add(new BuaAn(0, "Không có"));
        listBuaAn.add(new BuaAn(1, "Bữa Sáng"));
        listBuaAn.add(new BuaAn(2, "Bữa Sáng Và Trưa"));
        listBuaAn.add(new BuaAn(3, "Bữa Sáng Và Tối"));
        listBuaAn.add(new BuaAn(4, "Cả Ba Bữa"));
        khachSan = new KhachSan();
        try {
            int index = 0;
            listKhachSan = new ArrayList();
            listKhachSanNoiBat = new ArrayList();
            con = dao.SQLConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select K.Id as Id, K.Ten as Ten, DiaChi,"
                    + "SoDienThoai, CachTrungTam, K.MoTa, GiapBien, DanhGia, BuaAn, IdThanhPho,"
                    + "T.Ten as TenThanhPho, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan from KhachSan K, ThanhPho T,"
                    + "LoaiKhachSan L where K.IdThanhPho = T.Id and K.IdLoaiKhachSan = L.Id");
            while (rs.next()) {
                KhachSan tmp = new KhachSan();
                tmp.setId(rs.getInt("Id"));
                tmp.setTen(rs.getString("Ten"));
                tmp.setDiaChi(rs.getString("DiaChi"));
                tmp.setSoDienThoai(rs.getString("SoDienThoai"));
                tmp.setCachTrungTam(rs.getInt("CachTrungTam"));
                tmp.setMoTa(rs.getString("MoTa"));
                tmp.setGiapBien(rs.getBoolean("GiapBien"));
                tmp.setDanhGia(rs.getInt("DanhGia"));
                tmp.setBuaAn(rs.getInt("BuaAn"));
                tmp.setIdThanhPho(rs.getInt("IdThanhPho"));
                tmp.setTenThanhPho(rs.getString("TenThanhPho"));
                tmp.setIdThanhPho(rs.getInt("IdLoaiKhachSan"));
                tmp.setTenThanhPho(rs.getString("TenLoaiKhachSan"));
                listKhachSan.add(tmp);
                if (index < 4) {
                    listKhachSanNoiBat.add(tmp);
                    index++;
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset() {
        khachSan.setTen("");
        khachSan.setDiaChi("");
        khachSan.setSoDienThoai("");
        khachSan.setCachTrungTam(0);
        khachSan.setMoTa("");
        khachSan.setGiapBien(false);
        khachSan.setDanhGia(5);
        khachSan.setBuaAn(0);
        khachSan.setIdThanhPho(1);
        khachSan.setTenThanhPho("");
        khachSan.setIdLoaiKhachSan(1);
        khachSan.setTenLoaiKhachSan("");
    }

    public void insert(KhachSan tmp) {
        try {
            con = dao.SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into KhachSan output inserted.Id values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, tmp.getTen());
            stmt.setString(2, tmp.getDiaChi());
            stmt.setString(3, tmp.getSoDienThoai());
            stmt.setInt(4, tmp.getCachTrungTam());
            stmt.setString(5, tmp.getMoTa());
            stmt.setBoolean(6, tmp.isGiapBien());
            stmt.setInt(7, tmp.getDanhGia());
            stmt.setInt(8, tmp.getBuaAn());
            stmt.setInt(9, tmp.getIdThanhPho());
            stmt.setInt(10, tmp.getIdLoaiKhachSan());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tmp.setId(rs.getInt("Id"));
            }
            con.close();
            tmp.setTenThanhPho(hashThanhPho.get(tmp.getIdThanhPho()));
            KhachSan ks = new KhachSan(tmp);
            listKhachSan.add(ks);
            msg.Message.addMessage("Thành Công", "Thêm Khách Sạn Thành Công!");
        } catch (Exception e) {
            msg.Message.errorMessage("Thất Bại", "Thêm Khách Sạn Thất Bại!");
        }
    }

    public void update(KhachSan tmp) {
        try {
            con = dao.SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("update KhachSan set Ten=?, DiaChi=?, SoDienThoai=?, CachTrungTam=?, MoTa=?, GiapBien=?, DanhGia=?, BuaAn=?, IdThanhPho=?, IdLoaiThanhPho=? where Id=?");
            stmt.setString(1, tmp.getTen());
            stmt.setString(2, tmp.getDiaChi());
            stmt.setString(3, tmp.getSoDienThoai());
            stmt.setInt(4, tmp.getCachTrungTam());
            stmt.setString(5, tmp.getMoTa());
            stmt.setBoolean(6, tmp.isGiapBien());
            stmt.setInt(7, tmp.getDanhGia());
            stmt.setInt(8, tmp.getBuaAn());
            stmt.setInt(9, tmp.getIdThanhPho());
            stmt.setInt(10, tmp.getIdLoaiKhachSan());
            stmt.setInt(11, tmp.getId());
            stmt.executeUpdate();
            con.close();
            int Id = tmp.getId();
            tmp.setTenThanhPho(hashThanhPho.get(tmp.getIdThanhPho()));
            for (KhachSan ks : listKhachSan) {
                if (ks.getId() == Id) {
                    ks.reload(Id, tmp.getTen(), tmp.getDiaChi(), tmp.getSoDienThoai(), tmp.getCachTrungTam(), tmp.getMoTa(), tmp.isGiapBien(), tmp.getDanhGia(), tmp.getBuaAn(), tmp.getIdThanhPho(), tmp.getTenThanhPho(), tmp.getIdLoaiKhachSan(), tmp.getTenLoaiKhachSan());
                    break;
                }
            }
            msg.Message.addMessage("Thành Công", "Sửa Khách Sạn Thành Công!");
        } catch (Exception e) {
            msg.Message.errorMessage("Thất Bại", "Sửa Khách Sạn Thất Bại!");
        }
    }

    public void delete(int Id) {
        try {
            con = dao.SQLConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from KhachSan where id=?");
            stmt.setInt(1, Id);
            stmt.executeUpdate();
            con.close();
            for (KhachSan ks : listKhachSan) {
                if (ks.getId() == Id) {
                    listKhachSan.remove(ks);
                    break;
                }
            }
            msg.Message.addMessage("Thành Công", "Xóa Khách Sạn Thành Công!");
        } catch (Exception e) {
            msg.Message.errorMessage("Thất Bại", "Xóa Khách Sạn Thất Bại!");
        }
    }

}