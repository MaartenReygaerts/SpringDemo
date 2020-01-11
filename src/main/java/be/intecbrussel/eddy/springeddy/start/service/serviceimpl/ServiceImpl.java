package be.intecbrussel.eddy.springeddy.start.service.serviceimpl;

import be.intecbrussel.eddy.springeddy.start.guy.Guy;
import be.intecbrussel.eddy.springeddy.start.repository.GuyRepository;
import be.intecbrussel.eddy.springeddy.start.service.ServiceInterface;
import be.intecbrussel.eddy.springeddy.exeptions.GuyDoesNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    GuyRepository guyRepository;


    @Override
    public List<Guy> getAll() {
        return guyRepository.findAll();
    }

    public ServiceImpl() {
        super();
    }

    @Override
    public List<Guy> getAge(int age) throws GuyDoesNotExist {

        ageChecker(age);
                return guyRepository.findGuyByAge(age);

    }

    @Override
    public void addGuy(Guy guy) {
        guyRepository.save(guy);

    }

    @Override
    public void deleteById(int id) {
        guyRepository.deleteById(id);
    }

    @Override
    public Guy getById(int id) {


     return guyRepository.findById(id).get();
    }

    @Override
    public Integer getInsurance(String name) {

        Guy guy = guyRepository.findGuyByName(name);

        if (guy.getAge() > 30){
            return 1000;
        }
        else{
            return 2000;
        }

    }

    public void ageChecker(int age){


        List<Guy> guy = guyRepository.findAll();
        for (Guy guy1: guy){
            if (guy1.getAge() != age){
                throw new GuyDoesNotExist();

            }

    }


}}
