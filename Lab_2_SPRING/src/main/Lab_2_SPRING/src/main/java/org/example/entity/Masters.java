package org.example.entity;
import javax.persistence.*;
@Entity
@Table(name = "Masters")
@NamedQuery(name = "Masters.getAll", query = "SELECT s from Masters s")
public class Masters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "surname", length = 255)
    private String surname;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name="isDelete")
    private boolean isDelete;
    public Masters(Integer id, String surname, String name, Boolean isDelete) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.isDelete = isDelete;
    }
    public Masters() {}
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

    public boolean isDelete() {
        return isDelete;
    }
    public void setDelete(boolean deleted) {
        isDelete = deleted;
    }
}