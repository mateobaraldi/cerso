// Alumno: Mateo Baraldi - Curso: 6to Año (Completar división)

const API_URL = "http://localhost:8080/api/students";

// Estado local para filtrado y ordenamiento sin reconsultar la API
let listaEstudiantes = [];
let ordenActual = { columna: "id", ascendente: true };

// Referencias al DOM
const form = document.getElementById("student-form");
const inputId = document.getElementById("student-id");
const inputFirstName = document.getElementById("firstName");
const inputLastName = document.getElementById("lastName");
const inputEmail = document.getElementById("email");
const inputAge = document.getElementById("age");
const btnGuardar = document.getElementById("btn-guardar");
const btnCancelar = document.getElementById("btn-cancelar");
const formTitulo = document.getElementById("form-titulo");
const tablaBody = document.getElementById("tabla-body");
const mensajeDiv = document.getElementById("mensaje");
const buscador = document.getElementById("buscador");

let timeoutMensaje;

// Muestra avisos de éxito o error en pantalla sin usar alert()
function mostrarMensaje(texto, tipo) {
    clearTimeout(timeoutMensaje);
    mensajeDiv.textContent = texto;
    mensajeDiv.className = `mensaje ${tipo}`;

    timeoutMensaje = setTimeout(() => {
        mensajeDiv.className = "mensaje oculto";
    }, 5000);
}

// Formatea los errores 400 devueltos por Spring Boot (errors o message)
function extraerMensajeError(data, status) {
    if (data && data.errors) {
        return Object.values(data.errors).join(" | ");
    }
    if (data && data.message) {
        return data.message;
    }
    return `Error HTTP ${status}`;
}

// Actividad 2: GET todos los estudiantes
async function cargarEstudiantes() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error(`Error ${response.status}`);
        }
        listaEstudiantes = await response.json();
        aplicarFiltroYRenderizar();
    } catch (error) {
        if (error instanceof TypeError) {
            mostrarMensaje("No se pudo conectar con el servidor", "error");
        } else {
            mostrarMensaje("Error al cargar estudiantes: " + error.message, "error");
        }
    }
}

// Dibuja la tabla en el DOM
function renderizarTabla(estudiantes) {
    tablaBody.innerHTML = "";

    if (estudiantes.length === 0) {
        const tr = document.createElement("tr");
        tr.innerHTML = `<td colspan="6" class="empty-row">No hay estudiantes registrados</td>`;
        tablaBody.appendChild(tr);
        return;
    }

    estudiantes.forEach((est) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${est.id}</td>
            <td>${est.firstName}</td>
            <td>${est.lastName}</td>
            <td>${est.email}</td>
            <td>${est.age ?? "-"}</td>
            <td>
                <button type="button" class="btn btn-edit" data-id="${est.id}">Editar</button>
                <button type="button" class="btn btn-delete" data-id="${est.id}">Eliminar</button>
            </td>
        `;
        tablaBody.appendChild(tr);
    });
}

// Desafío opcional: Filtro por apellido y ordenamiento por columna
function aplicarFiltroYRenderizar() {
    const termino = buscador.value.trim().toLowerCase();

    const filtrados = listaEstudiantes.filter((est) =>
        est.lastName.toLowerCase().includes(termino)
    );

    filtrados.sort((a, b) => {
        const valA = a[ordenActual.columna] ?? "";
        const valB = b[ordenActual.columna] ?? "";

        if (typeof valA === "number" && typeof valB === "number") {
            return ordenActual.ascendente ? valA - valB : valB - valA;
        }
        return ordenActual.ascendente
            ? String(valA).localeCompare(String(valB))
            : String(valB).localeCompare(String(valA));
    });

    renderizarTabla(filtrados);
}

// Actividad 3 y 4: Crear (POST) o Actualizar (PUT) estudiante
async function guardarEstudiante(event) {
    event.preventDefault();

    const id = inputId.value;
    const estudianteData = {
        firstName: inputFirstName.value.trim(),
        lastName: inputLastName.value.trim(),
        email: inputEmail.value.trim(),
        age: inputAge.value !== "" ? Number(inputAge.value) : null
    };

    const esEdicion = Boolean(id);
    const url = esEdicion ? `${API_URL}/${id}` : API_URL;
    const metodo = esEdicion ? "PUT" : "POST";

    try {
        const response = await fetch(url, {
            method: metodo,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(estudianteData)
        });

        if (!response.ok) {
            const errorData = await response.json().catch(() => null);
            if (response.status === 404) {
                resetearFormulario();
                await cargarEstudiantes();
            }
            mostrarMensaje(extraerMensajeError(errorData, response.status), "error");
            return;
        }

        const msgExito = esEdicion
            ? "Estudiante actualizado correctamente."
            : "Estudiante registrado correctamente.";

        resetearFormulario();
        mostrarMensaje(msgExito, "exito");
        await cargarEstudiantes();
    } catch (error) {
        mostrarMensaje("No se pudo conectar con el servidor", "error");
    }
}

// Actividad 4: Cargar datos en formulario para editar (GET por ID)
async function prepararEdicion(id) {
    try {
        const response = await fetch(`${API_URL}/${id}`);

        if (!response.ok) {
            const errorData = await response.json().catch(() => null);
            mostrarMensaje(extraerMensajeError(errorData, response.status), "error");
            if (response.status === 404) {
                await cargarEstudiantes();
            }
            return;
        }

        const est = await response.json();
        inputId.value = est.id;
        inputFirstName.value = est.firstName;
        inputLastName.value = est.lastName;
        inputEmail.value = est.email;
        inputAge.value = est.age ?? "";

        formTitulo.textContent = `Editando Estudiante #${est.id}`;
        btnGuardar.textContent = "Actualizar";
        inputFirstName.focus();
    } catch (error) {
        mostrarMensaje("No se pudo conectar con el servidor", "error");
    }
}

// Actividad 5: Eliminar estudiante (DELETE)
async function eliminarEstudiante(id) {
    if (!confirm(`¿Seguro que deseas eliminar al estudiante con ID ${id}?`)) {
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) {
            const errorData = await response.json().catch(() => null);
            mostrarMensaje(extraerMensajeError(errorData, response.status), "error");
            if (response.status === 404) {
                await cargarEstudiantes();
            }
            return;
        }

        if (inputId.value === String(id)) {
            resetearFormulario();
        }

        mostrarMensaje("Estudiante eliminado correctamente.", "exito");
        await cargarEstudiantes();
    } catch (error) {
        mostrarMensaje("No se pudo conectar con el servidor", "error");
    }
}

// Vuelve el formulario al estado inicial (modo crear)
function resetearFormulario() {
    form.reset();
    inputId.value = "";
    formTitulo.textContent = "Nuevo Estudiante";
    btnGuardar.textContent = "Guardar";
}

// Eventos
document.addEventListener("DOMContentLoaded", cargarEstudiantes);
form.addEventListener("submit", guardarEstudiante);
btnCancelar.addEventListener("click", resetearFormulario);
buscador.addEventListener("input", aplicarFiltroYRenderizar);

// Delegación de eventos para los botones Editar y Eliminar de la tabla
tablaBody.addEventListener("click", (event) => {
    const target = event.target;
    const id = target.dataset.id;

    if (!id) return;

    if (target.classList.contains("btn-edit")) {
        prepararEdicion(id);
    } else if (target.classList.contains("btn-delete")) {
        eliminarEstudiante(id);
    }
});

// Ordenamiento al hacer clic en encabezados de tabla
document.querySelectorAll("th.sortable").forEach((th) => {
    th.addEventListener("click", () => {
        const columna = th.dataset.col;
        if (ordenActual.columna === columna) {
            ordenActual.ascendente = !ordenActual.ascendente;
        } else {
            ordenActual.columna = columna;
            ordenActual.ascendente = true;
        }
        aplicarFiltroYRenderizar();
    });
});