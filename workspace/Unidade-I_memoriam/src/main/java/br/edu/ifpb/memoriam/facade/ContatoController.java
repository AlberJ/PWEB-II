package br.edu.ifpb.memoriam.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import br.edu.ifpb.memoriam.dao.ContatoDAO;
import br.edu.ifpb.memoriam.dao.OperadoraDAO;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entity.Contato;
import br.edu.ifpb.memoriam.entity.Operadora;
import br.edu.ifpb.memoriam.entity.Usuario;

public class ContatoController {

	private Contato contato;
	private Operadora operadora;
	private List<String> mensagensErro;

	public List<Contato> consultarContato(Usuario usuario) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.findAllFromUser(usuario);
		return contatos;
	}

	

	public Contato buscarContato(Map<String, String[]> parametros) {
		String id = parametros.get("id")[0];
		ContatoDAO dao = new ContatoDAO();
		Contato localizado = dao.find(Integer.parseInt(id));

		return localizado;
	}

	public Resultado excluirContato(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		String[] selecionados = parametros.get("id");
		ContatoDAO dao = new ContatoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		for (int i = 0; i < selecionados.length; i++) {
			dao.delete(dao.find(Integer.parseInt(selecionados[i])));
		}
		dao.commit();
		resultado.setErro(false);
		return resultado;
	}

	public Resultado cadastrarContato(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		if (isParametrosValidos(parametros)) {
			ContatoDAO dao = new ContatoDAO(PersistenceUtil.getCurrentEntityManager());
			dao.beginTransaction();
			if (this.contato.getId() == null) {
				dao.insert(this.contato);
			} else {
				dao.update(this.contato);
			}
			dao.commit();
			resultado.setErro(false);
			Mensagem mensagem = new Mensagem();
			mensagem.setMensagem("Contato criado com sucesso!");
			mensagem.setCategoria(Categoria.AVISO);
			resultado.addMensagem(mensagem);
		} else {
			resultado.setEntidade(this.contato);
			resultado.setErro(true);
			Mensagem mensagem = new Mensagem();
			mensagem.setMensagem("não foi possível criar contato!");
			mensagem.setCategoria(Categoria.ERRO);
			resultado.addMensagem(mensagem);
		}
		return resultado;

	}

	private boolean isParametrosValidos(Map<String, String[]> parametros) {
		String[] id = parametros.get("id");
		String[] nome = parametros.get("nome");
		String[] fone = parametros.get("fone");
		String[] dataAniv = parametros.get("dataaniv");

		this.contato = new Contato();
		this.mensagensErro = new ArrayList<String>();

		if (id != null && id.length > 0 && !id[0].isEmpty()) {
			contato.setId(Integer.parseInt(id[0]));
		}

		if (nome == null || nome.length == 0 || nome[0].isEmpty()) {
			this.mensagensErro.add("Nome é campo obrigatório");
		} else {
			contato.setNome(nome[0]);
		}

		if (fone == null || fone.length == 0 || fone[0].isEmpty()) {
			this.mensagensErro.add("fone é campo obrigatório");
		} else {
			contato.setFone(fone[0]);
		}

		if (dataAniv == null || dataAniv.length == 0 || dataAniv[0].isEmpty()) {
			this.mensagensErro.add("Data de aniversário é campo obrigatório");

		} else {
			if (dataAniv[0].matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2,2}")) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false);
					Date dataIni = sdf.parse(dataAniv[0]);
					contato.setDataAniversario(dataIni);
				} catch (ParseException e) {
					this.mensagensErro.add("Data inválida para a data de aniversário");
				}
			} else {
				this.mensagensErro.add("Formato inválido para data de aniversário (use dd/mm/aaaa)!");
			}
		}

		Operadora operadora = null;
		String idOperadora = parametros.get("operadora")[0];
		if (idOperadora != null) {
			OperadoraDAO opDao = new OperadoraDAO(PersistenceUtil.getCurrentEntityManager());
			operadora = opDao.find(Integer.parseInt(idOperadora));
		}
		contato.setOperadora(operadora);
		return this.mensagensErro.isEmpty();
	}
}