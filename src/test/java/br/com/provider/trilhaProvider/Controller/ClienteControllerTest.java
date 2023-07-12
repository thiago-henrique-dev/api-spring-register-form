package br.com.provider.trilhaProvider.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.provider.trilhaProvider.acompanhamento.Controller.ClienteControlador;
import br.com.provider.trilhaProvider.acompanhamento.DTO.ClienteDto;
import br.com.provider.trilhaProvider.acompanhamento.service.ClienteService;

@WebMvcTest(ClienteControlador.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testCreateClientPost() throws Exception {
        long id = 1L;

        ClienteDto cliente = new ClienteDto();

        cliente.setId(id);
        cliente.setNameAdmin("Henrique Monteiro");
        cliente.setEmailAdmin("henriquedev@gmail.com");
        cliente.setName("Thiago");
        cliente.setPhone("(13) 997153672");
        cliente.setCpf("490.553.518-22");
        cliente.setGender("Masculino");
        cliente.setBirthdate("07-01-1997");
        cliente.setCep("11320-000");
        cliente.setStreet("Rua Jabuticaba");
        cliente.setNumber("882");
        cliente.setNeighborhood("Estancia");
        cliente.setCity("Peruibe");
        cliente.setState("SP");
        cliente.setComplement("14");

        when(clienteService.getClientId(id)).thenReturn(null);
        when(clienteService.save(any(ClienteDto.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testCreateClientPut() throws Exception {
        long id = 1L;

        ClienteDto cliente = new ClienteDto();

        cliente.setId(id);
        cliente.setNameAdmin("Thiago");
        cliente.setEmailAdmin("thiagohenriquedev@gmail.com");
        cliente.setName("Thiago");
        cliente.setPhone("(13) 997153672");
        cliente.setCpf("12345678901");
        cliente.setGender("Male");
        cliente.setBirthdate("06/04/2000");
        cliente.setCep("11320-000");
        cliente.setStreet("Rua dos A");
        cliente.setNumber("123");
        cliente.setNeighborhood("Estancia");
        cliente.setCity("Peruibe");
        cliente.setState("SP");
        cliente.setComplement("Mercado ME");

        when(clienteService.getClientId(id)).thenReturn(null);
        when(clienteService.save(any(ClienteDto.class))).thenReturn(cliente);

        mockMvc.perform(put("/clientes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreateClientGet() throws Exception {
        long id = 1L;

        ClienteDto cliente = new ClienteDto();
        cliente.setId(id);
        cliente.setNameAdmin("Thiago");
        cliente.setEmailAdmin("thiagohenriquedev@gmail.com");
        cliente.setName("Thiago");
        cliente.setPhone("(13) 997153672");
        cliente.setCpf("490.553.51-822");
        cliente.setGender("Masculino");
        cliente.setBirthdate("06/04/2000");
        cliente.setCep("11320-000");
        cliente.setStreet("Rua A");
        cliente.setNumber("123");
        cliente.setNeighborhood("Estancia");
        cliente.setCity("Peruibe");
        cliente.setState("SP");
        cliente.setComplement("Mercado ME");

        when(clienteService.getClientId(id)).thenReturn(cliente);

        mockMvc.perform(get("/clientes/{id}", id))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.nameAdmin").value(cliente.getNameAdmin()))
        .andExpect(jsonPath("$.emailAdmin").value(cliente.getEmailAdmin()))
        .andExpect(jsonPath("$.name").value(cliente.getName()))
        .andExpect(jsonPath("$.phone").value(cliente.getPhone()))
        .andExpect(jsonPath("$.cpf").value(cliente.getCpf()))
        .andExpect(jsonPath("$.gender").value(cliente.getGender()))
        .andExpect(jsonPath("$.birthdate").value(cliente.getBirthdate()))
        .andExpect(jsonPath("$.cep").value(cliente.getCep()))
        .andExpect(jsonPath("$.street").value(cliente.getStreet()))
        .andExpect(jsonPath("$.number").value(cliente.getNumber()))
        .andExpect(jsonPath("$.neighborhood").value(cliente.getNeighborhood()))
        .andExpect(jsonPath("$.city").value(cliente.getCity()))
        .andExpect(jsonPath("$.state").value(cliente.getState()))
        .andExpect(jsonPath("$.complement").value(cliente.getComplement()))

        .andDo(print());

    }

    /**
     * @throws Exception
     */
    @Test
    public void testCreateClientGetAll() throws Exception {
        List<ClienteDto> clientes = new ArrayList<>();

        ClienteDto cliente1 = new ClienteDto();
        cliente1.setId(1L);
        cliente1.setNameAdmin("Thiago");
        cliente1.setEmailAdmin("thiagohenriquedev1@gmail.com");
        cliente1.setName("Henrique Monteiro");
        cliente1.setPhone("(13) 997153672");
        cliente1.setCpf("490.553.518-822");
        cliente1.setGender("Masculino");
        cliente1.setBirthdate("05/04/2000");
        cliente1.setCep("11320-000");
        cliente1.setStreet("Rua Esmeralda");
        cliente1.setNumber("142");
        cliente1.setNeighborhood("Estancia");
        cliente1.setCity("Peruibe");
        cliente1.setState("SP");
        cliente1.setComplement("ME");


        ClienteDto cliente2 = new ClienteDto();
        cliente2.setId(2L);
        cliente2.setNameAdmin("Thiago");
        cliente2.setEmailAdmin("thiagohenriquedev2@gmail.com");
        cliente2.setName("Henrique");
        cliente2.setPhone("(13) 997153672)");
        cliente2.setCpf("490.553.51-822");
        cliente2.setGender("Masculino");
        cliente2.setBirthdate("06/04/2000");
        cliente2.setCep("11320-000");
        cliente2.setNumber("456");
        cliente2.setNeighborhood("Estancia dos Eucaliptos");
        cliente2.setCity("Peruíbe");
        cliente2.setState("SP");
        cliente2.setComplement("Mercado Me");


        clientes.add(cliente1);
        clientes.add(cliente2);

        when(clienteService.getClientAll()).thenReturn(clientes);

        mockMvc.perform(get("/clientes/list"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(cliente1.getId()))
        .andExpect(jsonPath("$[0].nameAdmin").value(cliente1.getNameAdmin()))
        .andExpect(jsonPath("$[0].emailAdmin").value(cliente1.getEmailAdmin()))
        .andExpect(jsonPath("$[0].name").value(cliente1.getName()))
        .andExpect(jsonPath("$[0].phone").value(cliente1.getPhone()))
        .andExpect(jsonPath("$[0].cpf").value(cliente1.getCpf()))
        .andExpect(jsonPath("$[0].gender").value(cliente1.getGender()))
        .andExpect(jsonPath("$[0].birthdate").value(cliente1.getBirthdate()))
        .andExpect(jsonPath("$[0].cep").value(cliente1.getCep()))
        .andExpect(jsonPath("$[0].street").value(cliente1.getStreet()))
        .andExpect(jsonPath("$[0].number").value(cliente1.getNumber()))
        .andExpect(jsonPath("$[0].neighborhood").value(cliente1.getNeighborhood()))
        .andExpect(jsonPath("$[0].city").value(cliente1.getCity()))
        .andExpect(jsonPath("$[0].state").value(cliente1.getState()))
        .andExpect(jsonPath("$[0].complement").value(cliente1.getComplement()))

        .andExpect(jsonPath("$[1].id").value(cliente2.getId()))
        .andExpect(jsonPath("$[1].nameAdmin").value(cliente2.getNameAdmin()))
        .andExpect(jsonPath("$[1].emailAdmin").value(cliente2.getEmailAdmin()))
        .andExpect(jsonPath("$[1].name").value(cliente2.getName()))
        .andExpect(jsonPath("$[1].phone").value(cliente2.getPhone()))
        .andExpect(jsonPath("$[1].cpf").value(cliente2.getCpf()))
        .andExpect(jsonPath("$[1].gender").value(cliente2.getGender()))
        .andExpect(jsonPath("$[1].birthdate").value(cliente2.getBirthdate()))
        .andExpect(jsonPath("$[1].cep").value(cliente2.getCep()))
        .andExpect(jsonPath("$[1].street").value(cliente2.getStreet()))
        .andExpect(jsonPath("$[1].number").value(cliente2.getNumber()))
        .andExpect(jsonPath("$[1].neighborhood").value(cliente2.getNeighborhood()))
        .andExpect(jsonPath("$[1].city").value(cliente2.getCity()))
        .andExpect(jsonPath("$[1].state").value(cliente2.getState()))        
        .andExpect(jsonPath("$[1].complement").value(cliente2.getComplement()))
        .andDo(print());

    }
}



       
