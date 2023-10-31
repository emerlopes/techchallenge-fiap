package br.com.ar.arinvest.controller.exceptions;

public class ControllerNotFoundException extends RuntimeException {
        public ControllerNotFoundException(String message) {
            super(message);
        }
}
