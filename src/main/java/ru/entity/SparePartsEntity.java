package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="spare_parts")
public class SparePartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_spare", length = 6, nullable = false, columnDefinition = "serial")
    private long id_spare;
    @Column(name="parts_name", length = 200, nullable = false)
    private String parts_name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_group", nullable = false)
    private GroupPartsEntity groupPartsEntity;

    public SparePartsEntity() {}

    public long getId() {        return id_spare;    }
    public void setId(long id_spare) {        this.id_spare = id_spare;    }
    public String getParts_name() {        return parts_name;    }
    public void setParts_name(String parts_name) {        this.parts_name = parts_name;    }
    public GroupPartsEntity getGroupPartsEntity() {        return groupPartsEntity;    }
    public void setGroupPartsEntity(GroupPartsEntity groupPartsEntity) {        this.groupPartsEntity = groupPartsEntity;   }
}
