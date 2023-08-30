
// Guardamos en una variable una funcion que muestra un cuadro de dialogo de tipo confirm
var dialogoConfirm = function (e) {
	if (!confirm('¿Realmente desea eliminar el producto?'))
	 e.preventDefault();
	 };

// Aplicamos a todos los elementos HTML que tengan la clase CSS 'confirmar' el evento click para que muestre el cuadro de dialogo de confirmacion. 
document.querySelectorAll('.confirmar').forEach(function(elemento) {
	elemento.addEventListener('click', dialogoConfirm, false);
	});
	