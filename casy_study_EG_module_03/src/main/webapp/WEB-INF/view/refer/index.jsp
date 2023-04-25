<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js" integrity="sha512-DZqqY3PiOvTP9HkjIWgjO6ouCbq+dxqWoJZ/Q+zPYNHmlnI2dQnbJ5bxAHpAMw+LXRm4D72EIRXzvcHQtE8/VQ==" crossorigin="anonymous"></script>
  <title>Movie Mania</title>
  <script src="app.js"></script>
  <link rel="stylesheet" href="style.css">
  <style>

    *{
      box-sizing: border-box;
    }
    :root{
      --primary-color:#22254b;
      --secondary-color:#363b69;

    }

    body{
      background-color: var(--primary-color);
      font-family: 'Poppins', sans-serif;
      margin: 0;

    }
    header{
      padding: 1rem;
      display: flex;
      justify-content: flex-end;
      background-color: var(--secondary-color);

    }
    .search{
      background-color: transparent;
      border: 2px solid var(--primary-color);
      padding: 0.5rem 1rem;
      border-radius: 50px;
      font-size: 1rem;
      color: #fff;
      font-family: inherit;
    }

    .search:focus{
      outline: 0;
      background-color: var(--primary-color);

    }

    .search::placeholder{
      color: #6368c5;
    }

    main{
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
    }

    .movie{
      width: 300px;
      margin: 1rem;
      border-radius: 3px;
      box-shadow: 0.2px 4px 5px rgba(0,0,0,0.1);
      background-color: var(--secondary-color);
      position: relative;
      overflow: hidden;
    }
    .movie img{
      width:100%;
    }

    .movie-info{
      color: #eee;
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 0.5rem 1rem 1rem;
      letter-spacing: 0.5px;
    }

    .movie-info h3{
      margin-top: 0;
    }
    .movie-info span{
      background-color: var(--primary-color);
      padding: 0.25rem 0.5rem;
      border-radius: 3px;
      font-weight: bold;
    }

    .movie-info span.green{
      color: lightgreen;
    }

    .movie-info span.orange{
      color: orange;
    }

    .movie-info span.red{
      color: red;
    }
    .overview{

      position: absolute;
      left: 0;
      right: 0;
      bottom: 0;
      border-color: #fff;
      padding: 1rem;
      max-height: 100%;
      transform: translateY(101%);
      transition: transform 0.3s ease-in;
      background-color:#fff;
    }

    .movie:hover .overview{
      transform: translateY(0);
    }
  </style>
</head>
<body>
<header>
  <form id="form"><input type="text" placeholder="search" id="search" class="search">

  </form>
</header>
<main id="main">
  <div class="movie">
    <img src="./movie-theater-insurance-header.jpg" alt="Image">
    <div class="movie-info">
      <h3>Movie Title</h3>
      <span class="green">9.8</span>
    </div>
    <div class="overview">
      Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae itaque totam quo dolorem recusandae quaerat vel incidunt iusto doloremque eaque!


    </div>
  </div>
  <div class="movie">
    <img src="./movie-theater-insurance-header.jpg" alt="Image">
    <div class="movie-info">
      <h3>Movie Title</h3>
      <span class="green">9.8</span>
    </div>
    <div class="overview">
      <h3>Overview</h3>
      Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae itaque totam quo dolorem recusandae quaerat vel incidunt iusto doloremque eaque!


    </div>
  </div>
  <div class="movie">
    <img src="./movie-theater-insurance-header.jpg" alt="Image">
    <div class="movie-info">
      <h3>Movie Title</h3>
      <span class="green">9.8</span>
    </div>
    <div class="overview">
      Lorem ipsum dolor sit, amet consectetur adipisicing elit. Molestiae itaque totam quo dolorem recusandae quaerat vel incidunt iusto doloremque eaque!


    </div>
  </div>
</main>
<script>
  //TMDB

  const API_KEY = 'api_key=1dae71e27a992b680ae81e308022025e';
  const BASE_URL = 'https://api.themoviedb.org/3';
  const API_URL = BASE_URL + '/discover/movie?sort_by=popularity.desc&' + API_KEY;
  const IMG_URL = 'https://image.tmdb.org/t/p/w500'
  const searchURL = BASE_URL + '/search/movie?'+API_KEY;


  const main = document.getElementById('main');
  const form = document.getElementById('form');
  const search = document.getElementById('search');


  getMovies(API_URL);

  function getMovies(url){
    fetch(url).then(res => res.json()).then(data => {
      console.log(data.results)
      show(data.results);
    })
  }

  function show(data){

    main.innerHTML = '';

    data.forEach(movie => {
      const {title, poster_path, vote_average, overview} = movie;
      const movieE1 = document.createElement('div');
      movieE1.classList.add('movie');
      movieE1.innerHTML =`
        <img src="${IMG_URL+poster_path}" alt="${title}">
  <div class="movie-info">
    <h3>${title}</h3>
    <span class="${getColor(vote_average)}">${vote_average}</span>
  </div>
  <div class="overview">
    <h3>Overview</h3>
    ${overview}


  </div>`

      main.appendChild(movieE1);
    })
  }

  function getColor(vote){
    if(vote>=8){
      return 'green'
    }else if(vote >= 5){
      return "orange"

    }else {
      return 'red'
    }
  }

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const searchTerm = search.value;

    if(searchTerm){
      getMovies(searchURL+'&query='+searchTerm)
    }
    else{
      getMovies(API_URL);
    }
  })
</script>
</body>
</html>