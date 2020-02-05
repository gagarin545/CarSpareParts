package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="parts")
public class PartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_parts", length = 6, nullable = false, columnDefinition = "serial")
    private long id_parts;
    @Column(name="photo", length = 200, nullable = false)
    private String photo;
    @Column(name="cost", length = 200, nullable = false)
    private double cost;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_spare", nullable = false)
    private SparePartsEntity sparePartsEntity;

    public PartsEntity() {    }

    public long getId() {        return id_parts;    }
    public void setId(long id_parts) {        this.id_parts = id_parts;    }
    public String getPhoto() {        return photo;    }
    public void setPhoto(String photo) {        this.photo = photo;    }
    public double getCost() {        return cost;    }
    public void setCost(double cost) {        this.cost = cost;    }
    public SparePartsEntity getSparePartsEntity() {        return sparePartsEntity;    }
    public void setSparePartsEntity(SparePartsEntity sparePartsEntity) {        this.sparePartsEntity = sparePartsEntity;   }
}
