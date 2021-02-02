package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseDTO;

import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public interface CourseBO extends SuperBO {

    void saveCourse(CourseDTO dto) throws Exception;

    void updateCourse(CourseDTO dto) throws Exception;

    void deleteCourse(String code) throws Exception;

    CourseDTO getCourse(String code) throws Exception;

    List<CourseDTO> getAllCourse() throws Exception;
}
