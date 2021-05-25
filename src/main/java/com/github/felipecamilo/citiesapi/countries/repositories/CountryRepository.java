package com.github.felipecamilo.citiesapi.countries.repositories;


import com.github.felipecamilo.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
