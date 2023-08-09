package dev.afonso.springplayground.news.controller;

import dev.afonso.springplayground.news.model.Article;
import dev.afonso.springplayground.news.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/news/articles")
public class ArticleController {

    private final ArticleRepository repository;

    ArticleController(ArticleRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Article> index() {
        return repository.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Article> findByUuid(@PathVariable String uuid) {
        Optional<Article> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping()
    public ResponseEntity<Article> create(@RequestBody Article article) {
        return ResponseEntity.ok(repository.save(article));
    }

    @PatchMapping("/{uuid}")
    // TODO: Do it right!!
    // TODO: See example -> https://github.com/Java-Techie-jt/patch-mapping-example
    public ResponseEntity<Article> update(@PathVariable String uuid, @RequestBody Article newArticle) {
        Optional<Article> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Article article = optional.get();

        if (!newArticle.getTitle().isEmpty()) {
            article.setTitle(newArticle.getTitle());
        }

        if (!newArticle.getBody().isEmpty()) {
            article.setBody(newArticle.getBody());
        }

        return ResponseEntity.ok(repository.save(article));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Article> delete(@PathVariable String uuid) {
        Optional<Article> optional = repository.findById(UUID.fromString(uuid));

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(optional.get());

        return ResponseEntity.noContent().build();
    }
}
