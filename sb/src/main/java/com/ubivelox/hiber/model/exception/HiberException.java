package com.ubivelox.hiber.model.exception;

public class HiberException extends Exception
{

    /**
     *
     */
    private static final long serialVersionUID = 6643741653105928267L;





    public HiberException(final String message, final Exception e)
    {
        super(message, e);
    }





    public HiberException(final String message)
    {
        super(message);
    }

}
