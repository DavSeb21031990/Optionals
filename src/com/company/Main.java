package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //Main main = new Main();

        //main.optionalsEjemplo2();
        //main.optionalsEjemplo1();
        //main.optionalsEjemplo3();

        Person person = new Person("David", null);

        String email = person.getEmail().map(String::toUpperCase).orElse("email not provided");

        if(person.getEmail().isPresent()){
            email = person.getEmail().get();
        }else{
            email = "email not provided";
        }

        System.out.println(email);

    }

    public void optionalsEjemplo1(){

        Optional<Object> empty = Optional.empty();

        System.out.println(empty);
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

    }

    public void optionalsEjemplo2(){

        Optional<String> ejemplo1 = Optional.of("hello");

        System.out.println(ejemplo1.isPresent());
        System.out.println(ejemplo1.isEmpty());

        String orElse = ejemplo1.orElse("world");

        System.out.println(orElse);

    }

    public void optionalsEjemplo3(){

        Optional<String> hello = Optional.ofNullable("hello");

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello
                .map(String::toUpperCase)
                .orElse("world");

        String orElseGet = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    return "world";
                });

        String orElseThrow = hello
                .map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);

        hello.ifPresent(word -> {
            System.out.println(word);
        });

        hello.ifPresentOrElse(word -> {
            System.out.println(word);
        }, () -> {
            System.out.println("world");
        });

        System.out.println(orElse);
        System.out.println(orElseGet);
        System.out.println(orElseThrow);

    }

    static class Person{

        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

    }

}
