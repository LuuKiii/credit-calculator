package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CreditBB {
	private Double x;
	private Double time;
	private Double percentage;
	private Double result=0.0;

	@Inject
	FacesContext ctx;

	
	


	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
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
			double time = this.time;
			double percentage = this.percentage;

			result = (x * percentage/100)+(x/time);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie" + this.result , null));
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

}
