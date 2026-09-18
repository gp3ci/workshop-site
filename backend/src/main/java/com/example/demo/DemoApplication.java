package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ============================================================
// BACKEND STAGES
// Stage 1: Run the API with an in-memory Java List so the
// frontend can connect to the backend without a database.
// Stage 2: Enable JPA, H2, PostRepository, and the database
// version of PostController/Post when persistent storage is needed.
// ============================================================
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
