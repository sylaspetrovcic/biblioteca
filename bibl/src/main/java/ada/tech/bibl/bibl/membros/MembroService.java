package ada.tech.bibl.bibl.membros;

import org.springframework.stereotype.Service;

@Service

public class MembroService {
    private MembroRepository repository;
    private MembroService(MembroRepository repository){
        this.repository = repository;
    }
    public void salvarMembros(Membro membro){
        repository.save(membro);
    }

    public void removerMembroPorId(Integer membroId) {
    }
}
