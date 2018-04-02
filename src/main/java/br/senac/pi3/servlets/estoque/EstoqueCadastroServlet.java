/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.servlets.estoque;

import br.senac.pi3.daos.EstoqueDAO;
import br.senac.pi3.entidades.EstoqueEntidade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joao Sergio
 */
@WebServlet(name = "EstoqueServletCadastro", urlPatterns = { "/protegido/estoque/cadastro" })
public class EstoqueCadastroServlet extends HttpServlet{
    
    public EstoqueDAO estoqueDao = new EstoqueDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/estoqueCreate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float precoCompra = Float.parseFloat(request.getParameter("preco_compra"));
        float precoVenda = Float.parseFloat(request.getParameter("preco_venda"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        
        EstoqueEntidade novoEstoque = new EstoqueEntidade(nome, descricao, precoCompra, precoVenda, quantidade);
        estoqueDao.cadastrar(novoEstoque);
        
        response.sendRedirect(request.getContextPath() + "/protegido/estoque");
        
    }
}
