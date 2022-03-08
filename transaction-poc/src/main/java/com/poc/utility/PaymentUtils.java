package com.poc.utility;

import java.util.HashMap;
import java.util.Map;

import com.poc.exception.InSufficiantFund;

public class PaymentUtils {

	private static Map<String, Double> paymentMap = new HashMap<>();

	static {
		paymentMap.put("acc1", 12000.0);
		paymentMap.put("acc2", 2000.0);
		paymentMap.put("acc3", 102000.0);
		paymentMap.put("acc4", 120000.0);
		paymentMap.put("acc5", 32000.0);

	}

	public static boolean validateCreditLimit(String accNo, double paidAmout) {
		if (paidAmout > paymentMap.get(accNo)) {
			throw new InSufficiantFund("Insufficiant amount of " + paidAmout + " for amount : " + paidAmout);

		} else {
			return true;
		}

	}

}
