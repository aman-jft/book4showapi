package org.catalystone.bookurshow.controller;

import java.util.List;

import org.catalystone.bookurshow.model.APIException;
import org.catalystone.bookurshow.model.MovieTheatreModel;
import org.catalystone.bookurshow.service.MovieTheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movietheatre")
public class MovieTheatreController {
	@Autowired
	private MovieTheatreService movieTheatreService;

	@PostMapping("/add")
	public MovieTheatreModel add(@RequestBody MovieTheatreModel movieTheatreModel) {
		return movieTheatreService.addMovieTheatre(movieTheatreModel);
	}

	@GetMapping("list")
	public List<MovieTheatreModel> list() {
		return movieTheatreService.listMovieTheatres();
	}

	@PostMapping("/update")
	public MovieTheatreModel update(@RequestBody MovieTheatreModel movieTheatreModel)
			throws APIException {
		return movieTheatreService.updateMovieTheatre(movieTheatreModel);
	}

	@GetMapping("/delete/{id}")
	public MovieTheatreModel delete(@PathVariable("id") long id) throws APIException {
		return movieTheatreService.deleteMovieTheatre(id);
	}
}
