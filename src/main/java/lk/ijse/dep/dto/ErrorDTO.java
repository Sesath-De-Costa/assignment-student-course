package lk.ijse.dep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ErrorDTO implements Serializable {
    private int status;
    private String error;
    private String message;
}
