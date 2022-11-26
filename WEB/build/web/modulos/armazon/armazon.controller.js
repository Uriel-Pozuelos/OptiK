let armazon = [];

export function insertar() {
	let nombre = document.getElementById('txtnombre').value;
	let marca = document.getElementById('txtmarca').value;
	let precioCompra = document.getElementById('txtprecioCompra').value;
	let precioVenta = document.getElementById('txtprecioVenta').value;
	let existencias = document.getElementById('txtexistencias').value;
	let modelo = document.getElementById('txtmodelo').value;
	let color = document.getElementById('txtcolor').value;
	let dimensiones = document.getElementById('txtdimensiones').value;
	let fotografia = document.getElementById('image').src;
	let descripcion = document.getElementById('txtdescripcion').value;

	let producto = {
		nombre: nombre,
		marca: marca,
		precioCompra: precioCompra,
		precioVenta: precioVenta,
		existencias: existencias
	};
	let ar = {
		producto: producto,
		modelo: modelo,
		color: color,
		dimensiones: dimensiones,
		descripcion: descripcion,
		fotografia: fotografia
	};

	let rmazon = { datosArmazon: JSON.stringify(ar) };

	let parametros = new URLSearchParams(rmazon);

	fetch('http://localhost:8080/Optik/api/armazon/insertArmazon', {
		method: 'POST',
		body: parametros,
		headers: {
			'Content-Type':
				'application/x-www-form-urlencoded;charset=UTF-8'
		}
	})
		.then(response => response.json())
		.then(
			data =>
				function (data) {
					if (data.error) {
					} else if (data.idProducto) {
						alert(
							'Armazon almacenado de forma correcta con id: ' +
								data.idProducto
						);
					} else {
						JSON.stringify(data);
						alert(JSON.stringify(data));
					}

					JSON.stringify(data);
				}
		);
	setTimeout(() => {
		getAll(1);
		limpiar();
	}, 1000);
}

export function actualizar() {
	let idArmazon = document.getElementById('txtidArmazon').value;
	let idProducto = document.getElementById('txtidProducto').value;
	let nombre = document.getElementById('txtnombre').value;
	let marca = document.getElementById('txtmarca').value;
	let precioCompra = document.getElementById('txtprecioCompra').value;
	let precioVenta = document.getElementById('txtprecioVenta').value;
	let existencias = document.getElementById('txtexistencias').value;
	let modelo = document.getElementById('txtmodelo').value;
	let color = document.getElementById('txtcolor').value;
	let dimensiones = document.getElementById('txtdimensiones').value;
	let fotografia = document.getElementById('image').src;
	let descripcion = document.getElementById('txtdescripcion').value;
	console.log(armazon);
	console.log(idArmazon);
	//encontrar el armazon a actualizar con el idArmazon
	let armazonA = armazon.find(
		armazon => armazon.idArmazon == idArmazon
	);

	let producto = {
		idProducto: idProducto,
		nombre: nombre,
		marca: marca,
		precioCompra: precioCompra,
		precioVenta: precioVenta,
		existencias: existencias
	};
	let ar = {
		producto,
		idArmazon: idArmazon,
		modelo: modelo,
		color: color,
		dimensiones: dimensiones,
		descripcion: descripcion,
		fotografia: fotografia
	};

	let rmazon = { datosArmazon: JSON.stringify(ar) };

	let parametros = new URLSearchParams(rmazon);
	fetch('http://localhost:8080/Optik/api/armazon/actualizararmazon', {
		method: 'POST',
		body: parametros,
		headers: {
			'Content-Type':
				'application/x-www-form-urlencoded;charset=UTF-8'
		}
	})
		.then(response => response.json())
		.then(
			data =>
				function (data) {
					if (data.error) {
						alert('Error');
					} else if (data.idProducto) {
						alert(
							'Armazon actualizado de forma correcta con id: ' +
								data.idProducto
						);
					} else {
						JSON.stringify(data);
					}
				}
		);
	//actualizar la tabla de acuerdo al estatus
	setTimeout(() => {
		getAll(`${armazonA.producto.estatus}`);
		limpiar();
	}, 1000);
}

export function getAll(estatus) {
	let datos = { estatus };
	let parametros = new URLSearchParams(datos);

	fetch('http://localhost:8080/Optik/api/armazon/getAllArmazon', {
		method: 'POST',
		body: parametros,
		headers: {
			'Content-Type':
				'application/x-www-form-urlencoded;charset=UTF-8'
		}
	})
		.then(response => response.json())
		.then(data => {
			if (data.error) {
			} else {
				cargarTablaArmazon(null, data);
			}
		});
}

export function cargarTablaArmazon(coincidencias, data) {
	if (coincidencias) {
		data = coincidencias;
	} else {
		armazon = data;
	}

	let contenido = '';
	data.forEach((rmazon, index) => {
		const { producto, armazon } = rmazon;
		contenido += '<tr>';
		contenido += '<td>' + rmazon.producto.nombre + '</td>';
		contenido += '<td>' + rmazon.producto.codigoBarras + '</td>';
		contenido += '<td>' + rmazon.producto.marca + '</td>';
		contenido += '<td>' + rmazon.producto.precioCompra + '</td>';
		contenido += '<td>' + rmazon.producto.precioVenta + '</td>';
		contenido += '<td>' + rmazon.producto.existencias + '</td>';
		contenido += '<td>' + rmazon.dimensiones + '</td>';
		contenido += '<td>' + rmazon.descripcion + '</td>';
		contenido +=
			'<td>' +
			"<img width='100px' height='100px' src='" +
			rmazon.fotografia +
			"'/>" +
			'</td>';
		contenido +=
			"<td><button type='button'  class='button is-primary has-icons-left' type='button' onclick='mar.cargarForm(" +
			index +
			");'>VER</td>";
		if (rmazon.producto.estatus == 0) {
			contenido +=
				"<td><button type='button' class='button is-success has-icons-left' type='button' onclick='mar.activar(" +
				producto.idProducto +
				");'>ACTIVAR</td>";
		} else {
			contenido +=
				"<td><button type='button' class='button is-danger has-icons-left' type='button' onclick='mar.eliminar(" +
				producto.idProducto +
				");'>DESACTIVAR</td>";
		}
		contenido += '</tr>';
	});
	document.getElementById('tbArmazon').innerHTML = contenido;
}

export function cargarForm(i) {
	document.getElementById('txtidArmazon').value =
		armazon[i].idArmazon;
	document.getElementById('txtidProducto').value =
		armazon[i].producto.idProducto;
	document.getElementById('txtcodigoBarras').value =
		armazon[i].producto.codigoBarras;
	document.getElementById('txtnombre').value =
		armazon[i].producto.nombre;
	document.getElementById('txtmarca').value =
		armazon[i].producto.marca;
	document.getElementById('txtprecioCompra').value =
		armazon[i].producto.precioCompra;
	document.getElementById('txtprecioVenta').value =
		armazon[i].producto.precioVenta;
	document.getElementById('txtexistencias').value =
		armazon[i].producto.existencias;
	document.getElementById('txtmodelo').value = armazon[i].modelo;
	document.getElementById('txtcolor').value = armazon[i].color;
	document.getElementById('txtdimensiones').value =
		armazon[i].dimensiones;
	document.getElementById('txtdescripcion').value =
		armazon[i].descripcion;
	document.getElementById('image').src = armazon[i].fotografia;
}

export function limpiar() {
	document.getElementById('txtidArmazon').value = '';
	document.getElementById('txtidProducto').value = '';
	document.getElementById('txtcodigoBarras').value = '';
	document.getElementById('txtnombre').value = '';
	document.getElementById('txtmarca').value = '';
	document.getElementById('txtprecioCompra').value = '';
	document.getElementById('txtprecioVenta').value = '';
	document.getElementById('txtexistencias').value = '';
	document.getElementById('txtmodelo').value = '';
	document.getElementById('txtcolor').value = '';
	document.getElementById('txtfotografia').value = '';
	document.getElementById('txtdimensiones').value = '';
	document.getElementById('txtdescripcion').value = '';
	document.getElementById('image').src = '../public/default.png';
}

export function eliminar(i) {
	fetch(
		`http://localhost:8080/Optik/api/armazon/actualizarestatus?idProducto=${i}&estatus=0`
	);
	setTimeout(() => {
		getAll(1);
	}, 500);
}
export function activar(i) {
	fetch(
		`http://localhost:8080/Optik/api/armazon/actualizarestatus?idProducto=${i}&estatus=1`
	);
	setTimeout(() => {
		getAll(0);
	}, 500);
}
export function buscar() {
	const busqueda = document.getElementById('button-addon2').value;

	const coincidencias = [];

	for (let i = 0; i < armazon.length; i++) {
		const rmazon = armazon[i];
		console.table(rmazon);
		if (
			rmazon.producto.nombre
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			rmazon.producto.marca
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			rmazon.producto.precioCompra.toString().includes(busqueda) ||
			rmazon.producto.precioVenta.toString().includes(busqueda) ||
			rmazon.producto.existencias.toString().includes(busqueda) ||
			rmazon.color.toLowerCase().includes(busqueda.toLowerCase()) ||
			rmazon.modelo.toLowerCase().includes(busqueda.toLowerCase()) ||
			rmazon.dimensiones
				.toString()
				.includes(busqueda.toLowerCase()) ||
			rmazon.descripcion
				.toLowerCase()
				.includes(busqueda.toLowerCase())
		) {
			coincidencias.push(rmazon);
		}

		cargarTablaArmazon(coincidencias, null);
	}
}

export function cambiarFoto() {
	const imagen = document.getElementById('txtfotografia');
	const file = imagen.files[0];
	var reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload = function () {
		const img = reader.result;
		document.getElementById('image').src = img;
	};
}
