let clientes = [];
let examenVista = [];
let armazones = [];

export function inicializarComponentes() {
	getAllClientes();
	getAllArmazon();
	getAllMaterial();
}

export function getAllClientes() {
	let datos = { estatus: 1 };
	let parametros = new URLSearchParams(datos);

	fetch(
		'http://localhost:8080/Optik/api/restcliente/getAllClientes',
		{
			method: 'POST',
			body: parametros,
			headers: {
				'Content-Type':
					'application/x-www-form-urlencoded;charset=UTF-8'
			}
		}
	)
		.then(response => response.json())
		.then(data => {
			if (data.error) {
				mostrarAlerta('error', 'Error al obtener clientes');
				return;
			}
			clientes = data;

			let selectCliente = document.getElementById('selectCliente');
			let conteido =
				'<option value="0">Seleccione un cliente</option>';
			clientes.forEach(cliente => {
				conteido += `<option value="${cliente.idCliente}">${cliente.persona.nombre} ${cliente.persona.apellidoPaterno} ${cliente.persona.apellidoMaterno}</option>`;
			});
			selectCliente.innerHTML = conteido;
		});
}

export function filterCliente(nombre) {
	let clientesFiltrados = clientes.filter(cliente =>
		cliente.persona.nombre
			.toLowerCase()
			.includes(nombre.toLowerCase())
	);
	let selectCliente = document.getElementById('selectCliente');
	let conteido = '<option value="0">Seleccione un cliente</option>';
	clientesFiltrados.forEach(cliente => {
		conteido += `<option value="${cliente.idCliente}">${cliente.persona.nombre} ${cliente.persona.apellidoPaterno} ${cliente.persona.apellidoMaterno}</option>`;
	});
	selectCliente.innerHTML = conteido;
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
let idCliente = document.querySelector('#selectCliente');
idCliente.addEventListener('change', () => {
	let idCliente = document.querySelector('#selectCliente').value;
	console.log(idCliente);
	getAllExamenVista(idCliente);
});
//cargar los examenes en el select
export function getAllExamenVista(idCliente) {
	let datosEv = { estatus: 1 };
	let parametrosC = new URLSearchParams(datosEv);

	fetch(
		'http://localhost:8080/Optik/api/examenVista/getAllExamenVista',
		{
			method: 'POST',
			body: parametrosC,
			headers: {
				'Content-Type':
					'application/x-www-form-urlencoded;charset=UTF-8'
			}
		}
	)
		.then(response => response.json())
		.then(dataEv => {
			// alert(JSON.stringify(data));
			examenVista = dataEv;
			if (dataEv.error) {
				mostrarAlerta(
					'error',
					'Error al obtener los examenes de vista'
				);
			} else {
				console.log({ dataEv });
				//filtrar los examenes de vista por cliente en base al idCliente
				let examenesVista = dataEv.filter(
					examenVista => examenVista.cliente.idCliente == idCliente
				);
				console.log(examenesVista);

				let select = document.querySelector('#selectGraduacion');
				select =
					"<option value=''>Seleccione un examen de vista</option>";
				examenesVista.forEach(examenVista => {
					select += `
          <option value="${examenVista.idExamenVista}">
          ${
						examenVista.cliente.persona.nombre +
						' ' +
						examenVista.idExamenVista
					}
          ${new Date(examenVista.fecha).toLocaleString()} </option>
          `;
				});

				document.querySelector('#selectGraduacion').innerHTML =
					select;
			}
		});
}

export function getAllArmazon() {
	let datos = { estatus: '1' };
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
				armazones = data;
				let select = document.querySelector('#selectArmazon');
				select = "<option value=''>Seleccione un armazon</option>";
				data.forEach(armazon => {
					select += `
          <option value="${armazon.idArmazon}">
          ${armazon.producto.nombre} - ${armazon.producto.marca}  - ${armazon.producto.precioVenta}
          </option>
          `;
				});
				document.querySelector('#selectArmazon').innerHTML = select;
			}
		});
}

export function getAllMaterial() {
	let datos = { estatus: 1 };
	let params = new URLSearchParams(datos);

	fetch('http://localhost:8080/Optik/api/material/getAll', {
		method: 'POST',
		body: params,
		headers: {
			'Content-Type':
				'application/x-www-form-urlencoded;charset=UTF-8'
		}
	})
		.then(response => response.json())
		.then(data => {
			if (data.error) {
				mostrarAlerta('error', 'Error al obtener los materiales');
			} else {
				let select = document.querySelector('#selectMaterial');
				select = "<option value=''>Seleccione un material</option>";
				data.forEach(material => {
					select += `
          <option value="${material.idMaterial}">
          ${material.nombre} - ${material.precioVenta}
          </option>
          `;
				});
				document.querySelector('#selectMaterial').innerHTML = select;
			}
		});
}

const venta = document.querySelector('#buscarL');
venta.addEventListener('click', async () => {
	let clave = `OQ-${Math.floor(Math.random() * 100000000000)}`;
	let empleado = JSON.parse(localStorage.getItem('currentUser'));
	//encontrar en el arreglo de examenes de vista el id del examen seleccionado
	let idExamenVista = document.querySelector('#selectExamen').value;
	idExamenVista = examenVista.find(
		examenVista => examenVista.idExamenVista == idExamenVista
	);
	const presupuesto = {
		examenVista: idExamenVista,
		clave: clave
	};

	const presupuestoLentes = {
		armazon:
			armazones[document.querySelector('#selectArmazon').value],
		material:
			materiales[document.querySelector('#selectMaterial').value],
		alturaOblea: '',
		listaTratamiento: [],
		tipoMica: {}
	};

	//ver que checkbox estan seleccionados de los tratamientos
	const tratamientos = document.querySelectorAll('#tratamientos');
	tratamientos.forEach(tratamiento => {
		if (tratamiento.checked) {
			presupuestoLentes.listaTratamiento.push({
				idTratamiento: tratamiento.value
			});
		}
	});

	//ver que tipo de mica esta seleccionado
	const tipoMica = document.querySelector('#selectMica');
	if (tipoMica.value === 'estetica') {
		presupuestoLentes.tipoMica = {
			idTipoMica: 1,
			nombre: 'Estetica',
			precioVenta: 400,
			precioCompra: 300
		};
	}
	if (tipoMica.value === 'graduacion') {
		presupuestoLentes.tipoMica = {
			idTipoMica: 2,
			nombre: 'Graduacion',
			precioVenta: 600,
			precioCompra: 500
		};
	}

	const venta = {
		empleado: empleado,
		clave: clave
	};

	const ventaPresupuestosLC = [];

	const DetalleVentaPresupuestoLentes = {
		venta: venta,
		ventaPresupuestosLC: ventaPresupuestosLC
	};
});
