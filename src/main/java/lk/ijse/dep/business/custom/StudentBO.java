package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.entity.Student;

import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public interface StudentBO extends SuperBO {
    void saveStudent(StudentDTO dto) throws Exception;

    void updateStudent(StudentDTO dto) throws Exception;

    void deleteStudent(int id) throws Exception;

    StudentDTO getStudent(int id) throws Exception;

    List<StudentDTO> getAllStudent() throws Exception;
}
