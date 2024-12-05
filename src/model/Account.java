package model;

public class Account {
    private String iban;
    private double saldo;
    private Customer cliente;


    public Account(String iban, double saldo, Customer cliente) {
        this.iban = iban;
        this.saldo = saldo;
        this.cliente = cliente;
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cuenta [IBAN=" + iban + ", Saldo=" + saldo + ", Cliente=" + cliente + "]";
    }
}