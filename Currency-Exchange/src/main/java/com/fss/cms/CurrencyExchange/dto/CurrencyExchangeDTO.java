package com.fss.cms.CurrencyExchange.dto;

import java.util.Date;

public class CurrencyExchangeDTO {

	private int sourceCurrencyId;
	private int targetCurrencyId;
	private double sourceCurrValue;
	private double targetCurrValue;
	private String exchangeRateDate;
	private int responseCode;
	private String responseMsg;

	public String getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(String exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
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

	@Override
	public String toString() {
		return "CurrencyExchangeDTO [sourceCurrencyId=" + sourceCurrencyId + ", targetCurrencyId=" + targetCurrencyId
				+ ", sourceCurrValue=" + sourceCurrValue + ", targetCurrValue=" + targetCurrValue + ", responseCode="
				+ responseCode + ", responseMsg=" + responseMsg + "]";
	}

}
