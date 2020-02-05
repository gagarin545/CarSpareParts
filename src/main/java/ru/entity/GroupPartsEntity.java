package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="group_parts")
public class GroupPartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_group", length = 6, nullable = false, columnDefinition = "serial")
    private long id_group;
    @Column(name="group_name", length = 150, nullable = false)
    private String group_name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_model", nullable = false)
    private ModelCarEntity modelCarEntity;

    public GroupPartsEntity() {}

    public long getId() {        return id_group;    }
    public void setId(long id_group) {        this.id_group = id_group;    }
    public String getGroup_name() {        return group_name;    }
    public void setGroup_name(String group_name) {        this.group_name = group_name;    }
    public ModelCarEntity getModelCarEntity() {        return modelCarEntity;    }
    public void setModelCarEntity(ModelCarEntity modelCarEntity) {        this.modelCarEntity = modelCarEntity;    }
}
