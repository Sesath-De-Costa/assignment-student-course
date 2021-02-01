package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
@Entity
@Table(name = "course_student")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseStudent implements SuperEntity {
    @EmbeddedId
    private CourseStudentPK courseStudentPK;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "course_id", referencedColumnName = "code", insertable = false, updatable = false)
    private Course course;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;
    @Temporal(TemporalType.DATE)
    @Column(name = "register_date", nullable = false)
    private Date registerDate;
    @Column(name = "register_fee")
    private BigDecimal registerFee;


    public CourseStudent(CourseStudentPK courseStudentPK, Date registerDate, BigDecimal registerFee) {
        this.courseStudentPK = courseStudentPK;
        this.registerDate = registerDate;
        this.registerFee = registerFee;
    }

    public CourseStudent(String courseCode, String studentID, Date registerDate, BigDecimal registerFee) {
        this.courseStudentPK = new CourseStudentPK(studentID, courseCode);
        this.registerDate = registerDate;
        this.registerFee = registerFee;
    }
}
