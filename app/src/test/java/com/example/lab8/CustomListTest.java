package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test to check if a city exists in the list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);

        // Check if hasCity returns true after adding the city
        Assertions.assertTrue(list.hasCity(city));

        // Check if hasCity returns false for a city not in the list
        City anotherCity = new City("Regina", "SK");
        Assertions.assertFalse(list.hasCity(anotherCity));
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        // Check if hasCity returns true after adding the city
        Assertions.assertTrue(list.hasCity(city));

        list.deleteCity(city);

        Assertions.assertFalse(list.hasCity(city));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City city1 = new City ("Edmonton", "AB");   // 1
        City city2 = new City ("Calgary", "AB");    // 2
        City city3 = new City ("Lethbridge", "AB"); // 3

        Assertions.assertEquals(3, list.counCities());

        list.deleteCity(city3);
        list.deleteCity(city2);

        Assertions.assertEquals(1, list.counCities());
    }


}
