package com.fss.cms.CurrencyExchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fss.cms.CurrencyExchange.dto.CurrencyExchangeDTO;
import com.fss.cms.CurrencyExchange.modals.CurrencyExchange;
import com.fss.cms.CurrencyExchange.service.CurrencyExchangeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/currencyexchange", description = "Services used to get the exchange rate")
public class CurrencyExchangeController {

	Logger logger = LoggerFactory.getLogger("currencyexchange");

	@Autowired
	CurrencyExchangeService currencyExchangeService;

	@ApiOperation(value = "API For Fetching Exchange rate", notes = "calculate the exchange rate for todays rate")
	@RequestMapping(value = "/getexchangerate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CurrencyExchangeDTO getCurrencyExchangeRate(@ApiParam(
            value = "Value given as parameter to calculate exchange rate" ,
            example = "{sourceCurrencyId: 356, targetCurrencyId: 840, sourceCurrValue: 2}") @RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
		try {
			logger.info("Get Exchange Rate");

			CurrencyExchange currencyExchange = currencyExchangeService.dTOtoModal(currencyExchangeDTO);
			currencyExchangeService.getCurrencyExchangeRate(currencyExchange);
			currencyExchangeService.modaltoDTO(currencyExchangeDTO, currencyExchange);

			currencyExchangeDTO.setResponseCode(0);
			currencyExchangeDTO.setResponseMsg("Success");
		} catch (Exception e) {
			logger.debug("Exception occured while getting exchange rate ", e);
			logger.error("Exception occured while getting exchange rate ", e);
			currencyExchangeDTO.setResponseCode(1);
			currencyExchangeDTO.setResponseMsg("failed");
		} finally {
			if (currencyExchangeDTO.getResponseCode() != 0) {
				currencyExchangeDTO.setResponseCode(1);
				currencyExchangeDTO.setResponseMsg("failed");
			}
		}
		return currencyExchangeDTO;
	}

	@ApiOperation(value = "API For Fetching Exchange rate for the given date", notes = "calculate the exchange rate for the date")
	@RequestMapping(value = "/fetchexchangerate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CurrencyExchangeDTO fetchCurrencyExchangeRate(@ApiParam(
            value = "Value given as parameter to calculate exchange rate for the given date" ,
            example = "{sourceCurrencyId: 356, targetCurrencyId: 840, sourceCurrValue: 2, exchangeRateDate: 22/04/2020}") @RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
		try {
			logger.info("Get Exchange Rate");
			if (currencyExchangeService.fetchCurrencyExchangeRatevalidation(currencyExchangeDTO)) {
				CurrencyExchange currencyExchange = currencyExchangeService.dTOtoModal(currencyExchangeDTO);
				currencyExchangeService.fetchCurrencyExchangeRate(currencyExchange);
				currencyExchangeService.modaltoDTO(currencyExchangeDTO, currencyExchange);

				currencyExchangeDTO.setResponseCode(0);
				currencyExchangeDTO.setResponseMsg("Success");
			} else {
				currencyExchangeDTO.setResponseCode(1);
				currencyExchangeDTO.setResponseMsg("Invalid Date Format");
			}
		} catch (Exception e) {
			logger.debug("Exception occured while getting exchange rate ", e);
			logger.error("Exception occured while getting exchange rate ", e);
			currencyExchangeDTO.setResponseCode(1);
			currencyExchangeDTO.setResponseMsg("failed");
		} finally {
			if (currencyExchangeDTO.getResponseCode() != 0 && currencyExchangeDTO.getResponseCode() != 1) {
				currencyExchangeDTO.setResponseCode(1);
				currencyExchangeDTO.setResponseMsg("failed");
			}
		}
		return currencyExchangeDTO;
	}

}
