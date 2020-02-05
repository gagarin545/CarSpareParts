package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="make_car")
public class MakeCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", length = 6, nullable = false, columnDefinition = "serial")
    private long id;
    @Column(name="car_name", length = 150, nullable = false)
    private String car_name;

    public MakeCarEntity() {}

    public long getId() {        return id;    }
    public void setId(long id) {        this.id = id;    }
    public String getCar_name() {        return car_name;    }
    public void setCar_name(String car_name) {        this.car_name = car_name;    }
}
