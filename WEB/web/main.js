const btn = document.querySelector('button');

const cambiarContenido = async () => {
	const res = await fetch('gestion/index.html');
	const data = await res.text();
	document.getElementById('app').innerHTML = data;
	//cargar el script de empleado.controller.js
	const script = document.createElement('script');
	script.src = 'gestion/empleado.controller.js';
	document.body.appendChild(script);
};
cambiarContenido();
btn.addEventListener('click', cambiarContenido);
