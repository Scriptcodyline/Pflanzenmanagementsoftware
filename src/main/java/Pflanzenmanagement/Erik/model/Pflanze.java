package Pflanzenmanagement.Erik.model;

import java.util.List;

import Pflanzenmanagement.Erik.event.AnbauEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pflanze {
    //////////////////////
    /// Attribute
    //////////////////////
    @Id
    @GeneratedValue
    private Long id;
    private String name; // z. B. "Getreide", "Rosenkohl"


    @OneToMany(mappedBy = "pflanze")
    private List<AnbauEvent> anbauevent;
    //////////////////////
    /// Konstruktor
    //////////////////////

    public Pflanze() {
    }
    

    public Pflanze(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //////////////////////
    /// Getter und setter
    //////////////////////
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //////////////////////
    /// toStringmethode
    //////////////////////

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
  
}