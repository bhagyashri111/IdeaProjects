document.getElementById("searchForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const title = document.getElementById("title").value.trim();
    if (title !== "") {
        fetch(`/search?title=${encodeURIComponent(title)}`)
            .then(response => response.json())
            .then(data => displayMovie(data))
            .catch(error => console.error('Error:', error));
    }
});

function displayMovie(movieData) {
    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = `
        <div class="movie">
            <h2>${movieData.Title} (${movieData.Year})</h2>
            <p><strong>Rated:</strong> ${movieData.Rated}</p>
            <p><strong>Released:</strong> ${movieData.Released}</p>
            <p><strong>Runtime:</strong> ${movieData.Runtime}</p>
            <p><strong>Genre:</strong> ${movieData.Genre}</p>
            <p><strong>Director:</strong> ${movieData.Director}</p>
            <p><strong>Writer:</strong> ${movieData.Writer}</p>
            <p><strong>Actors:</strong> ${movieData.Actors}</p>
            <p><strong>Plot:</strong> ${movieData.Plot}</p>
            <p><strong>Language:</strong> ${movieData.Language}</p>
            <p><strong>Country:</strong> ${movieData.Country}</p>
            <p><strong>Awards:</strong> ${movieData.Awards}</p>
            <p><strong>Rotten Tomatoes Rating:</strong> ${movieData.Ratings[0].Value}</p>
            <img src="${movieData.Poster}" alt="${movieData.Title} Poster">
        </div>
    `;
}