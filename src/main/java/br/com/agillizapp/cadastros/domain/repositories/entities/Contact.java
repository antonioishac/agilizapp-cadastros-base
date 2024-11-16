package br.com.agillizapp.cadastros.domain.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_pessoa_contato")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Person person;

    @Column(name = "nome", length = 150)
    private String name;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "observacao", length = 250)
    private String observation;

}
