package br.edu.ifpb.bibliotecaweb.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.edu.ifpb.bibliotecaweb.dao.UsuarioDAO;
import br.edu.ifpb.bibliotecaweb.entidade.Usuario;

public class UsuarioController {

	private List<String> mensagensErro;
	private EntityManager entityManager;

	public UsuarioController(EntityManager em) {
		this.entityManager = em;
	}

	public Resultado cadastre(Map<String, String[]> parametros) {

		Resultado resultado = new Resultado();
		Usuario usuario = null;

		if ((usuario = fromParametros(parametros)) != null) {
			UsuarioDAO dao = new UsuarioDAO(entityManager);
			dao.beginTransaction();
			usuario.setStatus(true);

			if (usuario.getId() == null) {
				dao.insert(usuario);
				resultado.setErro(false);
			} else
				dao.update(usuario);
			resultado.setErro(false);
			dao.commit();
		} else {
			resultado.setEntidade(usuario);
			resultado.setErro(true);
			resultado.setMensagens(this.mensagensErro);
		}
		return resultado;
	}

	public Resultado soliciteCadastro(Map<String, String[]> parametros) {

		Usuario usuario = null;
		Resultado resultado = new Resultado();

		if ((usuario = fromParametros(parametros)) != null) {
			UsuarioDAO dao = new UsuarioDAO(entityManager);
			dao.beginTransaction();
			usuario.setStatus(false);
			dao.insert(usuario);
			dao.commit();
			resultado.setErro(false);
			this.mensagensErro.add("Usuario cadastrado com sucesso, aguarde ativa��o");
			resultado.setMensagens(mensagensErro);
		}
		else {
			resultado.setErro(true);
			resultado.setMensagens(mensagensErro);
		}
		return resultado;
	}

	private Usuario fromParametrosEditando(Map<String, String[]> parametros) {

		String[] id = parametros.get("id");
		String[] email = parametros.get("email");
		String[] nome = parametros.get("nome");
		String[] perfil = parametros.get("perfil");
		String[] senha = parametros.get("senha");
		String[] fone = parametros.get("fone");
		String[] dataAniv = parametros.get("dataaniv");

		this.mensagensErro = new ArrayList<String>();
		Usuario usuario = new Usuario();

		if (id != null && id.length > 0 && !id[0].isEmpty()) {
			usuario.setId(Integer.parseInt(id[0]));
		}

		if (email == null || email.length == 0 || email[0].isEmpty()) {
			this.mensagensErro.add("Email � campo obrigat�rio");
		} else {
			usuario.setEmail(email[0]);
		}

		if (nome == null || nome.length == 0 || nome[0].isEmpty()) {
			this.mensagensErro.add("Nome � campo obrigat�rio");
		} else {
			usuario.setNome(nome[0]);
		}

		if (perfil == null || perfil.length == 0 || perfil[0].isEmpty()) {
			this.mensagensErro.add("Perfil � campo obrigat�rio");
		} else {
			usuario.setPerfil(perfil[0]);
		}

		if (senha == null || senha.length == 0 || senha[0].isEmpty()) {
			this.mensagensErro.add("Senha � campo obrigat�rio");
		} else {
			usuario.setSenha(senha[0]);
		}

		if (fone == null || fone.length == 0 || fone[0].isEmpty()) {
			this.mensagensErro.add("Telefone � campo obrigat�rio");
		} else {
			usuario.setFone(fone[0]);
		}

		if (dataAniv == null || dataAniv.length == 0 || dataAniv[0].isEmpty()) {
			this.mensagensErro.add("Data de anivers�rio � campo obrigat�rio");
		} else {
			if (dataAniv[0].matches("(19|20)\\d{2,2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					sdf.setLenient(false); // verifica datas inv�lidas ex: 30 de fevereiro
					Date dataIni = sdf.parse(dataAniv[0]);
					usuario.setDataAniversario(dataIni);
				} catch (ParseException e) {
					this.mensagensErro.add("Data inv�lido para a data de anivers�rio!");
				}
			} else {
				this.mensagensErro.add("Formato inv�lido para a data de anivers�rio (use dd/mm/aaaa)!");
			}
		}
		return this.mensagensErro.isEmpty() ? usuario : null;
	}

	private Usuario fromParametros(Map<String, String[]> parametros) {

		String[] id = parametros.get("id");
		String[] matricula = parametros.get("matricula");
		String[] email = parametros.get("email");
		String[] nome = parametros.get("nome");
		String[] perfil = parametros.get("perfil");
		String[] senha = parametros.get("senha");
		String[] fone = parametros.get("fone");
		String[] dataAniv = parametros.get("dataaniv");

		Usuario usuario = new Usuario();
		this.mensagensErro = new ArrayList<String>();

		if (id != null && id.length > 0 && !id[0].isEmpty()) {
			usuario.setId(Integer.parseInt(id[0]));
		}

		if (email == null || email.length == 0 || email[0].isEmpty()) {
			this.mensagensErro.add("Email � campo obrigat�rio");
		} else {
			usuario.setEmail(email[0]);
		}

		if (nome == null || nome.length == 0 || nome[0].isEmpty()) {
			this.mensagensErro.add("Nome � campo obrigat�rio");
		} else {
			usuario.setNome(nome[0]);
		}

		if (perfil == null || perfil.length == 0 || perfil[0].isEmpty()) {
			this.mensagensErro.add("Perfil � campo obrigat�rio");
		} else {
			usuario.setPerfil(perfil[0]);
		}

		if (matricula == null || matricula.length == 0 || matricula[0].isEmpty()) {
			this.mensagensErro.add("Matr�cula � campo obrigat�rio");
		} else {
			usuario.setMatricula(matricula[0]);
		}

		if (matricula != null && matricula.length > 0 && !matricula[0].isEmpty()) {
			UsuarioDAO dao = new UsuarioDAO(entityManager);
			List<Usuario> usuarios = dao.findAll();
			boolean matricula_cadastrada = false;
			boolean email_cadastrado = false;
			for (Usuario usuario_m : usuarios) {

				if (usuario_m.getMatricula().equals(matricula[0])) {
					matricula_cadastrada = true;
				}
				if (usuario_m.getEmail().equals(email[0])) {
					email_cadastrado = true;
				}
			}
			if (matricula_cadastrada) {
				this.mensagensErro.add("A matr�cula informada j� � cadastrada na Biblioteca.");
			}
			if (email_cadastrado) {
				this.mensagensErro.add("E-mail informado j� � utilizado por outro usu�rio.");
			}
		}

		if (senha == null || senha.length == 0 || senha[0].isEmpty()) {
			this.mensagensErro.add("Senha � campo obrigat�rio");
		} else {
			usuario.setSenha(senha[0]);
		}

		if (fone == null || fone.length == 0 || fone[0].isEmpty()) {
			this.mensagensErro.add("Telefone � campo obrigat�rio");
		} else {
			usuario.setFone(fone[0]);
		}

		if (dataAniv == null || dataAniv.length == 0 || dataAniv[0].isEmpty()) {
			this.mensagensErro.add("Data de anivers�rio � campo obrigat�rio");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date hoje = new Date(System.currentTimeMillis());
			Date nascimento = null;
			try {
				nascimento = sdf.parse(dataAniv[0]);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			if (hoje.before(nascimento)) {
				this.mensagensErro.add("A data de nascimento n�o pode ser posterior a data atual");
			}

			if (dataAniv[0].matches("(19|20)\\d{2,2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")) {
				try {
					sdf.setLenient(false); // verifica datas inv�lidas ex: 30 de fevereiro
					Date dataIni = sdf.parse(dataAniv[0]);
					usuario.setDataAniversario(dataIni);
				} catch (ParseException e) {
					this.mensagensErro.add("Data inv�lido para a data de anivers�rio!");
				}
			} else {
				this.mensagensErro.add("Formato inv�lido para a data de anivers�rio (use dd/mm/aaaa)!");
			}
		}
		return this.mensagensErro.isEmpty() ? usuario : null;
	}

	public List<Usuario> liste() {
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		List<Usuario> usuarios = dao.findAll();
		return usuarios;
	}

	public List<Usuario> listeInativos() {
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		List<Usuario> usuarios = dao.findInativos();
		return usuarios;
	}

	public List<Usuario> listeAtivos() {
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		List<Usuario> usuarios = dao.findAtivos();
		return usuarios;
	}

	public Usuario busque(Map<String, String[]> parameterMap) {
		String[] id = parameterMap.get("id");
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuario = dao.find(Integer.parseInt(id[0]));
		return usuario;
	}

	public void ative(Map<String, String[]> parameterMap) {
		String[] id = parameterMap.get("id");
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuario = dao.find(Integer.parseInt(id[0]));
		dao.beginTransaction();
		usuario.setStatus(true);
		dao.update(usuario);
		dao.commit();
	}

	public void desative(Map<String, String[]> parameterMap) {
		String[] id = parameterMap.get("id");
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuario = dao.find(Integer.parseInt(id[0]));
		dao.beginTransaction();
		usuario.setStatus(false);
		dao.update(usuario);
		dao.commit();

	}

	public Usuario busqueMatricula(Map<String, String[]> parameterMap) {
		String[] matricula = parameterMap.get("matricula");
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuario = dao.findByMatricula(matricula[0]);
		return usuario;
	}

	public Resultado atualize(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		Usuario usuario = null;

		if ((usuario = fromParametrosEditando(parametros)) != null) {
			UsuarioDAO dao = new UsuarioDAO(entityManager);
			dao.beginTransaction();
			usuario.setStatus(true);
			dao.update(usuario);
			resultado.setErro(false);
			dao.commit();
		} else {
			resultado.setEntidade(usuario);
			resultado.setErro(true);
			resultado.setMensagens(this.mensagensErro);
		}
		return resultado;
	}
}
