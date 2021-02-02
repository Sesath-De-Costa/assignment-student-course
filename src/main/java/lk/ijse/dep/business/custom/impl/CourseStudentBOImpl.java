package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.CourseStudentBO;
import lk.ijse.dep.business.util.EntityDTOMapper;
import lk.ijse.dep.dao.custom.CourseStudentDAO;
import lk.ijse.dep.dto.CourseStudentDTO;
import lk.ijse.dep.entity.CourseStudent;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public class CourseStudentBOImpl implements CourseStudentBO {

    private CourseStudentDAO courseStudentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        courseStudentDAO.setEntityManager(em);
    }

    @Override
    public void register(CourseStudentDTO courseStudentDTO) throws Exception {
        try {
            em.getTransaction().begin();
            courseStudentDAO.save(new CourseStudent(courseStudentDTO.getCourseCode(),
                    courseStudentDTO.getStudentId(), new Date(2021, 2, 2), BigDecimal.valueOf(50000)));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
