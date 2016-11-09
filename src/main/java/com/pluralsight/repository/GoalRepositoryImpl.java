package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager em;

    public Goal save(Goal goal) {
        em.persist(goal);
        em.flush();
        return goal;
    }

    public List<Goal> loadAll() {
        Query query = em.createQuery("select g from Goal g");
        List goals = query.getResultList();
        return goals;
    }

    public List<GoalReport> findAllGoalReports() {
        Query query = em.createQuery("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id=e.goal.id");
        return query.getResultList();
    }
}
