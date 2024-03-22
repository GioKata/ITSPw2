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
function generaDip(data) {
    var cont = document.getElementById("contenitore");
    cont.innerHTML = "";
    console.log(data);
    data.forEach(dipendente => {
        createCard(dipendente);
    });
}

function createCard(d){
    var cont = document.getElementById("contenitore");
    getDr(d)
        .then(dR => {
            let card = document.createElement("div");
            card.classList.add("col-4","px-2","py-3");
            let topDiv=document.createElement("div");
            topDiv.classList.add("d-flex","flex-column","text-center","topDiv","pt-1");
            let dataDiv=document.createElement("div");
            dataDiv.classList.add("d-flex","flex-column","justify-content-center","dataDiv","p-3");
            if(d.categoria==="dirigente"){
                topDiv.classList.add("dirigente");
                topDiv.innerHTML='<h5>'+d.nome+" "+d.cognome+'<h5><h6>Dirigente<h6>';
                dataDiv.innerHTML='<p>Data assunzione: ' + d.dataAssunzione + '</p><p>Codice fiscale: ' + d.codiceFiscale + '</p>';
            }else if(d.categoria==="tecnico"){
                topDiv.classList.add("tecnico");
                topDiv.innerHTML='<h5>'+d.nome+" "+d.cognome+'<h5><h6>Tecnico<h6>';
                dataDiv.innerHTML='<p>Data assunzione: ' + d.dataAssunzione + '</p><p>Codice fiscale: ' + d.codiceFiscale + '</p><p>Referente: '+dR.nome+' '+dR.cognome+'</p>';
            }else{
                topDiv.classList.add("manager");
                topDiv.innerHTML='<h5>'+d.nome+" "+d.cognome+'<h5><h6>Manager<h6>';
                dataDiv.innerHTML='<p>Data assunzione: ' + d.dataAssunzione + '</p><p>Codice fiscale: ' + d.codiceFiscale + '</p><p>Referente: '+dR.nome+' '+dR.cognome+'</p>';
            }
            card.appendChild(topDiv);
            card.appendChild(dataDiv);
            cont.appendChild(card);
        })
        .catch(error => {
            console.error('Error fetching reference:', error);
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
