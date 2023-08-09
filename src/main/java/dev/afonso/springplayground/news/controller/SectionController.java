package dev.afonso.springplayground.news.controller;

import dev.afonso.springplayground.news.model.Section;
import dev.afonso.springplayground.news.repository.SectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/news/sections")
public class SectionController {

    private final SectionRepository repository;

    SectionController(SectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Section> index() {
        return repository.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Section> findByUuid(@PathVariable String uuid) {
        Optional<Section> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping()
    public ResponseEntity<Section> create(@RequestBody Section section) {
        return ResponseEntity.ok(repository.save(section));
    }

    @PatchMapping("/{uuid}")
    // TODO: Do it right!!
    // TODO: See example -> https://github.com/Java-Techie-jt/patch-mapping-example
    public ResponseEntity<Section> update(@PathVariable String uuid, @RequestBody Section newSection) {
        Optional<Section> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Section section = optional.get();

        if (!newSection.getName().isEmpty()) {
            section.setName(newSection.getName());
        }

        return ResponseEntity.ok(repository.save(section));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Section> delete(@PathVariable String uuid) {
        Optional<Section> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(optional.get());

        return ResponseEntity.noContent().build();
    }
}
