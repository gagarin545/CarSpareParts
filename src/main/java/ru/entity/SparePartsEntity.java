package ru.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="spare_parts")
public class SparePartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_spare", length = 6, nullable = false, columnDefinition = "serial")
    private long id_spare;
    @Column(name="spare_name", length = 200, nullable = false)
    private String spare_name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_group", nullable = false)
    private GroupPartsEntity groupPartsEntity;

    public SparePartsEntity() {}

    public long getId_spare() {        return id_spare;    }
    public void setId_spare(long id_spare) {        this.id_spare = id_spare;    }
    public String getSpare_name() {        return spare_name;    }
    public void setSpare_name(String spare_name) {        this.spare_name = spare_name;    }
    public GroupPartsEntity getGroupPartsEntity() {        return groupPartsEntity;    }
    public void setGroupPartsEntity(GroupPartsEntity groupPartsEntity) {        this.groupPartsEntity = groupPartsEntity;    }
}
