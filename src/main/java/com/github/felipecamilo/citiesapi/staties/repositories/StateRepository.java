package com.github.felipecamilo.citiesapi.staties.repositories;


import com.github.felipecamilo.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
