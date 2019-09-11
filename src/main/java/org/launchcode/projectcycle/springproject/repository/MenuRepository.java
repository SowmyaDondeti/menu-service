package org.launchcode.projectcycle.springproject.repository;

import org.launchcode.projectcycle.springproject.entity.MenuEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    @PersistenceContext
    private final EntityManager entityManager;


    public MenuRepository(NamedParameterJdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public List<MenuEntity> getMenu() {
    System.out.println("Hi");
        TypedQuery<MenuEntity> query = entityManager.createQuery("from MenuEntity", MenuEntity.class);
        return query.getResultList();

    }

    public MenuEntity createMenu(MenuEntity menu) {

        entityManager.persist(menu);
        return menu;

    }
    public MenuEntity updateMenu(MenuEntity menu) {
        return entityManager.merge(menu);
    }
    public Optional<MenuEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(MenuEntity.class, id));
    }
}
