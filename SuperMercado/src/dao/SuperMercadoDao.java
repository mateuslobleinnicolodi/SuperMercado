/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.SuperMercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
/**
 *
 * @author Administrador
 */
public class SuperMercadoDao {
     public static boolean inserir(SuperMercado objeto) {
        String sql = "INSERT INTO SuperMercado (nome_fantasia, razao_social, fundacao, nr_funcionarios, valor_bolsa) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome_fantasia());
            ps.setString(2, objeto.getRazao_social());
            ps.setDate(3, Date.valueOf(objeto.getFundacao()));
            ps.setInt(4, objeto.getNr_funcionarios());
            ps.setDouble(5, objeto.getValor_bolsa());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
       public static boolean alterar(SuperMercado objeto) {
        String sql = "UPDATE SuperMercado SET nome_fantasia = ?, razao_social = ?, nr_funcionarios = ?, fundacao = ?, valor_bolsa = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome_fantasia()); 
            ps.setString(2, objeto.getRazao_social());
            ps.setInt(3, objeto.getNr_funcionarios());
            ps.setDate(4, Date.valueOf(objeto.getFundacao()));
            ps.setDouble(5, objeto.getValor_bolsa());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
         public static boolean excluir(SuperMercado objeto) {
        String sql = "DELETE FROM SuperMercado WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
         
         public static List<SuperMercado> consultar() {
        List<SuperMercado> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome_fantasia, razao_social, nr_funcionarios, fundacao, valor_bolsa FROM SuperMercado";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SuperMercado objeto = new SuperMercado();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome_fantasia(rs.getString("nome_fantasia"));
                objeto.setRazao_social(rs.getString("razao_social"));
                objeto.setNr_funcionarios(rs.getInt("nr_funcionarios"));
                objeto.setFundacao(rs.getDate("fundacao").toLocalDate());
                objeto.setValor_bolsa(rs.getDouble("valor_bolsa"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
}
