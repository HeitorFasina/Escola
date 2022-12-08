<?php

require_once "conexao.php";

$id = $_GET['id'];

$query = "SELECT * FROM requisicoes WHERE ID_REQUISICAO = $id;";
$result = mysqli_query($conn, $query);
$row = $result->fetch_assoc();

$id_req = $row['ID_REQUISICAO'];
$nome_vest = $row['nome_vestibular'];
$data_ini = $row['DATA_INICIO'];
$data_fim = $row['DATA_FIM'];
$link = $row['link'];
$autor = $row['autor'];
$id_autor = $row['id_autor'];

$query = "INSERT INTO aquisicoes VALUES (NULL, '$id_req', '$nome_vest', '$data_ini', '$data_fim', '$link', '$autor', '$id_autor');";
$result = mysqli_query($conn, $query);

$result = mysqli_query($conn, "SET @num := 0;");
$result = mysqli_query($conn, "UPDATE aquisicoes SET ID_AQUISICAO = @num := (@num+1)");
$result = mysqli_query($conn, "ALTER TABLE aquisicoes AUTO_INCREMENT = 1");

if ($result) {
    if ($result = mysqli_query($conn, "DELETE FROM requisicoes WHERE ID_REQUISICAO = $id")) {
        echo '<script type="text/javascript">alert("Aquisição adicionada.");</script>';
    } else {
        echo '<script type="text/javascript">alert("Ocorreu um erro.");</script>';
    }
} else {
    echo '<script type="text/javascript">alert("Ocorreu um erro.");</script>';
}
