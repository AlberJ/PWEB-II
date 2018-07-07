package br.edu.ifpb.pweb.turmas.bean;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.pweb.turmas.dao.AlunoDAO;
import br.edu.ifpb.pweb.turmas.dao.TurmaDAO;
import br.edu.ifpb.pweb.turmas.model.Aluno;
import br.edu.ifpb.pweb.turmas.model.Turma;

@ManagedBean(name = "turmasBean")
@SessionScoped
public class TurmasBean {
	private Turma turma;
	private List<Turma> turmas;
	private LinkedHashMap<Long, Boolean> editavel;
	private String nome;
	private String nome_aluno;
	private Set<Aluno> matriculados;
	private String matricula;
	private String email;

	public String listar() {
		TurmaDAO tDao = new TurmaDAO();
		this.turmas = tDao.findAll();
		editavel = new LinkedHashMap<Long, Boolean>(this.turmas.size());
		for (Turma t : this.turmas) {
			editavel.put(t.getId(), false);
		}
		return "index?faces-redirect=true";
	}

	public String listarMatriculados(Turma turma) {
		matriculados = turma.getAlunos();
		this.turma = turma;
		return "alunos?faces-redirect=true";
	}

	public void salvar(Turma turma) {
		TurmaDAO tDao = new TurmaDAO();
		tDao.beginTransaction();
		tDao.update(turma);
		tDao.commit();
		this.editavel.put(turma.getId(), false);
		this.listar();
	}

	public void excluir(Turma turma) {
		TurmaDAO tDao = new TurmaDAO();
		tDao.beginTransaction();
		tDao.delete(turma);
		tDao.commit();
		this.editavel.put(turma.getId(), false);
		this.turmas = tDao.findAll();
		this.listar();
	}

	public void excluiraluno(Aluno aluno) {
		Long id_turma_do_aluno = aluno.getTurma().getId();
		TurmaDAO tDao = new TurmaDAO();
		Turma turma_do_aluno = tDao.find(id_turma_do_aluno);
		turma_do_aluno.getAlunos().remove(aluno);
		tDao.beginTransaction();
		tDao.update(turma_do_aluno);
		tDao.commit();
		return;
	}

	public String nova() {
		turma = new Turma();
		turma.setNome(nome);
		Date hoje = new Date(System.currentTimeMillis());
		turma.setDataCriacao(hoje);
		TurmaDAO tDao = new TurmaDAO();
		tDao.beginTransaction();
		tDao.insert(turma);
		tDao.commit();
		this.turmas = tDao.findAll();
		return "index?faces-redirect=true";
	}

	public String matricular() {
		Aluno aluno = new Aluno();
		AlunoDAO aDao = new AlunoDAO();
		aDao.beginTransaction();
		aluno.setMatricula(matricula);
		aluno.setNome(nome_aluno);
		aluno.setEmail(email);
		aDao.insert(aluno);
		aDao.commit();

		TurmaDAO tDao = new TurmaDAO();
		tDao.beginTransaction();
		Turma turma_aluno = tDao.find(turma.getId());
		turma_aluno.addAluno(aluno);
		tDao.commit();

		return "alunos";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public LinkedHashMap<Long, Boolean> getEditavel() {
		return editavel;
	}

	public void setEditavel(LinkedHashMap<Long, Boolean> editavel) {
		this.editavel = editavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public Set<Aluno> getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(Set<Aluno> matriculados) {
		this.matriculados = matriculados;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
