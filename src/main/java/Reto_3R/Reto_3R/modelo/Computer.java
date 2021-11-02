/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto_3R.Reto_3R.modelo;

/**
 *
 * @author Andrea Guarnizo
 */


/**los Import correpondientes de cada libreria*/
import Reto_3R.Reto_3R.modelo.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**Import para el Id*/
import javax.persistence.Id;
/**Import JoinColumn*/
import javax.persistence.JoinColumn;
/**Import de Muchos a uno*/
import javax.persistence.ManyToOne;
/**Import de Uno a muchos*/
import javax.persistence.OneToMany;
/**Import de tabla*/
import javax.persistence.Table;
/**Entidad*/
@Entity
@Table(name = "computer")
/**Clase*/
public class Computer implements Serializable{
    
    /** metodos private*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    /**De muchos a uno*/
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("computers")
    private Categoria category;
    /**De uno a Muchos*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Mensaje> messages;
    /**De uno a Muchos*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "client"})
    private List<Reservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
    
    
    
    
    
    
}
