use tiendaRegalos;

CREATE TABLE producto(
idProducto INT AUTO_INCREMENT PRIMARY KEY,
precioVenta DOUBLE NOT NULL,
codigoBarras INT NOT NULL,
usuarioAcceso VARCHAR(50) NOT NULL
);

CREATE TABLE peluche(
idPeluche INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
marca VARCHAR(30) NOT NULL,
idProducto INT NOT NULL,
usuarioAcceso VARCHAR(50) NOT NULL,
CONSTRAINT fk_peluche_producto FOREIGN KEY(idProducto) REFERENCES producto(idProducto)
);