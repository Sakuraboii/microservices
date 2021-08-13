package employees.repository;

import employees.model.Policeman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PolicemanRepository extends CrudRepository<Policeman,Long> {
    Policeman findByName(String name);
}
