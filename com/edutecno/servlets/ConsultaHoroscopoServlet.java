package com.edutecno.servlets;

import com.edutecno.dao.HoroscopoDAOImp;
import com.edutecno.modelo.Horoscopo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultaHoroscopo")
public class ConsultaHoroscopoServlet extends HttpServlet {
    private HoroscopoDAOImp horoscopoDAO = new HoroscopoDAOImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Horoscopo> horoscopos = horoscopoDAO.obtenerHoroscopo();
        request.setAttribute("horoscopos", horoscopos);
        request.getRequestDispatcher("consultaHoroscopo.jsp").forward(request, response);
    }
}


