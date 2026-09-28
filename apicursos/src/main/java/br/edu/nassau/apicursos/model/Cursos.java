package br.edu.nassau.apicursos.model;

import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@Entity
@Table(name = "cursos")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    public Cursos(String nome, Integer cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Cursos() {

    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getCargaHoraria() {
        return this.cargaHoraria;
    }


    public void setId(Object o) {
    }

    public void setNome(String nome) {
    }

    public void setCargaHoraria(Integer cargaHoraria) {
    }

    public Object getDescricao() {
        return null;
    }

    public void setDescricao(Object descricao) {
    }

    public Optional<ResponseEntity<Object>> map(Object o) {
        return Optional.empty();
    }
}
