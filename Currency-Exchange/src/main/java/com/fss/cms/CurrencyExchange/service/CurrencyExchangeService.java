package com.fss.cms.CurrencyExchange.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fss.cms.CurrencyExchange.dto.CurrencyExchangeDTO;
import com.fss.cms.CurrencyExchange.modals.CurrencyExchange;
import com.fss.cms.CurrencyExchange.modals.CurrencyRate;

@Service
public class CurrencyExchangeService {

	Logger logger = LoggerFactory.getLogger("currencyexchange");

	private static HashMap<Integer, HashMap<String, List<CurrencyRate>>> exchangeRateHashMap = new HashMap<Integer, HashMap<String, List<CurrencyRate>>>();

	String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	 
	Pattern pattern = Pattern.compile(regex);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public boolean fetchCurrencyExchangeRatevalidation(CurrencyExchangeDTO currencyExchangeDTO) {
		if(pattern.matcher(currencyExchangeDTO.getExchangeRateDate()).matches()) {
			return true;
		}
		return false;
	}
	
	public CurrencyExchangeService() throws ParseException {
		ArrayList<CurrencyRate> currencyRates = new ArrayList<CurrencyRate>();
		HashMap<String, List<CurrencyRate>> exchgRateMap = new HashMap<String, List<CurrencyRate>>();
		currencyRates.add(new CurrencyRate(840, 76.1));
		logger.debug("Date :: " + dateFormat.format(new java.util.Date()));
		exchgRateMap.put("23/04/2020", currencyRates);
		ArrayList<CurrencyRate> dtcurrencyRates = new ArrayList<CurrencyRate>();
		dtcurrencyRates.add(new CurrencyRate(840, 75.1));
		exchgRateMap.put("22/04/2020", dtcurrencyRates);

		exchangeRateHashMap.put(356, exchgRateMap);
	}

	public CurrencyExchange dTOtoModal(CurrencyExchangeDTO currencyExchangeDTO) {
		CurrencyExchange currencyExchange = new CurrencyExchange();
		currencyExchange.setSourceCurrencyId(currencyExchangeDTO.getSourceCurrencyId());
		currencyExchange.setTargetCurrencyId(currencyExchangeDTO.getTargetCurrencyId());
		currencyExchange.setSourceCurrValue(currencyExchangeDTO.getSourceCurrValue());
		currencyExchange.setExchangeRateDate(currencyExchangeDTO.getExchangeRateDate());
		return currencyExchange;
	}

	public CurrencyExchangeDTO modaltoDTO(CurrencyExchangeDTO currencyExchangeDTO, CurrencyExchange currencyExchange) {
		currencyExchangeDTO.setTargetCurrValue(currencyExchange.getTargetCurrValue());
		currencyExchangeDTO.setExchangeRateDate(currencyExchange.getExchangeRateDate());
		return currencyExchangeDTO;
	}

	public CurrencyExchange getCurrencyExchangeRate(CurrencyExchange currencyExchange) throws ParseException {
		currencyExchange.setExchangeRateDate(dateFormat.format(new java.util.Date()));
		if (logger.isDebugEnabled())
			logger.debug("Get Exchange rate source Curr :: {} | Target Curr :: {} | Source Currency Value :: {} ",
					currencyExchange.getSourceCurrencyId(), currencyExchange.getTargetCurrencyId(),
					currencyExchange.getSourceCurrValue());
		logger.debug("Date2 :: " + currencyExchange.getExchangeRateDate());
		logger.debug("Rate :: " + exchangeRateHashMap.get(currencyExchange.getSourceCurrencyId()).get(currencyExchange.getExchangeRateDate()));
		exchangeRateHashMap.get(currencyExchange.getSourceCurrencyId()).get(currencyExchange.getExchangeRateDate())
				.forEach(currRate -> {
					if (currRate.getTargetCurrency() == currencyExchange.getTargetCurrencyId())
						currencyExchange
								.setTargetCurrValue(currRate.getExchangeRate() * currencyExchange.getSourceCurrValue());
				});
		if (logger.isDebugEnabled())
			logger.debug(
					"Get Exchange rate source Curr :: {} | Target Curr :: {} | Source Currency Value :: {} | Target Value :: {} ",
					currencyExchange.getSourceCurrencyId(), currencyExchange.getTargetCurrencyId(),
					currencyExchange.getSourceCurrValue(), currencyExchange.getTargetCurrValue());
		return currencyExchange;
	}

	public CurrencyExchange fetchCurrencyExchangeRate(CurrencyExchange currencyExchange) throws ParseException {
		if (logger.isDebugEnabled())
			logger.debug("Get Exchange rate source Curr :: {} | Target Curr :: {} | Source Currency Value :: {} | Exchange Rate :: {} ",
					currencyExchange.getSourceCurrencyId(), currencyExchange.getTargetCurrencyId(),
					currencyExchange.getSourceCurrValue(), currencyExchange.getExchangeRateDate());
		exchangeRateHashMap.get(currencyExchange.getSourceCurrencyId()).get(currencyExchange.getExchangeRateDate())
				.forEach(currRate -> {
					if (currRate.getTargetCurrency() == currencyExchange.getTargetCurrencyId())
						currencyExchange
								.setTargetCurrValue(currRate.getExchangeRate() * currencyExchange.getSourceCurrValue());
				});
		if (logger.isDebugEnabled())
			logger.debug(
					"Get Exchange rate source Curr :: {} | Target Curr :: {} | Source Currency Value :: {} | Target Value :: {} ",
					currencyExchange.getSourceCurrencyId(), currencyExchange.getTargetCurrencyId(),
					currencyExchange.getSourceCurrValue(), currencyExchange.getTargetCurrValue());
		return currencyExchange;
	}
}
