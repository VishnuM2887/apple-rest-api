package com.vishnu.spring.apple.mobile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Mobile {

    @Id
    @SequenceGenerator(
        name = "mobile_sequence",
        sequenceName = "mobile_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "mobile_sequence"
    )
    private Long id;
    private String sku;
    private String name;
    private String generation;
    private String suffix;
    private Integer storage;
    private String color;
    private Double mrp;
    @Transient
    private String fullQualifiedName;
    
    public Mobile() {
    }

    public Mobile(Long id, String name, String generation, String suffix, Integer storage, String color, Double mrp) {
        this.id = id;
        this.sku = generation + (suffix!=null ? suffix : "") + "-" + storage + color.replaceAll(" ", "");
        this.name = name;
        this.generation = generation;
        this.suffix = suffix;
        this.storage = storage;
        this.color = color;
        this.mrp = mrp;
    }

    public Mobile(String name, String generation, String suffix, Integer storage, String color, Double mrp) {
        this.sku = generation + (suffix != null ? suffix : "") + "-" + storage + color.replaceAll(" ", "");
        this.name = name;
        this.generation = generation;
        this.suffix = suffix;
        this.storage = storage;
        this.color = color;
        this.mrp = mrp;
    }
    
    public Mobile(String name, String generation, Integer storage, String color, Double mrp) {
        this.sku = generation + "-" + storage + color.replaceAll(" ", "");
        this.name = name;
        this.generation = generation;
        this.storage = storage;
        this.color = color;
        this.mrp = mrp;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGeneration() {
        return generation;
    }
    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getStorage() {
        return storage;
    }
    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Double getMrp() {
        return mrp;
    }
    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public String getFullQualifiedName() {
        return this.name + " " + this.generation + " " + (this.suffix!=null ? this.suffix + " " : "") + this.storage + "GB " + this.color;
    }
    public void setFullQualifiedName(String fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public void setSku() {
        this.sku = this.generation + (this.suffix!=null ? this.suffix : "") + "-" + this.storage + this.color.replaceAll(" ", "");
    }

    @Override
    public String toString() {
        return "Mobile [id=" + id + ", sku=" + sku + ", name=" + name + ", generation=" + generation + ", suffix="
                + suffix + ", storage=" + storage + ", color=" + color + ", mrp=" + mrp + ", fullQualifiedName="
                + fullQualifiedName + "]";
    }

}