package id.ac.binus.project_mobileprog;

public class Agent {
    int gambar;
    private String nama;
    private String phone;
    private String office;

    public Agent(int gambar, String nama, String office, String phone) {
        this.gambar = gambar;
        this.nama = nama;
        this.office = office;
        this.phone = phone;
    }

    public int getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getOffice() {
        return office;
    }

    public String getPhone() {
        return phone;
    }
}