/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function changeColor() {
    var num = document.getElementById("Type").value;
    if (document.getElementById("Type").value == 1)
    {
        document.getElementById("productFoto").className = "";
    }
    else if (document.getElementById("Type").value == 2)
    {
        document.getElementById("productFoto").className = "desaturate";
    }
    else
    {
        document.getElementById("productFoto").className = "sepia";
    }
}
function updatePrice() {
    var type = document.getElementById("Soort").value;
    var price = document.getElementById("Prijs");
    var currentPrice = document.getElementById("Prijs").innerHTML;
    currentPrice = currentPrice.substr(2);


    if(type == 1)
    {
        price.innerHTML = "$ 0.00";
    }
    else if(type == 2)
    {
        var newPrice = parseFloat(currentPrice) + 2
        price.innerHTML ="$ " + newPrice.toFixed(2);
    }
    else if(type == 3)
    {
        var newPrice = parseFloat(currentPrice) + 2.5
        price.innerHTML ="$ " + newPrice.toFixed(2);
    }
    else
    {
        var newPrice = parseFloat(currentPrice) + 3
        price.innerHTML ="$ " + newPrice.toFixed(2);
    }

    
}

