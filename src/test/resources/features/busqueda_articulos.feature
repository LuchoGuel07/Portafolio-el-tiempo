Feature: Como usuario deseo validar la funcionalidad
  de busquedas en el portal portafolio


  @portafolioBusqueda @portafolio
  Scenario Outline: Funcionalidad busqueda de Portafolio
    Given ingreso a la pagina de portafolio <fila>
      | Hoja               |
      | BusquedaPortafolio |
    When realizo una busqueda en portafolio
    Then puedo navegar entre dos resultados de portafolio

    Examples:
      | fila |
      | 1    |