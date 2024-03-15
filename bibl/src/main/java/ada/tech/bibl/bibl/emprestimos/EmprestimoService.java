package ada.tech.bibl.bibl.emprestimos;

import ada.tech.bibl.bibl.livro.Livro;
import ada.tech.bibl.bibl.livro.LivroRepository;
import ada.tech.bibl.bibl.membros.Membro;
import ada.tech.bibl.bibl.membros.MembroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmprestimoService {
    private EmprestimoRepository repository;
    private MembroRepository membroRepository;
    private LivroRepository livroRepository;

    public EmprestimoRepository getRepository() {
        return repository;
    }

    public void setRepository(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public MembroRepository getMembroRepository() {
        return membroRepository;
    }

    public void setMembroRepository(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    public LivroRepository getLivroRepository() {
        return livroRepository;
    }

    public void setLivroRepository(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public EmprestimoService(EmprestimoRepository repository, MembroRepository membroRepository,
                             LivroRepository livroRepository){
        this.repository = repository;
        this.membroRepository = membroRepository;
        this.livroRepository = livroRepository;

    }



    public void salvarEmprestimo(Emprestimo emprestimo , Integer idMembro, Integer idLivro) {
        Membro membro = membroRepository.findById(idMembro).orElseThrow(EntityNotFoundException::new);
        emprestimo.setMembro(membro);
        Livro livro = livroRepository.findById(idLivro).orElseThrow(EntityNotFoundException::new);;
        emprestimo.setLivro(livro);
        repository.save(emprestimo);
    }


    public void devolucao(Emprestimo emprestimo, Integer idMembro,Integer idLivro){
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
