tablaEmpleado('1');
const form = document.getElementById('guardar');
let empleados = [];
form.addEventListener('click', () => {
	guardar();
});

export function guardar() {
	//validar formulario
	// if (validarForm() === false) {
	// 	console.log('formulario invalido');
	// 	return;
	// }
	const empleado = {
		datosEmpleados: JSON.stringify({
			persona: {
				nombre: document.getElementById('nombre').value,
				apellidoPaterno:
					document.getElementById('apellidoPaterno').value,
				apellidoMaterno:
					document.getElementById('apellidoMaterno').value,
				genero: document.getElementById('genero').value,
				fechaNacimiento: convertirFecha(
					document.getElementById('fechaNacimiento').value
				),
				telCasa: document.getElementById('telCasa').value,
				telMovil: document.getElementById('telMovil').value,
				calle: document.getElementById('calle').value,
				numero: document.getElementById('numero').value,
				colonia: document.getElementById('colonia').value,
				cp: document.getElementById('cp').value,
				ciudad: document.getElementById('ciudad').value,
				estado: document.getElementById('estado').value,
				email: document.getElementById('email').value
			},
			usuario: {
				nombre: document.getElementById('nombreUsuario').value,
				contrasenia: document.getElementById('contrasenia').value,
				rol: document.getElementById('rol').value
			}
		})
	};
	//mandar por urlEncoded el objeto empleado al servicio
	empleadoService(empleado);
	//limpiar el formulario
	limpiarForm();
	tablaEmpleado('1');
}
async function empleadoService(empleado) {
	const urlEncoded = new URLSearchParams(empleado);
	const reponse = await fetch(
		'http://localhost:8080/Optik/api/empleado/guardar',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: urlEncoded
		}
	);
	const data = await reponse.json();
	if (data.error) {
		mostrarAlerta('error', 'No se pudo guardar el empleado');
		return;
	}
	mostrarAlerta('success', 'Empleado guardado correctamente');
}
const btnMostrar = document.getElementById('mostrar');
btnMostrar.addEventListener('click', () => {
	tablaEmpleado('1');
});

const btnMostrarD = document.getElementById('mostrarD');
btnMostrarD.addEventListener('click', () => {
	tablaEmpleado('0');
});

//tabla con los datos del empleado
export async function tablaEmpleado(estatus) {
	//fetch para obtener los datos del empleado
	const response = await fetch(
		'http://localhost:8080/Optik/api/empleado/getallempleado',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({ estatus })
		}
	);
	const data = await response.json();
	if (data.error) {
		mostrarAlerta('error', 'No se pudo obtener los empleados');
		return;
	}
	//crear la tabla
	mostrarTabla(null, data);
}

async function mostrarTabla(coincidencias, data) {
	//obtener el tbody de la tabla con el id tabla-empleado
	if (coincidencias) {
		data = coincidencias;
	} else {
		empleados = data;
	}

	let contenido = '';
	data.forEach((empleado, index) => {
		const { persona, usuario } = empleado;
		contenido +=
			/*HTML*/
			`  
	<tr>
	<td>${persona.nombre} ${persona.apellidoPaterno} ${persona.apellidoMaterno} </td>
	<td>${persona.genero}</td>
	<td>${persona.fechaNacimiento}</td>
	<td>${persona.calle} ${persona.numero} ${persona.colonia} ${persona.cp} ${persona.ciudad} ${persona.estado}</td>
	<td>${persona.telCasa}</td>
	<td>${persona.telMovil}</td>
	<td>${usuario.nombre}</td>
	<td>${persona.email}</td>
	<td>${usuario.rol}</td>
	<td><button class="button is-primary has-icons-left" type='button' onclick="ma.cargarForm(${index})">
	<span class="icon is-left pt-2">
	<icon-eye></icon-eye>
</span>
			</button>
	</td>`;
		if (empleado.estatus === 0) {
			/*HTML*/
			contenido += `
			<td><button class="button is-success has-icons-left" type='button' onclick="ma.activarEmpleado(${empleados[index].IdEmpleado})">
			<span class="icon is-left pt-2">
							<icon-check></icon-check>
						</span>
			</button></td>
			</tr>
		`;
		} else {
			/*HTML*/
			contenido += `
			<td><button class="button is-danger has-icons-left" type='button' onclick="ma.eliminarEmpleado(${empleados[index].IdEmpleado})">
			<span class="icon is-left pt-2">
							<icon-delete></icon-delete>
						</span>
			</button>
			</td>
			</tr>
			`;
		}
	});
	document.querySelector('tbody').innerHTML = contenido;
}

export async function activarEmpleado(idEmpleado) {
	const response = await fetch(
		'http://localhost:8080/Optik/api/empleado/activateempleado',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({ idEmpleado: idEmpleado })
		}
	);
	const data = await response.json();
	if (data.error) {
		mostrarAlerta('error', 'No se pudo activar el empleado');
		return;
	}
	mostrarAlerta('success', 'Empleado activado correctamente');
	tablaEmpleado('0');
}

//funcion para cargar el formulario con los datos del empleado
export function cargarForm(index) {
	const empleado = empleados[index];
	const { persona, usuario } = empleado;
	document.getElementById('nombre').value = persona.nombre;
	document.getElementById('apellidoPaterno').value =
		persona.apellidoPaterno;
	document.getElementById('apellidoMaterno').value =
		persona.apellidoMaterno;
	document.getElementById('genero').value = persona.genero;
	document.getElementById('fechaNacimiento').value =
		persona.fechaNacimiento;
	persona.fechaNacimiento = convertirFecha(persona.fechaNacimiento);
	document.getElementById('telCasa').value = persona.telCasa;
	document.getElementById('telMovil').value = persona.telMovil;
	document.getElementById('calle').value = persona.calle;
	document.getElementById('numero').value = persona.numero;
	document.getElementById('colonia').value = persona.colonia;
	document.getElementById('cp').value = persona.cp;
	document.getElementById('numero').value = persona.numero;
	document.getElementById('ciudad').value = persona.ciudad;
	document.getElementById('estado').value = persona.estado;
	document.getElementById('email').value = persona.email;
	document.getElementById('nombreUsuario').value = usuario.nombre;
	document.getElementById('contrasenia').value = usuario.contrasenia;
	document.getElementById('rol').value = usuario.rol;
	document.getElementById('index').value = index;
}

const limpiar = document.getElementById('limpiar');
limpiar.addEventListener('click', limpiarForm);
export function limpiarForm() {
	document.getElementById('nombre').value = '';
	document.getElementById('apellidoPaterno').value = '';
	document.getElementById('apellidoMaterno').value = '';
	document.getElementById('genero').value = 'M';
	document.getElementById('fechaNacimiento').value = '';
	document.getElementById('telCasa').value = '';
	document.getElementById('telMovil').value = '';
	document.getElementById('calle').value = '';
	document.getElementById('numero').value = '';
	document.getElementById('colonia').value = '';
	document.getElementById('cp').value = '';
	document.getElementById('numero').value = '';
	document.getElementById('ciudad').value = '';
	document.getElementById('estado').value = 'Aguascalientes';
	document.getElementById('email').value = '';
	document.getElementById('nombreUsuario').value = '';
	document.getElementById('contrasenia').value = '';
	document.getElementById('rol').value = 'Administrador';
	document.getElementById('index').value = '';
}

//actualizar los datos del empleado en el arreglo de empleados
const actualizar = document.getElementById('actualizar');
actualizar.addEventListener('click', actualizarEmpleado);
export function actualizarEmpleado() {
	//obtener los datos del formulario y ponerlos en un objeto empleado
	const index = document.getElementById('index').value;
	const em = empleados[index];
	// if (validarForm() === false) {
	// 	console.log('formulario invalido');
	// 	return;
	// }

	const { persona, usuario } = em;
	const empleado = {
		persona: {
			idPersona: persona.idPersona,
			nombre: document.getElementById('nombre').value,
			apellidoPaterno:
				document.getElementById('apellidoPaterno').value,
			apellidoMaterno:
				document.getElementById('apellidoMaterno').value,
			genero: document.getElementById('genero').value,
			fechaNacimiento: convertirFecha(
				document.getElementById('fechaNacimiento').value
			),
			telCasa: document.getElementById('telCasa').value,
			telMovil: document.getElementById('telMovil').value,
			calle: document.getElementById('calle').value,
			numero: document.getElementById('numero').value,
			colonia: document.getElementById('colonia').value,
			cp: document.getElementById('cp').value,
			ciudad: document.getElementById('ciudad').value,
			estado: document.getElementById('estado').value,
			email: document.getElementById('email').value
		},
		usuario: {
			idUsuario: usuario.idUsuario,
			nombre: document.getElementById('nombreUsuario').value,
			contrasenia: document.getElementById('contrasenia').value,
			rol: document.getElementById('rol').value
		}
	};

	updateService(empleado);
}

async function updateService(empleado) {
	const index = document.getElementById('index').value;
	const em = empleados[index];

	const { persona, usuario } = empleado;

	const obj = {
		IdEmpleado: em.IdEmpleado,
		numeroUnico: em.numeroUnico,
		persona: persona,
		usuario: usuario
	};

	const e = {
		datosEmpleados: JSON.stringify(obj)
	};

	const response = await fetch(
		'http://localhost:8080/Optik/api/empleado/updateempleado',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams(e)
		}
	);
	const data = await response.json();
	if (data.error) {
		mostrarAlerta('error', 'No se pudo actualizar el empleado');
		return;
	}
	mostrarAlerta('success', 'Empleado actualizado correctamente');
	//actualizar la tabla
	tablaEmpleado('1');
}

export async function eliminarEmpleado(idEmpleado) {
	const resp = await fetch(
		'http://localhost:8080/Optik/api/empleado/deleteempleado',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({ idEmpleado })
		}
	);

	mostrarAlerta('success', 'Empleado eliminado correctamente');
	limpiarForm();
	tablaEmpleado('1');
}

//convertir 1901-01-01 a 01/01/1901
function convertirFecha(fecha) {
	const f = fecha.split('-');
	return `${f[2]}/${f[1]}/${f[0]}`;
}

const regexValidar = {
	//validar solo letras y números
	letrasNumeros: /^[a-zA-Z0-9]+$/,
	//validar solo letras y espacios
	letras: /^[a-zA-Z ]+$/,
	//validar solo números
	numeros: /^[0-9]+$/,
	//validar correo
	correo: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/,
	//validar contraseña (al menos 8 caracteres, al menos una letra y un número)
	contrasenia: /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/
};

function validarForm() {
	//arreglo para poner false si hay un error
	let errores = [];
	const body = document.querySelector('body');

	const nombre = document.getElementById('nombre');
	const apellidoPaterno = document.getElementById('apellidoPaterno');
	const apellidoMaterno = document.getElementById('apellidoMaterno');
	const telCasa = document.getElementById('telCasa');
	const telMovil = document.getElementById('telMovil');
	const calle = document.getElementById('calle');
	const numero = document.getElementById('numero');
	const colonia = document.getElementById('colonia');
	const cp = document.getElementById('cp');
	const ciudad = document.getElementById('ciudad');
	const email = document.getElementById('email');
	const nombreUsuario = document.getElementById('nombreUsuario');
	const contrasenia = document.getElementById('contrasenia');
	//validar nombre usando regex regexValidar.letrasNumeros
	if (!regexValidar.letras.test(nombre.value)) {
		nombre.classList.add('error');
		document.getElementById('nombreP').style.display = 'block';
		body.addEventListener('click', () => {
			nombre.classList.remove('error');
			document.getElementById('nombreP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letras.test(apellidoPaterno.value)) {
		apellidoPaterno.classList.add('error');
		document.getElementById('apellidoPaternoP').style.display =
			'block';
		body.addEventListener('click', () => {
			apellidoPaterno.classList.remove('error');
			document.getElementById('apellidoPaternoP').style.display =
				'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letras.test(apellidoMaterno.value)) {
		apellidoMaterno.classList.add('error');
		document.getElementById('apellidoMaternoP').style.display =
			'block';
		body.addEventListener('click', () => {
			apellidoMaterno.classList.remove('error');
			document.getElementById('apellidoMaternoP').style.display =
				'none';
		});
		errores.push('error');
	}
	if (!regexValidar.numeros.test(telCasa.value)) {
		telCasa.classList.add('error');
		document.getElementById('telCasaP').style.display = 'block';
		body.addEventListener('click', () => {
			telCasa.classList.remove('error');
			document.getElementById('telCasaP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.numeros.test(telMovil.value)) {
		telMovil.classList.add('error');
		document.getElementById('telMovilP').style.display = 'block';
		body.addEventListener('click', () => {
			telMovil.classList.remove('error');
			document.getElementById('telMovilP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letras.test(calle.value)) {
		calle.classList.add('error');
		document.getElementById('calleP').style.display = 'block';
		body.addEventListener('click', () => {
			calle.classList.remove('error');
			document.getElementById('calleP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.numeros.test(numero.value)) {
		numero.classList.add('error');
		document.getElementById('numeroP').style.display = 'block';
		body.addEventListener('click', () => {
			numero.classList.remove('error');
			document.getElementById('numeroP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letras.test(colonia.value)) {
		colonia.classList.add('error');
		document.getElementById('coloniaP').style.display = 'block';
		body.addEventListener('click', () => {
			colonia.classList.remove('error');
			document.getElementById('coloniaP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letrasNumeros.test(cp.value)) {
		cp.classList.add('error');
		document.getElementById('cpP').style.display = 'block';
		body.addEventListener('click', () => {
			cp.classList.remove('error');
			document.getElementById('cpP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letras.test(ciudad.value)) {
		ciudad.classList.add('error');
		document.getElementById('ciudadP').style.display = 'block';
		body.addEventListener('click', () => {
			ciudad.classList.remove('error');
			document.getElementById('ciudadP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.correo.test(email.value)) {
		email.classList.add('error');
		document.getElementById('emailP').style.display = 'block';
		body.addEventListener('click', () => {
			email.classList.remove('error');
			document.getElementById('emailP').style.display = 'none';
		});
		errores.push('error');
	}
	if (!regexValidar.letrasNumeros.test(nombreUsuario.value)) {
		nombreUsuario.classList.add('error');
		document.getElementById('nombreUsuarioP').style.display = 'block';
		body.addEventListener('click', () => {
			nombreUsuario.classList.remove('error');
			document.getElementById('nombreUsuarioP').style.display =
				'none';
		});
		errores.push('error');
	}
	if (!regexValidar.contrasenia.test(contrasenia.value)) {
		contrasenia.classList.add('error');
		document.getElementById('contraseniaP').style.display = 'block';
		body.addEventListener('click', () => {
			contrasenia.classList.remove('error');
			document.getElementById('contraseniaP').style.display = 'none';
		});
		errores.push('error');
	}
	//si no hay errores
	if (errores.length === 0) {
		return true;
	}
	if (errores.length > 0) {
		//limpiar el arreglo
		errores = [];
		return false;
	}
}

const buscarP = document.getElementById('buscarP');
buscarP.addEventListener('click', () => {
	realizarBusqueda();
});
//mostrar en la tabla si coincide la búsqueda en los elementos de alumnos
export function realizarBusqueda() {
	mostrarTabla(null, empleados);
	//buscar si el valor de busqueda esta en el objeto empleado en alguna de sus propiedades
	//si lo encuentra, mostrarlo en la tabla agregando a coincidencias
	const busqueda = document.getElementById('buscar').value;
	const coincidencias = [];
	for (let i = 0; i < empleados.length; i++) {
		const empleado = empleados[i];
		//nombre sin importar mayusculas o minusculas
		if (
			empleado.persona.nombre
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.apellidoPaterno
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.apellidoMaterno
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.telCasa
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.telMovil
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.calle
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.numero
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.colonia
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.cp
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.ciudad
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.email
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.usuario.nombre
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.genero
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.persona.fechaNacimiento
				.toLowerCase()
				.includes(busqueda.toLowerCase()) ||
			empleado.usuario.rol
				.toLowerCase()
				.includes(busqueda.toLowerCase())
		) {
			coincidencias.push(empleado);
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
