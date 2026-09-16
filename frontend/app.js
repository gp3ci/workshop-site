const postForm = document.getElementById('post-form');
const captionInput = document.getElementById('caption-input');
const imageInput = document.getElementById('image-input');
const feed = document.getElementById('feed');

postForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const newPost = {
        caption: captionInput.value,
        imageUrl: imageInput.value
    };
    renderPost(newPost);
    postForm.reset();
});

function renderPost(post) {
    const card = document.createElement('div');
    card.className = 'post-card';
    card.innerHTML = `
        <img src="${post.imageUrl}" alt="Post image">
        <div class="caption"><strong>user</strong> ${post.caption}</div>
    `;
    feed.prepend(card);
}





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