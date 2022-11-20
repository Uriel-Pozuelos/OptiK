let ma = null;
let ml = null;
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
};
