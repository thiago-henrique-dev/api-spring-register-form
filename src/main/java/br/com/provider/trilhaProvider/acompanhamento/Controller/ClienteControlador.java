package br.com.provider.trilhaProvider.acompanhamento.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.provider.trilhaProvider.acompanhamento.DTO.ClienteDto;
import br.com.provider.trilhaProvider.acompanhamento.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable("id") Long id) {

        try {
            ClienteDto cliente = clienteService.getClientId(id);
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<?> createClient(@Valid @RequestBody ClienteDto cliente, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                errors.append("Error no campo '").append(error.getField()).append("': ");
                errors.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errors.toString());
        } else {
            try {
                ClienteDto clientDto = clienteService.save(cliente);
                return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating client");
            }
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateGestorById(@Valid @RequestBody ClienteDto cliente, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                errors.append("Error no campo '").append(error.getField()).append("': ");
                errors.append(error.getDefaultMessage()).append("; ");
            }
            return ResponseEntity.badRequest().body(errors.toString());
        } else {
            try {
                ClienteDto updatedClientDto = clienteService.updateById(cliente, id);
                return ResponseEntity.ok(updatedClientDto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating client");
            }
        }
    }
    
     
    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<List<ClienteDto>> getAllGestor() {
        try {
            List<ClienteDto> cliente = clienteService.getClientAll();
            if (cliente.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cliente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        clienteService.deleteClient(id);
        return new ResponseEntity<>("Cliente excluido com sucesso", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<ClienteDto>> getNameClient(@PathVariable String name) {
        try {
            List<ClienteDto> clientes = clienteService.getByNameClient(name);
            return new ResponseEntity<>(clientes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
