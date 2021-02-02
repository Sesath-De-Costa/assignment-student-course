package lk.ijse.dep.business;

import javax.persistence.EntityManager;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public interface SuperBO {
    void setEntityManager(EntityManager em);
}
