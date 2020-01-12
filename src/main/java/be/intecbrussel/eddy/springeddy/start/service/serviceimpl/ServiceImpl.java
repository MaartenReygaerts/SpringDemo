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

//Get all Guy objects
    @Override
    public List<Guy> getAll() {
        return guyRepository.findAll();
    }

    //Constructor
    public ServiceImpl() {
        super();
    }


    //methode om een Guy opbject op te vragen op basis van de leeftijd
    @Override
    public List<Guy> getAge(int age)  throws GuyDoesNotExist {

       ageChecker(age);
                return guyRepository.findGuyByAge(age);

    }
    //methode addGuy. Voegt een Guy object toe aan de database
    @Override
    public void addGuy(Guy guy) {
        guyRepository.save(guy);

    }
    //method delete by id
    @Override
    public void deleteById(int id) {
        guyRepository.deleteById(id);
    }

    @Override
    public Guy getById(int id) {


     return guyRepository.findById(id).get();
    }

    // berekening om te kijken hoeveel je verzekering waard is op basis van je leeftijd. Enkel hoger of lager dan 30 is momenteel mogelijk.
    // Guy kan gevonden worden op basis van zijn naam.
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

    //Methode dat een guy zal weergeven op basis van de naam.
    @Override
    public Guy getGuyByName(String name) {

        return guyRepository.findGuyByName(name);
    }

    //Agechecker om te kijken of er een guy bestaat met de leeftijd die jij ingeeft. Zo niet, throw een GuyDoesNotExist Exception
    public void ageChecker(int age){

        List<Guy> guy = guyRepository.findAll();

        for (Guy guy1: guy) {
            if (guy1.getAge() == age) {

                break;
            }
            else{
                throw new GuyDoesNotExist();
            }

        }


    }

}
