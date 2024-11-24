package br.com.agillizapp.cadastros.domain.repositories.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 150)
    private String name;

    @Column(name = "tipo", length = 1)
    private String personType;

    @Column(name = "site", length = 250)
    private String site;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "cliente", length = 1)
    private String client;

    @Column(name = "fornecedor", length = 1)
    private String supplier;

    @Column(name = "transportadora", length = 1)
    private String shippingCompany;

    @Column(name = "colaborador", length = 1)
    private String collaborator;

    @Column(name = "contador", length = 1)
    private String accountant;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses;

}
