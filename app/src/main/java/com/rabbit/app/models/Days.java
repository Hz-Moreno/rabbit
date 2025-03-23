package com.rabbit.app.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days")
public class Days {
    @Id
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "days", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

}
