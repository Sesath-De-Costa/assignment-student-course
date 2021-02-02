package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.CourseBO;
import lk.ijse.dep.business.util.EntityDTOMapper;
import lk.ijse.dep.dao.DAOFactory;
import lk.ijse.dep.dao.DAOTypes;
import lk.ijse.dep.dao.custom.CourseDAO;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.entity.Course;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CourseBOImpl() {
        courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        courseDAO.setEntityManager(em);
    }

    @Override
    public void saveCourse(CourseDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.save(new Course(dto.getCode(), dto.getDescription(), dto.getDuration(), dto.getAudience()));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCourse(CourseDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.update(new Course(dto.getCode(), dto.getDescription(), dto.getDuration(), dto.getAudience()));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCourse(String code) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.delete(code);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        try {
            em.getTransaction().begin();
            return mapper.getCourseDTO(courseDAO.get(code));

        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<CourseDTO> getAllCourse() throws Exception {
        try {
            em.getTransaction().begin();
            List<CourseDTO> courseDTOs = mapper.getCourseDTOs(courseDAO.getAll());
            return courseDTOs;

        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
