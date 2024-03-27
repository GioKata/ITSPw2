function getUrl(){
    var a=getQueryStringValue("type");
    filterData(a);
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
            card.classList.add("col","px-2","py-3","carta","d-flex", "flex-column","align-items-center");
            let topDiv=document.createElement("div");
            topDiv.classList.add("d-flex","flex-column","text-center","topDiv","pt-1",d.categoria);
            let dataDiv=document.createElement("div");
            dataDiv.classList.add("d-flex","flex-column","justify-content-center","dataDiv","p-3");
            topDiv.innerHTML='<h5>'+d.nome+" "+d.cognome+'<h5><h6>'+d.categoria+'<h6>';
            if(d.categoria==="dirigente"){
                dataDiv.innerHTML='<p>Data assunzione: ' + d.dataAssunzione + '</p><p>Codice fiscale: ' + d.codiceFiscale + '</p>';
            }else{
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
