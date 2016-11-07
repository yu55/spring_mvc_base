package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Exercise save(Exercise exercise) {
        entityManager.persist(exercise);
        entityManager.flush();
        return exercise;
    }
}
