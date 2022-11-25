let lentesContacto = [];
let lenteContactoActual = null;
tablaLenteC('1');

fotografia.addEventListener('change', () => {
	cambiarFoto();
});

export function cambiarFoto() {
	const { fotografia } = getElements();
	const file = fotografia.files[0];
	var reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload = function () {
		const img = reader.result;
		document.getElementById('imagen').src = img;
		console.log(
			document.getElementById('imagen').width,
			document.getElementById('imagen').height
		);
		if (
			document.getElementById('imagen').width > 252 ||
			document.getElementById('imagen').height > 252
		) {
			mostrarAlerta('error', 'La imagen es muy grande');
			document.getElementById('imagen').src = '../public/default.png';
		}
	};
}

function getElements() {
	return {
		nombre: document.getElementById('nombre'),
		marca: document.getElementById('marca'),
		precioCompra: document.getElementById('precioCompra'),
		precioVenta: document.getElementById('precioVenta'),
		existencias: document.getElementById('existencias'),
		keratometria: document.getElementById('keratometria'),
		fotografia: document.getElementById('fotografia'),
		imagen: document.getElementById('imagen'),
		tipo: document.getElementById('tipo')
	};
}
console.log('lenteContacto.controller.js');
form = document.getElementById('guardar');
form.addEventListener('click', () => {
	guardar();
});

export async function guardar() {
	let {
		nombre,
		marca,
		precioCompra,
		precioVenta,
		existencias,
		keratometria,
		fotografia,
		tipo
	} = getElements();
	let producto = {
		nombre: nombre.value,
		marca: marca.value,
		precioCompra: precioCompra.value,
		precioVenta: precioVenta.value,
		existencias: existencias.value
	};
	console.log(producto);
	const image = fotografia.files[0];

	imageToText(image, producto, keratometria.value, tipo.value);
}

export async function imageToText(
	fotografia,
	producto,
	keratometria,
	tipo
) {
	console.log(tipo);
	let datosLenteContacto = {
		datosLenteContacto: JSON.stringify({
			producto,
			keratometria: keratometria,
			fotografia: document.getElementById('imagen').src,
			tipo: tipo
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
	if (data.error) {
		mostrarAlerta('error', 'no se pudo guardar el lente de contacto');
		return;
	}
	mostrarAlerta('success', 'se guardo el lente de contacto');
	tablaLenteC(1);
	limpiarForm();
}

const mostrar = document.getElementById('mostrar');
mostrar.addEventListener('click', () => {
	tablaLenteC(1);
});

export async function tablaLenteC(estatus) {
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
		const { producto, keratometria, fotografia, tipo } =
			lenteContacto;
		contenido +=
			/*html*/
			`
    <tr>
    <td>${producto.nombre}</td>
		<td>${producto.codigoBarras}</td>
    <td>${producto.marca}</td>
    <td>${producto.precioCompra}</td>
    <td>${producto.precioVenta}</td>
    <td>${producto.existencias}</td>
    <td>${keratometria}</td>
		<td>${tipo}</td>
    <td><img src="${fotografia}" alt="fotografia" width="100px" height=100px/></td>
		<td><button class="button is-primary has-icons-left" type='button' onclick="ml.cargarForm(${index})">
		<span class="icon is-left pt-2">
							<icon-eye></icon-eye>
						</span>
						
		</button></td>
    `;
		if (producto.estatus === 1) {
			contenido += `<td><button class="button is-danger has-icons-left" type='button' onclick="ml.eliminarLente(${producto.idProducto})">
			<span class="icon is-left pt-2">
							<icon-delete></icon-delete>
						</span>
						
			</button></td>`;
		} else {
			contenido += `<td><button class="button is-success has-icons-left" type='button' onclick="ml.activarLente(${producto.idProducto})">
			<span class="icon is-left pt-2">
							<icon-check></icon-check>
						</span>
						</button></td>`;
		}
	});
	document.querySelector('tbody').innerHTML = contenido;
}
export function saludar() {
	console.log('hola');
}

export async function eliminarLente(index) {
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
		mostrarAlerta(
			'error',
			'no se pudo eliminar el lente de contacto'
		);
		return;
	}
	mostrarAlerta('success', 'se elimino el lente de contacto');
	tablaLenteC('1');
}

const mostrarD = document.getElementById('mostrarD');
mostrarD.addEventListener('click', () => {
	tablaLenteC(0);
});
export async function activarLente(index) {
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
		mostrarAlerta('error', 'no se pudo activar el lente de contacto');
		return;
	}
	mostrarAlerta('success', 'se activo el lente de contacto');
	tablaLenteC('0');
}

const limpiar = document.getElementById('limpiar');
limpiar.addEventListener('click', () => {
	limpiarForm();
});

export function limpiarForm() {
	document.getElementById('form').reset();
	document.getElementById('imagen').src = '../public/default.png';
	lenteContactoActual = null;
}

export function cargarForm(index) {
	const lenteA = lentesContacto[index];
	lenteContactoActual = lenteA;
	const { producto, keratometria, fotografia, tipo } = lenteA;
	document.getElementById('nombre').value = producto.nombre;
	document.getElementById('marca').value = producto.marca;
	document.getElementById('precioCompra').value =
		producto.precioCompra;
	document.getElementById('precioVenta').value = producto.precioVenta;
	document.getElementById('existencias').value = producto.existencias;
	document.getElementById('keratometria').value = keratometria;
	document.getElementById('tipo').value = tipo;
	//poner la imagen en el input file
	const imagen = document.getElementById('imagen');
	imagen.src = fotografia;
}
const actualizar = document.getElementById('actualizar');
actualizar.addEventListener('click', () => {
	updateLenteC();
});
export async function updateLenteC() {
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
			fotografia: document.getElementById('imagen').src,
			tipo: document.getElementById('tipo').value
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
	if (data.error) {
		mostrarAlerta(
			'error',
			'Nose pudo actualizar el lente de contacto'
		);
	}
	mostrarAlerta('success', 'Lente de contacto actualizado');
	tablaLenteC(`${producto.estatus}`);
	limpiarForm();
}

const buscar = document.getElementById('buscar');
const buscarP = document.getElementById('buscarP');
buscarP.addEventListener('click', () => {
	realizarBusqueda();
});

export function realizarBusqueda() {
	//buscar si el valor de busqueda esta en el objeto empleado en alguna de sus propiedades
	//si lo encuentra, mostrarlo en la tabla agregando a coincidencias
	const busqueda = document.getElementById('buscar').value;
	const coincidencias = [];
	for (let i = 0; i < lentesContacto.length; i++) {
		const lenteContacto = lentesContacto[i];
		//nombre sin importar mayusculas o minusculas
		if (
			lenteContacto.producto.nombre
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			lenteContacto.producto.marca
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			lenteContacto.producto.precioCompra
				.toString()
				.includes(busqueda) ||
			lenteContacto.producto.precioVenta
				.toString()
				.includes(busqueda) ||
			lenteContacto.producto.existencias
				.toString()
				.includes(busqueda) ||
			lenteContacto.keratometria
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			lenteContacto.tipo
				.toLowerCase()
				.includes(busqueda.toLowerCase())
		) {
			coincidencias.push(lenteContacto);
		}
	}
	console.table(coincidencias);
	mostrarTabla(coincidencias, null);
}

function mostrarAlerta(icon, mensaje) {
	const Toast = Swal.mixin({
		toast: true,
		position: 'top-end',
		showConfirmButton: true,
		timer: 3000,
		timerProgressBar: true
	});

	Toast.fire({
		icon: icon,
		title: mensaje
	});
}
