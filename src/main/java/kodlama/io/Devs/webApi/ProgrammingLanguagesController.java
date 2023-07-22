package kodlama.io.Devs.webApi;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/languages")
public class ProgrammingLanguagesController {
    private final ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping(path = "{languageId}")
    public ProgrammingLanguage getLanguage(@PathVariable("languageId") int id){
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    public void addNewLanguage(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.add(programmingLanguage);
    }

    @PutMapping
    public void updateLanguage(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping(path = "{languageId}")
    public void deleteLanguage(@PathVariable("languageId") int id){
        programmingLanguageService.delete(id);
    }
}
