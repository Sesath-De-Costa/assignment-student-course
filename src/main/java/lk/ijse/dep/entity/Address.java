package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

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
public class Address {
    private String no;
    private String addressLine1;
    private String addressLine2;
    private String city;
}
