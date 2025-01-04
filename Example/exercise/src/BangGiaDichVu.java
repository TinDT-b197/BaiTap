public class BangGiaDichVu {
    private int SoGBTieuThu;
    private int GiaTien;

    public int getSoGBTieuThu() {
        return SoGBTieuThu;
    }

    public void setSoGBTieuThu(int soGBTieuThu) {
        SoGBTieuThu = soGBTieuThu;
    }

    public void setGiaTien(int GiaTien) {
        if(SoGBTieuThu <= 50 ){
            this.GiaTien = 100000;
        } else if (SoGBTieuThu >= 51 && SoGBTieuThu <=100 ) {
            this.GiaTien = 150000;
        }
        else if(SoGBTieuThu > 100) {
            this.GiaTien = 200000;
        }
    }
    public int getGiaTien() {
        return GiaTien;
    }
    public BangGiaDichVu() {}
    public BangGiaDichVu(int SoGBTieuThu){
        this.SoGBTieuThu = SoGBTieuThu;
    }

}
