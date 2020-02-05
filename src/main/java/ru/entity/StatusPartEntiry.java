package ru.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="status_part")
public class StatusPartEntiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_status", length = 6, nullable = false, columnDefinition = "serial")
    private long id_status;
    @Column(name="date_create",  columnDefinition = "TimeStamp default current_timestamp")
    private Timestamp date_create;
    @Column(name="reserved")
    private Timestamp reserved;
    @Column(name="paid")
    private Timestamp paid;
    @Column(name="shipped")
    private Timestamp shipped;
    @Column(name="summa")
    private  double summa;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_client", nullable = false)
    private ClientEntity clientEntity;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_parts", nullable = false)
    private PartsEntity partsEntity;

    public StatusPartEntiry() {    }

    public long getId_status() {        return id_status;    }
    public void setId_status(long id_status) {        this.id_status = id_status;    }
    public Timestamp getDate_create() {        return date_create;    }
    public void setDate_create(Timestamp date_create) {        this.date_create = date_create;    }
    public Timestamp getReserved() {        return reserved;    }
    public void setReserved(Timestamp reserved) {        this.reserved = reserved;    }
    public Timestamp getPaid() {        return paid;    }
    public void setPaid(Timestamp paid) {        this.paid = paid;    }
    public Timestamp getShipped() {        return shipped;    }
    public void setShipped(Timestamp shipped) {        this.shipped = shipped;    }
    public double getSumma() {        return summa;    }
    public void setSumma(double summa) {        this.summa = summa;    }
    public ClientEntity getClientEntity() {        return clientEntity;    }
    public void setClientEntity(ClientEntity clientEntity) {        this.clientEntity = clientEntity;    }
    public PartsEntity getPartsEntity() {        return partsEntity;    }
    public void setPartsEntity(PartsEntity partsEntity) {        this.partsEntity = partsEntity;    }
}