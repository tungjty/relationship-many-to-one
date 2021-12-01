package com.example.demo;

import com.example.demo.model.Child;
import com.example.demo.model.Mom;
import com.example.demo.repository.ChildRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RelationshipManyToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationshipManyToOneApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ChildRepository childRepository) {
        return args -> {
            Mom mom_us = new Mom("Mommy US");
            Mom mom_vn = new Mom("Mommy VN");

            Child mariaChild = new Child("Maria Carey", mom_us);
            Child johnChild = new Child("Johny Deep", mom_us);
            List<Child> children_us = List.of(mariaChild, johnChild);

            Child huyChild = new Child("Mai Huy", mom_vn);
            Child tranChild = new Child("Khanh Tran", mom_vn);
            List<Child> children_vn = List.of(huyChild, tranChild);

            childRepository.saveAll(children_us);
            childRepository.saveAll(children_vn);
        };
    }

}
