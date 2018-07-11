package br.edu.ifpb.pweb.bean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "conversor")
@RequestScoped
public class Conversor {

	private double F;
	private double C;
	private double fConvertido;
	private double cConvertido;

	public String converter(Integer escala) {

		switch (escala) {
		case 1:
			cConvertido =  (F - 32 * (5.0 / 9.0));
			System.out.println("->"+cConvertido);
			break;
		case 2:
			fConvertido =  ((C * 1.8) + 32);
			System.out.println("=>"+fConvertido);
			break;

		default:
			break;
		}

		return null;
	}

	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getfConvertido() {
		return fConvertido;
	}

	public void setfConvertido(double fConvertido) {
		this.fConvertido = fConvertido;
	}

	public double getcConvertido() {
		return cConvertido;
	}

	public void setcConvertido(double cConvertido) {
		this.cConvertido = cConvertido;
	}


}
