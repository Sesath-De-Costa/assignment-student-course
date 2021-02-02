package lk.ijse.dep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
@Data
@AllArgsConstructor
    @NoArgsConstructor

    public class StudentDTO implements Serializable {

    private int id;
    private String name;
    private String gender;
    private String contact;
    private Date dob;
    private String address;


}
