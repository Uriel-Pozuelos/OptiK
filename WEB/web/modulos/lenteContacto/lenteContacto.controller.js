let lentesContacto = [];
let lenteContactoActual = null;

const { fotografia } = getElements();
fotografia.addEventListener('change', e => {
	var reader = new FileReader();
	reader.readAsDataURL(e.target.files[0]);
	reader.onload = function (e) {
		const img = reader.result;
		document.getElementById('imagen').src = img;
	};
});

function getElements() {
	return {
		nombre: document.getElementById('nombre'),
		marca: document.getElementById('marca'),
		precioCompra: document.getElementById('precioCompra'),
		precioVenta: document.getElementById('precioVenta'),
		existencias: document.getElementById('existencias'),
		keratometria: document.getElementById('keratometria'),
		fotografia: document.getElementById('fotografia'),
		imagen: document.getElementById('imagen')
	};
}
console.log('lenteContacto.controller.js');
form = document.getElementById('form');
form.addEventListener('submit', async function (e) {
	e.preventDefault();
	let {
		nombre,
		marca,
		precioCompra,
		precioVenta,
		existencias,
		keratometria,
		fotografia
	} = getElements();
	let producto = {
		nombre: nombre.value,
		marca: marca.value,
		precioCompra: precioCompra.value,
		precioVenta: precioVenta.value,
		existencias: existencias.value
	};
	const image = fotografia.files[0];

	imageToText(image, producto, keratometria.value);
});

async function imageToText(fotografia, producto, keratometria) {
	let reader = new FileReader();
	reader.readAsDataURL(fotografia);
	reader.onload = async function () {
		const base64 = reader.result;
		let datosLenteContacto = {
			datosLenteContacto: JSON.stringify({
				producto,
				keratometria: keratometria,
				fotografia: base64
			})
		};
		const response = await fetch(
			'http://localhost:8080/Optik/api/lenteContacto/guardar',
			{
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: new URLSearchParams(datosLenteContacto)
			}
		);
		const data = await response.json();
		tablaLenteC(1);
		limpiarForm();
	};
	reader.onerror = function (error) {
		console.log('Error: ', error);
	};
}

const mostrar = document.getElementById('mostrar');
mostrar.addEventListener('click', () => {
	tablaLenteC(1);
});

async function tablaLenteC(estatus) {
	const response = await fetch(
		'http://localhost:8080/Optik/api/lenteContacto/getalllente',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({ estatus: estatus })
		}
	);
	const data = await response.json();
	if (data.error) {
		alert(data.error);
		return;
	}
	//crear la tabla
	mostrarTabla(null, data);
}

function mostrarTabla(coincidencias, data) {
	if (coincidencias) {
		data = coincidencias;
	} else {
		lentesContacto = data;
	}
	let contenido = '';
	console.table(data);
	data.forEach((lenteContacto, index) => {
		const { producto, keratometria, fotografia } = lenteContacto;
		contenido +=
			/*html*/
			`
    <tr>
    <td>${producto.nombre}</td>
    <td>${producto.marca}</td>
    <td>${producto.precioCompra}</td>
    <td>${producto.precioVenta}</td>
    <td>${producto.existencias}</td>
    <td>${keratometria}</td>
    <td><img src="${fotografia}" alt="fotografia" width="100px"/></td>
		<td><button class="button is-primary" type='button' onclick="cargarForm(${index})">ver</button></td>
    `;
		if (producto.estatus === 1) {
			contenido += `<td><button class="button is-danger" type='button' onclick="eliminarLente(${producto.idProducto})">Desactivar</button></td>`;
		} else {
			contenido += `<td><button class="button is-success" type='button' onclick="activarLente(${producto.idProducto})">Activar</button></td>`;
		}
	});
	document.querySelector('tbody').innerHTML = contenido;
}

async function eliminarLente(index) {
	const response = await fetch(
		'http://localhost:8080/Optik/api/lenteContacto/deleteLente',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({
				idLente: index
			})
		}
	);
	const data = await response.json();
	if (data.error) {
		alert(data.error);
		return;
	}
	tablaLenteC('1');
}

const mostrarD = document.getElementById('mostrarD');
mostrarD.addEventListener('click', () => {
	tablaLenteC(0);
});
async function activarLente(index) {
	const response = await fetch(
		'http://localhost:8080/Optik/api/lenteContacto/activateLente',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({
				idLente: index
			})
		}
	);
	const data = await response.json();
	if (data.error) {
		alert(data.error);
		return;
	}
	tablaLenteC('0');
}

const limpiar = document.getElementById('limpiar');
limpiar.addEventListener('click', () => {
	document.getElementById('form').reset();
	document.getElementById('imagen').src = './public/default.png';
	lenteContactoActual = null;
});

function cargarForm(index) {
	const empleado = lentesContacto[index];
	lenteContactoActual = empleado;
	const { producto, keratometria, fotografia } = empleado;
	document.getElementById('nombre').value = producto.nombre;
	document.getElementById('marca').value = producto.marca;
	document.getElementById('precioCompra').value =
		producto.precioCompra;
	document.getElementById('precioVenta').value = producto.precioVenta;
	document.getElementById('existencias').value = producto.existencias;
	document.getElementById('keratometria').value = keratometria;
	//poner la imagen en el input file
	const imagen = document.getElementById('imagen');
	imagen.src = fotografia;
}
const actualizar = document.getElementById('actualizar');
actualizar.addEventListener('click', () => {
	updateLenteC();
});
async function updateLenteC() {
	const { producto } = lenteContactoActual;
	const datosLenteContacto = {
		datosLenteContacto: JSON.stringify({
			idLenteContacto: lenteContactoActual.idLenteContacto,
			producto: {
				idProducto: producto.idProducto,
				nombre: document.getElementById('nombre').value,
				marca: document.getElementById('marca').value,
				precioCompra: document.getElementById('precioCompra').value,
				precioVenta: document.getElementById('precioVenta').value,
				existencias: document.getElementById('existencias').value
			},
			keratometria: document.getElementById('keratometria').value,
			fotografia: document.getElementById('imagen').src
		})
	};

	const response = await fetch(
		'http://localhost:8080/Optik/api/lenteContacto/updateLente',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams(datosLenteContacto)
		}
	);
	const data = await response.json();
	console.log(data);

	tablaLenteC(`${producto.estatus}`);
	limpiarForm();
}
