package com.example.ListyCity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */

public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city Name of the city
     * @param province Name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return The city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name
     * @return The province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another city for sorting
     * @param o The city to compare to
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks if two City objects are equal based on city name and province.
     * @param o The object to compare
     * @return True if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    /**
     * Generates a hash code for the City object.
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
