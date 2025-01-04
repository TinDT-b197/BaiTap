public class HoaDon extends BangGiaDichVu {
    private String IdHoaDon;
    private String NgayLapHoaDon;
    private int SoGBTieuThu;

    @Override
    public int getSoGBTieuThu() {
        return SoGBTieuThu;
    }

    @Override
    public void setSoGBTieuThu(int soGBTieuThu) {
        SoGBTieuThu = soGBTieuThu;
    }

    private int SoTienPhaiTra;
    private boolean TrangThaiThanhToan;

    public HoaDon() {}
    public HoaDon(String IdHoaDon, String NgayLapHoaDon, int SoGBTieuThu) {
        super();
        this.IdHoaDon = IdHoaDon;
        this.NgayLapHoaDon = NgayLapHoaDon;
        this.TrangThaiThanhToan = false;
    }

    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        IdHoaDon = idHoaDon;
    }

    public String getNgayLapHoaDon() {
        return NgayLapHoaDon;
    }

    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        NgayLapHoaDon = ngayLapHoaDon;
    }

    public int getSoTienPhaiTra() {
        return SoTienPhaiTra;
    }

    public void setSoTienPhaiTra(int soTienPhaiTra) {
        SoTienPhaiTra = soTienPhaiTra;
    }

    public boolean isTrangThaiThanhToan() {
        return TrangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
        if(trangThaiThanhToan == true){
            System.out.println("Trang Thai Thanh Toan: Da Thanh Toan!");
        }
        else {
            System.out.println("Trang Thai Thanh Toan: Chua Thanh Toan!");
        }
    }

}
