/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function changeColor() {
    var num = document.getElementById("Type").value;
    if (document.getElementById("Type").value == 0)
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

