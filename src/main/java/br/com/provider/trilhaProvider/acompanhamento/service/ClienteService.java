package br.com.provider.trilhaProvider.acompanhamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provider.trilhaProvider.acompanhamento.DTO.ClienteDto;
import br.com.provider.trilhaProvider.acompanhamento.Models.Cliente;
import br.com.provider.trilhaProvider.acompanhamento.Repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteDto getClientId(Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            return convertClienteDTO(optional.get());
        }
        return null;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto save(ClienteDto clienteDto) {
        Cliente cliente = convertCliente(clienteDto);
        return convertClienteDTO(clienteRepository.save(cliente));
    }

    public List<ClienteDto> getClientAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return convertListToDto(clientes);
    }

    private Cliente convertCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNameAdmin(clienteDto.getNameAdmin());
        cliente.setEmailAdmin(clienteDto.getEmailAdmin());
        cliente.setName(clienteDto.getName());
        cliente.setPhone(clienteDto.getPhone());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setGender(clienteDto.getGender());
        cliente.setOtherGender(clienteDto.getOtherGender());
        cliente.setBirthdate(clienteDto.getBirthdate());
        cliente.setCep(clienteDto.getCep());
        cliente.setStreet(clienteDto.getStreet());
        cliente.setNumber(clienteDto.getNumber());
        cliente.setNeighborhood(clienteDto.getNeighborhood());
        cliente.setCity(clienteDto.getCity());
        cliente.setState(clienteDto.getState());
        cliente.setComplement(clienteDto.getComplement());
        return cliente;
    }

    private ClienteDto convertClienteDTO(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNameAdmin(cliente.getNameAdmin());
        clienteDto.setEmailAdmin(cliente.getEmailAdmin());
        clienteDto.setName(cliente.getName());
        clienteDto.setPhone(cliente.getPhone());
        clienteDto.setCpf(cliente.getCpf());
        clienteDto.setGender(cliente.getGender());
        clienteDto.setOtherGender(cliente.getOtherGender());
        clienteDto.setBirthdate(cliente.getBirthdate());;
        clienteDto.setCep(cliente.getCep());
        clienteDto.setStreet(cliente.getStreet());
        clienteDto.setNumber(cliente.getNumber());
        clienteDto.setNeighborhood(cliente.getNeighborhood());
        clienteDto.setCity(cliente.getCity());
        clienteDto.setState(cliente.getState());
        clienteDto.setComplement(cliente.getComplement());
        return clienteDto;
    }

    private List<ClienteDto> convertListToDto(List<Cliente> contatos) {
        return contatos.stream().map(this::convertClienteDTO).collect(Collectors.toList());
    }

    public ClienteDto updateById(ClienteDto clienteDto, Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = optional.get();
            if (clienteDto.getName() != null) {
                cliente.setName(clienteDto.getName());
            }
            if (clienteDto.getPhone() != null) {
                cliente.setPhone(clienteDto.getPhone());
            }
            if (clienteDto.getCpf() != null) {
                cliente.setCpf(clienteDto.getCpf());
            }
            if (clienteDto.getGender() != null) {
                cliente.setGender(clienteDto.getGender());
            }
            if (clienteDto.getOtherGender() != null) {
                cliente.setOtherGender(clienteDto.getOtherGender());
            }
            if (clienteDto.getBirthdate() != null) {
                cliente.setBirthdate(clienteDto.getBirthdate());
            }
            if (clienteDto.getCep() != null) {
                cliente.setCep(clienteDto.getCep());
            }
            if (clienteDto.getStreet() != null) {
                cliente.setStreet(clienteDto.getStreet());
            }
            if (clienteDto.getNumber() != null) {
                cliente.setNumber(clienteDto.getNumber());
            }
            if (clienteDto.getNeighborhood() != null) {
                cliente.setNeighborhood(clienteDto.getNeighborhood());
            }
            if (clienteDto.getCity() != null) {
                cliente.setCity(clienteDto.getCity());
            }
            if (clienteDto.getState() != null) {
                cliente.setState(clienteDto.getState());
            }
            if (clienteDto.getComplement() != null) {
                cliente.setComplement(clienteDto.getComplement());
            }

            clienteRepository.save(cliente);
            return convertClienteDTO(cliente);
        }
        return null;
    }

    public void deleteClient(Long id){
        clienteRepository.deleteById(id);
    }

    public List<ClienteDto> getByNameClient(String name) throws Exception {
        List<ClienteDto> clientes = convertListToDto(clienteRepository.findByName(name));
        if (clientes.size() == 0) {
            throw new Exception("Nome do cliente não encontrado.");
        }
        return clientes;
    }
}

