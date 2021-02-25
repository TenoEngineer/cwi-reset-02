package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupança;

import java.awt.*;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaCorrente heitor = new ContaCorrente(1234, InstituicaoBancaria.NUBANK, 1000);
        //ContaDigital fran = new ContaDigital(7185,InstituicaoBancaria.BANCO_DO_BRASIL,2);
        ContaCorrente jorge = new ContaCorrente(963852,InstituicaoBancaria.NUBANK,9000);

        //fran.getInstituicaoBancaria();
        jorge.transferir(5000.00, heitor);
        jorge.consultarSaldo();
        heitor.consultarSaldo();
        heitor.sacar(5000.00);
        heitor.consultarSaldo();
    }
}
