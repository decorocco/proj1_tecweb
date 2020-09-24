package br.edu.insper.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import br.edu.insper.model.*;

@WebServlet("/Mostra")
public class Mostra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
		try {
			dao = new DAO();
			
			List<Jogos> jogos = dao.getLista();
			
			request.setAttribute("jogos", jogos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lista.jsp");
			dispatcher.forward(request,response);
			
			dao.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
