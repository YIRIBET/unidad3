package mx.edu.utez.unidad3.modules.cede;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import mx.edu.utez.unidad3.modules.warehouse.Warehouse;

import java.util.List;

/*
* 01crear los atributos propios de la entidad
* 2crear los attributos de relacion
* crear contructores
* crear getters y setters
* */
@Entity
@Table(name = "cede")
public class Cede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "clave",nullable = false)
    private String clave;

    @Column(name = "state",nullable = false)
    private String state;

    @Column(name = "city",nullable = false)
    private String city;

    @OneToMany(mappedBy = "cede")
    @JsonIgnore
    private List<Warehouse> warehouses;

    public Cede() {
    }

    public Cede(int id, String clave, String state, String city, List<Warehouse> warehouses) {
        this.id = id;
        this.clave = clave;
        this.state = state;
        this.city = city;
        this.warehouses = warehouses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
