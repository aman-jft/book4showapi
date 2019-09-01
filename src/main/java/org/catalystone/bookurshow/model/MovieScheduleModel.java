package org.catalystone.bookurshow.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.catalystone.bookurshow.domain.MovieSchedule;
import org.catalystone.bookurshow.domain.MovieSchedule.TimeSlot;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MovieScheduleModel {
	private Long id;
	private Long movieTheatre;
	private Long movie;
	private String movieName;
	private LocalTime movieDuration;
	private TimeSlot timeSlot;
	private LocalDate from;
	private LocalDate to;
	private BigDecimal price;
	private boolean deleted;
	
	@JsonIgnore
	public MovieSchedule getDomain() {
		MovieSchedule movieSchedule = new MovieSchedule();
		movieSchedule.setDeleted(this.isDeleted());
		movieSchedule.setFrom(this.getFrom());
		movieSchedule.setId(this.id);
		movieSchedule.setPrice(this.getPrice());
		movieSchedule.setTimeSlot(this.getTimeSlot());
		movieSchedule.setTo(this.getTo());
		return movieSchedule;
	}
	
	public static MovieScheduleModel getInstance(MovieSchedule movieSchedule) {
		MovieScheduleModel movieScheduleModel= new MovieScheduleModel();
		movieScheduleModel.setDeleted(movieSchedule.isDeleted());
		movieScheduleModel.setFrom(movieSchedule.getFrom());
		movieScheduleModel.setId(movieSchedule.getId());
		movieScheduleModel.setMovie(movieSchedule.getMovie().getId());
		movieScheduleModel.setMovieTheatre(movieSchedule.getMovieTheatre().getId());
		movieScheduleModel.setPrice(movieSchedule.getPrice());
		movieScheduleModel.setTimeSlot(movieSchedule.getTimeSlot());
		movieScheduleModel.setTo(movieSchedule.getTo());
		
		movieScheduleModel.movieName = movieSchedule.getMovie().getName();
		movieScheduleModel.movieDuration = movieSchedule.getMovie().getDuration();
		return movieScheduleModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMovieTheatre() {
		return movieTheatre;
	}

	public void setMovieTheatre(Long movieTheatre) {
		this.movieTheatre = movieTheatre;
	}

	public Long getMovie() {
		return movie;
	}

	public void setMovie(Long movie) {
		this.movie = movie;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}	