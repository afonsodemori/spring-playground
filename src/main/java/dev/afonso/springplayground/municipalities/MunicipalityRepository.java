package dev.afonso.springplayground.municipalities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, String> {
    List<Municipality> findByNameContaining(String name);
}
