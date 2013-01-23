package com.alipay.commons;

public class PrizeNumberLessException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrizeNumberLessException(){
        super();
    }
    
	public PrizeNumberLessException(Throwable cause){
        super(cause);
    }

    public PrizeNumberLessException(String errorDesc, Throwable cause) {
        super(errorDesc, cause);
    }

    public PrizeNumberLessException(String errorDesc) {
        super(errorDesc);
    }
}
