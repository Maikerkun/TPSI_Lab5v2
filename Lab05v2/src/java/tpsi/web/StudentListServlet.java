/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maikeru
 */
@WebServlet(name = "StudentListServlet", urlPatterns = {"/studentList"})
public class StudentListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("licznik")==null)
        {
            session.setAttribute("licznik",1);
        }
        else
        {
            session.setAttribute("licznik", (Integer)session.getAttribute("licznik")+1);
        }
        
        
        
        request.getRequestDispatcher("studentList.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("licznik")==null)
        {
            session.setAttribute("licznik",1);
        }
        else
        {
            
            session.setAttribute("licznik", (Integer)session.getAttribute("licznik")+1);
        }
        
        String imie = request.getParameter("s_imie");
        String nazwisko = request.getParameter("s_nazwisko");
        String email = request.getParameter("s_email");
        
        Student nowy_student = new Student(imie, nazwisko, email);
        
        if(session.getAttribute("lista_studentow")==null)
        {
            List<Student> studenci = new ArrayList<>();
             studenci.add(nowy_student);
            session.setAttribute("lista_studentow",studenci);
        }
        else
        {
            List<Student> studenci = (List<Student>) session.getAttribute("lista_studentow");
            studenci.add(nowy_student);
            session.setAttribute("lista_studentow", studenci);
        }
        
        
        request.getRequestDispatcher("studentList.jsp").forward(request, response);
        
    }

}
