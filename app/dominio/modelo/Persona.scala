package dominio.modelo

case class Persona(id: Int, nombre: String, edad: Int) {
  require(edad > 18, "La persona debe tener 18 años")
}
