package com.ada_locate.infra;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DAO<E> {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<E> entityClass;

    static{
        entityManagerFactory = Persistence
                                .createEntityManagerFactory("locadora_veiculos");
    }

    public DAO(Class<E> entityClass){
        this.entityManager = entityManagerFactory
                            .createEntityManager();
        this.entityClass = entityClass;
    }

    public DAO() {
        this(null);
    }

    public DAO<E> startTransaction(){
        this.entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> commitTransaction(){
        this.entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> addTransaction(E entity){
        this.entityManager.persist(entity);
        return this;
    }

    public DAO<E> mergeTransaction(E entity){
        this.entityManager.merge(entity);
        return this;
    }

    public DAO<E> addAtomicTransaction(E entity){
        return this.startTransaction().addTransaction(entity).commitTransaction();
    }

    public DAO<E> updateAtomicTransaction(E entity){
        return this.startTransaction().mergeTransaction(entity).commitTransaction();
    }

    public List<E> getAll(Integer limit, Integer offset){
        if(this.entityClass == null){
            throw new UnsupportedOperationException("Classe não informada");
        }
        String queryJPQL = "SELECT e FROM " + this.entityClass.getName() + " e";
        TypedQuery<E> query = this.entityManager.createQuery(queryJPQL, entityClass);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }

    public void close(){
        this.entityManager.close();
    }

    public E getById(Object id) {
        if(id == null) throw new IllegalArgumentException("Id não fornecido ou Nulo");
        E entity = entityManager.find(entityClass, id);
        if(entity == null) return null;
        return entity;
    }
}
