let ma = null;
let ml = null;
let mac = null;
let mar = null;
let mm = null;

const empleado = document.getElementById('empleado');
empleado.addEventListener('click', () => {
	cambiarEmpleado();
});
const cambiarEmpleado = async () => {
	const res = await fetch('./empleado/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de empleado.controller.js con un import dinamico
	const obj = await import('./empleado/empleado.controller.js');
	ma = obj;
	ma.tablaEmpleado('1');
	//guardar en el localstorage la vista actual
	localStorage.setItem('vistaActual', 'empleado');
};

const lenteContacto = document.getElementById('lenteContacto');
lenteContacto.addEventListener('click', () => {
	cambiarLenteContacto();
});
const cambiarLenteContacto = async () => {
	//cargamos el html de lenteContacto en el div app
	const res = await fetch('./lenteContacto/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de lenteContacto.controller.js con un import dinamico cada vez que se cambie de vista
	const obj = await import(
		'./lenteContacto/lenteContacto.controller.js'
	);
	ml = obj;
	ml.tablaLenteC('1');

	//guardar en el localstorage la vista actual
	localStorage.setItem('vistaActual', 'lenteContacto');
};

const accesorio = document.getElementById('accesorio');
accesorio.addEventListener('click', () => {
	cambiarAccesorio();
});
const cambiarAccesorio = async () => {
	//cargamos el html de accesorio en el div app
	const res = await fetch('./accesorio/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de accesorio.controller.js con un import dinamico cada vez que se cambie de vista
	const obj = await import('./accesorio/accesorio.controller.js');
	mac = obj;
	mac.tablaAccesorio('1');
	//guardar en el localstorage la vista actual
	localStorage.setItem('vistaActual', 'accesorio');
};

const armazon = document.getElementById('armazon');
armazon.addEventListener('click', () => {
	cambiarArmazon();
});
const cambiarArmazon = async () => {
	//cargamos el html de armazon en el div app
	const res = await fetch('./armazon/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de armazon.controller.js con un import dinamico cada vez que se cambie de vista
	const obj = await import('./armazon/armazon.controller.js');
	mar = obj;
	mar.getAll(1);

	//guardar en el localstorage la vista actual
	localStorage.setItem('vistaActual', 'armazon');
};

const cargarHome = () => {
	window.location.replace('../modulos/');
};

function cerrarSesion() {
	localStorage.setItem('vistaActual', '');
	localStorage.setItem('token', '');
	setTimeout(() => {
		window.location.replace('../');
	}, 500);
}

const material = document.getElementById('material');
material.addEventListener('click', () => {
	cambiarMaterial();
});
const cambiarMaterial = async () => {
	const res = await fetch('./material/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de material.controller.js con un import dinamico
	const obj = await import('./material/material.controller.js');
	mm = obj;
	mm.getAll();
	//guardar en el localstorage la vista actual
	localStorage.setItem('vistaActual', 'material');
};

function cargarVista() {
	const vista = localStorage.getItem('vistaActual');
	switch (vista) {
		case 'empleado':
			cambiarEmpleado();
			break;
		case 'armazon':
			cambiarArmazon();
			break;
		case 'accesorio':
			cambiarAccesorio();
			break;
		case 'lenteContacto':
			cambiarLenteContacto();
			break;
		case 'material':
			cambiarMaterial();
			break;
	}
}

//validar si en localstorage el token es igual a 1 si es asi cargar la vista si no redireccionar al login
const token = localStorage.getItem('token');
if (token == 1) {
	cargarVista();
} else {
	window.location.replace('../');
}

document.addEventListener('DOMContentLoaded', () => {
	// Get all "navbar-burger" elements
	const $navbarBurgers = Array.prototype.slice.call(
		document.querySelectorAll('.navbar-burger'),
		0
	);

	// Add a click event on each of them
	$navbarBurgers.forEach(el => {
		el.addEventListener('click', () => {
			// Get the target from the "data-target" attribute
			const target = el.dataset.target;
			const $target = document.getElementById(target);

			// Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
			el.classList.toggle('is-active');
			$target.classList.toggle('is-active');
		});
	});
});
