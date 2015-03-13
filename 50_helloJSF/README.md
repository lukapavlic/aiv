# JSF

Preprost primer aplikacije z ogrodjem JSF.

V web.xml je potrebno registrirati krmilnik (javax.faces.webapp.FacesServlet), nato preprosto uporabljamo gradnike in pišemo upravljana zrna.

Aplikacija omogoèa vpis števil in njihovo raèunanje, vodi tudi zgodovino raèunov. Upravljano zrno, vezano na sejo uporabnika, je popolnoma neodvisno od prikaza.

Prikaz se veže na upravljano zrno in povezuje gradnike z atributi in metodami zrna.