package ada.tech.bibl.bibl.emprestimos;

import ada.tech.bibl.bibl.livro.Livro;
import ada.tech.bibl.bibl.membros.Membro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private EmprestimoService service;
    public EmprestimoController(EmprestimoService service){
        this.service = service;

    }
    @GetMapping("/all")
    public List<Emprestimo> recuperarEmprestimo(){
        return service.getAll();
    }

    @GetMapping
    public String salvarEmprestimo() {
        return "Emprestimo efetuado";
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo, Membro membro, Livro livro){

        service.salvarEmprestimo(emprestimo, membro.getId(), livro.getId());
        return emprestimo;

    }
}
