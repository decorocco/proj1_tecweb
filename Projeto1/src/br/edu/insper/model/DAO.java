package br.edu.insper.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	
private Connection connection = null;
	
	public DAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "root");
	}
	
	public List<Jogos> getLista() throws SQLException {
		
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM Jogos");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			Jogos jogo = new Jogos();
			jogo.setId(rs.getInt("id"));
			jogo.setNome(rs.getString("nome"));
			
			Calendar data =Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			jogo.setData(data);
			
			jogo.setTamanho(rs.getInt("tamanho"));
			
			jogos.add(jogo);
		}
		rs.close();
		stmt.close();
		
		return jogos;
	}
	
	public void adiciona(Jogos jogo) throws SQLException {
		String sql = "INSERT INTO Jogos" + "(nome, data, tamanho) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, jogo.getNome());
		stmt.setDate(2, new java.sql.Date(jogo.getData().getTimeInMillis()));
		stmt.setDouble(3, jogo.getTamanho());
		stmt.execute();
		stmt.close();
	}
	
	public void altera(Jogos jogo) throws SQLException {
		String sql = "UPDATE Jogos SET " + "nome=?, data=?, tamanho=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, jogo.getNome());
		stmt.setDate(2, new java.sql.Date(jogo.getData().getTimeInMillis()));
		stmt.setInt(4, jogo.getTamanho());
		stmt.setInt(5, jogo.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Jogos WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void close() throws SQLException {
		connection.close();
	}
}
