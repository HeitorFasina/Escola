<?php

require 'jwtClass.php';
$myjwt = new myJWT();

$user = "root";
$pass = "";
$db = "progweb3";
$server = "localhost";
$conn = mysqli_connect($server, $user, $pass, $db);

if($conn->connect_errno) {
    die("Erro de conexão".$conn->connect_error);
}

$idUsuario = $_POST["usuario"];
$senhaUsuario = $_POST["senha"];

$sql = "SELECT * FROM usuarios WHERE idusuario = '".$idUsuario."' AND senhausuario = '".$senhaUsuario."'";
$resultadoQuery = mysqli_query($conn, $sql);
if ($resultadoQuery->num_rows == 0 ) {
    die("usuário ou senha inválidos");
}

$arrayQuery = $resultadoQuery->fetch_assoc();

echo "usuário digitado: ".$arrayQuery["idusuario"];

echo "<BR>";
echo "<BR>";

echo "senha digitada: ".$arrayQuery["senhausuario"];

$payload = [
    'iss' => 'localhost',
    'nome' => $arrayQuery["nomeusuario"],
    'email' => $arrayQuery["email"]
];

echo "<BR>";
echo "<BR>";

$token = $myjwt->criaToken($payload);
echo $token;

echo "<BR>";
echo "<BR>";

echo "Token validado com sucesso?<BR>";
if ($myjwt->validaToken($token)){
    echo "sim<BR>";
}else{
    echo "não<BR>";
}
