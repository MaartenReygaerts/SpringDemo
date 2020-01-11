package be.intecbrussel.eddy.springeddy.exeptions;

public class GuyDoesNotExist extends RuntimeException {


    public GuyDoesNotExist(){

        super("Guy does not exist!");
    }

}
