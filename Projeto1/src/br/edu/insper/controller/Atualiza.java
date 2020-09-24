package br.edu.insper.controller;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Atualiza() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/atualiza.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
	
		try {
			dao = new DAO();
			
			Jogos jogo = new Jogos();
			jogo.setId(Integer.valueOf(request.getParameter("id")));
			jogo.setNome(request.getParameter("nome"));
			
			String data = request.getParameter("data");
			java.util.Date lancamento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar dataLancamento = Calendar.getInstance();
			dataLancamento.setTime(lancamento);
			jogo.setData(dataLancamento);
			
			jogo.setTamanho(Integer.valueOf(request.getParameter("tamanho")));
			jogo.setCategoria(request.getParameter("categoria"));
			
			dao.altera(jogo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Mostra");
			dispatcher.forward(request,response);
			
			dao.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
