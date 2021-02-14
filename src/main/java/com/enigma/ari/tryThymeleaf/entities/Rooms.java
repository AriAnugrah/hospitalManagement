package com.enigma.ari.tryThymeleaf.entities;

public class Rooms {
    private int id;
    private String roomname;
    private int code;
    private int bed;
    private Boolean status;

    public Rooms() {
    }

    public Rooms(int id, String roomname, int code, int bed, Boolean status) {
        this.id = id;
        this.roomname = roomname;
        this.code = code;
        this.bed = bed;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", roomname='" + roomname + '\'' +
                ", code=" + code +
                ", bed=" + bed +
                ", status=" + status +
                '}';
    }
}
