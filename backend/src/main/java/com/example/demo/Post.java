package com.example.demo;

// STAGE 1: Plain Java object used by the in-memory controller.
// No database annotations are required for the frontend-backend connection.
public class Post {
    private String caption;
    private String imageUrl;

    public Post() {}

    public Post(String caption, String imageUrl) {
        this.caption = caption;
        this.imageUrl = imageUrl;
    }

    public String getCaption() { return caption; }
    public String getImageUrl() { return imageUrl; }
    public void setCaption(String caption) { this.caption = caption; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}

// STAGE 2: Replace the class above with this database entity when H2/JPA is needed.
// The generated id allows the database to identify each stored post.
// package com.example.demo;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Post {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String caption;
//     private String imageUrl;

//     public Post() {}

//     public Post(String caption, String imageUrl) {
//         this.caption = caption;
//         this.imageUrl = imageUrl;
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getCaption() { return caption; }
//     public void setCaption(String caption) { this.caption = caption; }

//     public String getImageUrl() { return imageUrl; }
//     public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
// }