<%-- 
    Document   : cadastroCliente
    Created on : 22/04/2019, 00:23:34
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar um novo cliente</title>
    </head>
    <body>
          <form action="/admin/novoCliente" method="post">
            <fieldset>

                <!-- Form Name -->
                <legend>Novo Cliente</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nome">Nome</label>  
                    <div class="col-md-4">
                        <input id="nome" name="nome" type="text" placeholder="Nome" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email</label>  
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="senha">Senha</label>
                    <div class="col-md-4">
                        <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cpf">CPF</label>  
                    <div class="col-md-4">
                        <input id="cpf" name="cpf" type="text" placeholder="CPF" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="sexo">Sexo</label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="sexo-0">
                                <input type="radio" name="sexo" id="sexo-0" value="M" checked="checked">
                                Masculino
                            </label>
                        </div>
                        <div class="radio">
                            <label for="sexo-1">
                                <input type="radio" name="sexo" id="sexo-1" value="F">
                                Feminino
                            </label>
                        </div>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="telefone">Telefone</label>  
                    <div class="col-md-4">
                        <input id="telefone" name="telefone" type="text" placeholder="Telefone" class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nascimento">Nascimento</label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="nascimento" type="date" placeholder="Nascimento" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>