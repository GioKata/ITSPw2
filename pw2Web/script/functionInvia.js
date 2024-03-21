function invia() {
    var nome = document.getElementById("nome").value;
    var cognome = document.getElementById("cognome").value;
    var email = document.getElementById("email").value;
    var letteraDiRichiamo = document.getElementById("letteraDiRichiamo").value;

    // Verifica se tutti i campi sono stati compilati
    if (nome !== "" && cognome !== "" && email !== "" && letteraDiRichiamo.trim() !== "") {
        // Controllo validità email
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            alert('Inserisci un indirizzo email valido.');
            return; // Interrompi l'esecuzione se l'email non è valida
        }
        var messaggio = "La lettera di richiamo è stata inviata con successo al dipendente: " + nome + " " + cognome;
        window.alert(messaggio);
    } else {
        window.alert("Inserisci tutti i dati");
    }

    // Controllo validità email
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert('Inserisci un indirizzo email valido.');
        return; // Interrompi l'esecuzione se l'email non è valida
    }
}