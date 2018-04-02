<%-- 
    Document   : estoqueIndex.jsp
    Created on : 10/10/2017, 14:34:46
    Author     : Joao Sergio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Astec Games</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/ju/dt-1.10.16/b-1.4.2/b-html5-1.4.2/datatables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css"/>
    </head>
    <body>
        <div class="row">
            <c:forEach items="${estoque}" var="estoque">
                <div class="col s12 m6 l4" style="height: 428.83px !important;">
                    <div class="card teal">
                        <div class="card-content white-text">
                            <span class="card-title"><c:out value="${estoque.getNome()}" /></span>
                            <ul class="collection">
                                <li class="collection-item teal white-text"><strong>Descrição: </strong><c:out value="${estoque.getDescricao()}" /></li>
                                <li class="collection-item teal white-text"><strong>Preço de compra: </strong><c:out value="${estoque.getPreco_compra()}" /></li>
                                <li class="collection-item teal white-text"><strong>Preço de venda: </strong><c:out value="${estoque.getPreco_venda()}" /></li>
                                <li class="collection-item teal white-text"><strong>Quantidade: </strong><c:out value="${estoque.getQuantidade()}" /></li>
                            </ul>
                        </div>
                        <div class="card-action">
                            <a href="${pageContext.request.contextPath}/protegido/estoque/editar?id=${estoque.getId()}">Editar</a>
                            <a href="${pageContext.request.contextPath}/protegido/estoque/excluir?id=${estoque.getId()}">Deletar</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>

    <div class="fixed-action-btn">
        <a class="btn-floating btn-large tooltipped darken-3" data-position="left" data-delay="50" data-tooltip="Novo Produto" href="${pageContext.request.contextPath}/protegido/estoque/cadastro">
            <i class="large material-icons">add</i>
        </a>
    </div>

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/materialize.js"></script>
</body>
</html>
