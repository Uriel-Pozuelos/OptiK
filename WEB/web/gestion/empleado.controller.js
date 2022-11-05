const form = document.querySelectorAll('form');
let empleados = [];
form[1].addEventListener('submit', e => {
	e.preventDefault();
	let persona = Object.fromEntries(new FormData(form[0]));
	const usuario = Object.fromEntries(new FormData(form[1]));
	//convertir fecha a dd/mm/yyyy
	persona.fechaNacimiento = convertirFecha(persona.fechaNacimiento);
	const empleado = {
		datosEmpleados: JSON.stringify({
			persona: persona,
			usuario: usuario
		})
	};
	console.log(empleado);
	//mandar por urlEncoded el objeto empleado al servicio
	empleadoService(empleado);
});

const fecha = document.getElementById('fechaNacimiento');
fecha.addEventListener('change', e => {
	const fechaNacimiento = e.target.value;
	console.log(fechaNacimiento);
});

// funcion que envia el objeto empleado al servicio
async function empleadoService(empleado) {
	//convetir empleado a urlEncoded
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
	console.log(data);
}
const btnMostrar = document.getElementById('mostrar');
btnMostrar.addEventListener('click', tablaEmpleado);

//tabla con los datos del empleado
async function tablaEmpleado(empleado) {
	//fetch para obtener los datos del empleado
	const response = await fetch(
		'http://localhost:8080/Optik/api/empleado/getallempleado',
		{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: new URLSearchParams({ estatus: '1' })
		}
	);
	const data = await response.json();
	console.table(data);
	if (data.error) {
		alert(data.error);
		return;
	}
	//crear la tabla
	mostrarTabla(data);
}

async function mostrarTabla(data) {
	//obtener el tbody de la tabla con el id tabla-empleado
	empleados = data;

	let contenido = '';
	data.forEach((empleado, index) => {
		const { persona, usuario } = empleado;

		contenido +=
			/*HTML*/
			`  
		<tr>
				<td>${persona.nombre} ${persona.apellidoPaterno} ${persona.apellidoMaterno} </td>
				<td>${persona.genero}</td>
				<td>${persona.calle} ${persona.numero} ${persona.colonia} ${persona.cp} ${persona.ciudad} ${persona.estado}</td>
				<td>${usuario.nombre}</td>
				<td>${persona.email}</td>
				<td><button class="button is-primary" type='button' onclick="cargarForm(${index})">Ver</button></td>
		</tr>
		`;
	});
	document.querySelector('tbody').innerHTML = contenido;
}

//funcion para cargar el formulario con los datos del empleado
function cargarForm(index) {
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
function limpiarForm() {
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
	document.getElementById('estado').value = '';
	document.getElementById('email').value = '';
	document.getElementById('nombreUsuario').value = '';
	document.getElementById('contrasenia').value = '';
	document.getElementById('rol').value = 'Administrador';
	document.getElementById('index').value = '';
}

//actualizar los datos del empleado en el arreglo de empleados
const actualizar = document.getElementById('actualizar');
actualizar.addEventListener('click', actualizarEmpleado);
function actualizarEmpleado() {
	//obtener los datos del formulario y ponerlos en un objeto empleado
	const index = document.getElementById('index').value;
	const em = empleados[index];

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
	console.log(e);

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
	console.log(data);
	if (data.error) {
		alert(data.error);
		return;
	}
	//actualizar la tabla
	tablaEmpleado();
}

//eliminar un empleado del arreglo de empleados
const eliminar = document.getElementById('eliminar');
eliminar.addEventListener('click', eliminarEmpleado);
function eliminarEmpleado() {
	const index = document.getElementById('index').value;
	empleados.splice(index, 1);
	mostrarTabla(empleados);
	limpiarForm();
}

//convertir 1901-01-01 a 01/01/1901
function convertirFecha(fecha) {
	const f = fecha.split('-');
	return `${f[2]}/${f[1]}/${f[0]}`;
}
