package model;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Barang {
    private int id_barang;
    private String nama_barang;
    private String deskripsi;
    private String lokasi;
    private LocalDate waktu_kehilangan;
    private int status;
    private Image image;

    public Barang(String nama_barang, String deskripsi, String lokasi, LocalDate waktu_kehilangan, Image image) {
        this.nama_barang = nama_barang;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.waktu_kehilangan = waktu_kehilangan;
        this.image = image;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public LocalDate getWaktu_kehilangan() {
        return waktu_kehilangan;
    }

    public void setWaktu_kehilangan(LocalDate waktu_kehilangan) {
        this.waktu_kehilangan = waktu_kehilangan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Barang{" +
                "id_barang=" + id_barang +
                ", nama_barang='" + nama_barang + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", lokasi='" + lokasi + '\'' +
                ", waktu_kehilangan=" + waktu_kehilangan +
                '}';
    }


}

