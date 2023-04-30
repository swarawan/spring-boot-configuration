package com.swarawan.config;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ConfigAnnotationTest {

    @Value(value = "${spring.application.name:Contoh Env}")
    String applicationName;

    @Value(value = "#{${students}}")
    Map<String,String> students;

    @Value(value = "#{${students}.student1}")
    String student1;

    @Value(value = "#{${students}['student2']}")
    String student2;

    @Value(value = "#{${students}.student3}")
    String student3;

    @Value(value = "#{${students}['student4'] ?: 'default value student4'}")
    String student4;

    @Value(value = "${brandMobil}")
    List<String> carBrands;
    @Value(value = "#{'${brandMobilSemicolon}'.split(';')}")
    List<String> carBrandsSemicolon;

    @Test
    public void getApplicationName() {
        Assertions.assertEquals(applicationName, "Kodok Ngorek");
    }

    @Test
    public void getAllStudentsUsingMap() {
        Assertions.assertNotNull(students);

        Assertions.assertEquals(students.size(), 3);
        Assertions.assertEquals(students.get("student1"), "John Doe");
        Assertions.assertEquals(students.get("student2"), "Jane Doe");
        Assertions.assertEquals(students.get("student3"), "Fulan Bin Fulan");
    }

    @Test
    public void getAllStudents() {
        Assertions.assertNotNull(student1);
        Assertions.assertNotNull(student2);
        Assertions.assertNotNull(student3);
        Assertions.assertNotNull(student4);

        Assertions.assertEquals(student1, "John Doe");
        Assertions.assertEquals(student2, "Jane Doe");
        Assertions.assertEquals(student3, "Fulan Bin Fulan");
        Assertions.assertEquals(student4, "default value student4");
    }

    @Test
    public void getAllBrands(){
        Assertions.assertNotNull(carBrands);

        Assertions.assertEquals(carBrands.get(0), "Honda");
        Assertions.assertEquals(carBrands.get(1), "Toyota");
        Assertions.assertEquals(carBrands.get(2), "Daihatsu");
        Assertions.assertEquals(carBrands.get(3), "Subaru");
    }

    @Test
    public void getAllBrandsSemicolon(){
        Assertions.assertNotNull(carBrandsSemicolon);

        Assertions.assertEquals(carBrandsSemicolon.get(0), "Honda");
        Assertions.assertEquals(carBrandsSemicolon.get(1), "Toyota");
        Assertions.assertEquals(carBrandsSemicolon.get(2), "Daihatsu");
        Assertions.assertEquals(carBrandsSemicolon.get(3), "Subaru");
    }

}
