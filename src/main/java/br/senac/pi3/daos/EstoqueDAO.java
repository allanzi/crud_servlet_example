/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import br.senac.pi3.entidades.EstoqueEntidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class EstoqueDAO extends Conexao {

    public List<EstoqueEntidade> todos() {
        List<EstoqueEntidade> estoque = new ArrayList<EstoqueEntidade>();

        try {
            String sql = "SELECT * FROM estoque ORDER BY id DESC";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                EstoqueEntidade estoq = new EstoqueEntidade(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getFloat("preco_compra"),
                        resultado.getFloat("preco_venda"),
                        resultado.getInt("quantidade")
                );

                estoque.add(estoq);
            }

            return estoque;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }

    public EstoqueEntidade find(int id) {

        try {
            String sql = "SELECT * FROM estoque WHERE id = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                EstoqueEntidade estoque = new EstoqueEntidade(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getFloat("preco_compra"),
                        resultado.getFloat("preco_venda"),
                        resultado.getInt("quantidade")
                );

                return estoque;
            }

            return null;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }

    public EstoqueEntidade findWhereCode(int codigo) {

        try {
            String sql = "SELECT * FROM estoque WHERE codigo = ?";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                EstoqueEntidade estoque = new EstoqueEntidade(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getFloat("preco_compra"),
                        resultado.getFloat("preco_venda"),
                        resultado.getInt("quantidade")
                );

                return estoque;
            }

            return null;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return null;
    }

    public boolean cadastrar(EstoqueEntidade estoque) {
        try {
            String sql = "INSERT INTO estoque (nome, descricao, preco_compra, preco_venda, quantidade, criado_em, atualizado_em) values(?,?,?,?,?, now(), now());";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, estoque.getNome());
            comando.setString(2, estoque.getDescricao());
            comando.setFloat(3, estoque.getPreco_compra());
            comando.setFloat(4, estoque.getPreco_venda());
            comando.setInt(5, estoque.getQuantidade());

            comando.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return false;
    }

    public boolean atualizar(int id, EstoqueEntidade estoque) {
        try {
            String sql = "UPDATE estoque SET nome = ?, descricao = ?, preco_compra = ?, preco_venda = ?, quantidade = ?, atualizado_em = now() WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setString(1, estoque.getNome());
            comando.setString(2, estoque.getDescricao());
            comando.setFloat(3, estoque.getPreco_compra());
            comando.setFloat(4, estoque.getPreco_venda());
            comando.setInt(5, estoque.getQuantidade());
            comando.setInt(6, estoque.getId());

            comando.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return false;
    }

    public boolean atualizarQtde(int id, int qtde) {
        try {
            String sql = "UPDATE estoque SET quantidade = ?, atualizado_em = now() WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);

            comando.setInt(1, qtde);
            comando.setInt(2, id);

            comando.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return false;
    }

    public boolean excluir(int estoqueId) {
        try {
            String sql = "DELETE FROM estoque WHERE id = ?;";
            PreparedStatement comando = obterConexao().prepareStatement(sql);
            comando.setInt(1, estoqueId);

            comando.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FecharConexao();
        }

        return false;
    }
}
