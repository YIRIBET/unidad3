package mx.edu.utez.unidad3.modules.warehouse;

import jakarta.persistence.*;
import mx.edu.utez.unidad3.modules.cede.Cede;
import mx.edu.utez.unidad3.modules.client.Client;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "clave",nullable = false)
    private String name;


    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "sell_price",nullable = false)
    private String sell_price;

    @Column(name = "rent_price",nullable = false)
    private String rent_price;

    @ManyToOne
    @JoinColumn(name = "id_cede",nullable = false)
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Warehouse() {
    }

    public Warehouse(int id, String name, String status, String sell_price, String rent_price, Cede cede, Client client) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.sell_price = sell_price;
        this.rent_price = rent_price;
        this.cede = cede;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSell_price() {
        return sell_price;
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getRent_price() {
        return rent_price;
    }

    public void setRent_price(String rent_price) {
        this.rent_price = rent_price;
    }

    public Cede getCede() {
        return cede;
    }

    public void setCede(Cede cede) {
        this.cede = cede;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
