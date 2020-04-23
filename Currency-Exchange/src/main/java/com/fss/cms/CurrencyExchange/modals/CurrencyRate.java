package com.fss.cms.CurrencyExchange.modals;

public class CurrencyRate {

	private int targetCurrency;
	private double exchangeRate;
	
	public CurrencyRate() {
	}
	
	public CurrencyRate(int targetCurrency, double exchangeRate) {
		this.targetCurrency = targetCurrency;
		this.exchangeRate = exchangeRate;
	}
	public int getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(int targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	@Override
	public String toString() {
		return "CurrencyRate [targetCurrency=" + targetCurrency + ", exchangeRate=" + exchangeRate + "]";
	}
	
}
