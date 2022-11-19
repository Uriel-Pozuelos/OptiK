const btn = document.querySelector('button');

const cambiarEmpleado = async () => {
	const res = await fetch('modulos/empleado/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de empleado.controller.js
	const script = document.createElement('script');
	script.src = 'modulos/empleado/empleado.controller.js';
	document.body.appendChild(script);
};
//cambiarContenido();
btn.addEventListener('click', cambiarEmpleado);

const cambiarLenteContacto = async () => {
	const res = await fetch('modulos/lenteContacto/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de lenteContacto.controller.js
	const script = document.createElement('script');
	script.src = 'modulos/lenteContacto/lenteContacto.controller.js';
	document.body.appendChild(script);
};
cambiarLenteContacto();
//cambiarEmpleado();
