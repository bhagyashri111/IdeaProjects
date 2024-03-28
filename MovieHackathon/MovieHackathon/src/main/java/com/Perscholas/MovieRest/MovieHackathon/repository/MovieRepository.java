package com.Perscholas.MovieRest.MovieHackathon.repository;

import com.Perscholas.MovieRest.MovieHackathon.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
