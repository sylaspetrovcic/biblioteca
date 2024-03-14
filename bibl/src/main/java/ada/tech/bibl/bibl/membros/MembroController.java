package ada.tech.bibl.bibl.membros;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membro")
public class MembroController {
    private MembroService service;

    public MembroController(MembroService service) {
        this.service = service;
    }
    @GetMapping
    public Membro criarMembros(@RequestBody Membro membro){
        service.salvarMembros(membro);
        return membro;
    }
    @GetMapping("/remover")
    public String removerLivroPorId (@PathVariable("livroId") Integer membroId) {
        this.service.removerMembroPorId (membroId);
        return "Livro removido";
    }

}
