package dev.afonso.springplayground.news.repository;

import dev.afonso.springplayground.news.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SectionRepository extends JpaRepository<Section, UUID> {
}
