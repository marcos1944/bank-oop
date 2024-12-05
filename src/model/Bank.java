package model;

import com.sun.source.doctree.EscapeTree;

import java.util.ArrayList;

public class Bank {
    private String nombre;
    private Account[] cuentas;


    public Bank(String nombre, int capacidadCuentas) {
        this.nombre = nombre;
        this.cuentas = new Account[capacidadCuentas];
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Account[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Account[] cuentas) {
        this.cuentas = cuentas;
    }

    public void mostrarCuentas() {
        for (Account cuenta : cuentas) {
            if (cuenta != null) {
                System.out.println(cuenta);
            }
        }
    }

    public Account obtenerCuentaPorIban(String iban) {
        for (Account cuenta : cuentas) {
            if (cuenta != null && cuenta.getIban().equals(iban)) {
                return cuenta;
            }
        }
        return null;
    }

    public Account[] obtenerCuentasPorNif(String nif) {
        int contador = 0;
        for (Account cuenta : cuentas) {
            if (cuenta != null && cuenta.getCliente().getNif().equals(nif)) {
                contador++;
            }
        }

        if (contador > 0) {
            Account[] cuentasCliente = new Account[contador];
            int i = 0;
            for (Account cuenta : cuentas) {
                if (cuenta != null && cuenta.getCliente().getNif().equals(nif)) {
                    cuentasCliente[i++] = cuenta;
                }
            }
            return cuentasCliente;
        }

        return new Account[0];
    }
    
    public void ingresarDinero(String iban, double cantidad) {
        Account cuenta = obtenerCuentaPorIban(iban);
        if (cuenta != null) {
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
        } else {
            System.out.println("No se encuentra la cuenta.");
        }
    }

    public void retirarDinero(String iban, double cantidad) {
        Account cuenta = obtenerCuentaPorIban(iban);
        if (cuenta != null) {
            if (cuenta.getSaldo() >= cantidad) {
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("No se encuentra la cuenta.");
        }
    }
}

