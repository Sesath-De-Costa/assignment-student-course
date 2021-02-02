package lk.ijse.dep.api; /**
 * Created by Sesath De Costa on 2021-02-02
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.BOTypes;
import lk.ijse.dep.business.custom.StudentBO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.exception.HttpResponseException;
import lk.ijse.dep.exception.ResponseExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "StudentServlet", value = "/api/v1/students/*")
public class StudentServlet extends HttpServlet {
    final Logger logger = LoggerFactory.getLogger(StudentServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid student id", null);
            }
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            studentBO.deleteStudent(id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid student id", null);
            }
            String id = req.getPathInfo().replace("/", "");
            Jsonb jsonb = JsonbBuilder.create();
            StudentDTO dto = jsonb.fromJson(req.getReader(), StudentDTO.class);
            if (dto.getId() > 0 || dto.getAddress() == null || dto.getDob() == null || dto.getGender() == null || dto.getName().trim().isEmpty() || dto.getContact().trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid details", null);
            }
            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            studentBO.updateStudent(dto);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            response.setContentType("application/json");
            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            response.getWriter().println(jsonb.toJson(studentBO.getAllStudent()));
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, response);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        System.out.println("1 awa mulata");
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            StudentDTO dto = jsonb.fromJson(request.getReader(), StudentDTO.class);
            if (dto.getId() < 1 || dto.getAddress() == null || dto.getDob() == null || dto.getGender() == null || dto.getName().trim().isEmpty() || dto.getContact().trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid details", null);
            }
            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            studentBO.saveStudent(dto);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json");
            response.getWriter().println(jsonb.toJson(dto));
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
