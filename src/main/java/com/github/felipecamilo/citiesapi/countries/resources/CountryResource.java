package com.github.felipecamilo.citiesapi.countries.resources;

import com.github.felipecamilo.citiesapi.countries.entities.Country;
import com.github.felipecamilo.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {

    this.repository = repository;
  }

  /*public List<Country> countries() {
    return repository.findAll();
  }*/

  //localhost:8080/countriespages?page=0&size=10&sort=name,asc
  @GetMapping
  public Page<Country> countries(Pageable page) {
    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Country> getOne(@PathVariable Long id) {
    Optional<Country> optional = repository.findById(id);

    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    }
    else {
      return ResponseEntity.notFound().build();
    }
  }
}
