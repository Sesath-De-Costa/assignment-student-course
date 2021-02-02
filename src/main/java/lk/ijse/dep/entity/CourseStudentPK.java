package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CourseStudentPK implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private String courseId;

}
