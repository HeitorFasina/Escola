<?php require_once "validar_login.php"; ?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="style.css" rel="stylesheet">
    <style rel="stylesheet" type="text/css">
        table,
        th,
        td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>

<body>
    <h1>Requisições de usuário</h1>

    <hr>

    <?php if ($row['privilegio'] == "admin") { ?>
        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Data inicio</th>
                <th>Data fim</th>
                <th>Link</th>
                <th>Usuario</th>
                <th></th>
            </tr>
            <?php $query = "SELECT * FROM requisicoes;";
            $result = mysqli_query($conn, $query);
            while ($row = $result->fetch_assoc()) { ?>
                <tr>
                    <td><?php echo $row['ID_REQUISICAO']; ?></td>
                    <td><?php echo $row['nome_vestibular']; ?></td>
                    <td><?php echo date('d/m/Y', strtotime($row['DATA_INICIO'])); ?></td>
                    <td><?php echo date('d/m/Y', strtotime($row['DATA_FIM'])); ?></td>
                    <td><?php echo $row['link']; ?></td>
                    <td><?php echo $row['autor']; ?></td>
                    <td>
                        <a href="add_aquisicao.php?id=<?php echo $row['ID_REQUISICAO']; ?>">Adicionar.</a>
                    </td>
                </tr> <br> <br>
            <?php } ?>
        </table>
    <?php } else { ?>
        <div class="container">
            <form action="add_requisicao.php" method="post">
                Digite o nome do vestibular: <input type="text" name="nome_vest" id=""> <br>
                Insira a data de inicio das inscrições: <input type="date" name="data_ini" id=""> <br>
                Insira a data de fim das inscrições: <input type="date" name="data_fim" id=""> <br>
                Insira o link do site do vestibular: <input type="text" name="link" id=""> <br> <br>
                <button type="submit">Submeter</button>
            </form>
        </div>
    <?php } ?>
</body>

</html>