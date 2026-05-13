package org.example.gamestore.controller;

import jakarta.validation.Valid;
import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.service.DesenvolvedoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desenvolvedoras")
public class DesenvolvedoraController {

    private final DesenvolvedoraService service;

    public DesenvolvedoraController (DesenvolvedoraService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public DesenvolvedoraResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<DesenvolvedoraResponseDTO> listar(){
        return service.listar();
    }

    @PutMapping("/{id}")
    public DesenvolvedoraResponseDTO atualizar(@RequestBody DesenvolvedoraRequestDTO dto, @PathVariable Long id){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(Long id){
        service.deletar(id);
    }

    @PostMapping
    public DesenvolvedoraResponseDTO salvar(@RequestBody @Valid DesenvolvedoraRequestDTO dto){
        return service.salvar(dto);
    }


}
