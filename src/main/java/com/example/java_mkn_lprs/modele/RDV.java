package com.example.java_mkn_lprs.modele;

import java.sql.Timestamp;
import java.time.DateTimeException;

public class RDV {
    private int id_rdv;
    private Timestamp date_rdv;

    public int getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    public Timestamp getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(Timestamp date_rdv) {
        this.date_rdv = date_rdv;
    }
    public RDV (int id_rdv, Timestamp date_rdv){
        this.date_rdv = date_rdv;
        this.id_rdv = id_rdv;
    }
}
