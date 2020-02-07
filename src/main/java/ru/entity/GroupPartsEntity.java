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

    public GroupPartsEntity() {}

    public long getId_group() { return id_group;    }
    public void setId_group(long id_group) {        this.id_group = id_group;    }
    public String getGroup_name() {        return group_name;    }
    public void setGroup_name(String group_name) {        this.group_name = group_name;    }
}
