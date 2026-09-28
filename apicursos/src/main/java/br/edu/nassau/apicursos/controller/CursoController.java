package br.edu.nassau.apicursos.controller;

import br.edu.nassau.apicursos.model.Cursos;
import br.edu.nassau.apicursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cursos cadastrar(@RequestBody Cursos cursos) {
        return cursoService.cadastrar(cursos);
    }

    @GetMapping("/cursos")
    public List<Cursos> listar(){
        return this.cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {cursoService.remover(id); }

}
