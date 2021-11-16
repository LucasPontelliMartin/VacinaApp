<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.5.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.5.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/vaccination-1.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Agendar Vacina</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
  
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu1 cid-sOkeciZLMe" once="menu" id="menu1-d">
    

    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black text-primary display-7" href="index.html#top">Vacina APP</a></span>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-bs-toggle="collapse" data-target="#navbarSupportedContent" data-bs-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-black display-4" href="Sobre.html">Sobre</a></li>
                    
                    <li class="nav-item"><a class="nav-link link text-black display-4" href="Contato.html">Contato</a>
                    </li></ul>
                
                
            </div>
        </div>
    </nav>
</section>

<section data-bs-version="5.1" class="form6 cid-sOHtRBUkjT" id="form6-e">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Agendar a Vacina</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form action="AgendarController" method="POST" class="mbr-form form-with-styler mx-auto" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="pAd1PX1HTja5yopWYxaYykZiY2PSDJ7xzCmwWmKs2uJW4MTedQ8tW+/QwraFJaF7LZvNgtGQu630TSRGB38lCLfFvET+WbMNObd3oUFhnwcaeS0X7g7iMxMwNtcHIJRx">
                    <div class="row">
                        <div hidden="hidden" data-form-alert="" class="alert alert-success col-12">Thanks for filling
                            out the form!</div>
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">Oops...! some
                            problem!</div>
                    </div>
                    <div class="dragArea row">
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="name">
                            <select class="form-control" name="ubs">
                                <option value="" disabled selected>Selecione sua Ubs</option>
                                <%
								    	ArrayList<String> lista = (ArrayList<String>) request.getSession().getAttribute("UbsProxima");
										for (String s: lista){
								%>		
											<option value="<%= s %>"><%= s %></option>
									
										<%} %>
                                
                            </select>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="email">
                            <select class="form-control" name="campanha" >
                                <option value="" disabled selected>Selecione a Campanha</option>
                                <option value="Covid-19">Covid-19</option>
                                <option value="Gripe H1N1">Gripe H1N1</option>
                                <option value="Tétano">Tétano</option>
                                <option value="Febre amarela">Febre amarela</option>
                                <option value="Poliomielite">Poliomielite</option>
								<option value="Tuberculose">Tuberculose</option>
								<option value="Difteria">Difteria</option>
								<option value="Meningite">Meningite</option>
								<option value="Sarampo">Sarampo</option>
								<option value="Caxumba">Caxumba</option>								
                            </select>
                        </div>
                        <div data-for="phone" class="col-lg-12 col-md-12 col-sm-12 form-group mb-3">
                            <select class="form-control" name="hora" >
                                <option value="" disabled selected>Selecione o horário</option>
                                <option value="8:00">8:00</option>
                                <option value="8:30">8:30</option>
                                <option value="9:00">9:00</option>
                                <option value="9:30">9:30</option>
                                <option value="10:00">10:00</option>
                                <option value="10:30">10:30</option>
                                <option value="11:00">11:00</option>
                                <option value="11:30">11:30</option>
                                <option value="12:00">12:00</option>
								<option value="" disabled >Horário Indisponível (12:00 - 14:00)</option>
                                <option value="14:00">14:00</option>
                                <option value="14:30">14:30</option>
                                <option value="15:00">15:00</option>
                                <option value="15:30">15:30</option>
                                <option value="16:00">16:00</option>
                            </select>
                        </div>
                        <div class="col-auto mbr-section-btn align-center">
                            <button type="submit" class="btn btn-primary display-4">Salvar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>