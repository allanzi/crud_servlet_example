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
 * @author allan
 */
@WebServlet(name = "EstoqueServletEditar", urlPatterns = { "/protegido/estoque/editar" })
public class EstoqueEditarServlet extends HttpServlet{
    public EstoqueDAO estoqueDao = new EstoqueDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("estoque", estoqueDao.find(id));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/estoqueUpdate.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float precoCompra = Float.parseFloat(request.getParameter("preco_compra"));
        float precoVenda = Float.parseFloat(request.getParameter("preco_venda"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        EstoqueEntidade estoqueatualizado = new EstoqueEntidade(id, nome, descricao, precoCompra, precoVenda, quantidade);
        
        //int id = Integer.parseInt(request.getParameter("id"));
        
        estoqueDao.atualizar(id, estoqueatualizado);
        
        response.sendRedirect(request.getContextPath() + "/protegido/estoque");
        
    }
}
