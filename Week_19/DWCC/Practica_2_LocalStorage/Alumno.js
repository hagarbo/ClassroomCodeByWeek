class Alumno{
    constructor(dni, nombre, direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    getDni() {
        return this.dni;
    }

    getNombre() {
        return this.nombre;
    }

    getDireccion() {
        return this.direccion;
    }

    setDni(dni) {
        this.dni = dni;
    }

    setNombre(nombre) {
        this.nombre = nombre;
    }

    setDireccion(direccion) {
        this.direccion = direccion;
    }

    modificar(dni, nombre, direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    mostrar() {
        return `Alumno: ${this.nombre} con DNI: ${this.dni} y direccion: ${this.direccion}`;
    }
}