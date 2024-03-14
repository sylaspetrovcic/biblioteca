package ada.tech.bibl.bibl.livro;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private LivroRepository repository;
    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public LivroRepository getRepository() {
        return repository;
    }

    public void setRepository(LivroRepository repository) {
        this.repository = repository;
    }
    public void salvarLivro(Livro livro) {
    }


    public void removerLivroPorId(Integer id) {
        this.repository.deleteById(id);
    }


}
