// Validación básica de formulario (archivo externo)
document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formRegistro");
  const nombre = document.getElementById("nombre");
  const email = document.getElementById("email");
  const password = document.getElementById("password");

  const boxErrores = document.getElementById("errores");
  const boxOk = document.getElementById("ok");

  function showErrors(errors) {
    if (errors.length === 0) {
      boxErrores.classList.add("d-none");
      boxErrores.innerHTML = "";
      return;
    }
    boxOk.classList.add("d-none");
    boxErrores.classList.remove("d-none");
    boxErrores.innerHTML = "<strong>Revisa esto:</strong><ul class='mb-0'>" +
      errors.map(e => `<li>${e}</li>`).join("") +
      "</ul>";
  }

  function isValidEmail(value) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/.test(value);
  }

  function hasLetterAndNumber(value) {
    return /[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]/.test(value) && /\d/.test(value);
  }

  form.addEventListener("submit", (e) => {
    const errors = [];

    const n = nombre.value.trim();
    const em = email.value.trim();
    const pw = password.value;

    if (n.length === 0) errors.push("El nombre es obligatorio.");
    else if (n.length < 2 || n.length > 40) errors.push("El nombre debe tener entre 2 y 40 caracteres.");

    if (em.length === 0) errors.push("El email es obligatorio.");
    else if (!isValidEmail(em)) errors.push("El email no tiene un formato válido.");

    if (pw.trim().length === 0) errors.push("La contraseña es obligatoria.");
    else {
      if (pw.length < 8) errors.push("La contraseña debe tener mínimo 8 caracteres.");
      if (pw.length > 64) errors.push("La contraseña no puede superar 64 caracteres.");
      if (!hasLetterAndNumber(pw)) errors.push("La contraseña debe incluir letras y números.");
    }

    if (errors.length > 0) {
      e.preventDefault();
      showErrors(errors);
      return;
    }

    e.preventDefault();
    showErrors([]);
    boxOk.classList.remove("d-none");
    setTimeout(() => form.submit(), 350);
  });
});
