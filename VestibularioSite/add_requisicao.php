<?php

session_start();
require_once "conexao.php";

if (
    empty($_POST['nome_vest']) || empty($_POST['data_ini'])
    || empty($_POST['data_fim']) || empty($_POST['link'])
) {
    header('Location: pagina_principal.php');
    exit;
}

$nome_vest = $_POST['nome_vest'];
$data_ini = date('Y-m-d', strtotime($_POST['data_ini']));
$data_fim = date('Y-m-d', strtotime($_POST['data_fim']));
$link = $_POST['link'];
$autor = $_SESSION['user_nome'];
$id_autor = $_SESSION['user_id'];

$query = "INSERT INTO requisicoes VALUES (NULL, '$nome_vest', '$data_ini', '$data_fim', '$link', '$autor', '$id_autor');";
$result = mysqli_query($conn, $query);

if ($result) {
    echo '<script type="text/javascript">alert("Requisição adicionada.");</script>';
} else {
    echo '<script type="text/javascript">alert("Ocorreu um erro.");</script>';
}
