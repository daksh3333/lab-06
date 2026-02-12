package com.example.ListyCity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */

public class CityList {
    private List<com.example.ListyCity.City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(com.example.ListyCity.City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<com.example.ListyCity.City> getCities() {
        List<com.example.ListyCity.City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * Checks if a city is present in the list.
     * @param city The city to check for
     * @return True if the city is in the list, false otherwise
     */
    public boolean hasCity(com.example.ListyCity.City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list.
     * @param city The city to remove
     * @throws IllegalArgumentException if the city is not found in the list
     */
    public void delete(com.example.ListyCity.City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list
     * @return The size of the list
     */
    public int countCities() {
        return cities.size();
    }
}
