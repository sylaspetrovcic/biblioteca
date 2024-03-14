package ada.tech.bibl.bibl.livro;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/livro")
public class LivroController {
    private LivroService service;
    public LivroController(LivroService service){
        this.service = service;
    }
    @GetMapping
    public String salvarLivro(){
        return "Livro salvo";
    }
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro){
        service.salvarLivro(livro);
        return livro;
    }
    @GetMapping("/remover")
    public String removerLivroPorId (@PathVariable("livroId") Integer livroId) {
        this.service.removerLivroPorId (livroId);
        return "Livro removido";
    }
}
