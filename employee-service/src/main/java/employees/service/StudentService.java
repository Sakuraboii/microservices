package employees.service;

import employees.model.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> getAll();
    void delete(Student student);
    void update(Student student);
}
