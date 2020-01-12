package be.intecbrussel.eddy.springeddy.start;

import be.intecbrussel.eddy.springeddy.start.guy.Guy;
import be.intecbrussel.eddy.springeddy.start.repository.GuyRepository;

import be.intecbrussel.eddy.springeddy.start.service.serviceimpl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/")

@RestController
public class Controller {

    @Autowired
    ServiceImpl service;

    //method om elke guy op te vragen uit de database

    @RequestMapping(value = "/showAll")
        public ResponseEntity<List<Guy>> getAllGuys(){

        List<Guy> guys = service.getAll();

        return new ResponseEntity<List<Guy>>(guys, HttpStatus.OK);


    }

    //Reguest naar de serverImpl methode getAge
    @RequestMapping(method = RequestMethod.GET,value = "/getAge/{age}")
    public ResponseEntity<List<Guy>> getAge(@PathVariable("age") int age){
        List<Guy> ages = service.getAge(age);



        return new ResponseEntity<List<Guy>>(ages, HttpStatus.OK);
    }
    // Request naar de serverImpl methode addGuy
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public ResponseEntity<Guy>addGuy(@RequestBody Guy guy){

        service.addGuy(guy);

        return new ResponseEntity<>(guy, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getGuyById/{id}")
    public ResponseEntity<Guy>getGuyById(@PathVariable int id){
        Guy guy = service.getById(id);

        return new ResponseEntity<>(guy,HttpStatus.OK);
    }


    //Request naar de serverImpl methode deleteById
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public ResponseEntity<Guy>deleteById(@PathVariable int id){

        service.deleteById(id);


        return new ResponseEntity<>(HttpStatus.GONE);
    }


    //Request naar de serverImpl methode om een hypotetische verzekering te krijgen op basis van de leeftijd. U kan zoeken op naam naar zijn of haar verzekering
    @RequestMapping(method = RequestMethod.GET,value="/getins/{name}")
    public ResponseEntity<Integer> getInsurance(@PathVariable String name){

        Integer insurance = service.getInsurance(name);


        return new ResponseEntity<>(insurance,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getGuyByName/{name}")
    public ResponseEntity<Guy>getGuyByName(@PathVariable String name){
        Guy guy = service.getGuyByName(name);

        return new ResponseEntity<>(guy,HttpStatus.OK);
    }



   /* @Autowired
    private GuyRepository guyRepository;


    @RequestMapping(value = "/hello")
    public String helloWorld(){
        return "Hello World";

    }

    @RequestMapping(value = "/add/{num1}/{num2}")
    public Integer giveAddNr(@PathVariable int num1, @PathVariable int num2){

        return num1 + num2;
    }

    @RequestMapping(value = "/showAll")
    public List<Guy> getGuy(){
        return guyRepository.findAll();



    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addGuy(@RequestBody Guy guy){

        guyRepository.save(guy);

    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public void deleteGuy(@PathVariable ("id") int id){

        guyRepository.deleteById(id);

    }


    @RequestMapping(method = RequestMethod.GET,value = "/getAge/{age}")
    public Guy searchAge(@PathVariable("age") int age){
       return guyRepository.findGuyByAge(age);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getName/{name}")
    public Guy searchByName(@PathVariable("name") String name){
        return guyRepository.findGuyByName(name);
    }*/




}
