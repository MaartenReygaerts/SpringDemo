package be.intecbrussel.eddy.springeddy.start.service;

import be.intecbrussel.eddy.springeddy.exeptions.GuyDoesNotExist;
import be.intecbrussel.eddy.springeddy.start.guy.Guy;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceInterface {

    List<Guy> getAll();
    List<Guy> getAge(int age) throws GuyDoesNotExist;

    void addGuy(Guy guy);

    void deleteById(int id);

    Guy getById(int id);

    Integer getInsurance(String name);
}
