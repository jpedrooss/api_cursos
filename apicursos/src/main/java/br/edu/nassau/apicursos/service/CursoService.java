package br.edu.nassau.apicursos.service;

import br.edu.nassau.apicursos.model.Cursos;
import br.edu.nassau.apicursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public List<Cursos> listarTodos() {
        return this.cursoRepository.findAll();
    }

    public Cursos buscarPorId(long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new Error("Curso not found"));
    }

    public Cursos criar(Cursos curso) {
        validar(curso);
        curso.setId(null);
        return cursoRepository.save(curso);
    }

    public Cursos atualizar(Long id, Cursos cursoAtualizado) {
        Cursos cursoExistente = buscarPorId(id);
        validar(cursoAtualizado);

        cursoExistente.setNome(cursoAtualizado.getNome());
        cursoExistente.setCargaHoraria(cursoAtualizado.getCargaHoraria());
        cursoExistente.setDescricao(cursoAtualizado.getDescricao());

        return cursoRepository.save(cursoExistente);
    }

    public void remover(Long id) {
        Cursos curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }

    private void validar(Cursos curso) {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do curso não pode ser nulo ou vazio");
        }
        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero");
        }
    }

    public Cursos cadastrar(Cursos cursos) {
        return cursos;
    }
}

