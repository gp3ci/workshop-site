package com.instaclone;

public class Post {
    private Long id;
    private String caption;
    private String imageUrl;

    public Post() {}
    public Post(Long id, String caption, String imageUrl) {
        this.id = id;
        this.caption = caption;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public String getCaption() { return caption; }
    public String getImageUrl() { return imageUrl; }
    public void setId(Long id) { this.id = id; }
    public void setCaption(String caption) { this.caption = caption; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}


// package com.instaclone;

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

//     public Long getId() { return id; }
//     public String getCaption() { return caption; }
//     public String getImageUrl() { return imageUrl; }
// }