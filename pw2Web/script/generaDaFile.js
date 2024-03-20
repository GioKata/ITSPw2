function generaDip(data){
                var swiper=document.getElementById("contenitore");
                console.log(data);
                data.forEach(dipendente => {
                    data.find
                    let card=document.createElement("div");
                    card.classList.add("swiper-slide");
                    card.classList.add("d-flex");
                    card.classList.add("flex-column");
                    if(dipendente.categoria=="dirigente"){
                        card.innerHTML='<h1>'+dipendente.categoria.toUpperCase()+'</h1><h3>'+dipendente.nome+' '+dipendente.cognome+'</h3><p>Data assunzione: '+dipendente.dataAssunzione+'</p><p>Codice fiscale: '+dipendente.codiceFiscale+'</p>';
                    }else{
                        var dR=data.find(d => dipendente.nomeRiferimento==d.codiceFiscale);//per stampare il nome riferimento data.find(simile a filter con lambda);
                        card.innerHTML='<h1>'+dipendente.categoria.toUpperCase()+'</h1><h3>'+dipendente.nome+' '+dipendente.cognome+'</h3><p>Data assunzione: '+dipendente.dataAssunzione+'</p><p>Codice fiscale: '+dipendente.codiceFiscale+'</p><h5>Riferente:'+dR.nome+' '+dR.cognome+'</h5>';
                    }
                    swiper.appendChild(card);
                });
}
function scegliData(){
    fetch("../files/Dipendenti.json")
}