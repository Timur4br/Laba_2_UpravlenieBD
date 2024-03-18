package org.example.entity;
import javax.persistence.*;
@Entity
@Table(name = "Clients")
@NamedQuery(name = "Clients.getAll", query = "SELECT c from Clients c")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "surname", length = 255)
    private String surname;
    @Column(name = "name", length = 255)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_master")
    private Masters id_master;
    @Column(name = "isDelete")
    private Boolean isDelete;
    public Clients(Integer id, String surname, String name, Masters id_master, Boolean isDelete) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.id_master = id_master;
        this.isDelete = isDelete;
    }
    public  Clients(){}

    public int getId() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Masters getIdMasters() {
        return id_master;
    }

    public void setIdMasters(Masters id_masters) {
        this.id_master = id_masters;
    }

    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean deleted) {
        isDelete = deleted;
    }

}
