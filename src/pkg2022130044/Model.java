
package pkg2022130044;


public class Model {
    String pembeli, noMeja;
    int pilihmakanan1, pilihpedas1,pilihjumlah1;
    boolean shoopepay, gopay, member, pulang, tunai;

    public boolean isTunai() {
        return tunai;
    }

    public void setTunai(boolean tunai) {
        this.tunai = tunai;
    }
    
    
    public boolean isPulang() {
        return pulang;
    }

    public void setPulang(boolean pulang) {
        this.pulang = pulang;
    }

    
    
    public String getNoMeja() {
        return noMeja;
    }

    public void setNoMeja(String noMeja) {
        this.noMeja = noMeja;
    }
    
    
    
    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }
    
    
   
    
    public int getPilihmakanan1() {
        return pilihmakanan1;
    }

    public void setPilihmakanan1(int pilihmakanan1) {
        this.pilihmakanan1 = pilihmakanan1;
    }


    public int getPilihpedas1() {
        return pilihpedas1;
    }

    public void setPilihpedas1(int pilihpedas1) {
        this.pilihpedas1 = pilihpedas1;
    }

    public int getPilihjumlah1() {
        return pilihjumlah1;
    }

    public void setPilihjumlah1(int pilihjumlah1) {
        this.pilihjumlah1 = pilihjumlah1;
    }


    public boolean isShoopepay() {
        return shoopepay;
    }

    public void setShoopepay(boolean shoopepay) {
        this.shoopepay = shoopepay;
    }

    public boolean isGopay() {
        return gopay;
    }

    public void setGopay(boolean gopay) {
        this.gopay = gopay;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }
    
    
}
