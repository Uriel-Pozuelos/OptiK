const SERVER = 'http://localhost:8080/Optik';
let detalleVentaProducto = [];
const card = document.querySelector('#card');
let clg = console.log;
async function getAllDetalleVentaProducto() {
	const data = await fetch(`${SERVER}/api/venta/getAllDetalles`, {
		method: 'POST'
	}).then(resp => resp.json());
	detalleVentaProducto = data;
	renderDetalleVentas(detalleVentaProducto);
}

getAllDetalleVentaProducto();

function cardTemplate(detalleVentaProducto) {
	let ventasProducto = detalleVentaProducto.ventasProducto;
	let venta = detalleVentaProducto.venta;

	let card = `
    <div class="card p-5 m-3">
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-4">${venta.clave}</p>
            <p class="subtitle is-6">ID de venta: ${venta.idVenta}</p>
            <p class="subtitle is-6">Empleado: ${venta.empleado.persona.nombre} ${venta.empleado.persona.apellidoPaterno} ${venta.empleado.persona.apellidoMaterno}</p>
          </div>
        </div>
        <div class="content scroll">
          <table class="table is-fullwidth is-striped">
            <thead>
              <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Descuento</th>
                <th>Total</th>
              </tr>
            </thead>
            <tbody>
  `;

	let totalVenta = 0;
	ventasProducto.forEach(ventaProducto => {
		let producto = ventaProducto.producto;
		let cantidad = ventaProducto.cantidad;
		let precioUnitario = ventaProducto.precioUnitario;
		let descuento = ventaProducto.descuento;
		let total = (precioUnitario - descuento) * cantidad;
		totalVenta += total;

		card += `
      <tr>
        <td>${producto.nombre}</td>
        <td>${cantidad}</td>
        <td>${precioUnitario}</td>
        <td>${descuento}</td>
        <td>${total}</td>
      </tr>
    `;
	});

	card += `
            </tbody>
          </table>
          <p class="subtitle is-6">Total de venta: $${totalVenta.toFixed(
						2
					)}</p>
        </div>
      </div>
    </div>
  `;

	return card;
}

function renderDetalleVentas(detalleVentas) {
	let renderedVentas = {}; // Objeto para mantener un registro de los ids de venta procesados

	let container = document.getElementById('card');
	container.innerHTML = '';

	detalleVentas.forEach(detalleVenta => {
		let ventaId = detalleVenta.venta.idVenta;

		// Verificar si el id de la venta ya ha sido procesado
		if (!renderedVentas[ventaId]) {
			renderedVentas[ventaId] = true; // Marcar el id de la venta como procesado

			let cards = cardTemplate(detalleVenta);
			container.insertAdjacentHTML('beforeend', cards);
		}
	});
}
// ... Definición de la función cardTemplate ...

// Función para buscar las ventas que coincidan con los términos de búsqueda ingresados
function buscarVentas() {
	// Buscar por QR, número de venta o nombre del empleado
	let filteredDetalleVentaProducto = detalleVentaProducto.filter(
		detalleVenta => {
			let productos = detalleVenta.ventasProducto;
			let venta = detalleVenta.venta;
			let empleado = venta.empleado.persona;
			let nombreEmpleado =
				`${empleado.nombre} ${empleado.apellidoPaterno} ${empleado.apellidoMaterno}`.toLowerCase();
			let clave = venta.clave.toLowerCase();
			let nombresProductos = productos.map(
				producto => producto.producto.nombre
			);

			let searchTerm = document
				.getElementById('search-input')
				.value.toLowerCase()
				.trim();
			// ver que elemento se quiere buscar en base al select search-select
			// <option value="0">Número de venta</option>
			// 			<option value="1">Empleado</option>
			// 			<option value="2">Producto</option>
			let searchSelect =
				document.getElementById('search-select').value;
			if (searchSelect == 0) {
				return clave.includes(searchTerm);
			} else if (searchSelect == 1) {
				return nombreEmpleado.includes(searchTerm);
			} else if (searchSelect == 2) {
				return nombresProductos.includes(searchTerm);
			}
		}
	);
	mostrarVentas(filteredDetalleVentaProducto);
}

// Función para mostrar la lista de ventas
function mostrarVentas(detalleVentaProducto) {
	let cardsContainer = document.getElementById('card');
	cardsContainer.innerHTML = '';
	detalleVentaProducto.forEach(venta => {
		let card = document.createElement('div');
		card.innerHTML = cardTemplate(venta);
		cardsContainer.appendChild(card);
	});
}

// Agregar evento de escucha al input de búsqueda para buscar ventas en tiempo real
document
	.getElementById('search-input')
	.addEventListener('keyup', buscarVentas);
