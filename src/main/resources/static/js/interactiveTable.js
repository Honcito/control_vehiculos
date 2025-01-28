document.addEventListener("DOMContentLoaded", function() {
    function saveCellData(cell) {
        let id = cell.getAttribute("data-id");
        let field = cell.classList.contains("observaciones") ? "observaciones" :
            cell.classList.contains("fecha-salida") ? "fecha_salida" :
                "fecha_entrada";
        let value = cell.textContent;

        fetch(`/control_vehiculos/${id}/${field}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(value)
        });
    }

    function saveNewRow(newRow) {
        let controlVehiculos = {
            vehiculo: {
                matricula: newRow[0].textContent,
                propietario: {
                    empresa: newRow[1].textContent
                }
            },
            fecha_salida: newRow[2].textContent,
            observaciones: newRow[3].textContent,
            fecha_entrada: newRow[4].textContent
        };

        fetch(`/control_vehiculos/`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(controlVehiculos)
        }).then(response => response.json())
            .then(data => {
                // Limpiar la fila de entrada después de guardar
                newRow.forEach(cell => cell.textContent = '');
            });
    }

    document.querySelectorAll(".observaciones, .fecha-salida, .fecha-entrada").forEach(function(element) {
        element.addEventListener("blur", function(event) {
            saveCellData(event.target);
        });

        element.addEventListener("keydown", function(event) {
            if (event.key === "Enter") {
                event.preventDefault();
                saveCellData(event.target);
                moveToNextCell(event.target);
            }
        });

        element.addEventListener("click", function(event) {
            if (event.target.classList.contains("fecha-entrada") || event.target.classList.contains("fecha-salida")) {
                let currentDateTime = new Date().toISOString().slice(0, 19).replace('T', ' ');
                event.target.textContent = currentDateTime;
                saveCellData(event.target);
            }
        });
    });

    document.querySelectorAll(".new-control").forEach(function(element) {
        element.addEventListener("blur", function(event) {
            let newRow = document.querySelectorAll(".new-control");
            saveNewRow(newRow);
        });

        element.addEventListener("keydown", function(event) {
            if (event.key === "Enter") {
                event.preventDefault();
                let newRow = document.querySelectorAll(".new-control");
                saveNewRow(newRow);
                moveToNextCell(event.target);
            }
        });

        element.addEventListener("click", function(event) {
            if (event.target.classList.contains("fecha-entrada") || event.target.classList.contains("fecha-salida")) {
                let currentDateTime = new Date().toISOString().slice(0, 19).replace('T', ' ');
                event.target.textContent = currentDateTime;
            }
        });
    });

    function moveToNextCell(cell) {
        let cells = Array.from(document.querySelectorAll('[contenteditable="true"]'));
        let index = cells.indexOf(cell);
        if (index !== -1 && index < cells.length - 1) {
            cells[index + 1].focus();
        } else if (index !== -1) {
            cells[0].focus();
        }
    }
});
