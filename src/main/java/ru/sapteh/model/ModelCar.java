package ru.sapteh.model;

import java.util.Objects;

public class ModelCar {
    private int id;
    private String mark;
    private String bodyType;
    private String typeGasoline;

    public ModelCar() {

    }

    public ModelCar(int id, String mark, String bodyType, String typeGasoline) {
        this.id = id;
        this.mark = mark;
        this.bodyType = bodyType;
        this.typeGasoline = typeGasoline;
    }

    public ModelCar(String mark, String bodyType, String typeGasoline) {
        this.mark = mark;
        this.bodyType = bodyType;
        this.typeGasoline = typeGasoline;
    }

    public int getId() {
        return id;
    }

    public String getMark(){
        return mark;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTypeGasoline() {
        return typeGasoline;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setMark (String mark){
        this.mark = mark;
    }

    public void setBodyType (String bodyType) {
        this.bodyType = bodyType;
    }

    public void setTypeGasoline (String typeGasoline) {
        this.typeGasoline = typeGasoline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelCar modelCar = (ModelCar) o;
        return id == modelCar.id && Objects.equals(mark, modelCar.mark) && Objects.equals(bodyType, modelCar.bodyType) && Objects.equals(typeGasoline, modelCar.typeGasoline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, bodyType, typeGasoline);
    }

    @Override
    public String toString() {
        return "ModelCar{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", typeGasoline='" + typeGasoline + '\'' +
                '}';
    }
}
