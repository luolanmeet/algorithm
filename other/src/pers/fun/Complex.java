package pers.fun;

/**
 * 复数
 */
public class Complex {

	/**
	 * 实部
	 */
	private double real;
	/**
	 * 虚部
	 */
	private double imag;
	
	public Complex() {
	}
		
	public Complex(double real,double imag) {
		this.real=real;
		this.imag=imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public Complex add(Complex x) {
		Complex y = new Complex();
		y.real = this.real + x.real;
		y.imag = this.imag + x.imag;
		return y;
	}
	
	public Complex sub(Complex x) {
		Complex y = new Complex();
		y.real = this.real - x.real;
		y.imag = this.imag - x.imag;
		return y;
	}
	
	public Complex mult(Complex x) {
		Complex y = new Complex();
		y.real = this.real * x.real - this.imag * x.imag;
		y.imag = this.real * x.imag + this.imag * x.real;
		return y;
	}
	
	public Complex pow(int n) {
		Complex y = this;
		for(int i = 1; i < n; i++) {
			y = this.mult(y);
		}
		return y;
	}

}
