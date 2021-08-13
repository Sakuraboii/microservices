package employees.service.impl;

import employees.model.Policeman;
import employees.repository.PolicemanRepository;
import employees.service.PolicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicemanServiceImpl implements PolicemanService {

    PolicemanRepository policemanRepository;

    @Autowired
    public PolicemanServiceImpl(PolicemanRepository policemanRepository){
        this.policemanRepository = policemanRepository;
    }

    @Override
    public void save(Policeman policeman) {
        policemanRepository.save(policeman);
    }

    @Override
    public List<Policeman> getAll() {
        return (List<Policeman>) policemanRepository.findAll();
    }

    @Override
    public List<Policeman> getCorruptionPoliceman() {
        List<Policeman> policeman = (List<Policeman>) policemanRepository.findAll();
        return policeman.stream().filter(Policeman::getCorruption).collect(Collectors.toList());
    }

    @Override
    public Policeman getByName(String name) {
        return policemanRepository.findByName(name);
    }

    @Override
    public void delete(Policeman policeman) {
        policemanRepository.delete(policeman);
    }

    @Override
    public void update(Policeman policeman) {

    }
}
