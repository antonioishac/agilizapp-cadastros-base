package br.com.agillizapp.cadastros.domain.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_agencia_banco")
public class AgencyBankEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_banco")
    private BankEntity bank;

    @Column(name = "codigo", length = 10)
    private Integer code;

    @Column(name = "nome", length = 100)
    private String name;

    @Column(name = "logradouro", length = 100)
    private String publicPlace;

    @Column(name = "numero", length = 10)
    private String number;

    @Column(name = "cep", length = 8)
    private String zipCode;

    @Column(name = "municipio_ibge", length = 10)
    private String County;

    @Column(name = "uf", length = 2)
    private String state;

    @Column(name = "telefone", length = 10)
    private String phoneNumber;

    @Column(name = "gerente", length = 30)
    private String manager;

    @Column(name = "contato", length = 30)
    private String contact;

    @Column(name = "obs")
    private String observation;
}
