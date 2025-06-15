package ua.opnu.practice1_template.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    public Facility() {}

    public Facility(Long id, String name, Boolean available, Workspace workspace) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.workspace = workspace;
    }

    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public Workspace getWorkspace() { return workspace; }
    public void setWorkspace(Workspace workspace) { this.workspace = workspace; }
}

