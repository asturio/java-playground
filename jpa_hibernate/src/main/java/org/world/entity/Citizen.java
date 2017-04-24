package org.world.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "citizen")
public class Citizen implements java.io.Serializable {

    @Id
    @Column(insertable = true, unique = true, length = 225, updatable = true)
    private Integer citizen_id;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column
    private String name;
    @Column
    private String address;

    public Citizen() {
    }

    public Integer getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(Integer citizen_id) {
        this.citizen_id = citizen_id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

