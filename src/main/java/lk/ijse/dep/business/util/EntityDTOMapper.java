package lk.ijse.dep.business.util;

import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.entity.Address;
import lk.ijse.dep.entity.Course;
import lk.ijse.dep.entity.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "studentName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "contact", target = "contact")
    @Mapping(source = ".", target = "address", qualifiedByName = "address")
    Student getStudent(StudentDTO dto);

    @Named("address")
    default Address getAddress(StudentDTO dto) {
        EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

        return new Address(dto.getAddress().split(",")[0], dto.getAddress().split(",")[1], dto.getAddress().split(",")[2], dto.getAddress().split(",")[3]);
    }

    @InheritInverseConfiguration
    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentName", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "contact", target = "contact")
    @Mapping(source = ".", target = "address", qualifiedByName = "address")
    StudentDTO getStudentDTO(Student student);

    @Named("address")
    default String getAddress(Student student) {

        return student.getAddress().getNo() +
                "," + student.getAddress().getAddressLine1() +
                "," + student.getAddress().getAddressLine2() +
                "," + student.getAddress().getCity();
    }


    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "audience", target = "audience")
    Course getCourse(CourseDTO courseDTO);

    @InheritInverseConfiguration
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "audience", target = "audience")
    CourseDTO getCourseDTO(Course course);


    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "audience", target = "audience")
    List<Course> getCourses(List<CourseDTO> courseDTOs);

    @InheritInverseConfiguration
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "audience", target = "audience")
    List<CourseDTO> getCourseDTOs(List<Course> courses);

    @InheritInverseConfiguration
    @Mapping(source = "id", target = "id")
    @Mapping(source = "studentName", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "contact", target = "contact")
    @Mapping(source = ".", target = "address", qualifiedByName = "address")
    List<StudentDTO> getStudentDTOs(List<Student> students);

//
//    @Mapping(source = "code", target = "code")
//    @Mapping(source = "description", target = "description")
//    @Mapping(source = "duration", target = "duration")
//    @Mapping(source = "audience", target = "audience")
//    CourseDTO getCourseStudentDTO(Course course);
//
//    List<StudentDTO> getCourseStudentDTOs(List<Student> students);




}
