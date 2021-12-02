function criar(){
    if(document.getElementById("txtnome").value == "" || document.getElementById("txtsetor").value == "" || document.getElementById("txtvalor").value == ""){
		return;
	}
    var objeto = {
        "nome" : document.getElementById("txtnome").value,
        "setor" : document.getElementById("txtsetor").value,
        "valor" : document.getElementById("txtvalor").value
    }
    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }
    fetch("http://localhost:8080/novoproduto", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("criado",JSON.stringify(res));
            //window.location="login";
            console.log(objeto)
            window.alert("deu bom!")
        })
        .catch(err => {
            console.log(err);
            window.alert("deu ruim!");
        });
}
function logar(){
    var objeto = {
        "nome" : document.getElementById("txtnome").value,
        "setor" : document.getElementById("txtsetor").value
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/lerproduto", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            //window.location="login";
            console.log(objeto)
            window.alert("deu bom!")
            document.getElementById("valor_resp").innerText = "valor do produto: " +res.valor
        })
        .catch(err => {
            console.log(err);
            window.alert("deu ruizão!")
         
        });

}
function atualizar(){
    var objeto = {
        "id" : document.getElementById("txtid").value,
        "nome" : document.getElementById("txtnome").value,
        "setor" : document.getElementById("txtsetor").value,
        "valor" : document.getElementById("txtvalor").value

    }

    var cabecalho = {
        method: "PUT",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/atualizarproduto", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            //window.location="login";
            console.log(objeto)
            window.alert("deu bom!")
        })
        .catch(err => {
            console.log(err);
            window.alert("deu ruizão!")
         
        });

}
function deletar(){
    var objeto = {
        "id" : document.getElementById("txtid").value
    }

    var cabecalho = {
        method: "PUT",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/deletarproduto", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            //window.location="login";
            console.log(objeto)
            window.alert("deu bom!")
        })
        .catch(err => {
            console.log(err);
            window.alert("deu ruizão!")
         
        });

}