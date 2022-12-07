<?php

require_once "credenciais.php";

$conn = mysqli_connect($server, $user, $pass, $db);

if ($conn->connect_errno) {
    die("Erro de conexão: " . $conn->connect_error);
}
