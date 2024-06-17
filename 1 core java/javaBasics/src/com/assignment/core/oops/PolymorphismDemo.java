package com.assignment.core.oops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class AnimalPD {
	static Logger log = LogManager.getLogger(AnimalPD.class.getName());
	
    public void sound() {
        log.info("Animal makes a sound");
    }
    
    // Overloaded method
    public void sound(String sound) {
        log.info("Animal makes " + sound + " sound");
    }
    
    // Overloaded method
    public void sound(String sound, boolean isLoud) {
        if (isLoud)
            log.info("Animal makes loud " + sound + " sound");
        else 
            log.info("Animal makes soft " + sound + " sound");
    }
}

class DogPD extends AnimalPD {
	static Logger log = LogManager.getLogger(DogPD.class.getName());
	
    @Override
    public void sound() {
        log.info("Dog barks");
    }
}

class CatPD extends AnimalPD {
	static Logger log = LogManager.getLogger(CatPD.class.getName());
	
    @Override
    public void sound() {
        log.info("Cat meows");
    }
}

public class PolymorphismDemo {
	static Logger log = LogManager.getLogger(PolymorphismDemo.class.getName());
	
    public static void main(String[] args) {
        log.info("---------------------------------------------------------");
        log.info("----- Compile-time Polymorpism -----");
        AnimalPD animal;
        animal = new AnimalPD();
        animal.sound();
        animal.sound("bark");
        animal.sound("meow", false);
        
        log.info("\n");
        log.info("----- Runtime Polymorpism -----");
        AnimalPD dog, cat;
        dog = new DogPD();
        cat = new CatPD();
        animal.sound();
        dog.sound();
        cat.sound();
    }
}
