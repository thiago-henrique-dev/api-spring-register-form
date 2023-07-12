package br.com.provider.trilhaProvider.acompanhamento.Models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private long id;

    @Column(name = "nameAdmin")
    private String nameAdmin;

    @Column(name = "emailAdmin")
    private String emailAdmin;

    @NotNull(message = "O campo 'name' é obrigatório.")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "O campo 'phone' é obrigatório.")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull(message = "O campo 'cpf' é obrigatório.")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotNull(message = "O campo 'gender' é obrigatório.")
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "otherGender")
    private String otherGender;

    @NotNull(message = "O campo 'birthdate' é obrigatório.")
    @Column(name = "birthdate", nullable = false)
    private String birthdate;

    @NotNull(message = "O campo 'cep' é obrigatório.")
    @Column(name = "cep", nullable = false)
    private String cep;

    @NotNull(message = "O campo 'street' é obrigatório.")
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull(message = "O campo 'number' é obrigatório.")
    @Column(name = "number", nullable = false)
    private String number;

    @NotNull(message = "O campo 'neighborhood' é obrigatório.")
    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @NotNull(message = "O campo 'city' é obrigatório.")
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull(message = "O campo 'state' é obrigatório.")
    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "complement")
    private String complement;

}
