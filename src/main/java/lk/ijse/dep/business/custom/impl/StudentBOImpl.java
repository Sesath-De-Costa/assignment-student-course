package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.StudentBO;
import lk.ijse.dep.business.util.EntityDTOMapper;
import lk.ijse.dep.dao.custom.StudentDAO;
import lk.ijse.dep.dto.StudentDTO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentDAO.setEntityManager(em);
    }

    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.save(mapper.getStudent(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.update(mapper.getStudent(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.delete(id);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public StudentDTO getStudent(int id) throws Exception {
        try {
            em.getTransaction().begin();
            return mapper.getStudentDTO(studentDAO.get(id));
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        try {
            em.getTransaction().begin();
            return mapper.getStudentDTOs(studentDAO.getAll());
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
