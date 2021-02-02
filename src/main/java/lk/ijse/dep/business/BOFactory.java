package lk.ijse.dep.business;

import lk.ijse.dep.business.custom.impl.CourseBOImpl;
import lk.ijse.dep.business.custom.impl.CourseStudentBOImpl;
import lk.ijse.dep.business.custom.impl.StudentBOImpl;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return boFactory != null ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE_STUDENT:
                return (T) new CourseStudentBOImpl();
            default:
                return null;
        }
    }
}
