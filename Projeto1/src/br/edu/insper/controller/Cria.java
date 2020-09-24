package br.edu.insper.controller;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.model.DAO;
import br.edu.insper.model.Jogos;


@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
		try {
			dao = new DAO();
			
			Jogos jogo = new Jogos();
			jogo.setNome(request.getParameter("nome"));
			
			String data = request.getParameter("data");
			java.util.Date lancamento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar dataLancamento = Calendar.getInstance();
			dataLancamento.setTime(lancamento);
			jogo.setData(dataLancamento);
			
			jogo.setTamanho(Integer.valueOf(request.getParameter("tamanho")));
			
			dao.adiciona(jogo);
			
			request.setAttribute("jogo", jogo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Mostra");
			dispatcher.forward(request,response);
			
			dao.close();
			
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
	}

}
