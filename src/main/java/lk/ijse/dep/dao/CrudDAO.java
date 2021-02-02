package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public interface CrudDAO<T extends SuperEntity, PK extends Serializable> extends SuperDAO {

    void save(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(PK key) throws Exception;

    T get(PK key) throws Exception;

    List<T> getAll() throws Exception;

}
