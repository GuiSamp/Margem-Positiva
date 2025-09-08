package br.com.margempositiva.backend.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String msg){
        super(msg);
    }
}
