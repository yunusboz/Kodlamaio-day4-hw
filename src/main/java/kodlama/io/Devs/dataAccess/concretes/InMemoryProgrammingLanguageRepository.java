package kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    private final List<ProgrammingLanguage> programmingLanguagesList;

    @Autowired
    public InMemoryProgrammingLanguageRepository() {
        programmingLanguagesList = new ArrayList<ProgrammingLanguage>();
        programmingLanguagesList.add(new ProgrammingLanguage(1,"C#"));
        programmingLanguagesList.add(new ProgrammingLanguage(2,"Java"));
        programmingLanguagesList.add(new ProgrammingLanguage(3,"Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguagesList;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguagesList.get(id - 1);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesList.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesList.set((programmingLanguage.getId()-1),programmingLanguage);
    }

    @Override
    public void delete(int id) {
        programmingLanguagesList.remove(id - 1);
    }
}
