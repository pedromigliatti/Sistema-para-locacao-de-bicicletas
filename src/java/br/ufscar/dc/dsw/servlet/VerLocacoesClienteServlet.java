/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.servlet;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locacao;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedro
 */
@WebServlet(name="Ver Locacoes Cliente Servlet", urlPatterns = {"/user/verLocacoesCliente"})
public class VerLocacoesClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Locacao> todasLocacoes;
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            String cpf =null;
            Cliente cliente = clienteDAO.get(request.getParameter("nome"));
            if(cliente != null)
                cpf= cliente.getCpf();
            
            LocadoraDAO locadoraDAO = new LocadoraDAO();
            String cnpj =null;
            Locadora locadora = locadoraDAO.get(request.getParameter("nome"));
            if(locadora != null)
                cnpj = locadora.getCnpj();
            
            if(cpf==null){
                LocacaoDAO locacaoDAO = new LocacaoDAO();
                todasLocacoes = locacaoDAO.getAllLocadora(cnpj);
                request.setAttribute("listaLocacoes", todasLocacoes);
                request.setAttribute("cnpj", cnpj);
                request.getRequestDispatcher("listaLocacoesLocadora.jsp").forward(request, response);
            } else {
                LocacaoDAO locacaoDAO = new LocacaoDAO();
                String nome = request.getParameter("nome");
                todasLocacoes = locacaoDAO.getAllCliente(cpf);
                request.setAttribute("listaLocacoes", todasLocacoes);
                request.setAttribute("cpf", cpf);
                request.getRequestDispatcher("listaLocacoesCliente.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

