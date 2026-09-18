// ============================================================
// FRONTEND STAGES
// Stage 1: Connect the browser to the Java backend API.
// Stage 2: Keep using the same API when the backend switches
// from an in-memory List to H2/JPA database storage.
// ============================================================

// EARLIER LOCAL-ONLY VERSION: use this only when the backend is not running.
// const postForm = document.getElementById('post-form');
// const captionInput = document.getElementById('caption-input');
// const imageInput = document.getElementById('image-input');
// const feed = document.getElementById('feed');
// postForm.addEventListener('submit', (e) => {
//     e.preventDefault();
//     const newPost = {
//         caption: captionInput.value,
//         imageUrl: imageInput.value
//     };
//     renderPost(newPost);
//     postForm.reset();
// });
// function renderPost(post) {
//     const card = document.createElement('div');
//     card.className = 'post-card';
//     card.innerHTML = `
//         <img src="${post.imageUrl}" alt="Post image">
//         <div class="caption"><strong>user</strong> ${post.caption}</div>
//     `;
//     feed.prepend(card);
// }


const postForm = document.getElementById('post-form');
const captionInput = document.getElementById('caption-input');
const imageInput = document.getElementById('image-input');
const feed = document.getElementById('feed');

// STAGE 1: The frontend communicates with the backend through this API.
// STAGE 2: This URL stays the same; database persistence is handled by Java.
const API_URL = 'http://localhost:8080/api/posts';

// STAGE 1 and STAGE 2: Fetch posts from the Java backend when the page loads.
async function fetchFeed() {
    try {
        const res = await fetch(API_URL);
        const posts = await res.json();
        feed.innerHTML = '';
        posts.forEach(renderPost);
    } catch (error) {
        console.error('Error fetching feed:', error);
    }
}

// STAGE 1 and STAGE 2: Send a new post to the Java backend.
postForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const postData = {
        caption: captionInput.value,
        imageUrl: imageInput.value
    };

    try {
        await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(postData)
        });

        fetchFeed(); // Refresh the feed from the server.
        postForm.reset();
    } catch (error) {
        console.error('Error creating post:', error);
    }
});

// Shared UI helper for both backend stages.
function renderPost(post) {
    const card = document.createElement('div');
    card.className = 'post-card';
    card.innerHTML = `
        <img src="${post.imageUrl}" alt="Post image">
        <div class="caption"><strong>user</strong> ${post.caption}</div>
    `;
    feed.prepend(card);
}

// Start the frontend-backend connection when the page loads.
fetchFeed();












// const API_URL = 'http://localhost:8080/api/posts';

// async function fetchFeed() {
//     const response = await fetch(API_URL);
//     const posts = await response.json();
//     feed.innerHTML = '';
//     posts.forEach(renderPost);
// }

// postForm.addEventListener('submit', async (e) => {
//     e.preventDefault();
//     const postData = {
//         caption: captionInput.value,
//         imageUrl: imageInput.value
//     };

//     const response = await fetch(API_URL, {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' },
//         body: JSON.stringify(postData)
//     });

//     const savedPost = await response.json();
//     renderPost(savedPost);
//     postForm.reset();
// });

// fetchFeed();