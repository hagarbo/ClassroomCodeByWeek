class Vehiculo{
    constructor(modelo, marca, precio, km) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.km = km;
    }

    getModelo(){
        return this.modelo;
    }

    getMarca(){
        return this.marca;
    }

    getPrecio(){
        return this.precio;
    }

    getKm(){
        return this.km;
    }

    mostrarDatos(){
        return "[ Marca: "+ this.marca +
                " Modelo: " + this.modelo +
                " Precio: " + this.precio +
                " Km: " + this.km + " ]"
    }
}