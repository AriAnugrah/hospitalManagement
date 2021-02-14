package com.enigma.ari.tryThymeleaf.entities;

public class Patients {
    private int id;
    private String name;
    private String alamat;
    private int golongan;
    private int umur;

    public Patients() {
    }

    public Patients(int id, String name, String alamat, int golongan, int umur) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
        this.golongan = golongan;
        this.umur = umur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alamat='" + alamat + '\'' +
                ", golongan=" + golongan +
                ", umur=" + umur +
                '}';
    }
}
