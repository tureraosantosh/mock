package com.poc.exception;

public class InSufficiantFund extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InSufficiantFund() {
		// TODO Auto-generated constructor stub
	}

	public InSufficiantFund(String msg) {

		super(msg);
	}

}
