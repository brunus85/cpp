package cpp.model;


import java.sql.Connection;
import java.sql.SQLException;

import cpp.dao.ProcessoDAO;
import cpp.jdbc.ConnectionPool;

public class Processo {

	Integer id;
	String comarca;
	String num_processo;
	Integer id_vara;
	String classe;
	String assunto;
	String distribuicao;
	String autor;
	String denunciado;

	public void setNumProc(String num_proc) {
		this.num_processo = num_proc;
		
	}


	public void setId(int id) {
		this.id = id;
		
	}
	

}
