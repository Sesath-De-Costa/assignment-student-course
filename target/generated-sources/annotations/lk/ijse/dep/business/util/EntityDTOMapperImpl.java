package lk.ijse.dep.business.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.entity.Course;
import lk.ijse.dep.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-02T22:44:34+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class EntityDTOMapperImpl implements EntityDTOMapper {

    @Override
    public Student getStudent(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( dto.getId() );
        student.setStudentName( dto.getName() );
        student.setGender( dto.getGender() );
        student.setContact( dto.getContact() );
        student.setAddress( getAddress( dto ) );
        if ( dto.getDob() != null ) {
            student.setDob( new Date( dto.getDob().getTime() ) );
        }

        return student;
    }

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getStudentName() );
        studentDTO.setGender( student.getGender() );
        studentDTO.setContact( student.getContact() );
        studentDTO.setAddress( getAddress( student ) );
        studentDTO.setDob( student.getDob() );

        return studentDTO;
    }

    @Override
    public Course getCourse(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setCode( courseDTO.getCode() );
        course.setDescription( courseDTO.getDescription() );
        course.setDuration( courseDTO.getDuration() );
        course.setAudience( courseDTO.getAudience() );

        return course;
    }

    @Override
    public CourseDTO getCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCode( course.getCode() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setDuration( course.getDuration() );
        courseDTO.setAudience( course.getAudience() );

        return courseDTO;
    }

    @Override
    public List<Course> getCourses(List<CourseDTO> courseDTOs) {
        if ( courseDTOs == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( courseDTOs.size() );
        for ( CourseDTO courseDTO : courseDTOs ) {
            list.add( getCourse( courseDTO ) );
        }

        return list;
    }

    @Override
    public List<CourseDTO> getCourseDTOs(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( courses.size() );
        for ( Course course : courses ) {
            list.add( getCourseDTO( course ) );
        }

        return list;
    }

    @Override
    public List<StudentDTO> getStudentDTOs(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDTO( student ) );
        }

        return list;
    }
}
