<?php
class myJWT {
    private $senha = "SenhaSecreta";

    public function criaToken($payload) {
        $header = [
            'alg' => 'SHA256',
            'typ' => 'JWT'
        ];

        $header = json_encode($header); // transforma array em json
        $header = base64_encode($header); // transforma json em base64
        
        $payload = json_encode($payload);
        $payload = base64_encode($payload);

        $signature = hash_hmac('SHA256', "$header.$payload", $this->senha, true); // trasforma parâmetros em um dado criptográfico
        $signature = base64_encode($signature);

        return "$header.$payload.$signature"; // retorna parâmetros e finaliza a função
    }

    public function validaToken($jwt){
        $part = explode(".", $jwt); // transforma string em array, separando por "."
        $header = $part[0];
        $payload = $part[1];
        $signature = $part[2];

        $signatureCheck = hash_hmac('SHA256', "$header.$payload", $this->senha, true);
        $signatureCheck = base64_encode($signatureCheck);

        if ($signature == $signatureCheck){ // verifica se as assinaturas batem. caso não, retorna falso
            $retorno = true;
        }else {
            $retorno = false;
        }

        return $retorno;
    }
}
