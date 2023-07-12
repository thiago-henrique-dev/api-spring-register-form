package br.com.provider.trilhaProvider.acompanhamento.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDto {

    private long id;

    private String nameAdmin;

    private String emailAdmin;

    @NotBlank(message = "O campo 'name' é obrigatório.")
    private String name;

    @NotBlank(message = "O campo 'phone' é obrigatório.")
    private String phone;

    @NotBlank(message = "O campo 'cpf' é obrigatório.")
    private String cpf;

    @NotBlank(message = "O campo 'gender' é obrigatório.")
    private String gender;

    private String otherGender;

    @NotBlank(message = "O campo 'birthdate' é obrigatório.")
    private String birthdate;

    @NotBlank(message = "O campo 'cep' é obrigatório.")
    private String cep;

    @NotBlank(message = "O campo 'street' é obrigatório.")
    private String street;

    @NotBlank(message = "O campo 'number' é obrigatório.")
    private String number;

    @NotBlank(message = "O campo 'neighborhood' é obrigatório.")
    private String neighborhood;

    @NotBlank(message = "O campo 'city' é obrigatório.")
    private String city;

    @NotBlank(message = "O campo 'state' é obrigatório.")
    private String state;

    private String complement;

    // Adicione outras validações de acordo com a necessidade, como @Size, @Email, etc.
}
