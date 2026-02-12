package com.example.ListyCity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private com.example.listycity.CityList mockCityList() {
        com.example.listycity.CityList cityList = new com.example.listycity.CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private com.example.listycity.City mockCity() {
        return new com.example.listycity.City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        com.example.listycity.CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        com.example.listycity.City city = new com.example.listycity.City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        com.example.listycity.CityList cityList = mockCityList();
        com.example.listycity.City city = new com.example.listycity.City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        com.example.listycity.CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        com.example.listycity.City city = new com.example.listycity.City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        com.example.listycity.CityList cityList = mockCityList();
        com.example.listycity.City city = new com.example.listycity.City("Vancouver", "BC");

        // Test false before adding
        assertFalse(cityList.hasCity(city));

        // Test true after adding
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        com.example.listycity.CityList cityList = mockCityList();
        com.example.listycity.City city = new com.example.listycity.City("Toronto", "Ontario");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));

        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        com.example.listycity.CityList cityList = mockCityList();
        com.example.listycity.City city = new com.example.listycity.City("Halifax", "NS");

        // Attempt to delete a city that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        com.example.listycity.CityList cityList = mockCityList(); // Starts with 1 city
        assertEquals(1, cityList.countCities());

        com.example.listycity.City city = new com.example.listycity.City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}
