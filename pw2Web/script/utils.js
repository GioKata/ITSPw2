


function fetchGet(url) {
    return new Promise(function (resolve, reject) {
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');
        
        // effettuo la chiamata all'API con il metodo GET
        fetch(url, {
            method: 'GET',
            headers: headers,
            mode: 'cors'
        }).then(response => {
            // promise: arriva la risposta
            if (response.ok) {
                // se la risposta è ok, ne prendo il contenuto in formato json
                resolve(response.json());
            } else {
                // se il codice di risposta non è OK, consideriamo l'errore
                response.json().then(error => {
                    console.log('Errore API:', error);
                    reject(new Error(error.message || 'Errore nell\'API'));
                }).catch(err => {
                    console.log('Errore nella risposta JSON:', err);
                    reject(new Error('Errore nella risposta dell\'API'));
                });
            }
        }).catch(error => {
            console.log('Errore durante la richiesta:', error);
            reject(new Error('Errore durante la richiesta'));
        });
    });
}



function fetchPost(url, data) {
    return new Promise(function (resolve, reject) {
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');
        
        // effettuo la chiamata all'API con il metodo POST e il corpo della richiesta
        fetch(url, {
            method: 'POST',
            headers: headers,
            mode: 'cors',
            body: JSON.stringify(data)  // Convertiamo l'oggetto in formato JSON
        }).then(response => {
            // promise: arriva la risposta
            if (response.ok) {
                // Verifico se la risposta contiene dati prima di tentare di parsare il JSON
                const contentType = response.headers.get("content-type");
                if (contentType && contentType.indexOf("application/json") !== -1) {
                    resolve(response.json());
                } else {
                    // Se non ci sono dati JSON, restituisco undefined o un messaggio a tua scelta
                    resolve(undefined);
                }
            } else {
                // se il codice di risposta non è OK, consideriamo l'errore
                response.json().then(error => {
                    console.log('Errore API:', error);
                    reject(new Error(error.message || 'Errore nell\'API'));
                }).catch(err => {
                    console.log('Errore nella risposta JSON:', err);
                    reject(new Error('Errore nella risposta dell\'API'));
                });
            }
        }).catch(error => {
            console.log('Errore durante la richiesta:', error);
            reject(new Error('Errore durante la richiesta'));
        });
    });
}



function getQueryStringValue(parameter) {
    // Ottieni l'intera stringa di query dall'URL
    var queryString = window.location.search.substring(1);

    // Suddividi la stringa di query in coppie nome=valore
    var queryParams = queryString.split("&");

    // Cerca il parametro desiderato tra le coppie
    for (var i = 0; i < queryParams.length; i++) {
        var pair = queryParams[i].split("=");

        // Se trovi il parametro, restituisci il valore
        if (pair[0] === parameter) {
            return decodeURIComponent(pair[1]);
        }
    }

    // Se il parametro non è presente, restituisci null o un valore predefinito a tua scelta
    return null;
}