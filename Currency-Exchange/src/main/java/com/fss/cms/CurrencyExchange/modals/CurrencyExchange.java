package com.fss.cms.CurrencyExchange.modals;

import java.util.Date;

public class CurrencyExchange {

	private int sourceCurrencyId;
	private int targetCurrencyId;
	private double sourceCurrValue;
	private double targetCurrValue;
	private String sourceCurrency;
	private String targetCurrency;
	private String exchangeRateDate;

	public String getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(String exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public int getSourceCurrencyId() {
		return sourceCurrencyId;
	}

	public void setSourceCurrencyId(int sourceCurrencyId) {
		this.sourceCurrencyId = sourceCurrencyId;
	}

	public int getTargetCurrencyId() {
		return targetCurrencyId;
	}

	public void setTargetCurrencyId(int targetCurrencyId) {
		this.targetCurrencyId = targetCurrencyId;
	}

	public double getSourceCurrValue() {
		return sourceCurrValue;
	}

	public void setSourceCurrValue(double sourceCurrValue) {
		this.sourceCurrValue = sourceCurrValue;
	}

	public double getTargetCurrValue() {
		return targetCurrValue;
	}

	public void setTargetCurrValue(double targetCurrValue) {
		this.targetCurrValue = targetCurrValue;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [sourceCurrencyId=" + sourceCurrencyId + ", targetCurrencyId=" + targetCurrencyId
				+ ", sourceCurrValue=" + sourceCurrValue + ", targetCurrValue=" + targetCurrValue + ", sourceCurrency="
				+ sourceCurrency + ", targetCurrency=" + targetCurrency + "]";
	}

}
