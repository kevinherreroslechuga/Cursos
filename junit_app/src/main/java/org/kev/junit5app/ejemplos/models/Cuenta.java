package org.kev.junit5app.ejemplos.models;

import org.kev.junit5app.ejemplos.esceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;//ES EL MAS PRESISO AL TRABAJAR CON DINERO, ES MAS EFICIENTE, LOS CALCULOS SE REALIZAN CON CALCULO HUMANO
    private Banco banco;

    public Cuenta(String persona, BigDecimal saldo) {
        this.saldo = saldo;
        this.persona = persona;

    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void debito(BigDecimal monto){
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);//cuando se modifica un bigdecimal se cre un nuevo bigdecimal
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
           throw new DineroInsuficienteException("Dinero Insuficiente");
        }
        this.saldo = nuevoSaldo;

    }

    public void credito(BigDecimal monto){
        this.saldo = this.saldo.add(monto);//bigdecimal es inmutable

    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta)obj;
        if (this.persona == null || this.saldo == null){
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }
}
