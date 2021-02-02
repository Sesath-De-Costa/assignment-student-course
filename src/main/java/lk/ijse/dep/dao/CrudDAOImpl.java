package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

public abstract class CrudDAOImpl<T extends SuperEntity, PK extends Serializable> implements CrudDAO<T, PK> {
    private EntityManager em;
    private Class<T> entityClassObj;

    public CrudDAOImpl() {
        entityClassObj = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(T entity) throws Exception {
        em.persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        em.merge(entity);
    }

    @Override
    public void delete(PK key) throws Exception {
        em.remove(key);
    }

    @Override
    public T get(PK key) throws Exception {
        return em.find(entityClassObj, key);
    }

    @Override
    public List<T> getAll() throws Exception {
        return em.createQuery("SELECT entity FROM" + entityClassObj.getName() + "entity").getResultList();
    }


}
