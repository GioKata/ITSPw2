function generaDip(data) {
    var swiper = document.getElementById("contenitore");
    swiper.innerHTML = "";
    console.log(data);
    data.forEach(dipendente => {
        getDr(dipendente)
            .then(dR => {
                let card = document.createElement("div");
                card.classList.add("swiper-slide");
                card.classList.add("d-flex");
                card.classList.add("flex-column");

                if (dipendente.categoria === "dirigente") {
                    card.innerHTML = '<h1>' + dipendente.categoria.toUpperCase() + '</h1><h3>' + dipendente.nome + ' ' + dipendente.cognome + '</h3><p>Data assunzione: ' + dipendente.dataAssunzione + '</p><p>Codice fiscale: ' + dipendente.codiceFiscale + '</p>';
                } else {
                    card.innerHTML = '<h1>' + dipendente.categoria.toUpperCase() + '</h1><h3>' + dipendente.nome + ' ' + dipendente.cognome + '</h3><p>Data assunzione: ' + dipendente.dataAssunzione + '</p><p>Codice fiscale: ' + dipendente.codiceFiscale + '</p><h5>Riferente:' + dR.nome + ' ' + dR.cognome + '</h5>';
                }
                swiper.appendChild(card);
            })
            .catch(error => {
                console.error('Error fetching reference:', error);
            });
    });
}

function getDr(dipendente) {
    return new Promise((resolve, reject) => {
        fetch("../files/Dipendenti.json")
            .then(response => response.json())
            .then(data => {
                var dR = data.find(d => dipendente.nomeRiferimento === d.codiceFiscale);
                resolve(dR);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                reject(error);
            });
    });
}
function filterData(typeDip){
    fetch("../files/Dipendenti.json")
        .then(response => response.json())
        .then(data => {
            if(typeDip==null){
                generaDip(data);
            }else if(typeDip=="Leggenda"){
                var filterData=data.filter(dipendente=>{
                    let d1=new Date(dipendente.dataAssunzione);
                    let d2=new Date("2001-01-01");
                    console.log(d1<d2);
                    return d1<d2;
                });
                generaDip(filterData);
            }else{
                var filterData=data.filter(t => t.categoria==typeDip);
                generaDip(filterData);
            }
        })
        .catch(error=>{
            console.error('Error fetching data:', error);
        });
}