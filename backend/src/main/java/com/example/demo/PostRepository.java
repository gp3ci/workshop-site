package com.example.demo;

// STAGE 2 ONLY: Database access layer for the H2/JPA version.
// This file is unused by the current Stage 1 in-memory controller.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Spring Data JPA automatically provides methods such as:
    // .findAll(), .save(), .findById(), .deleteById()
}

