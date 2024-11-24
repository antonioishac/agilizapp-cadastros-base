package br.com.agillizapp.cadastros.domain.repositories.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_endereco")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Person person;

    @Column(name = "logradouro")
    private String publicPlace;

    @Column(name = "numero")
    private String streetNumber;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "municipio_ibge")
    private String municipalityIbge;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String city;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "principal")
    private String principal;

    @Column(name = "entrega")
    private String deliveryAddress;

    @Column(name = "cobranca")
    private String billingAddress;

    @Column(name = "correspondecia")
    private String mailingAddress;

}
