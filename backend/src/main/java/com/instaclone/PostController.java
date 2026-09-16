package com.instaclone;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    private final List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> getFeed() {
        return posts;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }
}

// package com.instaclone;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/posts")
// @CrossOrigin(origins = "*")
// public class PostController {

//     private final PostRepository repository;

//     public PostController(PostRepository repository) {
//         this.repository = repository;
//     }

//     @GetMapping
//     public List<Post> getFeed() {
//         return repository.findAll();
//     }

//     @PostMapping
//     public Post createPost(@RequestBody Post post) {
//         return repository.save(post);
//     }
// }