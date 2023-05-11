package com.example.demo.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MovieDTO2;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/movie")
	public List<MovieDTO> getAllMovie() {

		return movieService.getAllMovie();
	}

	@PostMapping("/movie")
	public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO) {
		movieService.save(movieDTO);
		return movieDTO;
	}

	@PutMapping("movie/{id}")
	public MovieDTO update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
		try {
			movieDTO.setId(id);
			movieService.update(movieDTO);
			// movieService.save(movieDTO);
			return movieDTO;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@DeleteMapping("/movie/{id}")
	public List<MovieDTO> delete(@PathVariable int id) {
		if (movieService.findById(id).getId() != null) {
			movieService.delete(id);
		}
		return movieService.getAllMovie();
	}

	// chay tren reactjs

	@GetMapping("api/movies")
	public ResponseEntity<List<MovieDTO2>> getAllMovies() {
		List<MovieDTO2> movies = movieService.getAllMovies();
		if (movies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

	@GetMapping("api/movie/{id}")
	public ResponseEntity<MovieDTO2> getMovieById(@PathVariable int id) {
		Movie movie = movieService.FindById(id);
		if (movie == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modelMapper.map(movie, MovieDTO2.class), HttpStatus.OK);
	}

	@PostMapping("api/movie")
	public ResponseEntity<Object> createMovie(@RequestBody MovieDTO2 movieDTO) {
		Movie movie = modelMapper.map(movieDTO, Movie.class);
		MovieDTO2 movie2 = movieService.save2(movie);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Movie created successfully",
				movie2));
	}

	@PutMapping("api/movie/{id}")
	public ResponseEntity<Object> updateMovie(@PathVariable int id, @RequestBody MovieDTO2 movieDTO) {
		Movie movieExisting = movieService.FindById(id);
		if (movieExisting == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Movie not found", null));
		}

		movieExisting.setName(movieDTO.getName());
		movieExisting.setSmallImageURl(movieDTO.getSmallImageURl());
		movieExisting.setShortDescription(movieDTO.getShortDescription());
		movieExisting.setLongDescription(movieDTO.getLongDescription());
		movieExisting.setLargeImageURL(movieDTO.getLargeImageURL());
		movieExisting.setDirector(movieDTO.getDirector());
		movieExisting.setActors(movieDTO.getActors());
		movieExisting.setCategories(movieDTO.getCategories());
		movieExisting.setReleaseDate(movieDTO.getReleaseDate());
		movieExisting.setDuration(movieDTO.getDuration());
		movieExisting.setTrailerURL(movieDTO.getTrailerURL());
		movieExisting.setLanguage(movieDTO.getLanguage());
		movieExisting.setRated(movieDTO.getRated());
		movieExisting.setIsShowing(movieDTO.getIsShowing());

		MovieDTO2 movie = movieService.save2(movieExisting);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Movie updated successfully",
				movie));

	}

	@DeleteMapping("api/movie/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
		Movie movie = movieService.FindById(id);
		if (movie == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Movie not found", null));
		}
		movieService.deleteMovie(movie);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Movie deleted successfully", null));
	}

	@GetMapping("movie/{id}")
	public MovieDTO findByID(@PathVariable int id) {
		return movieService.findById(id);
	}

	@GetMapping("api/movies/allMoviesShowing")
	public ResponseEntity<List<Movie>> getAllMoviesShowing() {
		List<Movie> movies = movieService.getMovieIsShowing();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
}
