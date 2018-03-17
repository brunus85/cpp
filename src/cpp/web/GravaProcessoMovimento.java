package cpp.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpp.controller.Tarefa;
import cpp.dao.MovimentoDAO;
import cpp.dao.ProcessoDAO;
import cpp.jdbc.ConnectionPool;
import cpp.model.Movimento;
import cpp.model.Processo;

public class GravaProcessoMovimento implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Integer id_processo = null;
		String num_proc = request.getParameter("num_proc");
		String comarca = request.getParameter("comarca");
		Integer id_vara = Integer.parseInt(request.getParameter("id_vara"), 10);
		String classe = request.getParameter("classe");
		String assunto = request.getParameter("assunto");
		String distribuicao = request.getParameter("distribuicao");
		String autor = request.getParameter("autor");
		String parte = request.getParameter("parte");

		Processo processo = new Processo(num_proc);
		processo.setComarca(comarca);
		processo.setIdVara(id_vara);
		processo.setClasse(classe);
		processo.setAssunto(assunto);
		processo.setDistribuicao(distribuicao);
		processo.setAutor(autor);
		processo.setParte(parte);

		// Recuperando dados do movimento
		String manifestacao = request.getParameter("manifestacao");
		String destino = request.getParameter("destino");
		String responsavel = request.getParameter("responsavel");
		//String data = request.getParameter("data");

		Movimento movimento = new Movimento(id_processo, manifestacao, destino, responsavel);

		try (Connection conn = new ConnectionPool().getConnection()) {
			ProcessoDAO daoProcesso = new ProcessoDAO(conn);
			id_processo = daoProcesso.gravaProcesso(processo);
			

			movimento.setIdProcesso(id_processo);
			
			System.out.println(movimento.toString());
			
			MovimentoDAO movDAO = new MovimentoDAO(conn);
			movDAO.gravaMovimento(movimento);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "/WEB-INF/paginas/cp_registraProcessoMovimentoOk.jsp";
	}

}
