package kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(int id);
    void add(ProgrammingLanguage programmingLanguage);
    void update(ProgrammingLanguage programmingLanguage);
    void delete(int id);
}
