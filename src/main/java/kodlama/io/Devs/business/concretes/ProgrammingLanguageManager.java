package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private final ProgrammingLanguageRepository repository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return repository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        ProgrammingLanguage entity = repository.getById(id);
        if (entity == null){
            throw new IllegalStateException("The programming language with id: " + id + " does not exist");
        }
        return entity;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        //Checking programming language name
        if (programmingLanguage.getName().isEmpty()){
            throw new IllegalStateException("Name is required");
        }
        //Checking repetition of the language name
        List<ProgrammingLanguage> programmingLanguages = repository.getAll();
        for (ProgrammingLanguage pl : programmingLanguages){
            if (pl.getName().equals(programmingLanguage.getName())){
                throw new IllegalStateException("The given language is already exist in db, please enter different language");
            }
        }
        repository.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        checkEntityExists(programmingLanguage.getId());
        repository.update(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        checkEntityExists(id);
        repository.delete(id);
    }

    private void checkEntityExists(int id){
        if (repository.getById(id) == null){
            throw new IllegalStateException("The programming language with id: " + id + " does not exist");
        }
    }
}
