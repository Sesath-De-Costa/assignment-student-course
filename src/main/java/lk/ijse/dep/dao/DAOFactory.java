package lk.ijse.dep.dao;

import lk.ijse.dep.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dep.dao.custom.impl.CourseStudentDAOImpl;
import lk.ijse.dep.dao.custom.impl.StudentDAOImpl;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return daoFactory != null ? daoFactory : (daoFactory = new DAOFactory());
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE_STUDENT:
                return (T) new CourseStudentDAOImpl();
            default:
                return null;
        }
    }
}
