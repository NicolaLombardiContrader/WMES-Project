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

    #linea{
	width: 100%;
    height:9px;
    }

    #username{
    margin-top:0px;
    }

    #login{
    margin-top:80px;
    margin-left:20px;
    }

    #frasedue{
    padding-left:220px;
    padding-top:247px;
    }

    #frasetre{
    color:rgb(255, 255, 255);
    padding-left:295px;
    padding-top:10px;
    font-size:28pt;
    font-family: impact;
    }

    #username{
    border-color:#ffffff;
    }

    #pwd{
    border-color:#ffffff;
    }

	div.row.uno{
	padding-top:40px;
	}

	div.row.due{
    padding-top:30px;
	}

    @media screen and (min-width: 992px) {
	#top {
	display: none;
	}
	}

	@media screen and (max-width: 991px) {
	#top {
	display: block;
	}
	}

	@media screen and (min-width: 992px) {
	#fascia {
	display: block;
	}
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

    <@media screen and (max-width: 354px) {
    #frasefascia {
    font-size:20px;
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
    padding-left:25px;
    padding-top: 70px;
    font-family: impact;
    }

    #fototop{
    height: 200px;
    }

    #fascia{
    background-repeat: no-repeat;
    }


    .btn{
    background-color:#5143DD;
    color:#ffffff;
    margin-top:65px;
    border-radius:9px;
    height:36px;
    width:130px;
    margin-left:-10px;

    }

    .btn2{
    background-color:#ffffff;
    color:#9C9B9B;
    margin-top:65px;
    border-radius:9px;
    height:36px;
    width:130px;
    margin-left:-10px;
    border-color:#5143DD;
    margin-top:20px;
    }

    .btn3{
    background-color:#ffffff;
    color:#9C9B9B;
    margin-top:65px;
    border-radius:9px;
    height:36px;
    width:130px;
    margin-left:-10px;
    border-color:#5143DD;
    margin-top:20px;
    }

    .btn4{
    background-color:#ffffff;
    color:#9C9B9B;
    margin-top:65px;
    border-radius:9px;
    height:36px;
    width:130px;
    margin-left:-10px;
    border-color:#5143DD;
    }






     </style>
 <!-- fine linguaggio CSS-->


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>Contreader Recruitment</title>
</head>
<body>
<div class="container col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
<!-- sezione bootsrap container generale-->
<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 full-height">
<!-- inizio sezione sinistra con inserimento dati dell'utente-->
<form action="LoginServlet" method="post">

<!--inizio fascialta con immagine in background quando lo schermo passa da lg a md />-->
<div class="row" id="top">
    <div id="fototop" class="col-md-12" style="background-image:url('fascialta1.jpg')">
		<div id="frasefascia"> VALUTA il tuo personale.</div>
    </div>
</div>
<!--fine fascialta con immagine in background quando lo schermo passa da lg a md />-->


<!--inizio inserimento logo piattaforma />-->
<div class="row">
    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2">
	    </div>
            <div class="col-lg-10 col-md-10 col-sm-8 col-xs-8">
                <img id="logo" src="logoapp.png"/>
            </div>
        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2">
    </div>
</div>
<!--fine inserimento logo piattaforma />-->


<!--inizio inserimento del botton per il login accedendo alla pagina successiva del sito />-->
<div class="row">
    <div class="col-lg-4 col-md-3 col-xs-2">
        </div>
            <div class="col-lg-4 col-md-6 col-xs-8" style="text-align:center">
                <div class="form-group">
                  <button type="button" class="btn4" value="Login" name="bott">Lista Candidati</button>
                </div>
            </div>
        <div class="col-lg-4 col-md-3 col-xs-2" >
    </div>
</div>
<!--fine inserimento del botton per il login accedendo alla pagina successiva del sito />-->


<!--inizio inserimento del botton per il login accedendo alla pagina successiva del sito />-->
<div class="row">
    <div class="col-lg-4 col-md-3 col-xs-2">
        </div>
            <div class="col-lg-4 col-md-6 col-xs-8" style="text-align:center">
                <div class="form-group">
                  <button type="button" class="btn3" value="Login" name="bott">Lista annunci</button>
                </div>
            </div>
        <div class="col-lg-4 col-md-3 col-xs-2" >
    </div>
</div>
<!--fine inserimento del botton per il login accedendo alla pagina successiva del sito />-->


<!--inizio inserimento del botton per il login accedendo alla pagina successiva del sito />-->
<div class="row">
    <div class="col-lg-4 col-md-3 col-xs-2">
        </div>
            <div class="col-lg-4 col-md-6 col-xs-8" style="text-align:center">
                <div class="form-group">
                  <button type="button" class="btn2" value="Login" name="bott">Valuta Candidato</button>
                </div>
            </div>
        <div class="col-lg-4 col-md-3 col-xs-2" >
    </div>
</div>
<!--fine inserimento del botton per il login accedendo alla pagina successiva del sito />-->


<!--inizio inserimento del botton per il login accedendo alla pagina successiva del sito />-->
<div class="row">
    <div class="col-lg-4 col-md-3 col-xs-2">
        </div>
            <div class="col-lg-4 col-md-6 col-xs-8" style="text-align:center">
                <div class="form-group">
                  <button type="button" class="btn" value="Login" name="bott">Logout</button>
                </div>
            </div>
        <div class="col-lg-4 col-md-3 col-xs-2" >
    </div>
</div>
<!--fine inserimento del botton per il login accedendo alla pagina successiva del sito />-->








</form>
<!--fine dei 2 campi di compilazione a coppia />-->
<!--fine del campo di compilazione per l'inserimento dei dati dell'user />-->
</div>
<!--fine accesso per la registrazione al sito con relativi dati personali  />-->
<!--fine sezione sinistra con inserimento dati dell'utente />-->

<!--inizio sezione destra con immagine in background />-->
<div id="fascia" class="col-xs-12 col-sm-8 col-md-8 col-lg-8 col-xl-8 full-height" style="background-image:url('fondotre1.jpg')">
    <div id="frasedue">VALUTA</div>
    <div id="frasetre">il tuo personale.</div>
</div>
<!--fine sezione destra con immagine in background />-->


</div>
</body>
</html>
<!--fine linguaggio HTML />-->