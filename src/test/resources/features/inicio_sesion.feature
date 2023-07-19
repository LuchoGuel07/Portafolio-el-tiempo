Feature: Login Exitoso yo como usuario de el tiempo deseo poder realizar inicio de sesion en el aplicativo para poder acceder a las diferentes opciones

  Scenario Outline:Login portafolio
    Given ingreso a la pagina de login de portafolio <fila>
      | Hoja            |
      | LoginPortafolio |
    When ingreso los datos de logueo de portafolio
    Then puede validar la funcionalidad de logueo de portafolio

    Examples:
      | fila |
      | 1    |
