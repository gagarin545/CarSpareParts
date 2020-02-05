package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="model_car")
public class ModelCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_model", length = 6, nullable = false, columnDefinition = "serial")
    private long id_model;
    @Column(name="model_name", length = 150, nullable = false )
    private String model_name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id", nullable = false)
    private MakeCarEntity makeCarEntity;

    public ModelCarEntity() { }

    public long getId() {        return id_model;    }
    public void setId(long id_model) {        this.id_model = id_model;    }
    public String getModel_name() {        return model_name;    }
    public void setModel_name(String model_name) {        this.model_name = model_name;    }
    public MakeCarEntity getMakeCarEntity() {        return makeCarEntity;    }
    public void setMakeCarEntity(MakeCarEntity makeCarEntity) {        this.makeCarEntity = makeCarEntity;   }
}
