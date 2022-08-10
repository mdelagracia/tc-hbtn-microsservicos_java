package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api-jpa-h2/h2-console/")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/addClient")
    public Cliente addClient(@RequestBody Cliente cliente) {
        //return clienteRepository.saveAndFlush(cliente);
        return clienteRepository.save(cliente);
    }

    @GetMapping("/findAllClients")
    public List<Cliente> findAllClients() {
        return clienteRepository.findAll();
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return clienteRepository.findById(idClient)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
         clienteRepository.findById(idClient)
                .map(record ->{
                    clienteRepository.deleteById(idClient);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
         clienteRepository.findById(id)
                .map(record ->{
                    record.setIdade(cliente.getIdade());
                    record.setEmail(cliente.getEmail());
                    record.setNome(cliente.getNome());
                    Cliente updated = clienteRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}