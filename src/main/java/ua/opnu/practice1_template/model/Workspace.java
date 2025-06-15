package ua.opnu.practice1_template.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer capacity;
    private String location;

    public Workspace() {}

    public Workspace(Long id, String name, Integer capacity, String location) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}

