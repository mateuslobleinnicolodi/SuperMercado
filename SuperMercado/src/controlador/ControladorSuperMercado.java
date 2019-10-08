/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.SuperMercadoDao;
import javax.swing.JOptionPane;
import modelo.SuperMercado;
import tela.manutencao.ManutencaoSuperMercado;

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Administrador
 */
public class ControladorSuperMercado {

    public static void inserir(ManutencaoSuperMercado man){
        SuperMercado objeto = new SuperMercado();
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        objeto.setRazao_social(man.jtfRazao_social.getText());
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNr_funcionarios(Integer.parseInt(man.jtfNr_funcionarios.getText()));
        objeto.setValor_bolsa(Double.parseDouble(man.jtfValor_bolsa.getText()));
        
        boolean resultado = SuperMercadoDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoSuperMercado man){
        SuperMercado objeto = new SuperMercado();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome_fantasia(man.jtfNome_fantasia.getText());
        objeto.setRazao_social(man.jtfRazao_social.getText());
        objeto.setNr_funcionarios(Integer.parseInt(man.jtfNr_funcionarios.getText()));
        objeto.setFundacao(LocalDate.parse(man.jtfFundacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setValor_bolsa(Double.parseDouble(man.jtfValor_bolsa.getText()));
        
        boolean resultado = SuperMercadoDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

     public static void excluir(ManutencaoSuperMercado man){
        SuperMercado objeto = new SuperMercado();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = SuperMercadoDao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
     public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome fantasia");
        modelo.addColumn("Razão social");
        modelo.addColumn("Número de funcionários");
        modelo.addColumn("Fundação");
        modelo.addColumn("Valor da bolsa");
        List<SuperMercado> resultados = SuperMercadoDao.consultar();
        for (SuperMercado objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome_fantasia());
            linha.add(objeto.getRazao_social());
            linha.add(objeto.getNr_funcionarios());
            linha.add(objeto.getFundacao());
            linha.add(objeto.getValor_bolsa());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
