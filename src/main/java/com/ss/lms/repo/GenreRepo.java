package com.ss.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Genre;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Integer> {
	@Query(" FROM Genre where genre_id =:genre_id")
	public List<Genre> readGenreById(@Param("genre_id") Integer genreId);
	
	@Query(" FROM Genre where  genre_name =:genre_name")
	public List<Genre> readGenreByName(@Param("genre_name") String genre_name);
}
