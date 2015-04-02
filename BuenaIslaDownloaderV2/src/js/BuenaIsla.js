// ==UserScript==
// @name         BuenaIsla
// @namespace    http://www.ZeroDrako.com/
// @version      1.1
// @description  Download Images BuenaIsla
// @author       ZeroDrako
// @match        http://www.buenaisla.com/*
// @grant        none
// ==/UserScript==

var boton = document.createElement("BUTTON");
boton.id = "SaveImages";
var t = document.createTextNode("Guardar");
boton.appendChild(t);
var list = document.getElementById("temaPuntuacion");
list.insertBefore(boton, list.childNodes[0]);

var css = document.createElement("style");
css.type = "text/css";
css.innerHTML = "#SaveImages {\n\
                                border-radius: 4px;\n\
                                text-shadow: 1px 1px 1px #000000;\n\
                                color: #ffffff;\n\
                                background: #7dca81;\n\
                                padding: 2px 3px 2px 3px;\n\
                                border: solid #24681a 1px;\n\
                                text-decoration: none;\n\
                             }\n\
                 #SaveImages:hover{\n\
                                background: #4f64a7;\n\
                                text-decoration: none;\n\
                                }";
document.body.appendChild(css);

$("#SaveImages").click(function () {
    function GetLinks() {
        var div = document.getElementById('contenido_post');
        var img = div.getElementsByTagName('img');
        var trash = [
                    "http://www.buenaisla.com/img/fecha.png",
                    "http://www.buenaisla.com/img/visitas.png",
                    "http://media.adjal.com/brand/files/adjal/5886/5886_Banners_Azul_300x250.gif",
                    "http://my.track.land/aff_i?offer_id=5886&aff_id=21576&url_id=27262&file_id=485744"
                    ];
        var links = "";
        for (var i = 0; i < img.length; i++) {
           if ( !(trash.indexOf(img[i].src) != (-1)) ) {
                links += (img[i].src + "<br>");
            }          
        }
        return links;
    }

    function GetName() {
        var tem1 = document.getElementById("contenido");
        var my = tem1.getElementsByClassName("titulo");
        var string = my[0].textContent;
        var res = string.split("\n");
        var names = res[1]+res[2];
        return names;
    }
    
    var links = GetLinks();
    var names =  GetName();
    var salida = names+"<br>"+links;
    var newWindow = window.open();
    newWindow.document.write(salida);
});