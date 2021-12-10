package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CreditBB {
	private Double x = 0.00;
	private int time = 0;
	private Double percentage = 0.0;
	private Double result;

	@Inject
	FacesContext ctx;

	
	


	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Double getResult() {
		return result;
	}

	public boolean doTheMath() {
		try {
			double x = this.x;
			int time = this.time;
			double interest = this.percentage/100;
			double i = interest/12; // Oprocentowanie na miesi¹c

			result = x*(i*Math.pow(1+i, time))/(Math.pow(1+i, time)-1);
			
			result = (double)Math.round(result * 100d)/100d;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wysokoœæ raty na miesi¹c wynosi : " + this.result + " z³", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad podczas przetwarzania parametrow", null));
			return false;
		}
	}

	public String calc() {
		if (doTheMath()) {
			return null;
		}
		return null;
	}
	
	public void redirect() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("https://www.ican.pl/b/co-powinienes-wiedziec-zanim-wezmiesz-kredyt-gotowkowy/PMgwOzqr7");
	}

}
