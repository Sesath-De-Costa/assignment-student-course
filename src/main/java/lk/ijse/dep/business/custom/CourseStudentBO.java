package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseStudentDTO;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

public interface CourseStudentBO extends SuperBO {

    void register(CourseStudentDTO courseStudentDTO) throws Exception;
}
