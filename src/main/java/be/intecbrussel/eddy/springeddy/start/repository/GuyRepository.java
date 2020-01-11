package be.intecbrussel.eddy.springeddy.start.repository;

import be.intecbrussel.eddy.springeddy.start.guy.Guy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuyRepository extends JpaRepository<Guy,Integer> {

    List<Guy> findGuyByAge(int age);
    Guy findGuyByName(String name);


}
