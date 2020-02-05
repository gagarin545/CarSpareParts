package ru.entity;

import javax.persistence.*;

@Entity
@Table(name ="client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_client", length = 6, nullable = false, columnDefinition = "serial")
    private long id_client;
    @Column(name="client_name", length = 150, nullable = false)
    private String client_name;
    @Column(name="lastname", length = 150)
    private String lastname;
    @Column(name = "password", length = 50)
    private String password;

    public ClientEntity() {}

    public long getId() {        return id_client;    }
    public void setId(long id_client) {        this.id_client = id_client;    }
    public String getClient_name() {        return client_name;    }
    public void setClient_name(String client_name) {        this.client_name = client_name;    }
    public String getLastname() {        return lastname;    }
    public void setLastname(String lastname) {        this.lastname = lastname;    }
    public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }
}
