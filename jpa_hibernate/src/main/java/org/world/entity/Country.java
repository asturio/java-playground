package org.world.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Country implements java.io.Serializable {

    @Column
    String name;
    @Column
    String currency;
    @Id
    @Column(name = "country_id")
    private Integer country_id;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "country", targetEntity = Citizen.class)
    private Set citizen;

    public Country() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Set getCitizen() {
        return citizen;
    }

    public void setCitizen(Set citizen) {
        this.citizen = citizen;
    }
}