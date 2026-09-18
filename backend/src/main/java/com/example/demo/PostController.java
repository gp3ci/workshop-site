package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*") 
public class PostController {

    // STAGE 1: Simple frontend-backend connection.
    // Posts live only in memory and are lost when the application restarts.
    private final List<Post> posts = new 
    ArrayList<>();

    @GetMapping
    public List<Post> getFeed() {
        return posts;
    }

    @PostMapping
    public Post createPost(@RequestBody
         Post post) {
        posts.add(post);
        return post;
    }
}

// STAGE 2: Use this controller when H2/JPA database storage is enabled.
// Uncomment this version after enabling the JPA and H2 dependencies in pom.xml
// and the database settings in application.properties.
// package com.example.demo;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/posts")
// @CrossOrigin(origins = "*")
// public class PostController {

//     private final PostRepository postRepository;

//     // The repository is injected so the controller can read and save database rows.
//     public PostController(PostRepository postRepository) {
//         this.postRepository = postRepository;
//     }

//     @GetMapping
//     public List<Post> getFeed() {
//         return postRepository.findAll();
//     }

//     @PostMapping
//     public Post createPost(@RequestBody Post post) {
//         return postRepository.save(post);
//     }
// }