package employees.service;

import employees.model.Policeman;

import java.util.List;

public interface PolicemanService {
    void save(Policeman policeman);
    List<Policeman> getAll();
    List<Policeman> getCorruptionPoliceman();
    Policeman getByName(String name);
    void delete(Policeman policeman);
    void update(Policeman policeman);
}
