package ada.tech.bibl.bibl.emprestimos;

import ada.tech.bibl.bibl.livro.Livro;
import ada.tech.bibl.bibl.livro.LivroRepository;
import ada.tech.bibl.bibl.membros.Membro;
import ada.tech.bibl.bibl.membros.MembroRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository repository;
    private MembroRepository membroRepository;
    private LivroRepository livroRepository;
    public EmprestimoService(EmprestimoRepository repository,MembroRepository membroRepository,
                             LivroRepository livroRepository){
        this.repository = repository;
        this.membroRepository = membroRepository;
        this.livroRepository = livroRepository;
    }

    public void salvarEmprestimo(Emprestimo emprestimo ,Integer idMembro,Integer idLivro) {
        Membro membro = membroRepository.findById(idMembro).orElseThrow(EntityNotFoundException::new);
        emprestimo.setMembro(membro);
        Livro livro = livroRepository.findById(idLivro).orElseThrow(EntityNotFoundException::new);;
        emprestimo.setLivro(livro);
        repository.save(emprestimo);
    }


    public void devulucao(Emprestimo emprestimo, Integer idMembro,Integer idLivro){
        Membro membro = membroRepository.findById(idMembro).orElseThrow(EntityNotFoundException::new);
        emprestimo.setMembro(membro);
        Livro livro = livroRepository.findById(idLivro).orElseThrow(EntityNotFoundException::new);;
        emprestimo.setLivro(livro);
        repository.deleteById(idLivro);
        emprestimo.isDevolvido();
    }
    public List<Emprestimo> getAll(){
    return (List<Emprestimo>) repository.findAll();
    }

        }
