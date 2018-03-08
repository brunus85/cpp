package cpp.model;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;
public class Processo {

	Integer id;
	String comarca;
	String num_processo;
	Integer id_vara;
	String classe;
	Setting assunto;
	String distribuicao;
	String autor;
	String denunciado;
	
	public Processo(String num_processo) {
		this.num_processo = num_processo;
	}

	public String buscaProcesso(String num_proc) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
