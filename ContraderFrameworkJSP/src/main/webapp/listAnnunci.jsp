<%@ page import="com.virtualpairprogrammers.domain.Annunci" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<Annunci> annunci = (List<Annunci>) session.getAttribute("listAnnunci");
        String ruolo = ((String) session.getAttribute("ruolo"));
        Integer idcandidato = ((Integer) session.getAttribute("id"));%>


</head>
<body>
<table>
    <tr>
        <th>
            Id
        </th>
        <th>
            Titolo
        </th>
        <th>
            Luogo
        </th>
        <th>
            Categoria
        </th>
        <th>
            Contratto
        </th>

    </tr>

    <%for (Annunci annuncio : annunci) { %>
    <tr>

        <td>
            <%= annuncio.getId()%>
        </td>

        <td>
            <%= annuncio.getTitolo()%>
        </td>

        <td>
            <%= annuncio.getLuogo()%>
        </td>

        <td>
            <%= annuncio.getCategoria()%>
        </td>

        <td>
            <%= annuncio.getContratto()%>
        </td>


        <td>
            <%if (ruolo.equals("gestore")) {%>
            <a href="CancellaAnnuncioServlet?id=<%= annuncio.getId()%>">Cancella Annuncio</a>
            <%}%>
        </td>

        <td>
                <%if (ruolo.equals("candidato")){%>
            <a href="IscrizioneAnnuncioServlet?id=<%= annuncio.getId()%>&idca=<%= idcandidato%>">Candidati</a>
                <%}%>
        </td>

         <td>
                    <%if (ruolo.equals("recruiter")) {%>
                     <a href="VisualizzaCandidatiAnnuncioServlet?id=<%= annuncio.getId()%>">Visualizza Candidature Annuncio </a>
                    <%}%>
                </td>


    </tr>
    <% }%>
</table>
<%if (ruolo.equals("gestore")) {%>
<a href="homeGestore.jsp">Home</a>
<%} else if (ruolo.equals("recruiter")) {%>
<a href="homeRecruiter.jsp">Home</a>
<%} else if (ruolo.equals("candidato")) {%>
<a href="homeCandidato.jsp">Home</a>
<%}%>
</body>
</html>

<!-- inizio linguaggio HTML-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Piattaforma di Recruitment</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--indica le librerie che sto utilizzando per bootstrap(con relativo CSS) e JQuery />-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--indica le librerie che sto utilizzando per bootstrap(con relativo CSS) e JQuery />-->


<!-- inizio linguaggio CSS-->
<style>


    html,body, .container,.full-height{
    height:100%;
    }

    #logo{
    width: 100%;
    height: auto;
    padding-top: 60px;
	padding-bottom:40px;
    }

    .row {
    margin-right: -15px;
    margin-left: -15px;
    margin-top:50px;
    }


	@media screen and (max-width: 991px) {
	#fascia {
	display: none;
    width: 100%;
	}
	}

	@media screen and (min-width: 992px) {
	#frasedue {
	font-size:610%;
    color:rgb(255, 255, 255);
    font-family: impact;
    padding-left: 290px;
    }
	}

    @media screen and (max-width: 354px) {
    #frasefascia {
    font-size:23px;
	}
	}

    @media screen and (min-width: 355px) {
    #frasefascia {
    font-size:28px;
	}
	}

    @media screen and (min-width: 491px) {
    #frasefascia {
    font-size:29px;
	}
	}

    @media screen and (min-width: 627px) {
    #frasefascia {
    font-size:35px;
	}
	}

    #frasefascia{
    color:rgb(255, 255, 255);
    padding-left:40%;
    padding-top: 70px;
    font-family: impact;
    }

    #fototop{
    height: 200px;
    margin-top:-50px;
    width:100%;
    background-repeat: no-repeat;
    }





     </style>
<!-- fine linguaggio CSS-->


<!--inizio fascialta con immagine in background quando lo schermo passa da lg a md />-->
<div class="row" id="top">
    <div id="fototop" class="col-md-12" style="background-image:url('fascialta1.jpg')">
		<div id="frasefascia">Lista annunci </div>
    </div>
</div>
<!--fine fascialta con immagine in background quando lo schermo passa da lg a md />-->


<!--inizio inserimento logo piattaforma />-->
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-1">
	    </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-10">
                <img id="logo" src="logoapp.png"/>
            </div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-1">
    </div>
</div>
<!--fine inserimento logo piattaforma />-->


<!-- inizio sezione lista-->
<div class="row">
    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2">
	    </div>
            <div class="col-lg-10 col-md-10 col-sm-8 col-xs-8">
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                            <td>John</td>
                            <td>Doe</td>
                            <td>john@example.com</td>
                            </tr>
                            <tr>
                            <td>Mary</td>
                            <td>Moe</td>
                            <td>mary@example.com</td>
                            </tr>
                            <tr>
                            <td>July</td>
                            <td>Dooley</td>
                            <td>july@example.com</td>
                          </tr>
                        </tbody>
                      </table>
                </div>
            </div>
        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2">
    </div>
</div>
<!-- fine sezione lista-->


</div>

</div>
</body>
</html>
<!--fine linguaggio HTML />-->