<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHPWebPage.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Change password</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>

        <div class="container-fluid">
            <h1>Cambio de contraseña</h1>
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-6">
                    <form method="post">
                        <!-- Email input -->
                        <div class="form-group mb-4 ">
                            <label class="form-label" for="email">Email address</label>
                            <input type="email" id="email" class="form-control" name="email"  required/>

                        </div>

                        <!-- Current Password input -->
                        <div class="form-group mb-4">
                            <label class="form-label" for="currentPwd">Contraseña actual</label>
                            <input type="password" id="currentPwd" class="form-control" name="pwd" required/>

                        </div>

                        <!-- New Password input 1-->
                        <div class="form-group mb-4">
                            <label class="form-label" for="newPwd1">Nueva contraseña</label>
                            <input type="password" id="newPwd1" class="form-control" name="newPwd1" required/>

                        </div>

                        <!-- New Password input 2-->
                        <div class="form-group mb-4">
                            <label class="form-label" for="newPwd2">Repita nueva contraseña</label>
                            <input type="password" id="newPwd2" class="form-control" name="newPwd2" required/>

                        </div>

                        <!-- Submit button -->
                        <input type="submit" class="btn btn-primary btn-block mb-4" value="Cambiar contraseña"></button>


                    </form>

                    <?php

                    require_once("util.php");
                    ini_set("display_errors",1);
                    const MIN_LENGH = 6;
                    $usuarios = array("user1@edu.es" => array("pwd" => "Abc123.", "pwd-1" => "aBc123.", "pwd-2" => "abC123."),
                        "user2@edu.es" => array("pwd" => "123Abc.", "pwd-1" => "123aBc.", "pwd-2" => "123abC."));
                    $simbolos = [".", "?", "@"];
                  
                    $numeros = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

                    const USER_DOES_NOT_EXIST = "No existe usuario";
                    const PWD_INCORRECT = "La contraseña no es correcta";
                    const PWD_MISMATCH = "Las nuevas contraseñas no coinciden";
                    const MIN_LENGTH_ERROR = "La longitud mínima es " . MIN_LENGH;
                    const PWD_USED = "La contraseña es una de las 2 últimas utilizadas";
                    const UPPER_CASE_NEEDED = "La nueva contraseña debe contener al menos una letra mayúscula";
                    const NUMBER_NEEDED = "La nueva contraseña debe contener al menos un número";
                    const SYMBOL_NEEDED = "La nueva contraseña debe contener al menos un símbolo: ";

                    //Completar
                    $exito = false;
                    $errors = array();

                    $strErr_symbol = SYMBOL_NEEDED;
                    $regex_symbols = "/[";
                    foreach ($simbolos as $value) {
                        $regex_symbols .= $value;
                        $strErr_symbol .= $value . " , ";
                    }
                    $regex_symbols .= "]/";
                    $strErr_symbol = substr($strErr_symbol,0, strlen($strErr_symbol) - 2);

                    if (isset($_POST["email"]) && isset($_POST["pwd"]) && isset($_POST["newPwd1"]) && isset($_POST["newPwd2"])) {

                        $user_input = $_POST["email"];
                        $pwd_input = $_POST["pwd"];
                        $new_pwd_input = $_POST["newPwd1"];
                        $new_pwd_verifier_input = $_POST["newPwd2"];

                        if (!is_valid_user($user_input, $usuarios)) //error 1
                            array_push($errors, USER_DOES_NOT_EXIST);
                        elseif (!check_password($user_input, $pwd_input, $usuarios)) //error 2
                            array_push($errors, PWD_INCORRECT);
                        elseif (!compare_new_passwords($new_pwd_input, $new_pwd_verifier_input)) //error 3
                            array_push($errors, PWD_MISMATCH);
                        elseif(!check_password_length($new_pwd_input,MIN_LENGH)) // error 4
                            array_push($errors, MIN_LENGTH_ERROR);
                        elseif(is_old_password($user_input,$new_pwd_input,$usuarios)) //error 5
                            array_push($errors, PWD_USED);
                        elseif (!has_uppercase($new_pwd_input)) //error 6
                            array_push($errors, UPPER_CASE_NEEDED);
                        elseif (!has_number($new_pwd_input)) // error 7
                            array_push($errors, NUMBER_NEEDED);
                        elseif (!has_symbol($new_pwd_input,$regex_symbols)) // error 8
                            array_push($errors, $strErr_symbol);
                        else { // TODO OK
                            $exito = true;
                            // Guardamos los nuevos datos
                            $usuarios[$user_input]["pwd-2"] = $usuarios[$user_input]["pwd-1"];
                            $usuarios[$user_input]["pwd-1"] = $usuarios[$user_input]["pwd"];
                            $usuarios[$user_input]["pwd"] = $new_pwd_input;
                        }
                    }

                    
                  
                    ?>


                    
                        <div class="alert alert-danger" role="alert">
                         <?php
                            foreach ($errors as $value) {
                             echo "<p>".$value."</p>";
                            }
                         ?>
                        </div>
                  

                        <div class="alert alert-success" role="alert">
                            <?php
                            if ($exito)
                                echo "Se ha actualizado correctamente la contraseña :";
                                print_r($usuarios[$user_input]);
                            ?> 
                        </div>
                   
                </div>
            </div>
        </div>


    </body>
</html>

