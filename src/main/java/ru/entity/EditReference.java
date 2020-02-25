package ru.entity;

import lombok.Setter;

import javax.persistence.*;



public class EditReference {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_name", nullable = false)
    private MakeCarEntity makeCarEntity;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_name", nullable = false)
    private ModelCarEntity modelCarEntity;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_name", nullable = false)
    private GroupPartsEntity groupPartsEntity;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spare_name", nullable = false)
    private SparePartsEntity sparePartsEntity;

    public EditReference() {}

    public MakeCarEntity getMakeCarEntity() {        return makeCarEntity;    }
    public ModelCarEntity getModelCarEntity() {        return modelCarEntity;    }
    public GroupPartsEntity getGroupPartsEntity() {        return groupPartsEntity;    }
    public SparePartsEntity getSparePartsEntity() {        return sparePartsEntity;    }

    public void setMakeCarEntity(MakeCarEntity makeCarEntity) {        this.makeCarEntity = makeCarEntity; }
    public void setModelCarEntity(ModelCarEntity modelCarEntity) {        this.modelCarEntity = modelCarEntity;    }
    public void setGroupPartsEntity(GroupPartsEntity groupPartsEntity) {        this.groupPartsEntity = groupPartsEntity;    }
    public void setSparePartsEntity(SparePartsEntity sparePartsEntity) {        this.sparePartsEntity = sparePartsEntity;    }
}
