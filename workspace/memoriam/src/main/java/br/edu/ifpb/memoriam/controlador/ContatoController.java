package br.edu.ifpb.memoriam.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifpb.memoriam.dao.ContatoDAO;
import br.edu.ifpb.memoriam.dao.OperadoraDAO;
import br.edu.ifpb.memoriam.dao.UsuarioDAO;
import br.edu.ifpb.memoriam.entidade.Contato;
import br.edu.ifpb.memoriam.entidade.Operadora;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class ContatoController {

	private List<String> mensagensErro;
	
	private EntityManager entityManager;
	
	public ContatoController(EntityManager em) {
		this.entityManager = em; 
	}

	public Resultado cadastre(Usuario usuario, Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		Contato contato = null;
		if ((contato = fromParametros(parametros)) != null) {
			ContatoDAO dao = new ContatoDAO(entityManager);
			dao.beginTransaction();
			UsuarioDAO udao = new UsuarioDAO(entityManager);
			usuario = udao.findByLogin(usuario.getEmail());
			contato.setUsuario(usuario);
			if (contato.getId() == null) {
				dao.insert(contato);
			} else {
				dao.update(contato);
			}
			dao.commit();
			resultado.setErro(false);
			String m = "Contato salvo com sucesso";
			resultado.addMensagem(m);
		} else {
			resultado.setEntidade(contato);
			resultado.setErro(true);
			resultado.setMensagens(this.mensagensErro);
		}
		return resultado;
	}

	/** Valida os parâmetros e os transforma em um objeto do tipo Contato. Se houver algum erro, preenche 
	 * a variável de instância listaErros e retorna null.
	 * @param parametros Mapa de parâmetros
	 * @return Um objeto Contato ou null, em caso de erros.
	 */
	private Contato fromParametros(Map<String, String[]> parametros) {
		// os nomes dos parâmetros vêm dos atributos 'name' das tags HTML do
		// formulário
		String[] id = parametros.get("id");
		String[] nome = parametros.get("nome");
		String[] fone = parametros.get("fone");
		String[] dataAniv = parametros.get("dataaniv");

		Contato contato = new Contato();
		this.mensagensErro = new ArrayList<String>();

		if (id != null && id.length > 0 && !id[0].isEmpty()) {
			contato.setId(Integer.parseInt(id[0]));
		}

		if (nome == null || nome.length == 0 || nome[0].isEmpty()) {
			this.mensagensErro.add("Nome é campo obrigatório!");
		} else {
			contato.setNome(nome[0]);
		}

		if (fone == null || fone.length == 0 || fone[0].isEmpty()) {
			this.mensagensErro.add("Fone é campo obrigatório!");
		} else {
			contato.setFone(fone[0]);
		}

		if (dataAniv == null || dataAniv.length == 0 || dataAniv[0].isEmpty()) {
			this.mensagensErro.add("Data de aniversário é campo obrigatório!");
		} else {
			if (dataAniv[0].matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2,2}")) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false); // verifica datas inválidas, ex: 30
											// de fevereiro
					Date dataIni = sdf.parse(dataAniv[0]);
					contato.setDataAniversario(dataIni);
				} catch (ParseException e) {
					this.mensagensErro.add("Data inválida para a data de aniversário!");
				}
			} else {
				this.mensagensErro.add("Formato inválido para a data de aniversário (use dd/mm/aaaa)!");
			}
		}

		// Recupera a operadora selecionada, a partir do seu id
		Operadora operadora = null;
		String idOperadora = parametros.get("operadora")[0];
		if (idOperadora != null && !idOperadora.isEmpty()) {
			OperadoraDAO opDao = new OperadoraDAO(entityManager);
			operadora = opDao.find(Integer.parseInt(idOperadora));
		}
		contato.setOperadora(operadora);

		return this.mensagensErro.isEmpty() ? contato : null;
	}
	
	public List<Contato> consulte(Usuario usuario) {
		ContatoDAO dao = new ContatoDAO(entityManager);
		List<Contato> contatos = dao.findAllFromUser(usuario);
		return contatos;
	}

	public Contato busque(Map<String, String[]> parameterMap)  {
		String[] id = parameterMap.get("id");
		ContatoDAO dao = new ContatoDAO(entityManager);
		Contato contato = dao.find(Integer.parseInt(id[0]));
		return contato;
	}

	public Resultado exclua(Map<String, String[]> parameterMap) {
		String ids[] = parameterMap.get("delids");
		ContatoDAO dao = new ContatoDAO(entityManager);
		Resultado r = new Resultado();
		try {
			dao.beginTransaction();
			for (String id : ids) {
				Contato c = dao.find(Integer.parseInt(id));
				dao.delete(c);
			}
			dao.commit();
			r.setErro(false);
		} catch (PersistenceException e) {
			dao.rollback();
			r.setErro(true);
			r.addMensagem("Erro ao excluir contatos");
		}
		return r;

	}

}
