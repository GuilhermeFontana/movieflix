package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private  final CategoryService categoryService;
    private final StreamingService streamingService;


    public Movie save(Movie movie){
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreaming(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }


    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }


    public Optional<Movie> update (Long movieid, Movie updateMovie){
      Optional<Movie> optMovie = repository.findById(movieid);
      if (optMovie.isPresent()){

          List<Category> categories = this.findCategories(updateMovie.getCategories());
          List<Streaming> streaming = this.findStreaming(updateMovie.getStreamings());

          Movie movie = optMovie.get();
          movie.setTitle(updateMovie.getTitle());
          movie.setDescription(updateMovie.getDescription());
          movie.setReleaseDate(updateMovie.getReleaseDate());
          movie.setRating(updateMovie.getRating());

          movie.getCategories().clear();
          movie.getCategories().addAll(categories);

          movie.getStreamings().clear();
          movie.getStreamings().addAll(streaming);

          repository.save(movie);
          return Optional.of(movie);
      }

      return Optional.empty();

    }

    public void deletar(Long id){
        repository.deleteById(id);
    }


    public List<Movie> findByCategory(Long categoryId){
        return repository.findByCategories(List.of(Category.builder().id(categoryId).build()));
    }



    private List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category ->
                categoryService.gettByCategoryId(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreaming(List<Streaming> streamings){
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming ->
                streamingService.gettByCategoryId(streaming.getId()).ifPresent(streamingFound::add));
        return streamingFound;
    }












}
