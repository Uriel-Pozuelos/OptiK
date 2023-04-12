const SERVER = 'http://localhost:8080/Optik';
let detalleVentaProducto = [];
const card = document.querySelector('#card');
let clg = console.log;
async function getAllDetalleVentaProducto() {
    const data = await fetch(`${SERVER}/api/venta/getAllDetalles`,{
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
        <div class="content">
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
          <p class="subtitle is-6">Total de venta: $${totalVenta.toFixed(2)}</p>
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
