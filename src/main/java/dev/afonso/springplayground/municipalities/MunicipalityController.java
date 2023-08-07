package dev.afonso.springplayground.municipalities;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/municipalities")
public class MunicipalityController {
    private final MunicipalityRepository repository;

    public MunicipalityController(final MunicipalityRepository repository) {
        this.repository = repository;
    }

    // TODO: Make trailing slash optional or redirect
    @GetMapping("")
    List<Municipality> list() {
        return repository.findAll();
    }

    // TODO: Make trailing slash optional or redirect
    @GetMapping("/search")
    List<Municipality> searchName(@RequestParam String q) {
        return repository.findByNameContaining(q);
    }

    // TODO: Make trailing slash optional or redirect
    @GetMapping("/{code:\\d+}")
    ResponseEntity<Municipality> findByCode(@PathVariable String code) {
        Optional<Municipality> municipality = repository.findById(code);
        // TODO: Give the 404 response a body
        return municipality.isPresent() ? ResponseEntity.ok(municipality.get()) : ResponseEntity.notFound().build();
    }
}
