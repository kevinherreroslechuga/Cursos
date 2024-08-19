package org.kev.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kev.junit5app.ejemplos.esceptions.DineroInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {//tiene que ser metodos difault o de package, que los test nos e puedan acceder de otras aprtes de nuestro codigo, tiene que ser encapsulado de nuestro ambiente de pruebas


    @Test
    void testNombreCuenta() {//snombre del metodo para ser mas distintivo de una prueba
        Cuenta cuenta = new Cuenta("Kevin", new BigDecimal("1000.123456"));//EN BIG DECIMAL ES MEJOR PASAR EL NUMERO EN UN STRING PRA QUE NO LO TOME COMO UN DOEBLE O UN FLOAT
       // cuenta.setPersona("Kevin");
        String esperado = "Kevin";
        String real = cuenta.getPersona();
        assertNotNull(real);
        assertEquals(esperado, real);// sin necesidad de usar Assertions antes de assertequals
        assertTrue(real.equals("Kevin"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);//comparto SI 0 ES MAYOR QUE SALDO VA A DEVOLVER UN -1, 0 SI SON IGUALES Y 1 SI ES MAYOR A 0, SI SE COMPARA CON EL TORO 0 REGRESA EL BOOLEANO DESEADO
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaDeCuenta() {
        Cuenta cuenta = new Cuenta("Jhon Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("Jhon Doe", new BigDecimal("8900.9997"));

        //assertNotEquals(cuenta, cuenta2);
        assertEquals(cuenta, cuenta2);//assert equals se puede modificar sobrescribiendo el metodo equals

    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123456"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900,cuenta.getSaldo().intValue());
        assertEquals("900.123456",  cuenta.getSaldo().toPlainString());//vuelve un bigdecimal en string
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123456"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100,cuenta.getSaldo().intValue());
        assertEquals("1100.123456",  cuenta.getSaldo().toPlainString());//vuelve un bigdecimal en string
    }

    @Test
    void testDineroInsuficienteExceptionCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123456"));
        Exception exception = assertThrows(DineroInsuficienteException.class, ()->{//assertThrwos debuelve el objeto exception
           cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferenciaDineroCuentas(){
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas(){
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco del Estado", cuenta1.getBanco().getNombre());
        assertEquals("Andres", banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Andres"))
                .findFirst()
        .get().getPersona());

        assertTrue(banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Jhon Doe")));
    }
}
