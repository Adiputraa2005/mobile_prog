package id.ac.binus.project_mobileprog;

import android.widget.Button;

public class Rumah {
    private int Id;
    private int gambar;
    private String tipe_rumah;
    private String nama_rumah;
    private String harga_rumah;
    private String ukuran_rumah;
    private String lokasi_rumah;

    public Rumah(int gambar, String tipe_rumah, String nama_rumah, String harga_rumah, String ukuran_rumah,  String lokasi_rumah) {
        this.gambar = gambar;
        this.harga_rumah = harga_rumah;
        this.lokasi_rumah = lokasi_rumah;
        this.nama_rumah = nama_rumah;
        this.tipe_rumah = tipe_rumah;
        this.ukuran_rumah = ukuran_rumah;
    }

    public int getGambar() {
        return gambar;
    }
    public int getId(){
        return Id;
    }

    public String getHarga_rumah() {
        return harga_rumah;
    }

    public String getLokasi_rumah() {
        return lokasi_rumah;
    }

    public String getNama_rumah() {
        return nama_rumah;
    }

    public String getTipe_rumah() {
        return tipe_rumah;
    }

    public String getUkuran_rumah() {
        return ukuran_rumah;
    }
}
