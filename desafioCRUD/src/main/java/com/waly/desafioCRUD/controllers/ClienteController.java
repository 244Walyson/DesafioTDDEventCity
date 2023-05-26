package com.waly.desafioCRUD.controllers;

import com.waly.desafioCRUD.dto.ClienteDto;
import com.waly.desafioCRUD.entities.Cliente;
import com.waly.desafioCRUD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id){
        ClienteDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> finAll(Pageable pageable){
        Page<ClienteDto> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ClienteDto insert(@RequestBody ClienteDto dto){
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping(value = "/{id}")
    public ClienteDto update(@RequestBody ClienteDto dto, @PathVariable Long id){
        dto = service.update(dto, id);
        return dto;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
