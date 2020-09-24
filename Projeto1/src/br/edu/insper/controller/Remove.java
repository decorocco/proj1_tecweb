package br.edu.insper.controller;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.model.DAO;

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAO dao;
		try {
			
			dao = new DAO();
			dao.remove(Integer.valueOf(request.getParameter("id")));
			
			dao.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Mostra");
			dispatcher.forward(request,response);
			
			//dao.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
